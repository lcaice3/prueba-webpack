package co.com.bancodebogota.exceptions;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class CustomerManagmentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2794805286724151192L;

	private final transient ObjectNode customerNode;

	public CustomerManagmentException(String message, Throwable cause, ObjectNode customerNode) {
		super(message, cause);
		this.customerNode = customerNode;
	}

	public ObjectNode getCustomerNode() {
		return customerNode;
	}

}
