package co.com.bancodebogota.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.bancodebogota.dtos.BankAccountDto;
import co.com.bancodebogota.dtos.account.debitcards.NotificationRespDto;
import co.com.bancodebogota.dtos.notifications.DeliveryInfoTypeDto;
import co.com.bancodebogota.dtos.notifications.NotificationRecTypeDto;
import co.com.bancodebogota.dtos.notifications.NotificationRequestDto;
import co.com.bancodebogota.dtos.notifications.NotificationTypeDto;
import co.com.bancodebogota.dtos.notifications.ParameterTypeDto;
import co.com.bancodebogota.utils.MaskRemover;
@Service
public class NotificationMapperImpl implements NotificationMapper {
	
	public static final String CATEGORY_EMAIL = "NMON";
	public static final String TYPE_EMAIL = "EMAIL";
	public static final boolean SECURITY = false;
	public static final String TEMPLATE_EMAIL = "cuentas_digital";
	public static final String BUSINESS_EMAIL = "NOTIFICACIONES";
	public static final String TYPE_SMS = "SMS";
	public static final String CATEGORY_SMS = "MON";
	public static final String CONTRACT = "refWSEmailRutaDigital";
	public static final String PARAMETER_NAME = "nombre_cliente";
	public static final String PARAMETER_ACCOUNT_NUMBER = "num_cuenta";
	public static final String PARAMETER_ACCOUNT_TYPE = "tipo_cuenta";
	public static final String MODE = "sync";
	public static final String SUBJECT = "Creación de cuenta";

	@Autowired
	MaskRemover maskRemover;

	@Override
	public NotificationRequestDto mapperSmsNotificationRq(String cellPhone, String name, String identityNumber,
			String identityType, String numAccount, String accountType, String debitCard) {
		NotificationRequestDto notificationRequestDto = new NotificationRequestDto();
		notificationRequestDto.setDocument(maskRemover.removeIdentificationMask(identityNumber));
		notificationRequestDto.setDocumentType(identityType);
		notificationRequestDto.setMode(MODE);
		notificationRequestDto.setNotificationRec(setNotificationRecTypeSmsDto(
				maskRemover.removeCellphoneMask(cellPhone), SUBJECT, name, numAccount, accountType, debitCard));

		return notificationRequestDto;
	}

	public String returnMessageSmsOffice(String name, String accountType, String accountNumber, String debitCard) {
		return String.format(
				"¡Bienvenido a Banco de Bogotá, %s! Has hecho una excelente eleccion al abrir tu cuenta %s %s con tu tarjeta débito #%s.",
				name, accountType, accountNumber, debitCard.substring(12, debitCard.length()));
	}

	public String returnMessageSmsWeb(String name, String accountType, String accountNumber) {
		return String.format(
				"¡Bienvenido a Banco de Bogota, %s! Has hecho una excelente eleccion al abrir tu cuenta %s %s.", name,
				accountType, accountNumber);
	}

	@Override
	public NotificationRequestDto mapperEmailNotificationRq(String email, String name, String identityNumber,
			String identityType, String numAccount,String accountType) {
		NotificationRequestDto notificationRequestDto = new NotificationRequestDto();
		notificationRequestDto.setDocument(maskRemover.removeIdentificationMask(identityNumber));
		notificationRequestDto.setDocumentType(identityType);
		notificationRequestDto.setMode(MODE);
		notificationRequestDto.setNotificationRec(setNotificationRecTypeEmailDto(email, SUBJECT, name, numAccount,accountType));
		return notificationRequestDto;
	}

