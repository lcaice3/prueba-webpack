package co.com.bancodebogota.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bancodebogota.digital.utilities.date.DateUtilities;
import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.bancodebogota.dtos.checklog.CheckTypeLogItemDto;
import co.com.bancodebogota.dtos.checklog.CheckTypeLogListDto;
import co.com.bancodebogota.services.AccountManagementJpa;
import co.com.bancodebogota.utils.MaskRemover;
import co.com.bancodebogota.utils.RedisRepository;

@Service
public class AccountManagementJpaImpl implements AccountManagementJpa {

	@Autowired
	RedisRepository storageUtilities;

	@Autowired
	private MaskRemover maskRemover;

	@Value("${ENDPOINT_ACCOUNT_MANAGEMENT_JPA}")
	private String endpointAccountMngtJpa;

	private static final String PREFIX_CHECK_VERIFY = "CHECK_VERIFY";

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public void putCheckItemLog(String documentType, String identityNumber, String check) {
		String documentNumber = maskRemover.removeIdentificationMask(identityNumber);
		List<CheckTypeLogItemDto> checkItemList = new ArrayList<>();
		ObjectMapper mapper = new ObjectMapper();
		String checkIdentity = storageUtilities.getCache(documentType, documentNumber, PREFIX_CHECK_VERIFY);
		if (checkIdentity != null) {
			try {
				CheckTypeLogListDto checkLog = mapper.readValue(checkIdentity, CheckTypeLogListDto.class);
				checkItemList = checkLog.getCheckTypeLogList();
			} catch (IOException e) {
				LoggerUtils.error("AccountManagementJpaImpl.putCheckItemLog : "+e.getMessage());
			}
		}
		storageUtilities.addCache(documentType, documentNumber, PREFIX_CHECK_VERIFY,
				mapperCheckTypeLog(documentNumber, check, checkItemList));
	}

	/**
	 * Se mapea el nuevo check en la lista obtenida de reddis
	 * 
	 * @param identityNumber
	 * @param check
	 * @param checkRedisItemList
	 * @return
	 */
	public CheckTypeLogListDto mapperCheckTypeLog(String identityNumber, String check,
			List<CheckTypeLogItemDto> checkRedisItemList) {
		String documentNumber = maskRemover.removeIdentificationMask(identityNumber);
		ObjectMapper mapper = new ObjectMapper();
		CheckTypeLogListDto checkTypeLogListDto = new CheckTypeLogListDto();
		CheckTypeLogItemDto newItemCheck = new CheckTypeLogItemDto();
		checkTypeLogListDto.setIdentityNumber(documentNumber);		
		newItemCheck.setDate(DateUtilities.getCurrentTimestampGMT_5());
		newItemCheck.setCheckType(Integer.parseInt(check));
		checkRedisItemList.add(newItemCheck);
		checkTypeLogListDto.setCheckTypeLogList(checkRedisItemList);
		try {
			LoggerUtils.info("checkTypeLogListDto -> " + mapper.writeValueAsString(checkTypeLogListDto));
		} catch (JsonProcessingException e) {
			LoggerUtils.error("AccountManagementJpaImpl.mapperCheckTypeLog : "+e.getMessage());
		}
		return checkTypeLogListDto;
	}

	@Override
	public void saveCheckLog(String documentType, String identityNumber, String accountNumber) {
		String documentNumber = maskRemover.removeIdentificationMask(identityNumber);
		String resource = "/savings/check-type-log";
		ObjectMapper mapper = new ObjectMapper();
		String storageCheck = storageUtilities.getCache(documentType, documentNumber, PREFIX_CHECK_VERIFY);
		try {
			CheckTypeLogListDto checkLog = mapper.readValue(storageCheck, CheckTypeLogListDto.class);
			checkLog.setIdentityNumber(accountNumber);
			restTemplate.postForEntity(endpointAccountMngtJpa + resource, checkLog, Object.class);
		} catch (IOException e) {
			LoggerUtils.error("Error savings-check-type-log: "+e.getMessage());
		}
	}

	/**
	 * 
	 * @param restTemplate
	 */
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
