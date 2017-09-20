package co.com.bancodebogota.exceptions;

public class InvalidAccess extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6811369891753687784L;
	final boolean  sucess;
	final String message;
	
	public InvalidAccess(boolean success, String message) {
		super();
		sucess = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return sucess;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
}
