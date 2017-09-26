package co.com.bancodebogota.customers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.com.bancodebogota.blacklist.BlacklistRequestDTO;
import co.com.bancodebogota.blacklist.BlacklistService;

@Service
public class CustomerService {
	
	private static final String CUSTOMER_INFO_PATH = "/customer-info";

	@Value("${CUSTOMER_SERVICE_ENDPOINT}")
	private String customerEndpoint;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BlacklistService blacklistService;

	public CustomerExistsResponseDTO checkUserExists(String identityType, String identityNumber) {

		CustomerDTO customer = getCustomerInfoFromBackend(identityType, identityNumber);
		CustomerExistsResponseDTO response = new CustomerExistsResponseDTO();
		
		response.isCustomer(customerExists(customer));

		if (response.isCustomer()) {
			BlacklistRequestDTO blackListRequest = new BlacklistRequestDTO(identityNumber,
					customer.getLastName(), null, customer.getFirstName());
			boolean clientInBlacklist = blacklistService.isInBlacklist(blackListRequest);
			response.isInBlacklist(clientInBlacklist);
		} 

		return response;
	}

	private boolean customerExists(CustomerDTO consultCustomerRespDTO) {
		if (consultCustomerRespDTO == null)
			return false;
		
		String firstName = consultCustomerRespDTO.getFirstName();
		return firstName != null && !firstName.isEmpty();
	}

	private CustomerDTO getCustomerInfoFromBackend(String identityType, String identityNumber) {
		
		String url="";
		try {
			UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(customerEndpoint)
				.path(CUSTOMER_INFO_PATH)
				.queryParam("documentType", identityType)
				.queryParam("documentNumber", identityNumber);
			
			URI uri = urlBuilder.build().encode().toUri() ;
		
			url = uri.getPath();
			
			return restTemplate.getForObject(uri, CustomerDTO.class);
			
		} catch (Exception e) {
			System.out.println(e.getMessage()+ url );
			throw e;
		}
	}
}
