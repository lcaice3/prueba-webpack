package co.com.bancodebogota.dtos.account.debitcards;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class AssociateCardToAccountDto {

	@NotNull
	private String documentNumber;
	
	private static final String CEDULA = "C";


	@NotNull
	private String cardNumber;

	@NotNull
	private String accountNumber;

	private String cardPin;

	private String otp;

	private boolean newCard;

	private String officeCode;

	@NotNull
	private String accountType;

	private String fullName;

	private String codDane;

	@Valid
	private NotificationRespDto notification;

	private boolean txInOffice;

	private String debitCardFi;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean isNewCard() {
		return newCard;
	}

	public void setNewCard(boolean newCard) {
		this.newCard = newCard;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public NotificationRespDto getNotification() {
		return notification;
	}

	public void setNotification(NotificationRespDto notification) {
		this.notification = notification;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCodDane() {
		return codDane;
	}

	public void setCodDane(String codDane) {
		this.codDane = codDane;
	}

	public boolean isTxInOffice() {
		return txInOffice;
	}

	public void setTxInOffice(boolean txInOffice) {
		this.txInOffice = txInOffice;
	}
	
	public String getIdentityType() {
		return CEDULA;
	}


	@Override
	public String toString() {
		return "AssociateCardToAccountDto [documentNumber=" + documentNumber + ", cardNumber=" + cardNumber
				+ ", accountNumber=" + accountNumber + ", cardPin=" + cardPin + ", otp=" + otp + ", newCard=" + newCard
				+ ", officeCode=" + officeCode + ", accountType=" + accountType + ", notification=" + notification
				+ "]";
	}

	public String getDebitCardFi() {
		return debitCardFi;
	}

	public void setDebitCardFi(String debitCardFi) {
		this.debitCardFi = debitCardFi;
	}
}
