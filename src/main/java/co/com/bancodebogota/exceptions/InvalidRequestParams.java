package co.com.bancodebogota.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;

public class InvalidRequestParams extends Exception {

	private static final long serialVersionUID = -7213391407399422499L;
	private final String param;
	private final List<FieldError> fieldErrorList;

	public InvalidRequestParams(String param, String message) {
		super(message);
		this.param = param;
		this.fieldErrorList = null;
	}

	public InvalidRequestParams(String param, List<FieldError> fieldErrorList) {
		super();
		this.param = param;
		this.fieldErrorList = fieldErrorList;
	}

	public String getParam() {
		return param;
	}

	public List<FieldError> getFieldErrorList() {
		return fieldErrorList;
	}

	public Map<String, Object> serialize() {
		Map<String, Set<String>> errorGroup = this.getFieldErrorList().stream().collect(Collectors.groupingBy(
				FieldError::getField, Collectors.mapping(FieldError::getDefaultMessage, Collectors.toSet())));

		Map<String, Object> errorMessage = new HashMap<>();
		errorMessage.put("param", this.param);
		errorMessage.put("error", errorGroup);
		return errorMessage;
	}

}
