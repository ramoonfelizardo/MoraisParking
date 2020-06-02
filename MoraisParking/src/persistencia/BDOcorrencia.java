package persistencia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Veiculo;
import model.Evento;
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

	
	
	public void escrever(String string){
		try {
			File file = new File ("Relat�rioOcorrencia.txt");
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			output.writeObject(string);
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
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
