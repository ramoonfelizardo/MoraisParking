package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Estacionamento {
	
	private ArrayList <Proprietario> proprietario;
	private Integer total = 1500;
	private Integer qtdVagas = 700;
	private Integer qtdZonaEvento = 500;
	private Integer qtdVagasEspeciais = 300;
	private boolean evento;

	public Estacionamento() {
		
	}
	
	public Estacionamento(ArrayList<Proprietario> p) {
		this.proprietario = p;
	}
	
	//Quando houver um evento passar a v�riavel "evento" para true, assim a zona de evento esta bloqueada.
	
	public void locada(boolean tipoVaga) {
		
		if(tipoVaga) {
			qtdVagasEspeciais --;
		}else {
			qtdVagas --;
			if(qtdVagas == 0 && evento == false) {
				qtdZonaEvento --;
			}if(qtdVagas == 0 && evento == true) {
				JOptionPane.showMessageDialog(null, "zona bloqueada para evento!");
			}
			
			
		}

	}
	
	public void addVagaEspecial(int qtdNovaVaga) {
		
		qtdVagasEspeciais = qtdNovaVaga + qtdVagasEspeciais;
		qtdVagas = qtdVagas - qtdNovaVaga;
		
	}
	
	public ArrayList<Proprietario> getProprietario() {
		return proprietario;
	}
	public void setProprietario(ArrayList<Proprietario> proprietario) {
		this.proprietario = proprietario;
	}
	public Integer getQtdVagas() {
		return qtdVagas;
	}
	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}
	public Integer getQtdVagasEspeciais() {
		return qtdVagasEspeciais;
	}
	public void setQtdVagasEspeciais(Integer qtdVagasEspeciais) {
		this.qtdVagasEspeciais = qtdVagasEspeciais;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getQtdZonaEvento() {
		return qtdZonaEvento;
	}

	public void setQtdZonaEvento(Integer qtdZonaEvento) {
		this.qtdZonaEvento = qtdZonaEvento;
	}

	public boolean isEvento() {
		return evento;
	}

	public void setEvento(boolean evento) {
		this.evento = evento;
	}
	
	
	
}