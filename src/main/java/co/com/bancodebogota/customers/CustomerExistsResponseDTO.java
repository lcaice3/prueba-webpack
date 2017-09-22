package co.com.bancodebogota.customers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerExistsResponseDTO {
	private Boolean isInBlacklist;
	private boolean isCustomer;
	
	@JsonProperty("isInBlacklist")
	public Boolean isInBlacklist() {
		return isInBlacklist;
	}
	public void isInBlacklist(Boolean isInBlacklist) {
		this.isInBlacklist = isInBlacklist;
	}
	
	@JsonProperty("isCustomer")
	public boolean isCustomer() {
		return isCustomer;
	}
	public void isCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}
}
