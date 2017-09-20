package co.com.bancodebogota.customers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.node.ObjectNode;

import co.com.bancodebogota.exceptions.CaptchaException;
import co.com.bancodebogota.exceptions.InvalidAccess;
import co.com.bancodebogota.services.VerifyReCaptcha;

@CrossOrigin(origins = "*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private VerifyReCaptcha verifyReCaptchaService;

	@GetMapping("/customer-exists")
	public ResponseEntity<ObjectNode> checkCustomerExists(@RequestParam String documentType,
			@RequestParam String documentNumber, @RequestParam String verifyReCaptcha,
			@RequestParam String gRecaptchaResponse) throws CaptchaException, InvalidAccess {
		if (verifyReCaptchaService.verifyCaptcha(gRecaptchaResponse, verifyReCaptcha, documentType, documentNumber)) {
			ObjectNode response = customerService.checkUserExists(documentType, documentNumber);
			HttpStatus status = response.get("exists").asBoolean() ? HttpStatus.OK : HttpStatus.NOT_FOUND;
			return new ResponseEntity<>(response, status);
		} else {
			throw new InvalidAccess(false, "Captcha requerido");
		}

	}

	@GetMapping("/customer-info")
	public ResponseEntity<Map<String, String>> customerInfo(@RequestHeader("Access-Token") String accessToken,
			@RequestParam String documentType, @RequestParam String documentNumber) {

		String cleanDocNumber = documentNumber.replace(".", "");
		return customerService.getCustomerInfo(accessToken, documentType, cleanDocNumber);
	}

	@PostMapping("/create-customer-reference")
	public boolean createCustomerReference(@RequestBody CustomerReferences customerReferences) {
		return customerService.updateReferences(customerReferences);
	}
}
