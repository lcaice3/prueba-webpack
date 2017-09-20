package co.com.bancodebogota.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${AUTHENTICATION_SERVICE_ENDPOINT}")
	private String authEndpoint;

	public boolean checkToken(String accessToken, String identityType, String identityNumber) {
		String url = String.format("/check-token?accessToken=%s&documentType=%s&documentNumber=%s", accessToken,
				identityType, identityNumber);
		return restTemplate.getForObject(authEndpoint + url, Boolean.class);
	}
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
}
