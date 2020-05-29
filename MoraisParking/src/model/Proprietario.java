package model;

public class Proprietario {
	
	
	private String nome;
	private String curso;
	private String matricula;
	private boolean especial;

	
	public Proprietario() {
		
	}
	
	public Proprietario(String nome, String curso, String matricula, boolean especial) {
		this.nome = nome;
		this.curso = curso;
		this.matricula = matricula;
		this.especial = especial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean getEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}
	
	public Proprietario atualizarProprietario(Proprietario proprietario) {
		this.curso = proprietario.getCurso();
		this.matricula = proprietario.getMatricula();
		this.nome = proprietario.getNome();
		this.especial = proprietario.getEspecial();
		
		return this;
	}

	public String toString() {
		return "Nome: " + nome + "\nCurso: " + curso + "\nMatricula: " + matricula + "\nEspecial: " + especial;
	}
}
