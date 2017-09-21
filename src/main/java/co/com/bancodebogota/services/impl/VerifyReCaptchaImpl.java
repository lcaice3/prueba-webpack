package co.com.bancodebogota.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bancodebogota.digital.utilities.log.LoggerUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.bancodebogota.captcha.CaptchaResponse;
import co.com.bancodebogota.exceptions.CaptchaException;
import co.com.bancodebogota.services.VerifyReCaptcha;
import co.com.bancodebogota.utils.RedisRepository;
@Service
public class VerifyReCaptchaImpl implements VerifyReCaptcha {

	private RestTemplate restTemplate = new RestTemplate();
	private static final String PREFIX_CHECK_AUTH = "CHECK_AUTH";
	public static final String URL_RECAPTCHA = "https://www.google.com/recaptcha/api/siteverify";
	public static final String KEY_RECAPTCHA = "6Lfd5ygUAAAAACxRY6IqgO-jznBHEJFdyaqW8Pk1";
	public static final String KEY_VERIFY_RECAPTCHA = "jznBHERY6IJFdyaqW8PIqgOk1AAACxRY6";
	
	@Autowired
	RedisRepository storageUtilities;
	
	@Override
	public boolean verifyCaptcha(String publicKey,String verifyReCaptcha,String documentType,String documentNumber) throws CaptchaException {

		LoggerUtils.info("publicKey captcha: " + publicKey + "verifyReCaptcha: " + verifyReCaptcha);
		LoggerUtils.info("publicKey " + publicKey + "verifyReCaptcha " + verifyReCaptcha);
		ObjectMapper mapper = new ObjectMapper();
		if(KEY_VERIFY_RECAPTCHA.equals(verifyReCaptcha)){
			storageUtilities.addCache(documentType, documentNumber, PREFIX_CHECK_AUTH,verifyReCaptcha);
			return true;
		}else{
			if (publicKey == null || "".equals(publicKey) || "undefined".equals(publicKey)) {
				return false;
			}
			String urlCompleteCaptcha = generateUrlCaptcha(publicKey);
			CaptchaResponse recaptchaResponse  = restTemplate.postForEntity(urlCompleteCaptcha , null, CaptchaResponse.class).getBody();
			try {
				LoggerUtils.info("response captcha " + mapper.writeValueAsString(recaptchaResponse));
			} catch (JsonProcessingException e) {
				LoggerUtils.error("Error procesing captcha", e);
			}
			if(recaptchaResponse.getSuccess().equals("true")){
				storageUtilities.addCache(documentType, documentNumber, PREFIX_CHECK_AUTH,publicKey);
				return true;
			}else{
				throw new CaptchaException(false, recaptchaResponse);
			}
		}
		
		
	}
	
	public String generateUrlCaptcha(String publicKey){
		return new StringBuilder()
                .append(URL_RECAPTCHA)
                .append("?secret=")
                .append(KEY_RECAPTCHA)
                .append("&response=")
                .append(publicKey)
                .toString();
		
	}

}
