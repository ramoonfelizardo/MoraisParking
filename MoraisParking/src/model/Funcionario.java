package model;

public class Funcionario {
	
	private String nome;
	private String cargo;
	private boolean especial;
	
	public Funcionario(String nome, String cargo) {
		this.nome = nome;
		this.cargo = cargo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public boolean getEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}
	
	public Funcionario atualizarFuncionario(Funcionario funcionario) {
		this.nome = funcionario.getNome();
		this.cargo = funcionario.getCargo();
		this.especial = funcionario.getEspecial();
		
		return this;
	}

	public String toString() {
		return "Nome do Funcionário: " + nome + "\nCargo: " + cargo + "\nEspecial: " + especial;
	}
}
