package co.com.bancodebogota.services;

import co.com.bancodebogota.exceptions.CaptchaException;

public interface VerifyReCaptcha {
	
	public boolean verifyCaptcha(String publicKey,String verifyReCaptcha,String documentType,String documentNumber) throws CaptchaException;
}
