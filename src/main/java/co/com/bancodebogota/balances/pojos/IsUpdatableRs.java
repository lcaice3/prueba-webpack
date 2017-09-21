package co.com.bancodebogota.balances.pojos;

public class IsUpdatableRs {

	private boolean rejectedByRuleSavings;

	private boolean rejectedByRuleTc;

	public boolean isRejectedByRuleSavings() {
		return rejectedByRuleSavings;
	}

	public void setRejectedByRuleSavings(boolean rejectedByRuleSavings) {
		this.rejectedByRuleSavings = rejectedByRuleSavings;
	}

	public boolean isRejectedByRuleTc() {
		return rejectedByRuleTc;
	}

	public void setRejectedByRuleTc(boolean rejectedByRuleTc) {
		this.rejectedByRuleTc = rejectedByRuleTc;
	}

}
