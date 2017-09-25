package co.com.bancodebogota.blacklist;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpServerErrorException;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlacklistServiceTests {

	@MockBean
	public RestTemplate restTemplate;
	
	@Autowired
	public BlacklistService blacklistService;
		
	@Test
	public void testIsInBlacklist() {
		
		BlacklistRequestDTO blacklistRequestDTO = new BlacklistRequestDTO
				("12345678", "surname", "secondSurname", "firstName");
		
		when(restTemplate.getForObject(any(URI.class), eq(JsonNode.class)))
			.thenReturn(new ObjectMapper().createObjectNode())
			.thenThrow(new HttpServerErrorException(HttpStatus.CONFLICT));
		
		boolean response = blacklistService.isInBlacklist(blacklistRequestDTO);
		
		assertThat(response).isFalse();
		
		response = blacklistService.isInBlacklist(blacklistRequestDTO);
		
		assertThat(response).isTrue();
	}
}
