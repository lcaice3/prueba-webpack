package co.com.bancodebogota.blacklist;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;

@Service
public class BlacklistService {
	
	private static final String CONSULT_BLACKLIST_PATH = "/blacklist/consultar-participante";
	private static final String REGISTER_BLACKLIST_CASE_PATH ="/blacklist/registrar-caso";
	
	@Value("${BLACKLIST_ENDPOINT}")
	private String blacklistEndpoint;
	
	@Autowired 
	private RestTemplate restTemplate;

	public boolean isInBlacklist(BlacklistRequestDTO blacklistParticipanteRqDto) {
		boolean clientInBlacklist = false;
		
		UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(blacklistEndpoint)
				.path(CONSULT_BLACKLIST_PATH)
				.queryParam("documentNumber", blacklistParticipanteRqDto.getDocumentNumber())
				.queryParam("firstName", blacklistParticipanteRqDto.getFirstName())
				.queryParam("secondSurname", blacklistParticipanteRqDto.getSecondSurname())
				.queryParam("surname", blacklistParticipanteRqDto.getSurname())
				.queryParam("activeLog", true);
				
		URI uri = urlBuilder.build().encode().toUri() ;

		try {
			restTemplate.getForObject(uri, JsonNode.class);
		} catch (HttpStatusCodeException ex) {
			if (ex.getStatusCode() == HttpStatus.UNAUTHORIZED) {
				clientInBlacklist = true;
			} else {
				throw ex;
			}
		}

		return clientInBlacklist;
	}

	public JsonNode registerCase(BlacklistCaseRequestDTO blacklistRegCasoRqDto) {
		String resource = REGISTER_BLACKLIST_CASE_PATH;
		String url = blacklistEndpoint + resource;
		return restTemplate.postForObject(url, blacklistRegCasoRqDto, JsonNode.class);
	}
}
