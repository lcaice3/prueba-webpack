package co.com.bancodebogota.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class RequiredValidator extends RuntimeException {

	private static final long serialVersionUID = 9223355855891056795L;

	private final String messageError;
	private final List<FieldError> fieldErrorList;

	public RequiredValidator(String messageError, List<FieldError> fieldErrorList) {
		super();
		this.messageError = messageError;
		this.fieldErrorList = fieldErrorList;
	}

	public String getMessageError() {
		return messageError;
	}

	public List<FieldError> getFieldErrorList() {
		return fieldErrorList;
	}

}