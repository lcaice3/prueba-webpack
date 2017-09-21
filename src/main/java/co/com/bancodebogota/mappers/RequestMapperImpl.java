package co.com.bancodebogota.mappers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.com.bancodebogota.customers.ConsultCustomerRespDTO;
import co.com.bancodebogota.dtos.BankAccountDto;
import co.com.bancodebogota.dtos.account.AddressDto;
import co.com.bancodebogota.dtos.account.CreateAccountDto;
import co.com.bancodebogota.utils.MaskRemover;
import co.com.bancodebogota.utils.RedisRepository;
import co.com.bancodebogota.utils.TimeUtilities;

@Service

public class RequestMapperImpl implements RequestMapper {
	
	static final String MVP_NATIONALITY = "COL";
	static final String MVP_ADDRESS = "AV;0;CL;0;;;;;;;COL;11;11001000;;";
	static final String MVP_ADDRESS_PURPOSE = "34";
	static final String MVP_EMAIL_PURPOSE = "20002";
	static final String MVP_TEL_PURPOSE = "15";

	@Autowired
	private MaskRemover maskRemover;

	@Autowired
	private TimeUtilities timeUtilities;
	
	@Autowired
	private RedisRepository storageTempUtil;
	
	static final String CUSTOMER_INFORMATION = "CUSTOMER_INFO";

	@Override
	public ObjectNode mapCreateCustomerRequest(BankAccountDto bankAccountDto) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode jsonRequest = objectMapper.createObjectNode();
		ObjectNode jsonAddress = objectMapper.createObjectNode();

		/* REQUIRED FIELDS */
		jsonAddress.put("address1", MVP_ADDRESS);
		jsonAddress.put("bbpurposedir1", MVP_ADDRESS_PURPOSE);
		jsonAddress.put("bbpurposeeml1", MVP_EMAIL_PURPOSE);
		jsonAddress.put("bbpurposetel1", "12");
		jsonAddress.put("bbpurposetel2", "11");
		jsonAddress.put("bbpurposetel5", "15");

		jsonAddress.put("city", bankAccountDto.getLivingCityId());
		
		jsonAddress.put("emailaddr", bankAccountDto.getEmail());

		jsonAddress.put("phone", maskRemover.removeCellphoneMask(bankAccountDto.getCellphone()));

		jsonRequest.put("aacodciiu", bankAccountDto.getJobActivityId());
		jsonRequest.put("aacodocupacion", bankAccountDto.getOccupationId());
		jsonRequest.put("aanit", maskRemover.removeIdentificationMask(bankAccountDto.getIdentityNumber()));

		jsonRequest.put("aalugarexpdoc", bankAccountDto.getExpeditionCityId());
		jsonRequest.put("aafecdocumento", timeUtilities.changeFormat(bankAccountDto.getExpeditionDate()));
		jsonRequest.put("companyname", bankAccountDto.getNameCompany());
		jsonRequest.put("bbreportecostos", 100000);
		jsonRequest.put("aavlractivos", Long.parseLong(maskRemover.removeMoneyMask(bankAccountDto.getTotalAssets())));
		jsonRequest.put("aavlregresomes",
				Long.parseLong(maskRemover.removeMoneyMask(bankAccountDto.getMonthlyOutcome())));
		jsonRequest.put("aavlringbrumes",
				Long.parseLong(maskRemover.removeMoneyMask(bankAccountDto.getMonthlyIncome())));
		jsonRequest.put("aavlrpasivos", Long.parseLong(maskRemover.removeMoneyMask(bankAccountDto.getTotalDebts())));
		jsonRequest.put("bbnacionalidad", MVP_NATIONALITY);
		jsonRequest.put("bbtipodocpn", bankAccountDto.getIdentityType());
		jsonRequest.put("birthdate", timeUtilities.changeFormat(bankAccountDto.getBirthDate()));
		jsonRequest.put("duedt", dateFormat.format(new Date()));
		jsonRequest.put("firstname", bankAccountDto.getFirstName());
		jsonRequest.put("middlename", bankAccountDto.getMiddleName());
		jsonRequest.put("lastname", bankAccountDto.getLastName());
		jsonRequest.put("secondlastname", bankAccountDto.getSecondLastName());

		jsonRequest.put("sex", bankAccountDto.getGender() == null ? "M" : bankAccountDto.getGender());
		if(bankAccountDto.getFatca()!=null){
			jsonRequest.put("fatca",  bankAccountDto.getFatca() );
			jsonRequest.put("bbnacionalfatca",  bankAccountDto.getFatca() );
		}

		jsonRequest.put("aadeclararenta", "N");
		jsonRequest.putPOJO("a1", jsonAddress);
		/* END REQUIRED FIELDS */

