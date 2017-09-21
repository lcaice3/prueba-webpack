package co.com.bancodebogota.dtos.notifications;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class ClientDto {
	@NotBlank
	@NotEmpty
	@NotNull
	private String documentType;

	@NotBlank
	@NotEmpty
	@NotNull
	private String document;

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}



}
