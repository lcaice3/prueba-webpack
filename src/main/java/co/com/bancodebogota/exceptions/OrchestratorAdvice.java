package co.com.bancodebogota.exceptions;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

import com.bancodebogota.digital.utilities.json.JacksonUtils;
import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestControllerAdvice
public class OrchestratorAdvice {

	private static final String DESCRIPTION = "description";
	private static final String ERROR = "error";

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RequiredValidator.class)
	public ObjectNode handleRequiredValidatorInit(HttpServletRequest req, RequiredValidator ex)
			throws  IOException {
		
		RequiredValidator reqValidator = ex;
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode returnErrors = mapper.createObjectNode();
		Map<String, Set<String>> errorGroup = reqValidator.getFieldErrorList().stream().collect(Collectors.groupingBy(
				FieldError::getField, Collectors.mapping(FieldError::getDefaultMessage, Collectors.toSet())));
		ObjectNode nodeErrors = mapper.readValue(mapper.writeValueAsString(errorGroup), ObjectNode.class);
		returnErrors.put(ERROR, reqValidator.getMessageError());
		returnErrors.putPOJO(DESCRIPTION, nodeErrors);
		LoggerUtils.error("RequiredValidator ->"+ returnErrors);
		return returnErrors;
	}


	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RestMapperJsonException.class)
	protected ObjectNode handleRestMapperJsonException(RestMapperJsonException e) {
		LoggerUtils.error("RestMapperJsonException exception", e);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode err = mapper.createObjectNode();
		err.put("json", e.getJson());
		err.put(ERROR, "RestMapperJsonException");
		return err;
	}

	@ExceptionHandler(HttpStatusCodeException.class)
	protected ResponseEntity<JsonNode> handleHttpStatusCodeException(HttpStatusCodeException e) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode responseBody;
		String stringResponseBody = e.getResponseBodyAsString();
		if (stringResponseBody != null && !stringResponseBody.isEmpty()) {
			responseBody = JacksonUtils.parseWithoutNulls(stringResponseBody);
		} else {
			ObjectNode jsonMappingException = mapper.createObjectNode();
			jsonMappingException.put( "data" , "No se obtuvo response body.");
			responseBody = jsonMappingException;	
		}
		LoggerUtils.error("\nHttpStatusCodeException, statusCode:" + e.getRawStatusCode() + "\n---RESPONSE BODY---"
				+ responseBody.toString());
		return new ResponseEntity<>(responseBody, e.getStatusCode());
	}
		
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(CaptchaException.class)
	protected ObjectNode handleRestServiceException(CaptchaException e) {
	
		LoggerUtils.error("CaptchaService exception", e);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode err = mapper.createObjectNode();
		err.putPOJO(DESCRIPTION,"Error ReCaptchaService");
		return err;
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(InvalidAccess.class)
	protected ObjectNode handleRestServiceException(InvalidAccess e){
		LoggerUtils.error("Error validacion acceso", e);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode err = mapper.createObjectNode();
		err.putPOJO("error",e.getMessage());		
		err.putPOJO(DESCRIPTION,"Error acceso");
		return err;
	}

}