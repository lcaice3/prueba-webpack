package co.com.bancodebogota.customers;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import co.com.bancodebogota.blacklist.BlacklistRequestDTO;
import co.com.bancodebogota.blacklist.BlacklistService;
import co.com.bancodebogota.customers.CustomerDTO;
import co.com.bancodebogota.customers.CustomerExistsResponseDTO;
import co.com.bancodebogota.customers.CustomerService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTests {

	@MockBean
	public RestTemplate restTemplate;
	
	@MockBean
	public BlacklistService blacklistService;
	
	@Autowired
	public CustomerService customerService;
	
	public CustomerExistsResponseDTO response;
	public CustomerDTO customerDTO;
	
	@Before
	public void setUp() {
		customerDTO = new CustomerDTO();
		customerDTO.setFirstName("Nombre prueba");
	}
		
	@Test
	public void testCheckUserExistsWithCustomerOk() {
		 
		when(restTemplate.getForObject(any(URI.class), eq(CustomerDTO.class)))
			.thenReturn(customerDTO);
		
		when(blacklistService.isInBlacklist(any(BlacklistRequestDTO.class)))
		.thenReturn(false);
		
		response = customerService.checkUserExists("C", "12345678");
		
		assertThat(response.isCustomer()).isTrue();
		assertThat(response.isInBlacklist()).isFalse();	
	}
	
	@Test
	public void testCheckUserExistsWithCustomerInBlacklist() {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setFirstName("Nombre prueba");
		
		when(restTemplate.getForObject(any(URI.class), eq(CustomerDTO.class)))
			.thenReturn(customerDTO);
		
		when(blacklistService.isInBlacklist(any(BlacklistRequestDTO.class)))
		.thenReturn(true);
		
		response = customerService.checkUserExists("C", "12345678");
		
		assertThat(response.isCustomer()).isTrue();
		assertThat(response.isInBlacklist()).isTrue();	
	}
	
	@Test
	public void testCheckUserExistsWithNoCustomer() {
		
		when(restTemplate.getForObject(any(URI.class), eq(CustomerDTO.class)))
			.thenReturn(null);
		
		when(blacklistService.isInBlacklist(any(BlacklistRequestDTO.class)))
		.thenReturn(true);
		
		response = customerService.checkUserExists("C", "12345678");
		
		assertThat(response.isCustomer()).isFalse();
		assertThat(response.isInBlacklist()).isNull();	
	}

}
