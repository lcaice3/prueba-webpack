package co.com.bancodebogota.services;

import co.com.bancodebogota.dtos.account.agreement.DisperserInformation;
import co.com.bancodebogota.dtos.account.agreement.GetDisperserRequest;

public interface AccountAgreement {
	
	DisperserInformation getAccountInformation(GetDisperserRequest getDisperserRequest);

}
