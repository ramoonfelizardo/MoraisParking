package model;

public class Proprietario {

	private String nome;
	private String curso;
	private int matricula;
	private boolean especial;
	private Veiculo veiculo;

	public Proprietario(String nome, String curso, int matricula, boolean especial) {
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

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String toString() {
		return "Nome: " + nome + "\nCurso: " + curso + "\nMatricula: " + matricula + "\nEspecial: " + especial + "\n" + veiculo.toString();
	}
}