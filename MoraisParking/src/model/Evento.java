package model;


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import javax.swing.JOptionPane;

public class Evento implements Serializable {
	
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

	public void escrever(Evento evento){
		try {
			File file = new File ("RelatórioEvento.txt");
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(evento.toString());
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
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


