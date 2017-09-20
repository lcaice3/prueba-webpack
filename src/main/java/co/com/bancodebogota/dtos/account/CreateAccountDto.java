package co.com.bancodebogota.dtos.account;

public class CreateAccountDto {
	
	private static final long serialVersionUID = 1L;

	private boolean txInOffice;
	
	private String bbnumterm;

	private String bbtipodoc;

	private String aanit;

	private String lastname;

	private String secondlastname;

	private String firstname;

	private String middlename;

	private String bbtitularidad;

	private String bbcodceo;

	private String productid;

	private String bbcodctanom;

	private String birthdate;

	private String sex;

	private String aacodciiu;

	private String bbtiporetencion;

	private String bbenvioextracto;

	private String bbcodoficinahs;
	
	private String bbcodvendedor;

	private String bbcodofi;

	private AddressDto a1;

	private String deliveryAddress;

	private String fatca;

	private boolean newClient;
	
	private Integer newCard;
	
	private Integer gmf;

	public String getBbnumterm() {
		return bbnumterm;
	}

	public void setBbnumterm(String bbnumterm) {
		this.bbnumterm = bbnumterm;
	}

	public String getBbtipodoc() {
		return bbtipodoc;
	}

	public void setBbtipodoc(String bbtipodoc) {
		this.bbtipodoc = bbtipodoc;
	}

	public String getAanit() {
		return aanit;
	}

	public void setAanit(String aanit) {
		this.aanit = aanit;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSecondlastname() {
		return secondlastname;
	}

	public void setSecondlastname(String secondlastname) {
		this.secondlastname = secondlastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getBbtitularidad() {
		return bbtitularidad;
	}

	public void setBbtitularidad(String bbtitularidad) {
		this.bbtitularidad = bbtitularidad;
	}

	public String getBbcodceo() {
		return bbcodceo;
	}

	public void setBbcodceo(String bbcodceo) {
		this.bbcodceo = bbcodceo;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAacodciiu() {
		return aacodciiu;
	}

	public void setAacodciiu(String aacodciiu) {
		this.aacodciiu = aacodciiu;
	}

	public String getBbtiporetencion() {
		return bbtiporetencion;
	}

	public void setBbtiporetencion(String bbtiporetencion) {
		this.bbtiporetencion = bbtiporetencion;
	}

	public String getBbenvioextracto() {
		return bbenvioextracto;
	}

	public void setBbenvioextracto(String bbenvioextracto) {
		this.bbenvioextracto = bbenvioextracto;
	}

	public String getBbcodoficinahs() {
		return bbcodoficinahs;
	}

	public void setBbcodoficinahs(String bbcodoficinahs) {
		this.bbcodoficinahs = bbcodoficinahs;
	}

	public String getBbcodofi() {
		return bbcodofi;
	}

	public void setBbcodofi(String bbcodofi) {
		this.bbcodofi = bbcodofi;
	}

	public AddressDto getA1() {
		return a1;
	}

	public void setA1(AddressDto a1) {
		this.a1 = a1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBbcodctanom() {
		return bbcodctanom;
	}

	public void setBbcodctanom(String bbcodctanom) {
		this.bbcodctanom = bbcodctanom;
	}

	public boolean isTxInOffice() {
		return txInOffice;
	}

	public void setTxInOffice(boolean txInOffice) {
		this.txInOffice = txInOffice;
	}

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public boolean isNewClient() {
		return newClient;
	}

	public void setNewClient(boolean newClient) {
		this.newClient = newClient;
	}

	public Integer getNewCard() {
		return newCard;
	}

	public void setNewCard(Integer newCard) {
		this.newCard = newCard;
	}

	public Integer getGmf() {
		return gmf;
	}

	public void setGmf(Integer gmf) {
		this.gmf = gmf;
	}

	public String getBbcodvendedor() {
		return bbcodvendedor;
	}

	public void setBbcodvendedor(String bbcodvendedor) {
		this.bbcodvendedor = bbcodvendedor;
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
