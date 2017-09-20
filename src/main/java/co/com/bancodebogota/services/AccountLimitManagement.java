package co.com.bancodebogota.services;

import com.fasterxml.jackson.databind.JsonNode;

import co.com.bancodebogota.dtos.accountlimit.AccountLimitsDto;

public interface AccountLimitManagement {
	
	public JsonNode updateAccountLimit(AccountLimitsDto accountLimitDto);
	
}
