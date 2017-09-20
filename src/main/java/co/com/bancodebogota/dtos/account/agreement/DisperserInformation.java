package co.com.bancodebogota.dtos.account.agreement;

public class DisperserInformation {

	private String nameAccount;
	private String codeAccountDisperser;

	public DisperserInformation() {
		super();
	}
	
	public DisperserInformation(String nameAccount, String codeAccountDisperser) {
		super();
		this.nameAccount = nameAccount;
		this.codeAccountDisperser = codeAccountDisperser;
	}

	public String getNameAccount() {
		return nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public String getCodeAccountDisperser() {
		return codeAccountDisperser;
	}

	public void setCodeAccountDisperser(String codeAccountDisperser) {
		this.codeAccountDisperser = codeAccountDisperser;
	}
	
	
	
}
