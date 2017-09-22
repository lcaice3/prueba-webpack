package co.com.bancodebogota.blacklist;

import javax.validation.constraints.NotNull;


public class BlacklistCaseRequestDTO {
	
	@NotNull
   private String firstName;
	
	@NotNull
	private String surname;
	
	@NotNull
	private String application;
	
	@NotNull
	private String codigoUnidad;
	
	@NotNull
	private String documentNumber;
	
	@NotNull
	private String rejectionCode;
	
	@NotNull
	private String listTypeCode;
	
	@NotNull
	private String rejectionDescription;
	
	private boolean activeLog;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getCodigoUnidad() {
		return codigoUnidad;
	}

	public void setCodigoUnidad(String codigoUnidad) {
		this.codigoUnidad = codigoUnidad;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getRejectionCode() {
		return rejectionCode;
	}

	public void setRejectionCode(String rejectionCode) {
		this.rejectionCode = rejectionCode;
	}

	public String getListTypeCode() {
		return listTypeCode;
	}

	public void setListTypeCode(String listTypeCode) {
		this.listTypeCode = listTypeCode;
	}

	public String getRejectionDescription() {
		return rejectionDescription;
	}

	public void setRejectionDescription(String rejectionDescription) {
		this.rejectionDescription = rejectionDescription;
	}

	public boolean isActiveLog() {
		return activeLog;
	}

	public void setActiveLog(boolean activeLog) {
		this.activeLog = activeLog;
	}
	
}
