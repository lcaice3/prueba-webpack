package co.com.bancodebogota.customers;

import java.util.List;

public class CustomerReferences {

    private String documentType;

    private String documentNumber;

    private List<CustomerReference> customerReferences;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

	public List<CustomerReference> getCustomerReferences() {
		return customerReferences;
	}

	public void setCustomerReferences(List<CustomerReference> customerReferencesList) {
		this.customerReferences = customerReferencesList;
	}
}
