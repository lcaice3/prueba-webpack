package co.com.bancodebogota.events;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class EventsController {

	@Autowired
	private EventsService eventsService;

	@PostMapping("/events")
	public Boolean createEvent(@RequestBody Map<String, Object> obj) throws InterruptedException, ExecutionException {
		String messageType = (String) obj.get("messageType");
		Object messageContent = obj.get("messageContent");
		CompletableFuture<Boolean> publish = eventsService.publish(messageType, messageContent);
		return publish.get();
	}
}
