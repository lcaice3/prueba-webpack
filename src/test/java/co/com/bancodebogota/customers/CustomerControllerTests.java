package co.com.bancodebogota.customers;

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
@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

	@Autowired
	public MockMvc mockMvc;
	
	@MockBean
	public CustomerService customerService;
	
	@Test
	public void testCheckCustomerExists() throws Exception {
		
		CustomerExistsResponseDTO response = new CustomerExistsResponseDTO();
		
		String documentType = "C";
		String documentNumber = "12345678";
		
		String expected = "{'isCustomer': true, 'isInBlacklist': false}";
				
		response.isCustomer(true);
		response.isInBlacklist(false);	
		
		when(customerService.checkUserExists(documentType, documentNumber))
			.thenReturn(response);
		
		this.mockMvc.perform(
			get("/customer-exists")
				.param("documentType", "C")
				.param("documentNumber", "12345678")
			)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().json(expected));	
	}
}
