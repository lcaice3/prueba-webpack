package co.com.bancodebogota.utility;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class FinancialMathTests {

	@Test
	public void testGetIRR() {
		double[] payments = { -12000, 5000, 6000, 7000, 8000 };
		double expected = 0.36;

		double result = FinancialMath.getIRR(payments);
		assertThat(result).isCloseTo(expected, within(0.02));
	}

	@Test
	public void testGetPayment() {
		double rate = 0.3;
		double periods = 12;
		double loan = -5000;
		double expected = 1567.27;

		double result = FinancialMath.getPayment(rate, periods, loan);

		assertThat(result).isCloseTo(expected, within(0.02));

	}

	@Test
	public void testNominalToEffective() {

		double nominal = 0.15;
		double term = 12;

		double result = FinancialMath.nominalToEffective(nominal, term);
		double expected = 0.1608;

		assertThat(result).isCloseTo(expected, within(0.0002));
	}

	@Test
	public void testMaxLoanAmount() {

		double salary = 1000000;
		double discount = 20000;
		int nPeriods = 12;
		double expected = 5760000;

		double result = FinancialMath.maxLoanAmount(salary, discount, nPeriods);

		assertThat(result).isEqualTo(expected);
	}
}
