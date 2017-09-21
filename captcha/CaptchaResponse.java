package co.com.bancodebogota.captcha;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaptchaResponse {

	private String success;
	@JsonProperty("error-codes")
	private List<String> errorCode;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public List<String> getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(List<String> errorCode) {
		this.errorCode = errorCode;
	}

}
