package co.com.bancodebogota.simulator;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.com.bancodebogota.simulator.dto.SimulatorParamsDTO;
import co.com.bancodebogota.simulator.dto.SimulatorRequestDTO;
import co.com.bancodebogota.simulator.dto.SimulatorResponseDTO;
import co.com.bancodebogota.utility.FinancialMath;

@Service
public class SimulatorService {

	private static int COMP_PERIOD = 12;

	@Value("${PER_LIFE_INSURANCE}")
	private String perLifeInsurance;

	@Value("${MAXIMUM_TERM}")
	private String maxPeriods;

	@Value("${MINIMUM_TERM}")
	private String minPeriods;

	@Value("${MINIMUM_AMOUNT}")
	private String minAmount;

	@Value("${MAXIMUM_AMOUNT}")
	private String maxAmount;

	/**
	 * @return the perLifeInsurance
	 */
	private double getPerLifeInsurance() {
		return Double.parseDouble(perLifeInsurance);
	}

	/**
	 * @return the maxPeriods
	 */
	private int getMaxPeriods() {
		return Integer.parseInt(maxPeriods);
	}

	/**
	 * @return the minPeriods
	 */
	private int getMinPeriods() {
		return Integer.parseInt(minPeriods);
	}

	/**
	 * @return the minAmount
	 */
	private double getMinAmount() {
		return Double.parseDouble(minAmount);
	}

	/**
	 * @return the maxAmount
	 */
	private double getMaxAmount() {
		return Double.parseDouble(maxAmount);
	}

	public SimulatorResponseDTO getSimulatorData(SimulatorRequestDTO request) {

		SimulatorResponseDTO data = new SimulatorResponseDTO();

		double[] payments = new double[request.getNumPeriods() + 1];

		double rate = getAgreementRate(request.getAmount(), request.getNumPeriods());
		double nvm = rate * COMP_PERIOD;
		double rateEA = FinancialMath.nominalToEffective(rate, COMP_PERIOD);
		double payment = FinancialMath.getPayment(rate, request.getNumPeriods(), -request.getAmount());
		double lifeInsurance = getPerLifeInsurance() * request.getAmount();
		double maxLoanAmount = FinancialMath.maxLoanAmount(request.getSalary(), request.getDiscount(),
				request.getNumPeriods());

		Arrays.fill(payments, payment + lifeInsurance);
		payments[0] = -request.getAmount(); 

		double vtua = FinancialMath.getIRR(payments);

		data.setRateNMV(nvm);
		data.setPayment(payment);
		data.setLifeInsurance(lifeInsurance);
		data.setRateEA(rateEA);
		data.setRateVTUA(vtua);
		data.setMaxLoanAmount(maxLoanAmount);

		return data;
	}

	public SimulatorParamsDTO getSimulatorParams() {

		SimulatorParamsDTO params = new SimulatorParamsDTO();

		params.setMaxPeriods(getMaxPeriods());
		params.setMinAmount(getMinAmount());
		params.setMinPeriods(getMinPeriods());
		params.setPerLifeInsurance(getPerLifeInsurance());

		return params;
	}

	public double[][] getRatesTable() {
		int periodRange = 6;
		int amountRange = 100000;
		int periodDimension = getMaxPeriods() / periodRange;
		int amountDimension = (int) (getMaxAmount() / amountRange);

		double[][] rates = new double[periodDimension][amountDimension];

		for (int i = 0; i < periodDimension; i++) {
			for (int j = 0; j < amountDimension; j++) {
				int period = periodRange * (i+1);
				double amount = amountRange * (j+1);
				rates[i][j] = getAgreementRate(amount, period);
			}
		}
		
		return rates;
	}

	private double getAgreementRate(double amount, double nPeriods) {
		// TODO: Comsumir decisor

		return 0.0125;

	}

}
