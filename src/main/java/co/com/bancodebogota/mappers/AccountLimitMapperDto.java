package co.com.bancodebogota.mappers;

import co.com.bancodebogota.dtos.BankAccountDto;
import co.com.bancodebogota.dtos.accountlimit.AccountLimitsDto;

public class AccountLimitMapperDto {

	public AccountLimitsDto createAccountLimitDto(BankAccountDto bankAccountDto,String accountNumber){
		AccountLimitsDto accountLimitsDto = new AccountLimitsDto();
		accountLimitsDto.setAcctId(accountNumber);
		accountLimitsDto.setAcctType("SDA");
		accountLimitsDto.setDocumentType(bankAccountDto.getIdentityType());
		accountLimitsDto.setNumberDocument(bankAccountDto.getIdentityNumber());
		accountLimitsDto.setListAcctLimitsDesc(bankAccountDto.getAccountLimit());
		return accountLimitsDto;
	}
}
