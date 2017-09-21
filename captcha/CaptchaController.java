package co.com.bancodebogota.captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.bancodebogota.exceptions.CaptchaException;
import co.com.bancodebogota.services.VerifyReCaptcha;

@CrossOrigin(origins = "*")
@RestController
public class CaptchaController {

	@Autowired
	VerifyReCaptcha verifyReCaptcha;

	@RequestMapping(value="/verifyCaptcha", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public boolean verifyCaptcha(@RequestBody String gRecaptchaResponse, @RequestBody String validCaptcha,String documentType,String documentNumber) throws CaptchaException  {
		return verifyReCaptcha.verifyCaptcha(gRecaptchaResponse,validCaptcha,documentType,documentNumber);
	}
}
