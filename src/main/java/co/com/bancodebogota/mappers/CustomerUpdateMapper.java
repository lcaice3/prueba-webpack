package co.com.bancodebogota.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import co.com.bancodebogota.customers.ConsultCustomerRespDTO;
import co.com.bancodebogota.dtos.BankAccountDto;

public interface CustomerUpdateMapper {

	ObjectNode mapCreateCustomerRequest(ConsultCustomerRespDTO customerDto, String cellphone, String email,
			String documentNumber, BankAccountDto bankAccountDto) throws JsonProcessingException;

	ObjectNode mapCreateCustomerRequestByCreate(BankAccountDto bankAccountDto) throws JsonProcessingException;
}
