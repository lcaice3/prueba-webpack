package co.com.bancodebogota.services;

import co.com.bancodebogota.dtos.account.debitcards.NotificationRespDto;

public interface NotificationManagement {

	public boolean sendNotification(NotificationRespDto notificationDto);

}
