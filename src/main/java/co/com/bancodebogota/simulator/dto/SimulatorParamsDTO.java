package co.com.bancodebogota.simulator.dto;

public class SimulatorParamsDTO {

	private int minPeriods;
	private int maxPeriods;
	private double minAmount;
	
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
}
