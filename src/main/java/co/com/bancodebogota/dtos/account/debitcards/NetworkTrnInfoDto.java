
package co.com.bancodebogota.dtos.account.debitcards;

public class NetworkTrnInfoDto {

	private String networkOwner;
	private String terminalId;
	private String terminalType;
	private String bankId;
	private String desc;
	private String name;

	public String getNetworkOwner() {
		return networkOwner;
	}

	public void setNetworkOwner(String networkOwner) {
		this.networkOwner = networkOwner;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "NetworkTrnInfoDto [networkOwner=" + networkOwner + ", terminalId=" + terminalId + ", terminalType="
				+ terminalType + ", bankId=" + bankId + ", desc=" + desc + ", name=" + name + "]";
	}

}
