package co.com.bancodebogota.dtos.account.debitcards;

public class CardMgmtAddRqDto {

	private String clientTerminalSeqId;

	private NetworkTrnInfoDto networkTrnInfoDto;

	private CustIdDto custIdDto;

	private String branchId;

	private CardAcctIdDto cardAcctIdDto;

	private String pinBlock;

	private String otp;

	public String getClientTerminalSeqId() {
		return clientTerminalSeqId;
	}

	public void setClientTerminalSeqId(String clientTerminalSeqId) {
		this.clientTerminalSeqId = clientTerminalSeqId;
	}

	public NetworkTrnInfoDto getNetworkTrnInfoDto() {
		return networkTrnInfoDto;
	}

	public void setNetworkTrnInfoDto(NetworkTrnInfoDto networkTrnInfoDto) {
		this.networkTrnInfoDto = networkTrnInfoDto;
	}

	public CustIdDto getCustIdDto() {
		return custIdDto;
	}

	public void setCustIdDto(CustIdDto custIdDto) {
		this.custIdDto = custIdDto;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public CardAcctIdDto getCardAcctIdDto() {
		return cardAcctIdDto;
	}

	public void setCardAcctIdDto(CardAcctIdDto cardAcctIdDto) {
		this.cardAcctIdDto = cardAcctIdDto;
	}

	public String getPinBlock() {
		return pinBlock;
	}

	public void setPinBlock(String pinBlock) {
		this.pinBlock = pinBlock;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "CardMgmtAddRqDto [clientTerminalSeqId=" + clientTerminalSeqId + ", networkTrnInfoDto="
				+ networkTrnInfoDto + ", custIdDto=" + custIdDto + ", branchId=" + branchId + ", cardAcctIdDto="
				+ cardAcctIdDto + ", pinBlock=" + pinBlock + ", otp=" + otp + "]";
	}

}
