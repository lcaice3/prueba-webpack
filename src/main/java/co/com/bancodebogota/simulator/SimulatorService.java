package co.com.bancodebogota.simulator;

import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.com.bancodebogota.simulator.dto.SimulatorParamsDTO;
import co.com.bancodebogota.simulator.dto.SimulatorRequestDTO;
import co.com.bancodebogota.simulator.dto.SimulatorResponseDTO;
import co.com.bancodebogota.utility.FinancialMath;

@Service
public class SimulatorService {

	private static int COMP_PERIOD = 12;
	
	@Value("${DECISOR_ENDPOINT}")
	private String decisorEndpoint;

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
	
	@Value("${AMOUNT_STEP}")
	private String amountStep;
	
	@Value("${TERM_STEP}")
	private String periodStep;
	
	@Value("${MAXIMUM_AMOUNT_STEP}")
	private String maxAmountStep;
	
	@Autowired
	private RestTemplate restTemplate;
	

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

	/**
	 * @return the amountStep
	 */
	private double getAmountStep() {
		return Double.parseDouble(amountStep);
	}

	/**
	 * @return the periodStep
	 */
	private int getPeriodStep() {
		return Integer.parseInt(periodStep);
	}

	/**
	 * @return the maxAmountStep
	 */
	private double getMaxAmountStep() {
		return Double.parseDouble(maxAmountStep);
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
		params.setMaxAmount(getMaxAmount());
		params.setPerLifeInsurance(getPerLifeInsurance());
		params.setAmountStep(getAmountStep());
		params.setPeriodStep(getPeriodStep());
		params.setMaxAmountStep(getMaxAmountStep());

		return params;
	}

	public double[][] getRatesTable() {
		int periodRange = getPeriodStep();
		double amountRange = getAmountStep();
		int periodDimension = getMaxPeriods() / periodRange;
		int amountDimension = (int) (getMaxAmountStep() / amountRange) + 1;

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
		
		String url="";
		try {
			
			UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(decisorEndpoint)
				.path("/convenio")				
				.queryParam("amount", amount)
				.queryParam("plazo", nPeriods);
			
			URI uri = urlBuilder.build().encode().toUri() ;
		
			url = uri.getPath();
			url = uri.toString();
			
			// return restTemplate.getForObject(uri, Double.class);
			return 0.0125;
			
		} catch (HttpStatusCodeException ex) {
			
			throw ex;	
		}
	}

}
