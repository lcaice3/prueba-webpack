package co.com.bancodebogota.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.com.bancodebogota.dtos.account.agreement.DisperserInformation;
import co.com.bancodebogota.dtos.account.agreement.GetDisperserRequest;
import co.com.bancodebogota.services.AccountAgreement;

@Service("AccountAgreementService")
public class AccountAgreementImpl implements AccountAgreement {

	@Value("${ENDPOINT_ACCOUNT_AGREEMENT}")
	private String endpointAgreement;

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public DisperserInformation getAccountInformation(GetDisperserRequest getDisperserRequest) {

		String url = endpointAgreement + "?accountOffice=" + getDisperserRequest.getAccountOffice() + "&identityNumber="
				+ getDisperserRequest.getIdentityNumber() + "&identityType=" + getDisperserRequest.getIdentityType()
				+ "&accountType=" + getDisperserRequest.getAccountType() + "&accountNumber="
				+ getDisperserRequest.getAccountNumber();

		return restTemplate.getForObject(url, DisperserInformation.class);
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
