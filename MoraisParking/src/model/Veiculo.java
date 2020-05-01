package model;

public class Veiculo {
	
	private String placa;
	private String tipoDeVeiculo;
	private Proprietario proprietario;
	
	public Veiculo(String placa, String tipoDeVeiculo, Proprietario proprietario) {
		this.placa = placa;
		this.tipoDeVeiculo = tipoDeVeiculo;
		
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getTipoDeVeiculo() {
		return tipoDeVeiculo;
	}

	public void setTipoDeVeiculo(String tipoDeVeiculo) {
		this.tipoDeVeiculo = tipoDeVeiculo;
	}
	

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Veiculo [placa=" + placa + ", tipoDeVeiculo=" + tipoDeVeiculo + "]";
	}
	

}
