package co.com.bancodebogota.exceptions;

public class RestMapperJsonException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String json;

	public RestMapperJsonException(Throwable e, String json) {
		super("Error mapeando objeto JSON: " + e.getMessage(), e);
		this.json = json;

	}

	public String getJson() {
		return json;
	}

}