	public List<NotificationRecTypeDto> setNotificationRecTypeEmailDto(String email, String subject, String name,
			String numCuenta,String tipoCuenta) {
		List<NotificationRecTypeDto> notificationRec = new ArrayList<>();
		NotificationRecTypeDto notificationRecDto = new NotificationRecTypeDto();
		notificationRecDto.setCategory(CATEGORY_EMAIL);
		notificationRecDto.setType(NotificationTypeDto.EMAIL);
		notificationRecDto.setSecurityEmail(SECURITY);
		notificationRecDto
				.setDeliveryInfo(setDeliveryInfoTypEmailDto(email, subject, setParameterEmailTypeDto(name, numCuenta,tipoCuenta)));
		notificationRec.add(notificationRecDto);
		return notificationRec;
	}

	public List<NotificationRecTypeDto> setNotificationRecTypeSmsDto(String cellPhone, String subject, String name,
			String numCuenta, String accountType, String debitcard) {
		List<NotificationRecTypeDto> notificationRec = new ArrayList<>();
		NotificationRecTypeDto notificationRecDto = new NotificationRecTypeDto();
		notificationRecDto.setCategory(CATEGORY_SMS);
		notificationRecDto.setType(NotificationTypeDto.SMS);
		notificationRecDto.setSecurityPhone(SECURITY);
		notificationRecDto.setDeliveryInfo(
				setDeliveryInfoTypSmslDto(cellPhone, subject, accountType, debitcard, numCuenta, name));
		notificationRec.add(notificationRecDto);
		return notificationRec;
	}

	public DeliveryInfoTypeDto setDeliveryInfoTypEmailDto(String email, String subject,
			List<ParameterTypeDto> parameter) {
		DeliveryInfoTypeDto delivery = new DeliveryInfoTypeDto();
		delivery.setEmailAddr(email);
		delivery.setLabel(TEMPLATE_EMAIL);
		delivery.setMessage("1");
		delivery.setSubject(subject);
		delivery.setContract(CONTRACT);
		delivery.setBusiness(BUSINESS_EMAIL);
		delivery.setTemplate(TEMPLATE_EMAIL);
		delivery.setParameters(parameter);
		return delivery;
	}

	public DeliveryInfoTypeDto setDeliveryInfoTypSmslDto(String cellPhone, String subject, String accountType,
			String debitCard, String accountNumber, String name) {
		DeliveryInfoTypeDto delivery = new DeliveryInfoTypeDto();
		delivery.setPhone(cellPhone);
		delivery.setMessage(debitCard != null ? returnMessageSmsOffice(name, accountType, accountNumber, debitCard)
				: returnMessageSmsWeb(name, accountType, accountNumber));
		delivery.setSubject(subject);
		return delivery;
	}

	public List<ParameterTypeDto> setParameterEmailTypeDto(String name, String numCuenta,String tipoCuenta) {
		List<ParameterTypeDto> parameterList = new ArrayList<>();
		ParameterTypeDto parameter = new ParameterTypeDto();
		parameter.setName(PARAMETER_NAME);
		parameter.setValue(name);
		parameterList.add(parameter);
		parameter = new ParameterTypeDto();
		parameter.setName(PARAMETER_ACCOUNT_NUMBER);
		parameter.setValue(numCuenta);
		parameterList.add(parameter);
		parameter = new ParameterTypeDto();
		parameter.setName(PARAMETER_ACCOUNT_TYPE);
		parameter.setValue(tipoCuenta);
		parameterList.add(parameter);
		return parameterList;
	}
	
	@Override
	public NotificationRespDto setNotificationReqDto(BankAccountDto bankAccountDto,String accountNumber){
		NotificationRespDto notificationRespDto = new NotificationRespDto();
		 notificationRespDto.setAccountNumber(accountNumber);
		 notificationRespDto.setAccountTypeDescription(bankAccountDto.getAccountType());
		 notificationRespDto.setCellPhone(bankAccountDto.getCellphone());
		 notificationRespDto.setEmail(bankAccountDto.getEmail());
		 notificationRespDto.setFirstName(bankAccountDto.getFirstName());
		 notificationRespDto.setIdentityNumber(bankAccountDto.getIdentityNumber());
		 return notificationRespDto;
	}
}