		return jsonRequest;
	}

	@Override
	public CreateAccountDto mapCreateAccountDtoRequest(BankAccountDto bankAccountDto) {
		String documentNumber = maskRemover.removeIdentificationMask(bankAccountDto.getIdentityNumber());
		ObjectMapper mapper = new ObjectMapper();
		CreateAccountDto createAccountDto = new CreateAccountDto();
		String clientNode = storageTempUtil.getCache("C", documentNumber, CUSTOMER_INFORMATION);

		createAccountDto.setBbnumterm("DIGITAL");
		createAccountDto.setAanit(documentNumber);
		createAccountDto.setBbtitularidad("");
		createAccountDto.setBbcodceo("0000");
		createAccountDto.setBbtiporetencion("3");
		createAccountDto.setBbenvioextracto("C");

		createAccountDto.setDeliveryAddress(bankAccountDto.getDeliveryAddress());

		AddressDto a1 = new AddressDto();
		a1.setAddress1("AV;a;CO;a;;;;;;;COL;11;11001000;");
		a1.setAddress11("");
		a1.setBbpurposeeml1(MVP_EMAIL_PURPOSE);
		a1.setBbpurposetel1("12");
		a1.setBbpurposetel2("11");
		a1.setBbpurposetel5("15");
		a1.setBbpurposedir1("32");
		a1.setBbpurposedir2("");

		a1.setCity("5001000");
		a1.setCity2("");
		createAccountDto.setA1(a1);
		
		//FRONT PARAMETERS 
		createAccountDto.setProductid(bankAccountDto.getProductId());
		createAccountDto.setBbcodctanom(bankAccountDto.getCodNomina());
		createAccountDto.setBbtipodoc(bankAccountDto.getIdentityType());
		createAccountDto.setLastname(bankAccountDto.getLastName());
		createAccountDto.setSecondlastname(bankAccountDto.getSecondLastName());
		createAccountDto.setFirstname(bankAccountDto.getFirstName());
		createAccountDto.setMiddlename(bankAccountDto.getMiddleName());
		createAccountDto.setLastname(bankAccountDto.getLastName());
		createAccountDto.setSecondlastname(bankAccountDto.getSecondLastName());
		createAccountDto.setBirthdate(timeUtilities.changeFormat(bankAccountDto.getBirthDate()));
		createAccountDto.setSex(bankAccountDto.getGender());
		createAccountDto.setAacodciiu(bankAccountDto.getJobActivityId());
		createAccountDto.setBbcodoficinahs(bankAccountDto.getOfficeCode());
		createAccountDto.setBbcodvendedor(bankAccountDto.getOfficeCodeSeller());
		createAccountDto.setBbcodofi(bankAccountDto.getOfficeCode());
		createAccountDto.setBbcodctanom(bankAccountDto.getCodNomina());
		createAccountDto.setTxInOffice(bankAccountDto.isTxInWeb() ? false : true);
		createAccountDto.setNewClient(!bankAccountDto.getCustomerExistsInCrm());
		createAccountDto.setNewCard(bankAccountDto.isClientWithDebitCards() ? 0 : 1);
		createAccountDto.setGmf(bankAccountDto.isCheckGmf() ? 1 : 0);
		createAccountDto.setFatca(bankAccountDto.getFatca());
		
		a1.setEmailaddr(bankAccountDto.getEmail());
		a1.setPhone(maskRemover.removeCellphoneMask(bankAccountDto.getCellphone()));

		if (clientNode != null) {
			ConsultCustomerRespDTO customerDto;
			try {
				customerDto = mapper.readValue(clientNode, ConsultCustomerRespDTO.class);
				createAccountDto.setSex(customerDto.getSex());
				createAccountDto.setAacodciiu(customerDto.getCodCiuu());
			} catch (Exception e) {
				LoggerUtils.error("Error mapping object", e);
			}
		} 

		return createAccountDto;
	}

	@Override
	public String createRequestParamsUrl(Map<String, Object> params) {
		StringBuilder requestBuilder = new StringBuilder();
		boolean firstChar = true;
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			Object value = entry.getValue();
			if (value != null) {
				if (firstChar) {
					requestBuilder.append("?");
					firstChar = false;
				} else {
					requestBuilder.append("&");
				}
				String key = entry.getKey();
				requestBuilder.append(key + "=");
				requestBuilder.append(value);
			}
		}
		return requestBuilder.toString();
	}

	@Override
	public String getRequestParamsUrl(String endpoint, Map<String, Object> params) {
		return endpoint + this.createRequestParamsUrl(params);

	}

}