package persistencia;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Evento;
import model.Veiculo;

public class BDEstacionamento {
	
	private static BDEstacionamento INSTANCE;
	private Integer qtdVagas = 700;
	private Integer qtdZonaEvento = 500;
	private Integer qtdVagasEspeciais = 300;
	private Veiculo listaDeVagas[] = new Veiculo[1500];
	private Veiculo veiculo;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	private Date dataDeHoje = new Date();
	
	private BDEstacionamento() throws ParseException {
		
		verificarEventoHoje();
	}
	
	public static BDEstacionamento getInstance() throws ParseException {
		
		if(INSTANCE == null) {
			INSTANCE = new BDEstacionamento();
		}
		
		return INSTANCE;
	}

	public boolean locarVaga(boolean tipoVaga, Veiculo veiculo) {
		
		if(tipoVaga) {
			
			if (locarVagaEspecial()) {
				return true;
			}

			else if (locarVagaNormal() || locarVagaEvento()) {
				JOptionPane.showMessageDialog(null, "Não temos mais vagas especiais, mas colocaremos você em uma vaga normal");
				return true;
			}
		}
		
		else{
			if (locarVagaNormal() || locarVagaEvento()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean locarVagaEspecial() {
		for (int i = 0; i < this.listaDeVagas.length; i++) {
			if (this.listaDeVagas[i] == null && qtdVagasEspeciais > 0) {
				this.listaDeVagas[i] = veiculo;
				qtdVagasEspeciais --;
				return true;
			}
		}
		return false;
	}
	
	public boolean locarVagaNormal() {
		for (int i = 0; i < this.listaDeVagas.length; i++) {
			if (this.listaDeVagas[i] == null && qtdVagas > 0) {
				this.listaDeVagas[i] = veiculo;
				qtdVagas --;
				return true;
			}
		}
		return false;
	}
	
	public boolean locarVagaEvento() {
		for (int i = 0; i < this.listaDeVagas.length; i++) {
			if (this.listaDeVagas[i] == null && qtdZonaEvento > 0) {
				this.listaDeVagas[i] = veiculo;
				qtdZonaEvento --;
				return true;
			}
		}
		return false;
	}
	
	public void verificarEventoHoje() throws ParseException {
		
		if (BDEvento.getInstance().buscarEventoPelaDataInicio(sdf.format(dataDeHoje))) {
			FecharZonaParaEvento();
		}
		else {
			Evento evento = BDEvento.getInstance().buscarEventoPelaDataFinal(sdf.format(dataDeHoje));
			if (evento != null) {
				BDEvento.getInstance().excluirEvento(evento.getNome());
				AbrirZonaDeEvento();
			}
		}
	}
	
	public void FecharZonaParaEvento() {
		qtdZonaEvento = 0;
	}
	
	public void AbrirZonaDeEvento() {
		qtdZonaEvento = 500;
	}
	
	public void addVagaEspecial(int qtdNovaVaga) {
		
		qtdVagasEspeciais = qtdNovaVaga + qtdVagasEspeciais;
		qtdVagas = qtdVagas - qtdNovaVaga;
	}

	public Integer getQtdVagas() {
		return qtdVagas;
	}
	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}
	public Integer getQtdVagasEspeciais() {
		return qtdVagasEspeciais;
	}
	public void setQtdVagasEspeciais(Integer qtdVagasEspeciais) {
		this.qtdVagasEspeciais = qtdVagasEspeciais;
	}

	public Integer getQtdZonaEvento() {
		return qtdZonaEvento;
	}

	public void setQtdZonaEvento(Integer qtdZonaEvento) {
		this.qtdZonaEvento = qtdZonaEvento;
	}

	public Veiculo[] getListaDeVagas() {
		return listaDeVagas;
	}

	public void setListaDeVagas(Veiculo listaDeVagas[]) {
		this.listaDeVagas = listaDeVagas;
	}
}