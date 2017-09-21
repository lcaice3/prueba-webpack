package co.com.bancodebogota.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import co.com.bancodebogota.dtos.account.CreateAccountDto;
import co.com.bancodebogota.services.AccountManagment;

@Service("accountProd")
public class AccountManagmentImpl implements AccountManagment {

	@Value("${ENDPOINT_ACCOUNT_MANAGEMENT}")
	private String endpointAccountMngt;

	@Override
	public JsonNode createAccount(CreateAccountDto createAccountDto) {
		String resource = "createSavingAccount";
		RestTemplate restTemplate = new RestTemplate();

		return restTemplate.postForObject(endpointAccountMngt + resource, createAccountDto, JsonNode.class);

	}

}
