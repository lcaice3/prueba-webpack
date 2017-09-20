package co.com.bancodebogota.dtos.account.agreement;

import org.hibernate.validator.constraints.NotBlank;

public class GetDisperserRequest {
	
	@NotBlank
	private String identityNumber;
	@NotBlank
	private String identityType;
	@NotBlank
	private String accountNumber;
	@NotBlank
	private String accountType;
	@NotBlank
	private String accountOffice;

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountOffice() {
		return accountOffice;
	}

	public void setAccountOffice(String accountOffice) {
		this.accountOffice = accountOffice;
	}
}