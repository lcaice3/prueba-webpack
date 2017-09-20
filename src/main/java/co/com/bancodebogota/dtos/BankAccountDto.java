package co.com.bancodebogota.dtos;

import java.util.List;

import co.com.bancodebogota.dtos.accountlimit.AcctLimitsDescDto;

public class BankAccountDto {

	private static final String CEDULA = "C";

	private String lastName;

	private String secondLastName;

	private String firstName;

	private String middleName;

	private String gender;

	private Integer expeditionCityId;

	private String expeditionDate;

	private String identityNumber;

	private String birthDate;

	private String email;

	private String livingCityId;

	private String cellphone;

	private Integer occupationId;

	private String employeeName;

	private String employeeAddress;

	private String employeeState;

	private String employeePhone;

	private String monthlyIncome;

	private String monthlyOutcome;

	private String totalAssets;

	private String totalDebts;

	private Boolean hasAuthorizedRiskCheck = true;

	private Boolean greenCard = true;

	private String accountType;

	private Boolean customerExistsInCrm;

	private boolean assetsDeclaration;

	private boolean usaIncome;

	private boolean usaLongTimeVisitor;

	private int bornCityId;

	private String productId;

	private String jobActivityId;

	private int cityCompanyId;

	private String codNomina;

	private String employeeNit;
	
	private String nameCompany;

	private List<AcctLimitsDescDto> accountLimit;

	private String officeCode;
	
	private String officeCodeSeller;
	
	private boolean checkGmf;
	
	private String deliveryAddress;
	
	private boolean txInWeb;
	
	private String fatca; //facta
	
	private boolean clientWithDebitCards;

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public boolean isTxInWeb() {
		return txInWeb;
	}

	public void setTxInWeb(boolean txInWeb) {
		this.txInWeb = txInWeb;
	}

	public List<AcctLimitsDescDto> getAccountLimit() {
		return accountLimit;
	}

	public void setAccountLimit(List<AcctLimitsDescDto> accountLimit) {
		this.accountLimit = accountLimit;
	}

	public void setGreenCard(Boolean greenCard) {
		this.greenCard = greenCard;
	}

	public String getCodNomina() {
		return codNomina;
	}

