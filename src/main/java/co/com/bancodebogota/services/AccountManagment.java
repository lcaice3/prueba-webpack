package co.com.bancodebogota.services;

import com.fasterxml.jackson.databind.JsonNode;

import co.com.bancodebogota.dtos.account.CreateAccountDto;

public interface AccountManagment {

	public JsonNode createAccount(CreateAccountDto createAccountDto);

}
