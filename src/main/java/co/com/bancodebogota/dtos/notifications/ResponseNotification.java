package co.com.bancodebogota.dtos.notifications;

public class ResponseNotification {

	private boolean sendNotification;
	private String description;

	public boolean isSendNotification() {
		return sendNotification;
	}

	public void setSendNotification(boolean sendNotification) {
		this.sendNotification = sendNotification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
