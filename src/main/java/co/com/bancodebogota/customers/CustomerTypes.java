package co.com.bancodebogota.customers;

public enum CustomerTypes {
	NON_CUSTOMER(0),
	NON_ACCOUNT_CUSTOMER(1),
	ACCOUNT_CUSTOMER(2);
	
	private int value;
	
	CustomerTypes(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}
