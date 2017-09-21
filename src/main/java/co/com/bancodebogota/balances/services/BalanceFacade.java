package co.com.bancodebogota.balances.services;

import co.com.bancodebogota.balances.pojos.IsUpdatableRs;

public interface BalanceFacade {

	IsUpdatableRs checkUser(String documentNumber);

}
