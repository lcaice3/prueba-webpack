package co.com.bancodebogota.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.com.bancodebogota.dtos.accountlimit.AccountLimitsDto;
import co.com.bancodebogota.services.AccountLimitManagement;
import co.com.bancodebogota.utils.MaskRemover;

@Service("AccountLimitServiceImpl")
public class AccountLimitServiceImpl implements AccountLimitManagement {

	@Value("${ENDPOINT_ACCOUNT_LIMIT}")
	private String endpoint;
	@Autowired
	private MaskRemover maskRemover;
	
	@Override
	public JsonNode updateAccountLimit(AccountLimitsDto accountLimitDto) {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode jsonResponse = mapper.createObjectNode();
		try{
		String resource = "updateAccountLimit";		
		RestTemplate restTemplate = new RestTemplate();
		accountLimitDto.setNumberDocument(maskRemover.removeIdentificationMask(accountLimitDto.getNumberDocument()));
		ResponseEntity<JsonNode> responseJson = restTemplate.postForEntity(endpoint+resource, accountLimitDto, JsonNode.class);
		jsonResponse = (ObjectNode) responseJson.getBody();
		}catch(Exception e){
			
			jsonResponse.put("result", false);
			LoggerUtils.error("error asignacion topes " + e.getMessage());
		}
		return jsonResponse;
	}
}
