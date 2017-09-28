package co.com.bancodebogota.utility;

import org.apache.poi.ss.formula.functions.Irr;
import org.apache.poi.ss.formula.functions.FinanceLib;

public class FinancialMath {

	public static double getIRR(double[] payments) {
		return Irr.irr(payments);
	}

	public static double getPayment(double rate, double nPeriods, double loan) {
		return getPayment(rate, nPeriods, loan, 0, false);
	}
	
	public static double getPayment(double rate, double nPeriods, double loan, double fv, boolean isAnticipated) {
		return FinanceLib.pmt(rate, nPeriods, loan, 0, false);
	}
	
	public static double nominalToEffective(double nominal, double nPeriods) {
		return Math.pow(nominal / nPeriods + 1, nPeriods) - 1;
	}
	
	public static double maxLoanAmount(double salary, double discount) {
		return (salary / 2) - discount;
	}
}
