package co.com.bancodebogota.simulator.dto;

public class SimulatorResponseDTO {

	private double payment;
	private double rateNMV;
	private double rateEA;
	private double rateVTUA;
	private double maxLoanAmount;
	private double lifeInsurance;

	public double getLifeInsurance() {
		return lifeInsurance;
	}

	public void setLifeInsurance(double lifeInsurance) {
		this.lifeInsurance = lifeInsurance;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public double getRateNMV() {
		return rateNMV;
	}

	public void setRateNMV(double rateNMV) {
		this.rateNMV = rateNMV;
	}

	public double getRateEA() {
		return rateEA;
	}

	public void setRateEA(double rateEA) {
		this.rateEA = rateEA;
	}

	public double getRateVTUA() {
		return rateVTUA;
	}

	public void setRateVTUA(double rateVTUA) {
		this.rateVTUA = rateVTUA;
	}

	public double getMaxLoanAmount() {
		return maxLoanAmount;
	}

	public void setMaxLoanAmount(double maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
}
