package co.com.bancodebogota.mappers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.com.bancodebogota.customers.ConsultCustomerRespDTO;
import co.com.bancodebogota.dtos.BankAccountDto;
import co.com.bancodebogota.utils.MaskRemover;
import co.com.bancodebogota.utils.TimeUtilities;

@Service
public class CustomerUpdateMapperImpl implements CustomerUpdateMapper {

	private static final String KEY_ADDRESS1 = "address1";
	private static final String YYYY_MM_DD = "yyyy-MM-dd";
	static final String MVP_NATIONALITY = "COL";
	static final String MVP_EMAIL_PURPOSE = "20002";
	static final String BB_CAJERO = "0009999993";
	static final String MVP_ADDRESS = "AV;0;CL;0;;;;;;;COL;11;11001000;;";

	@Autowired
	private MaskRemover maskRemover;

	@Autowired
	private TimeUtilities timeUtilities;

	@Override
	public ObjectNode mapCreateCustomerRequest(ConsultCustomerRespDTO customerDto, String cellphone, String email,
			String documentNumber, BankAccountDto bankAccountDto) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode jsonRequest = objectMapper.createObjectNode();
		LoggerUtils.info("Consulta cliente - " + objectMapper.writeValueAsString(customerDto));
		DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
		/* A0 */
		jsonRequest.put("bbcajero", BB_CAJERO);
		jsonRequest.put("aanit", maskRemover.removeIdentificationMask(documentNumber));
		jsonRequest.put("bbtipodocpn", "C");
		jsonRequest.put("lastname", customerDto.getLastName());
		jsonRequest.put("firstname", customerDto.getFirstName());
		jsonRequest.put("secondlastname", customerDto.getSecondLastName());
		jsonRequest.put("middlename", customerDto.getMiddleName());
		jsonRequest.put("birthdate", customerDto.getBirthDate());
		jsonRequest.put("sex", customerDto.getSex());
		jsonRequest.put("bbnacionalidad", MVP_NATIONALITY);// Estatus residencia
															// COL,ENR ERE
		if (!customerDto.getExpeditionDate().isEmpty())
			jsonRequest.put("aafecdocumento", customerDto.getExpeditionDate());
		jsonRequest.put("aacodocupacion", customerDto.getCodOcupation());
		jsonRequest.put("aacodciiu", customerDto.getCodCiuu());
		jsonRequest.put("duedt", dateFormat.format(new Date()));
		jsonRequest.put("aavlractivos", maskRemover.removeMoneyMask(bankAccountDto.getTotalAssets()));
		jsonRequest.put("aavlregresomes", maskRemover.removeMoneyMask(bankAccountDto.getMonthlyOutcome()));
		jsonRequest.put("aavlringbrumes", maskRemover.removeMoneyMask(bankAccountDto.getMonthlyIncome()));
		jsonRequest.put("aavlrpasivos", maskRemover.removeMoneyMask(bankAccountDto.getTotalDebts()));
		LoggerUtils.info("debts bankDTO " + bankAccountDto.getTotalDebts() + " Remove: "
				+ maskRemover.removeMoneyMask(bankAccountDto.getTotalDebts()));
		jsonRequest.put("bbpais", customerDto.getNationality());
		jsonRequest.put("aaciudad2", customerDto.getCodCity());// municipio
		//jsonRequest.put("bbnacionalfatca", customerDto.getNationality());// Nacionalidad
		jsonRequest.put("bbreportecostos", customerDto.getRepCostos());
		jsonRequest.putPOJO("a1", mapperA1Update(customerDto, cellphone, email));
		
		if(bankAccountDto.getFatca()!=null){
			jsonRequest.put("fatca",  bankAccountDto.getFatca() );
			jsonRequest.put("bbnacionalfatca",  bankAccountDto.getFatca() );
		}
		
