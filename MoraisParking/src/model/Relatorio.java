package model;

import java.util.ArrayList;

public class Relatorio {
	// codar pra mostrar as vagas disponiveis e ocupadas
	
	private String data;
	private ArrayList<Ocorrencia> listaOcorrencia;
	private ArrayList<Evento> listaEvento;
	
	public Relatorio(String data, ArrayList<Ocorrencia> listaOcorrencia, ArrayList<Evento> listaEvento) {
		this.data = data;
		this.listaOcorrencia = listaOcorrencia;
		this.listaEvento = listaEvento;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public ArrayList<Ocorrencia> getListaOcorrencia() {
		return listaOcorrencia;
	}

	public void setListaOcorrencia(ArrayList<Ocorrencia> listaOcorrencia) {
		this.listaOcorrencia = listaOcorrencia;
	}

	public ArrayList<Evento> getListaEvento() {
		return listaEvento;
	}

	public void setListaEvento(ArrayList<Evento> listaEvento) {
		this.listaEvento = listaEvento;
	}

	public String toString() {
		return "Relatório \nData: " + data + ", Ocorrências: " + listaOcorrencia +
				"\nEventos: " + listaEvento;
	}
	
}
