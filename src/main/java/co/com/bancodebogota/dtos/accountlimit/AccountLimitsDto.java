package co.com.bancodebogota.dtos.accountlimit;

import java.util.List;

public class AccountLimitsDto {

	private String documentType;

	private String numberDocument;

	private String acctId;

	private String acctType;	

	private List<AcctLimitsDescDto>listAcctLimitsDesc;
	
	
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getNumberDocument() {
		return numberDocument;
	}
	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}
	public String getAcctId() {
		return acctId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	public List<AcctLimitsDescDto> getListAcctLimitsDesc() {
		return listAcctLimitsDesc;
	}
	public void setListAcctLimitsDesc(List<AcctLimitsDescDto> listAcctLimitsDesc) {
		this.listAcctLimitsDesc = listAcctLimitsDesc;
	}
	
	
}
