package co.com.bancodebogota.services;

public interface AccountManagementJpa {

	void putCheckItemLog(String documentType,String identityNumber,String check);
	
	void saveCheckLog(String documentType,String identityNumber,String accountNumber);
}
