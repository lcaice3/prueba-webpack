package co.com.bancodebogota.services.impl;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bancodebogota.digital.utilities.log.LoggerUtils;

import co.com.bancodebogota.dtos.account.debitcards.NotificationRespDto;
import co.com.bancodebogota.dtos.notifications.NotificationRequestDto;
import co.com.bancodebogota.dtos.notifications.ResponseNotification;
import co.com.bancodebogota.events.ThreadPool;
import co.com.bancodebogota.mappers.NotificationMapper;
import co.com.bancodebogota.services.NotificationManagement;

@Service("NotificationManagementService")
public class NotificationManagementImpl implements NotificationManagement {

	public static final String DOCUMENT_TYPE_MVP = "C";

	@Value("${ENDPOINT_NOTIFICATION}")
	private String endpointNotification;

	@Autowired
	private NotificationMapper notificationMapper;

	private static final String RESOURCE = "customer/notification";

	@Override
	public boolean sendNotification(NotificationRespDto notificationDto) {
		CompletableFuture.runAsync(() -> callProxyNotification(notificationDto), ThreadPool.EXECUTOR_SERVICE)
				.handle((content, ex) -> {
					if (ex != null)
						LoggerUtils.error("sendNotification", ex);
					return false;
				});
		return true;
	}

	private boolean callProxyNotification(NotificationRespDto notificationDto) {

		RestTemplate restTemplate = new RestTemplate();
		NotificationRequestDto notificationEmail = new NotificationRequestDto();
		NotificationRequestDto notificationSms = new NotificationRequestDto();
		try {
			LoggerUtils.logJSON(notificationDto, "NotificationDto");

			notificationEmail = createNotificationMail(notificationDto);
			notificationSms = createNotificationSms(notificationDto);
			LoggerUtils.logJSON(notificationEmail, "RequestNotifications email");
			LoggerUtils.logJSON(notificationSms, "RequestNotifications sms");

			String url = endpointNotification + RESOURCE;
			restTemplate.postForEntity(url, notificationEmail, ResponseNotification.class)
					.getBody();
			restTemplate.postForEntity(url, notificationSms, ResponseNotification.class)
					.getBody();
		} catch (Exception e) {
			LoggerUtils.error("Error servicio Notificaciones", e);
		}
		return true;
	}

	private NotificationRequestDto createNotificationSms(NotificationRespDto notificationDto) {
		NotificationRequestDto notificationSms;
		notificationSms = notificationMapper.mapperSmsNotificationRq(notificationDto.getCellPhone(),
				notificationDto.getFirstName(), notificationDto.getIdentityNumber(), DOCUMENT_TYPE_MVP,
				notificationDto.getAccountNumber(), notificationDto.getAccountTypeDescription(),
				notificationDto.getCardNumber());
		return notificationSms;
	}

	private NotificationRequestDto createNotificationMail(NotificationRespDto notificationDto) {
		NotificationRequestDto notificationEmail;
		notificationEmail = notificationMapper.mapperEmailNotificationRq(notificationDto.getEmail(),
				notificationDto.getFirstName(), notificationDto.getIdentityNumber(), DOCUMENT_TYPE_MVP,
				notificationDto.getAccountNumber(), notificationDto.getAccountTypeDescription());
		return notificationEmail;
	}

}
