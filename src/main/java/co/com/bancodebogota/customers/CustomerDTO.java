package co.com.bancodebogota.customers;

import java.util.HashMap;
import java.util.Map;

import co.com.bancodebogota.transformations.ToFrontend;

public class CustomerDTO {

	private String firstName;
	private String middleName;
	private String lastName;
	private String secondLastName;
	private String birthDate;
	private String expeditionDate;
	private String expeditionCityId;
	private String email;
	private String cellphone;
	private String sex;
	private String nationality;
	private int codOcupation;
	private String codCiuu;
	private String valActivos;
	private String valEgresos;
	private String valIngresos;
	private String valOtrosActivos;
	private String valPasivos;
	private String codCity;
	private String repCostos;
	private String address1;
	private String purposeAddress1;
	private String effdt;

	public String getEffdt() {
		return effdt;
	}

	public void setEffdt(String effdt) {
		this.effdt = effdt;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getExpeditionDate() {
		return expeditionDate;
	}

	public void setExpeditionDate(String expeditionDate) {
		this.expeditionDate = expeditionDate;
	}

	public String getExpeditionCityId() {
		return expeditionCityId;
	}

	public void setExpeditionCityId(String expeditionCityId) {
		this.expeditionCityId = expeditionCityId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getCodOcupation() {
		return codOcupation;
	}

	public void setCodOcupation(int codOcupation) {
		this.codOcupation = codOcupation;
	}

	public String getCodCiuu() {
		return codCiuu;
	}

	public void setCodCiuu(String codCiuu) {
		this.codCiuu = codCiuu;
	}

	public String getValActivos() {
		return valActivos;
	}

	public void setValActivos(String valActivos) {
		this.valActivos = valActivos;
	}

	public String getValEgresos() {
		return valEgresos;
	}

	public void setValEgresos(String valEgresos) {
		this.valEgresos = valEgresos;
	}

	public String getValIngresos() {
		return valIngresos;
	}

	public void setValIngresos(String valIngresos) {
		this.valIngresos = valIngresos;
	}

	public String getValOtrosActivos() {
		return valOtrosActivos;
	}

	public void setValOtrosActivos(String valOtrosActivos) {
		this.valOtrosActivos = valOtrosActivos;
	}

	public String getValPasivos() {
		return valPasivos;
	}

	public void setValPasivos(String valPasivos) {
		this.valPasivos = valPasivos;
	}

	public String getCodCity() {
		return codCity;
	}

	public void setCodCity(String codCity) {
		this.codCity = codCity;
	}

	public String getRepCostos() {
		return repCostos;
	}

	public void setRepCostos(String repCostos) {
		this.repCostos = repCostos;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getPurposeAddress1() {
		return purposeAddress1;
	}

	public void setPurposeAddress1(String purposeAddress1) {
		this.purposeAddress1 = purposeAddress1;
	}

	public Map<String, String> serialize() {

		HashMap<String, String> map = new HashMap<>();
		map.put("firstName", ToFrontend.asName(getFirstName()));
		map.put("middleName", ToFrontend.asName(getMiddleName()));
		map.put("lastName", ToFrontend.asName(getLastName()));
		map.put("secondLastName", ToFrontend.asName(getSecondLastName()));
		map.put("expeditionCityId", getExpeditionCityId());
		map.put("email", getEmail());
		map.put("cellphone", getCellphone());
		map.put("totalAssets", getValActivos());
		map.put("monthlyIncome", getValIngresos());
		map.put("monthlyOutcome", getValEgresos());
		map.put("totalDebts", getValPasivos());
		return map;
	}

}
