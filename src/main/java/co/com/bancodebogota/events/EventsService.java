package co.com.bancodebogota.events;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bancodebogota.digital.utilities.events.EventsManager;
import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EventsService {

	@Value("${events-manager.api-gateway-id}")
	private String eventsApiGatewayId;
	
	private EventsManager eventsManager;

	private ObjectMapper mapper = new ObjectMapper();

	public CompletableFuture<Boolean> publish(String messageType, Object messageContent) {
		try {
			String payload = mapper.writeValueAsString(messageContent);
			CompletableFuture.runAsync(() -> getEventsManager().publish(messageType, payload),
					ThreadPool.EXECUTOR_SERVICE);
			return CompletableFuture.completedFuture(true);
		} catch (JsonProcessingException e) {
			LoggerUtils.error("publish", e);
			return CompletableFuture.completedFuture(false);
		}
	}

	public void setEventsManager(EventsManager eventsManager) {
		this.eventsManager = eventsManager;
	}

	public EventsManager getEventsManager() {
		if (eventsManager == null) {
			eventsManager = new EventsManager(eventsApiGatewayId);
		}
		return eventsManager;
	}
}
