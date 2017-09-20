package co.com.bancodebogota.services;

import java.io.IOException;

import co.com.bancodebogota.dtos.BankAccountDto;

public interface CustomerManagement {

	boolean createCustomer(BankAccountDto bankAccountDto);

	boolean updateCustomer(BankAccountDto bankAccountDto) throws IOException;

}
