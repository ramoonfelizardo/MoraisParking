package persistencia;

import java.util.ArrayList;

import model.Proprietario;
import model.Veiculo;

public class BD {
	
	private static BD INSTANCE;
	private ArrayList<Proprietario> proprietarios;
	private ArrayList<Veiculo> veiculos;
	
	private BD() {
		this.proprietarios = new ArrayList<Proprietario>();
		this.veiculos = new ArrayList<Veiculo>();
	}
	
	public static BD getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new BD();
		}
		
		return INSTANCE;
	}
	
	public Proprietario salvarProprietario(Proprietario proprietario) {
		Proprietario prop = this.buscarProprietario(proprietario.getMatricula());
		if (prop != null) {
			return prop.atualizarProprietario(proprietario);
		}
		this.proprietarios.add(proprietario);
		return proprietario;
	}
	
	public boolean excluirProprietario(String matricula) {
		for (Proprietario proprietario : proprietarios) {
			if (proprietario.getMatricula().equals(matricula)) {
				this.proprietarios.remove(proprietario);
				return true;
			}
		}
		return false;
	}
	
	public Proprietario buscarProprietario(String matricula) {
		for (Proprietario proprietario : proprietarios) {
			if (proprietario.getMatricula().equals(matricula)) {
				return proprietario;
			}
		}
		return null;
	}
	
	public Proprietario buscarProprietarioPeloNome(String nome) {
		for (Proprietario proprietario : proprietarios) {
			if (proprietario.getNome().equals(nome)) {
				return proprietario;
			}
		}
		return null;
	}
	
	public Veiculo salvarVeiculo(Veiculo veiculo) {
		Veiculo veic = this.buscarVeiculoPorPlaca((veiculo.getPlaca()));
		if (veic != null) {
			return veiculo.atualizarVeiculo(veiculo);
		}
		this.veiculos.add(veiculo);
		return veiculo;
	}
	
	public boolean excluirVeiculo(String placa) {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equals(placa)) {
				this.veiculos.remove(veiculo);
				return true;
			}
		}
		return false;
	}
	
	public Veiculo buscarVeiculoPorPlaca(String placa) {
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equals(placa)) {
				return veiculo;
			}
		}
		return null;
	}
}
