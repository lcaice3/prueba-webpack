package co.com.bancodebogota.simulator;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.com.bancodebogota.simulator.dto.SimulatorRequestDTO;
import co.com.bancodebogota.simulator.dto.SimulatorResponseDTO;
import co.com.bancodebogota.utility.FinancialMath;

@Service
public class SimulatorService {
	
	private static int COMP_PERIOD = 12;
	
	@Value("${PER_LIFE_INSURANCE}")
	private double perLifeInsurance;
	
	public SimulatorResponseDTO getSimulatorData(SimulatorRequestDTO request) {
		SimulatorResponseDTO data = new SimulatorResponseDTO();
		
		double [] payments = new double[request.getNumPeriods()];
		
		double rate = getAgreementRate(0, request.getAmount(), request.getNumPeriods());
		double nvm = rate * COMP_PERIOD;
		double rateEA = FinancialMath.nominalToEffective(rate, COMP_PERIOD);
		double payment = FinancialMath.getPayment(rate, request.getNumPeriods(), request.getAmount()); 
		double lifeInsurance = perLifeInsurance * request.getAmount();
		double maxLoanAmount = FinancialMath.maxLoanAmount(request.getSalary(), request.getDiscount());
		
		Arrays.fill(payments, payment + lifeInsurance);
		
		double vtua = FinancialMath.getIRR(payments);
		
		data.setRateNMV(nvm);
		data.setPayment(payment);
		data.setLifeInsurance(lifeInsurance);
		data.setRateEA(rateEA);
		data.setRateVTUA(vtua);
		data.setMaxLoanAmount(maxLoanAmount);
		
		return data;
	}
	
	private double getAgreementRate(int agreementId, double amount, double nPeriods) {
		//TODO: Comsumir decisor
		
		return 0.0125;
		
	}
	
}
