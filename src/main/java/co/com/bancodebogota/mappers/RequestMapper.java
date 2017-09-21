package co.com.bancodebogota.mappers;

import java.util.Map;

import com.fasterxml.jackson.databind.node.ObjectNode;

import co.com.bancodebogota.dtos.BankAccountDto;
import co.com.bancodebogota.dtos.account.CreateAccountDto;


public interface RequestMapper {
	
	ObjectNode mapCreateCustomerRequest(BankAccountDto bankAccountDto);
	
	CreateAccountDto mapCreateAccountDtoRequest(BankAccountDto bankAccountDto);

	String createRequestParamsUrl(Map<String, Object> params);
	
	String getRequestParamsUrl(String endpoint, Map<String, Object> params);
	
}
