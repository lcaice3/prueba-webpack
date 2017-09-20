package co.com.bancodebogota.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5302122895342413064L;

	public ResourceNotFoundException() {
		super();
	}

    public ResourceNotFoundException(String message) {
        super(message);
    }
}