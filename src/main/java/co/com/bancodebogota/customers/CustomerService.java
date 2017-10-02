package co.com.bancodebogota.customers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
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

		CustomerExistsResponseDTO response = new CustomerExistsResponseDTO();
		try
		{
			CustomerDTO customer = getCustomerInfoFromBackend(identityType, identityNumber);
			
			
			response.isCustomer(customerExists(customer));
	
			if (response.isCustomer()) {
				BlacklistRequestDTO blackListRequest = new BlacklistRequestDTO(identityNumber,
						customer.getLastName(), null, customer.getFirstName());
				boolean clientInBlacklist = blacklistService.isInBlacklist(blackListRequest);
				response.isInBlacklist(clientInBlacklist);
		} 
		} catch (Exception e) {
			System.out.println("error checkUserExists despues de ajuste "+e.getMessage() );
			throw e;
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
				.queryParam("documentNumber", identityNumber)
				.queryParam("documentType", identityType);
			
			URI uri = urlBuilder.build().encode().toUri() ;
		
			url = uri.getPath();
			url = uri.toString();
			
			return restTemplate.getForObject(uri, CustomerDTO.class);
			
		} catch (HttpStatusCodeException ex) {
			
			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				
				return null;
			} 
			else {
				System.out.println("get customer error  despues de ajuste  "+ex.getMessage()+" URL "+ url +"  endpoint propiedades "+customerEndpoint);
				
				throw ex;
			}
			
			
		}
	}
}
