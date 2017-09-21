package co.com.bancodebogota.dtos.notifications;


public enum NotificationTypeDto {

    SMS,
    EMAIL,
    PUSH,
    AUTO;

    public String value() {
        return name();
    }

    public static NotificationTypeDto fromValue(String v) {
        return valueOf(v);
    }

}
