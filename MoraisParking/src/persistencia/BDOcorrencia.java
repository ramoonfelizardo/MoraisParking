package persistencia;

import java.util.ArrayList;
import java.util.Date;

import model.Veiculo;

import model.Ocorrencia;

public class BDOcorrencia {
	
	private static BDOcorrencia INSTANCE;
	private ArrayList<Ocorrencia> ocorrencias;
	
	
	private BDOcorrencia() {
		this.ocorrencias = new ArrayList<Ocorrencia>();
	}
	
	public static BDOcorrencia getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new BDOcorrencia();
		}
		
		return INSTANCE;
	}

	public Ocorrencia salvarOcorrencia(Ocorrencia ocorrencia) {
		Ocorrencia oco = this.buscarOcorrencia(ocorrencia.getData());
		 if (oco != null) {
			return ocorrencia.atualizarOcorrencia(ocorrencia);
		}
		this.ocorrencias.add(ocorrencia);
		return ocorrencia;
	}
	
	
	public Ocorrencia buscarOcorrencia(Date Data) {
		for (Ocorrencia ocorrencia : ocorrencias) {
			if (ocorrencia.getData() == Data) {
				return ocorrencia;
			}
		}
		
		return null;

}}
