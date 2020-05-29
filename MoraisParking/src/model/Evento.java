package model;

import java.util.Date;

public class Evento {
	
	private String nome;
	private Date dataInicio, dataFinal;

	public Evento(String nome, Date dataInicio, Date dataFinal) {
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFinal = dataFinal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Evento atualizarEvento(Evento evento) {
		this.nome = evento.getNome();
		this.dataInicio = evento.getDataInicio();
		this.dataFinal = evento.getDataFinal();
		return this;
	}
	
	public String toString() {
		return "Nome do Evento: " + nome + "\nInicio do evento: " + dataInicio + 
				"\nData final:" + dataFinal;
	}

	
	}


