package co.com.bancodebogota.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.com.bancodebogota.balances.pojos.IsUpdatableRs;
import co.com.bancodebogota.balances.services.BalanceFacade;
import co.com.bancodebogota.customers.ConsultCustomerRespDTO;
import co.com.bancodebogota.dtos.BankAccountDto;
import co.com.bancodebogota.exceptions.CustomerManagmentException;
import co.com.bancodebogota.mappers.CustomerUpdateMapper;
import co.com.bancodebogota.mappers.RequestMapper;
import co.com.bancodebogota.services.CustomerManagement;
import co.com.bancodebogota.utils.MaskRemover;
import co.com.bancodebogota.utils.RedisRepository;

@Service("CustomerManagementImpl")
public class CustomerManagementImpl implements CustomerManagement {

	public static final String CREATE_ACCOUNT_RESOURCE = "createIP";
	public static final String UPDATE_ACCOUNT_RESOURCE = "updateCRM";

	@Autowired
	private RequestMapper requestMapper;
	
	@Autowired
	private BalanceFacade balanceFacade;

	@Autowired
	private CustomerUpdateMapper customerUpdateMapper;

	@Autowired
	private RedisRepository redisRepository;

	@Autowired
	private MaskRemover mask;

	@Value("${ENDPOINT_CRM_CREATE}")
	private String customerAdapterEndpoint;

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public boolean createCustomer(BankAccountDto bankAccountDto) {
		ObjectNode request = requestMapper.mapCreateCustomerRequest(bankAccountDto);
		LoggerUtils.logJSON(request, "createCustomer");
		restTemplate.postForEntity(customerAdapterEndpoint + CREATE_ACCOUNT_RESOURCE, request, Object.class);

		try {
			return callMergeCustomer(customerUpdateMapper.mapCreateCustomerRequestByCreate(bankAccountDto));
		} catch (Exception e) {
			throw new CustomerManagmentException("Error in createCustomer", e, request);
		}
	}

	@Override
	public boolean updateCustomer(BankAccountDto bankAccountDto) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String documentNumber = mask.removeIdentificationMask(bankAccountDto.getIdentityNumber());
		IsUpdatableRs userIsUpdatable = checkUser(documentNumber);
		boolean rejectedByRuleSavings = userIsUpdatable.isRejectedByRuleSavings();
		boolean rejectedByRuleTc = userIsUpdatable.isRejectedByRuleTc();
		if (rejectedByRuleSavings || rejectedByRuleTc) {
			LoggerUtils.info(String.format("User %s rejected by savings %s, creditCard %s ", documentNumber,
					rejectedByRuleSavings, rejectedByRuleTc));
			return true;
		}
		return mergeCustomer(bankAccountDto, mapper, documentNumber);
	}

	private IsUpdatableRs checkUser(String documentNumber) {
		ObjectMapper mapper = new ObjectMapper();
		String isUpdatableRedis = redisRepository.getCache("C", documentNumber, "balances");
		IsUpdatableRs userIsUpdatable;
		try {
			userIsUpdatable = mapper.readValue(isUpdatableRedis, IsUpdatableRs.class);
		} catch (IOException e) {
			userIsUpdatable = balanceFacade.checkUser(documentNumber);
		}
		return userIsUpdatable;
	}
	
	private boolean mergeCustomer(BankAccountDto bankAccountDto, ObjectMapper mapper, String documentNumber) {
		try {
			String customerRedis = redisRepository.getCache("C", documentNumber, "CUSTOMER_INFO");
			ConsultCustomerRespDTO customerDto = mapper.readValue(customerRedis, ConsultCustomerRespDTO.class);
			String cellPhone = mask.removeCellphoneMask(bankAccountDto.getCellphone());
			String email = bankAccountDto.getEmail();
			ObjectNode request = customerUpdateMapper.mapCreateCustomerRequest(customerDto, cellPhone, email,
					documentNumber, bankAccountDto);
			return callMergeCustomer(request);

		} catch (Exception e) {
			LoggerUtils.error("Error in updateCustomer", e);
			return false;
		}  
	}
	
	private boolean callMergeCustomer(ObjectNode request) {
		LoggerUtils.logJSON(request, "mergeCustomerInCrm");
		restTemplate.postForEntity(customerAdapterEndpoint + UPDATE_ACCOUNT_RESOURCE, request, Object.class);
		return true;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
