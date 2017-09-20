package co.com.bancodebogota.exceptions;

public class CaptchaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5668988057362100627L;
	final boolean success;
	final transient Object response;

	public CaptchaException(boolean success, Object response) {
		super();
		this.success = success;
		this.response = response;
	}

	public boolean isSuccess() {
		return success;
	}

	public Object getResponse() {
		return response;
	}
	
}
