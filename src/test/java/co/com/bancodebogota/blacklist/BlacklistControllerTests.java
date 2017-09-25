package co.com.bancodebogota.blacklist;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(BlacklistController.class)
public class BlacklistControllerTests {

	@Autowired
	public MockMvc mockMvc;
	
	@MockBean
	public BlacklistService blacklistService;
	
	@Test
	public void testIsInBlacklist() throws Exception {
		
		Boolean response = true;
		
		when(blacklistService.isInBlacklist(any(BlacklistRequestDTO.class)))
			.thenReturn(response);
		
		this.mockMvc.perform(
			get("/blacklist/check-costumer")
				.param("documentNumber", "12345678")
				.param("firstName", "firstName")
				.param("secondSurname", "secondSurname")
				.param("surname", "surname")
			)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString(response.toString())));	
	}
}
