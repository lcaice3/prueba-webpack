package co.com.bancodebogota.simulator.dto;

public class SimulatorParamsDTO {

	private int minPeriods;
	private int maxPeriods;
	private double minAmount;
	private double perLifeInsurance; 
	
	public int getMinPeriods() {
		return minPeriods;
	}
	public void setMinPeriods(int minPeriods) {
		this.minPeriods = minPeriods;
	}
	public int getMaxPeriods() {
		return maxPeriods;
	}
	public void setMaxPeriods(int maxPeriods) {
		this.maxPeriods = maxPeriods;
	}
	public double getMinAmount() {
		return minAmount;
	}
	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}

	public double getPerLifeInsurance() {
		return perLifeInsurance;
	}

	public void setPerLifeInsurance(double perLifeInsurance) {
		this.perLifeInsurance = perLifeInsurance;
	}
}