		return jsonRequest;
	}

	@Override
	public ObjectNode mapCreateCustomerRequestByCreate(BankAccountDto bankAccountDto) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		ObjectNode jsonRequest = objectMapper.createObjectNode();
		LoggerUtils.info("Update by create  - " + objectMapper.writeValueAsString(bankAccountDto));
		DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
		/* A0 */
		jsonRequest.put("bbcajero", BB_CAJERO);
		jsonRequest.put("aanit", maskRemover.removeIdentificationMask(bankAccountDto.getIdentityNumber()));
		jsonRequest.put("bbtipodocpn", "C");
		jsonRequest.put("lastname", bankAccountDto.getLastName());
		jsonRequest.put("firstname", bankAccountDto.getFirstName());
		jsonRequest.put("secondlastname", bankAccountDto.getSecondLastName());
		jsonRequest.put("middlename", bankAccountDto.getMiddleName());
		jsonRequest.put("birthdate", timeUtilities.changeFormat(bankAccountDto.getBirthDate()));
		jsonRequest.put("sex", bankAccountDto.getGender());
		jsonRequest.put("bbnacionalidad", MVP_NATIONALITY);// Estatus residencia
															// COL,ENR ERE
		if (!bankAccountDto.getExpeditionDate().isEmpty())
			jsonRequest.put("aafecdocumento", timeUtilities.changeFormat(bankAccountDto.getExpeditionDate()));
		jsonRequest.put("aacodocupacion", bankAccountDto.getOccupationId());
		jsonRequest.put("aacodciiu", bankAccountDto.getJobActivityId());
		jsonRequest.put("duedt", dateFormat.format(new Date()));
		jsonRequest.put("aavlractivos", maskRemover.removeMoneyMask(bankAccountDto.getTotalAssets()));
		jsonRequest.put("aavlregresomes", maskRemover.removeMoneyMask(bankAccountDto.getMonthlyOutcome()));
		jsonRequest.put("aavlringbrumes", maskRemover.removeMoneyMask(bankAccountDto.getMonthlyIncome()));
		jsonRequest.put("aavlrpasivos", maskRemover.removeMoneyMask(bankAccountDto.getTotalDebts()));
		jsonRequest.put("bbpais", MVP_NATIONALITY);
		jsonRequest.put("aaciudad2", bankAccountDto.getLivingCityId());// municipio
		jsonRequest.put("bbnacionalfatca", MVP_NATIONALITY);// Nacionalidad
		jsonRequest.put("bbreportecostos", "1");
		if(bankAccountDto.getFatca()!=null){
			jsonRequest.put("fatca",  bankAccountDto.getFatca() );
			jsonRequest.put("bbnacionalfatca",  bankAccountDto.getFatca() );
		}
		jsonRequest.putPOJO("a1", mapperA1UpdateByCreate(bankAccountDto));
		return jsonRequest;
	}

	public JsonNode mapperA1UpdateByCreate(BankAccountDto customerDTO) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode mapperA1 = mapper.createObjectNode();
		mapperA1.put("emailaddr", customerDTO.getEmail());
		mapperA1.put("bbpurposeeml1", MVP_EMAIL_PURPOSE);
		mapperA1.put("phone5", maskRemover.removeCellphoneMask(customerDTO.getCellphone()));
		mapperA1.put("bbpurposetel5", "12");
		mapperA1.put(KEY_ADDRESS1, MVP_ADDRESS);
		mapperA1.put("bbpurposedir1", "34");
		return mapperA1;

	}

	public JsonNode mapperA1Update(ConsultCustomerRespDTO customerDTO, String cellphone, String email) {
		ObjectMapper mapper = new ObjectMapper();
		LoggerUtils.info("address crm : " + customerDTO.getAddress1());
		ObjectNode mapperA1 = mapper.createObjectNode();
		mapperA1.put("emailaddr", email);
		mapperA1.put("bbpurposeeml1", MVP_EMAIL_PURPOSE);
		mapperA1.put("phone5", cellphone);
		mapperA1.put("bbpurposetel5", "12");
		if (validateDueDt(customerDTO.getEffdt()))
			mapperA1.put(KEY_ADDRESS1, MVP_ADDRESS);
		else
			mapperA1.put(KEY_ADDRESS1, customerDTO.getAddress1());
		mapperA1.put("bbpurposedir1", customerDTO.getPurposeAddress1());

		return mapperA1;

	}

	public boolean validateDueDt(String dueDt) {
		DateFormat format = new SimpleDateFormat(YYYY_MM_DD);
		int millisecDay = 24 * 60 * 60 * 1000;
		LoggerUtils.info("dueDtCRM: " + dueDt);
		
		try {
			if (dueDt == null || "".equals(dueDt.trim()))
				return true;
			else {
				Date dateCrm = format.parse(dueDt);
				Date currentDay = new Date();
				int totalDays = (int) ((currentDay.getTime() - dateCrm.getTime()) / millisecDay);
				if (totalDays > 365) {
					return true;
				}
			}

		} catch (ParseException e) {
			LoggerUtils.info("Error parserException dueDtCRM: " + dueDt);
		}
		return false;

	}

}
