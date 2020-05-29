package model;

public class Evento {
	
	private String nome, dataInicio, dataFinal, zona;

	public Evento(String nome, String dataInicio, String dataFinal, String zona) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
		this.zona = zona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String toString() {
		return "Nome do Evento: " + nome + "\nInicio do evento: " + dataInicio + 
				"\nData final:" + dataFinal + "\nZona: " + zona;
	}

}
