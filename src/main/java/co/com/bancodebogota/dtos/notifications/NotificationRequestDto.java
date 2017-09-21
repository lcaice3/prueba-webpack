package co.com.bancodebogota.dtos.notifications;

import java.util.List;

public class NotificationRequestDto {

	
	private List<NotificationRecTypeDto> notificationRec;
	private String document;
	private String documentType;
	private String mode;

	public List<NotificationRecTypeDto> getNotificationRec() {
		return notificationRec;
	}

	public void setNotificationRec(List<NotificationRecTypeDto> notificationRec) {
		this.notificationRec = notificationRec;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	

}
