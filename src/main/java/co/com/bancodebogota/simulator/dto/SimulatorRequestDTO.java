package co.com.bancodebogota.simulator.dto;

public class SimulatorRequestDTO {
	
	private double amount;
	private int nPeriods;
	private double salary;
	private double discount;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getNumPeriods() {
		return nPeriods;
	}
	public void setNumPeriods(int nPeriods) {
		this.nPeriods = nPeriods;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
