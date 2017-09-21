package co.com.bancodebogota.events;

public class EventPayload {

    private String messageType;

    private String messageContent;

    public String getMessageType() {
        return messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
