package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Ocorrencia implements Serializable{
	
	private Date data;
	private String tipoOcorrencia;
	private ArrayList<Veiculo> listaVeiculos;
	
	public Ocorrencia(Date data, String tipoOcorrencia, ArrayList<Veiculo> listaVeiculos) {
		this.data = data;
		this.tipoOcorrencia = tipoOcorrencia;
		this.listaVeiculos = listaVeiculos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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

	public Ocorrencia atualizarOcorrencia(Ocorrencia ocorrencia) {
		this.data = ocorrencia.getData();
		this.listaVeiculos = ocorrencia.getListaVeiculos();
		this.tipoOcorrencia = ocorrencia.getTipoOcorrencia();
		
		return this;
	}	
	
	public String toString() {
		return "Data: " + data + "\nTipo da ocorr�ncia: " + tipoOcorrencia +
				"\nVeiculos: " + listaVeiculos;
	}
}
