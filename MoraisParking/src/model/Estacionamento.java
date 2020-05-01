package model;

import java.util.ArrayList;

public class Estacionamento {
	
	private ArrayList<Zona> listaZona;
	private ArrayList<ZonaEspecial> listaZonaEspecial;
	private final int qntvagas = 100;
	
	public Estacionamento(ArrayList<Zona> listaZona) {
		this.listaZona = listaZona;
	}
	
	public ArrayList<Zona> getListaZona() {
		return listaZona;
	}
	
	public void setListaZona(ArrayList<Zona> listaZona) {
		this.listaZona = listaZona;
	}

	public String toString() {
		return "Zonas: " + listaZona;
	}
}