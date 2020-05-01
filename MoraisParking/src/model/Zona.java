package model;

public class Zona {
	
	private String nome;
	private final int qntvagas = 20;
	
	public Zona(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Zona" + nome;
	}
}