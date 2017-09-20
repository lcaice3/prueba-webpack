package co.com.bancodebogota.dtos.account.debitcards;

public class CustIdDto {

	private String sPName;

	private String custPermId;

	private String custLoginId;

	public String getsPName() {
		return sPName;
	}

	public void setsPName(String sPName) {
		this.sPName = sPName;
	}

	public String getCustPermId() {
		return custPermId;
	}

	public void setCustPermId(String custPermId) {
		this.custPermId = custPermId;
	}

	public String getCustLoginId() {
		return custLoginId;
	}

	public void setCustLoginId(String custLoginId) {
		this.custLoginId = custLoginId;
	}

	@Override
	public String toString() {
		return "CustIdDto [sPName=" + sPName + ", custPermId=" + custPermId + ", custLoginId=" + custLoginId + "]";
	}

}
