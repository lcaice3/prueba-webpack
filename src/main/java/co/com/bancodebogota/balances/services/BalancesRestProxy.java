package co.com.bancodebogota.balances.services;

import co.com.bancodebogota.balances.pojos.AccountBalancesResponse;

public interface BalancesRestProxy {

	AccountBalancesResponse getTotalBalances(String documentNumber);

}
