package co.com.bancodebogota.dtos.accountlimit;

public class AcctLimitsDescDto {

	private String networkOwner;

	private String amount;

	private String trnCount;

	
	
	
	public String getNetworkOwner() {
		return networkOwner;
	}
	public void setNetworkOwner(String networkOwner) {
		this.networkOwner = networkOwner;
	}
	
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTrnCount() {
		return trnCount;
	}
	public void setTrnCount(String trnCount) {
		this.trnCount = trnCount;
	}
	
	
}
