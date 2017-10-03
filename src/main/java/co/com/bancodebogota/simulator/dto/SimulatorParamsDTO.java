package co.com.bancodebogota.simulator.dto;

public class SimulatorParamsDTO {

	private int minPeriods;
	private int maxPeriods;
	private int periodStep;
	private double minAmount;
	private double maxAmount;
	private double amountStep;
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

	public double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}
	public double getPerLifeInsurance() {
		return perLifeInsurance;
	}

	public void setPerLifeInsurance(double perLifeInsurance) {
		this.perLifeInsurance = perLifeInsurance;
	}

	public int getPeriodStep() {
		return periodStep;
	}

	public void setPeriodStep(int periodsStep) {
		this.periodStep = periodsStep;
	}

	public double getAmountStep() {
		return amountStep;
	}

	public void setAmountStep(double amountStep) {
		this.amountStep = amountStep;
	}
}