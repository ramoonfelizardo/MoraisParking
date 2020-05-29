package model;

import java.util.ArrayList;

public class Ocorrencia {
	
	private String data, tipoOcorrencia;
	private ArrayList<Veiculo> listaVeiculos;
	
	public Ocorrencia(String data, String tipoOcorrencia, ArrayList<Veiculo> listaVeiculos) {
		this.data = data;
		this.tipoOcorrencia = tipoOcorrencia;
		this.listaVeiculos = listaVeiculos;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipoOcorrencia() {
		return tipoOcorrencia;
	}

	public void setTipoOcorrencia(String tipoOcorrencia) {
		this.tipoOcorrencia = tipoOcorrencia;
	}

	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public String toString() {
		return "Data: " + data + "\nTipo da ocorrência: " + tipoOcorrencia +
				"\nVeiculos: " + listaVeiculos;
	}
}
