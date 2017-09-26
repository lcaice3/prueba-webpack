package co.com.bancodebogota.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
 
	@GetMapping("/customer-exists")
	public ResponseEntity<CustomerExistsResponseDTO> checkCustomerExists(@RequestParam String documentType, 
		@RequestParam String documentNumber) {
			CustomerExistsResponseDTO response = customerService.checkUserExists(documentType, documentNumber);
			return new ResponseEntity<CustomerExistsResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/health")
	public String health() {
		return "OK";
	}
}
