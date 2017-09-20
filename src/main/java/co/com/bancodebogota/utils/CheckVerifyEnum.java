package co.com.bancodebogota.utils;

public enum CheckVerifyEnum {

	CHECK_CENTRALES("centrales",1),
	CHECK_GMF("gmf",2),
	CHECK_TERMINOS("terminos",3);
	
	
	private final String description;
	private final int idCheck;
	
	
	public String getDescription() {
		return description;
	}


	public int getIdCheck() {
		return idCheck;
	}


	private CheckVerifyEnum(String description, int idCheck) {
		this.description = description;
		this.idCheck = idCheck;
	}
	
	
}
