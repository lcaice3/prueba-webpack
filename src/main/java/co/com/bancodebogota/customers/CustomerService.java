package co.com.bancodebogota.customers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.com.bancodebogota.authentication.AuthenticationService;
import co.com.bancodebogota.blacklist.pojos.BlacklistParticipanteRqDto;
import co.com.bancodebogota.services.AccountManagementJpa;
import co.com.bancodebogota.services.BlacklistService;
import co.com.bancodebogota.utils.CheckVerifyEnum;
import co.com.bancodebogota.utils.RedisRepository;
import co.com.bancodebogota.utils.TimeUtilities;

@Service
public class CustomerService {

	@Value("${CUSTOMER_SERVICE_ENDPOINT}")
	private String customerEndpoint;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private RedisRepository storageTempUtilities;

	@Autowired
	private BlacklistService blacklistService;

	@Autowired
	private TimeUtilities timeUtilities;

	@Autowired
	private AccountManagementJpa accountMngJpa;

	@Autowired
	RedisRepository storageUtilities;

	private static final String CUSTOMER_INFORMATION = "CUSTOMER_INFO";
	private static final String PREFIX_CHECK_VERIFY = "CHECK_VERIFY";

	public ObjectNode checkUserExists(String identityType, String identityNumber) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode response = mapper.createObjectNode();
		storageUtilities.deleteKeyRedis(identityType, identityNumber, PREFIX_CHECK_VERIFY);
		accountMngJpa.putCheckItemLog(identityType, identityNumber,
				String.valueOf(CheckVerifyEnum.CHECK_CENTRALES.getIdCheck()));
		ConsultCustomerRespDTO customer = getCustomerInfoFromBackend(identityType, identityNumber);

		boolean isClient = customerExists(customer);

		if (isClient) {
			BlacklistParticipanteRqDto blacklistParticipanteRqDto = new BlacklistParticipanteRqDto(identityNumber,
					customer.getLastName(), null, customer.getFirstName());
			boolean clientInBlacklist = blacklistService.participanteInBlacklist(blacklistParticipanteRqDto);
			response.put("clientInBlacklist", clientInBlacklist);
			response.put("firstName", customer.getFirstName());

		}
		response.put("exists", isClient);
		return response;
	}

	public ResponseEntity<Map<String, String>> getCustomerInfo(String accessToken, String identityType,
			String identityNumber) {
		if (!authenticationService.checkToken(accessToken, identityType, identityNumber))
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);

		ConsultCustomerRespDTO consultCustomerRespDTO = getCustomerInfoFromBackend(identityType, identityNumber);
		if (consultCustomerRespDTO != null) {
			consultCustomerRespDTO
					.setExpeditionDate(timeUtilities.changeFormat(consultCustomerRespDTO.getExpeditionDate()));
			storageTempUtilities.addCache("C", identityNumber, CUSTOMER_INFORMATION, consultCustomerRespDTO);

		}
		Map<String, String> serialize = consultCustomerRespDTO != null ? consultCustomerRespDTO.serialize() : null;
		return new ResponseEntity<>(serialize, HttpStatus.OK);
	}

	private boolean customerExists(ConsultCustomerRespDTO consultCustomerRespDTO) {
		if (consultCustomerRespDTO == null)
			return false;
		String firstName = consultCustomerRespDTO.getFirstName();
		return firstName != null && !firstName.isEmpty();
	}

	private ConsultCustomerRespDTO getCustomerInfoFromBackend(String identityType, String identityNumber) {
		String url = String.format("/customer-info?documentType=%s&documentNumber=%s", identityType, identityNumber);

		LoggerUtils.info("Calling " + customerEndpoint + url);
		return restTemplate.getForObject(customerEndpoint + url, ConsultCustomerRespDTO.class);
	}

    public boolean updateReferences(CustomerReferences customerReferences) {
		String url = String.format("%s/customermanagement/referencingCRM", customerEndpoint);
		LoggerUtils.info("Creating reference using URL: " + customerEndpoint + url);
		restTemplate.put(url, customerReferences);
		return true;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
