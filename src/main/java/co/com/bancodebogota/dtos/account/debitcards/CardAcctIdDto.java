package co.com.bancodebogota.dtos.account.debitcards;

public class CardAcctIdDto {

	private String cardId;

	private String cardType;

	private String cardVrfyData;

	private String expDt;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardVrfyData() {
		return cardVrfyData;
	}

	public void setCardVrfyData(String cardVrfyData) {
		this.cardVrfyData = cardVrfyData;
	}

	public String getExpDt() {
		return expDt;
	}

	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}

}
