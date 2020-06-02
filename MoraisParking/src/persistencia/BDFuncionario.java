package persistencia;

import java.util.ArrayList;

import model.Funcionario;
import model.Proprietario;
import model.Veiculo;

public class BDFuncionario {
	
	private static BDFuncionario INSTANCE;
	private ArrayList<Funcionario> funcionarios;
	
	private BDFuncionario() {
		this.funcionarios = new ArrayList<Funcionario>();
	}
	
	public static BDFuncionario getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new BDFuncionario();
		}
		
		return INSTANCE;
	}
	
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		Funcionario func = this.buscarFuncionario(funcionario.getNome());
		if (func != null) {
			return funcionario.atualizarFuncionario(funcionario);
		}
		this.funcionarios.add(funcionario);
		return funcionario;
	}
	
	
	public Funcionario buscarFuncionario(String Nome) {
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getNome().equals(Nome)) {
				return funcionario;
			}
		}
		
		return null;
	}

}
