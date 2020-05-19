package model;

public class Veiculo{
	
	private String placa;
	private String tipoDeVeiculo;
	private Proprietario proprietario;
	
	public Veiculo(String placa, String tipoDeVeiculo, Proprietario proprietario) {
		this.placa = placa;
		this.tipoDeVeiculo = tipoDeVeiculo;
		this.proprietario = proprietario;
		
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

	public String toString() {
		return "Placa: " + placa + "\nTipo do Veículo: " + tipoDeVeiculo;
	}
	
	public Veiculo atualizarVeiculo(Veiculo veiculo) {
		this.placa = veiculo.getPlaca();
		this.tipoDeVeiculo = veiculo.getTipoDeVeiculo();
		this.proprietario = veiculo.getProprietario();
		
		return this;
	}
	
}
