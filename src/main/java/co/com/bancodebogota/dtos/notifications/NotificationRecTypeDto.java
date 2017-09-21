package co.com.bancodebogota.dtos.notifications;

public class NotificationRecTypeDto {


	private NotificationTypeDto type;
	private String category;
	private Boolean securityPhone;
	private Boolean securityEmail;
	private DeliveryInfoTypeDto deliveryInfo;

	public NotificationTypeDto getType() {
		return type;
	}

	public void setType(NotificationTypeDto type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Boolean getSecurityPhone() {
		return securityPhone;
	}

	public void setSecurityPhone(Boolean securityPhone) {
		this.securityPhone = securityPhone;
	}

	public Boolean getSecurityEmail() {
		return securityEmail;
	}

	public void setSecurityEmail(Boolean securityEmail) {
		this.securityEmail = securityEmail;
	}

	public DeliveryInfoTypeDto getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(DeliveryInfoTypeDto deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

}
