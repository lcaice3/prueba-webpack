package co.com.bancodebogota.mappers;

import co.com.bancodebogota.dtos.BankAccountDto;
import co.com.bancodebogota.dtos.account.debitcards.NotificationRespDto;
import co.com.bancodebogota.dtos.notifications.NotificationRequestDto;

public interface NotificationMapper {

	NotificationRequestDto mapperSmsNotificationRq(String cellPhone,String name,String identityNumber,String identityType, String numAccount,String accountType,String debitCard);

	NotificationRequestDto mapperEmailNotificationRq(String email, String name, String identityNumber,
			String identityType, String numAccount,String accountType);
    NotificationRespDto setNotificationReqDto(BankAccountDto bankAccountDto,String accountNumber);
}
