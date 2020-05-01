package model;

public class ZonaEspecial {
	
	private String nome;
	private final int qntvagas = 20;
	
	public ZonaEspecial(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return "Zona Especial" + nome;
	}
}