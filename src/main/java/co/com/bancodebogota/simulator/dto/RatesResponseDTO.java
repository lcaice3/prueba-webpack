package co.com.bancodebogota.simulator.dto;

public class RatesResponseDTO {
	private String descripcionRespuesta;
	private String tipoTasa;
	private double valor;
	private double tasaEA;
	private String spread;
	private String valorDFT;
	
	public String getValorDFT() {
		return valorDFT;
	}
	public void setValorDFT(String valorDFT) {
		this.valorDFT = valorDFT;
	}
	public String getDescripcionRespuesta() {
		return descripcionRespuesta;
	}
	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}
	public String getTipoTasa() {
		return tipoTasa;
	}
	public void setTipoTasa(String tipoTasa) {
		this.tipoTasa = tipoTasa;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getTasaEA() {
		return tasaEA;
	}
	public void setTasaEA(double tasaEA) {
		this.tasaEA = tasaEA;
	}
	public String getSpread() {
		return spread;
	}
	public void setSpread(String spread) {
		this.spread = spread;
	}
}