	public void setCodNomina(String codNomina) {
		this.codNomina = codNomina;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getExpeditionCityId() {
		return expeditionCityId;
	}

	public void setExpeditionCityId(int expeditionCity) {
		this.expeditionCityId = expeditionCity;
	}

	public String getExpeditionDate() {
		return expeditionDate;
	}

	public void setExpeditionDate(String expeditionDate) {
		this.expeditionDate = expeditionDate;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLivingCityId() {
		return livingCityId;
	}

	public void setLivingCityId(String livingCity) {
		this.livingCityId = livingCity;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeState() {
		return employeeState;
	}

	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public Boolean getHasAuthorizedRiskCheck() {
		return hasAuthorizedRiskCheck;
	}

	public void setHasAuthorizedRiskCheck(Boolean hasAuthorizedRiskCheck) {
		this.hasAuthorizedRiskCheck = hasAuthorizedRiskCheck;
	}

	public Boolean getGreenCard() {
		return greenCard;
	}

	public void setGreenCard(boolean greenCard) {
		this.greenCard = greenCard;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public boolean isAssetsDeclaration() {
		return assetsDeclaration;
	}

	public void setAssetsDeclaration(boolean assetsDeclaration) {
		this.assetsDeclaration = assetsDeclaration;
	}

	public boolean isUsaIncome() {
		return usaIncome;
	}

	public void setUsaIncome(boolean usaIncome) {
		this.usaIncome = usaIncome;
	}

	public boolean isUsaLongTimeVisitor() {
		return usaLongTimeVisitor;
	}

	public void setUsaLongTimeVisitor(boolean usaLongTimeVisitor) {
		this.usaLongTimeVisitor = usaLongTimeVisitor;
	}

	public Integer getBornCityId() {
		return bornCityId;
	}

	public void setBornCityId(int borncity) {
		this.bornCityId = borncity;
	}

	public Integer getOccupationId() {
		return occupationId;
	}

	public void setOccupationId(Integer occupationId) {
		this.occupationId = occupationId;
	}

	public String getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(String monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getMonthlyOutcome() {
		return monthlyOutcome;
	}

	public void setMonthlyOutcome(String monthlyOutcome) {
		this.monthlyOutcome = monthlyOutcome;
	}

	public String getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(String totalAssets) {
		this.totalAssets = totalAssets;
	}

	public String getTotalDebts() {
		return totalDebts;
	}

	public void setTotalDebts(String totalDebts) {
		this.totalDebts = totalDebts;
	}

	public Boolean getCustomerExistsInCrm() {
		return customerExistsInCrm;
	}

	public void setCustomerExistsInCrm(Boolean existeClienteCrm) {
		this.customerExistsInCrm = existeClienteCrm;
	}

	public Integer getCityCompanyId() {
		return cityCompanyId;
	}

	public void setCityCompanyId(int cityCompanyId) {
		this.cityCompanyId = cityCompanyId;
	}

	public String getIdentityType() {
		return CEDULA;
	}

	public String getJobActivityId() {
		return jobActivityId;
	}

	public void setJobActivityId(String jobActivityId) {
		this.jobActivityId = jobActivityId;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getEmployeeNit() {
		return employeeNit;
	}

	public void setEmployeeNit(String employeeNit) {
		this.employeeNit = employeeNit;
	}

	public boolean isCheckGmf() {
		return checkGmf;
	}

	public void setCheckGmf(boolean checkGmf) {
		this.checkGmf = checkGmf;
	}


	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public boolean isClientWithDebitCards() {
		return clientWithDebitCards;
	}

	public void setClientWithDebitCards(boolean clientWithDebitCards) {
		this.clientWithDebitCards = clientWithDebitCards;
	}

	public String getOfficeCodeSeller() {
		return officeCodeSeller;
	}

	public void setOfficeCodeSeller(String officeCodeSeller) {
		this.officeCodeSeller = officeCodeSeller;
	}

	@Override
	public String toString() {
		return "BankAccountDto [lastName=" + lastName + ", secondLastName=" + secondLastName + ", firstName="
				+ firstName + ", middleName=" + middleName + ", gender=" + gender + ", expeditionCityId="
				+ expeditionCityId + ", expeditionDate=" + expeditionDate + ", identityNumber=" + identityNumber
				+ ", birthDate=" + birthDate + ", email=" + email + ", livingCityId=" + livingCityId + ", cellphone="
				+ cellphone + ", occupationId=" + occupationId + ", employeeName=" + employeeName + ", employeeAddress="
				+ employeeAddress + ", employeeState=" + employeeState + ", employeePhone=" + employeePhone
				+ ", monthlyIncome=" + monthlyIncome + ", monthlyOutcome=" + monthlyOutcome + ", totalAssets="
				+ totalAssets + ", totalDebts=" + totalDebts + ", hasAuthorizedRiskCheck=" + hasAuthorizedRiskCheck
				+ ", greenCard=" + greenCard + ", accountType=" + accountType + ", customerExistsInCrm="
				+ customerExistsInCrm + ", assetsDeclaration=" + assetsDeclaration + ", usaIncome=" + usaIncome
				+ ", usaLongTimeVisitor=" + usaLongTimeVisitor + ", bornCityId=" + bornCityId + ", productId="
				+ productId + ", jobActivityId=" + jobActivityId + ", cityCompanyId=" + cityCompanyId + ", codNomina="
				+ codNomina + ", employeeNit=" + employeeNit + ", nameCompany=" + nameCompany + ", accountLimit="
				+ accountLimit + ", officeCode=" + officeCode + ", officeCodeSeller=" + officeCodeSeller + ", checkGmf="
				+ checkGmf + ", deliveryAddress=" + deliveryAddress + ", txInWeb=" + txInWeb + ", clientWithDebitCards="
				+ clientWithDebitCards + "]";
	}
	
	/**
	 * @return the fatca
	 */
	public String getFatca() {
		return fatca;
	}  

	/**
	 * @param fatca the fatca to set
	 */
	public void setFatca(String fatca) {
		this.fatca = fatca;
	}

}
