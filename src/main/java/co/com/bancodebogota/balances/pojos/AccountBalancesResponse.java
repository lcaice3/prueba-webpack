package co.com.bancodebogota.balances.pojos;

import java.math.BigDecimal;

public class AccountBalancesResponse {

	BigDecimal savingsTotal;

	BigDecimal creditTotal;

	public BigDecimal getSavingsTotal() {
		return savingsTotal;
	}

	public void setSavingsTotal(BigDecimal balancesTotal) {
		this.savingsTotal = balancesTotal;
	}

	public BigDecimal getCreditTotal() {
		return creditTotal;
	}

	public void setCreditTotal(BigDecimal creditTotal) {
		this.creditTotal = creditTotal;
	}

}
