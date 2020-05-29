package persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Evento;
import model.Veiculo;

public class BDEvento {
	
	private static BDEvento INSTANCE;
	private ArrayList<Evento> eventos;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
	
	private BDEvento() {
		this.eventos = new ArrayList<Evento>();
	}
	
	public static BDEvento getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new BDEvento();
		}
		
		return INSTANCE;
	}

	public Evento salvarEvento(Evento evento) {
		Evento even = this.buscarEvento(evento.getNome());
		 if (even != null) {
			return evento.atualizarEvento(evento);
		}
		this.eventos.add(evento);
		return evento;
	}
	
	public boolean excluirEvento(String nome) {
		for (Evento evento : eventos) {
			if (evento.getNome().equals(nome)) {
				this.eventos.remove(evento);
				return true;
			}
		}
		return false;
	}
	
	
	public Evento buscarEvento(String nome) {
		for (Evento evento : eventos) {
			if (evento.getNome() == nome) {
				return evento;
			}
		}
		return null;
	}
	
	public boolean buscarEventoPelaDataInicio(String data) throws ParseException {
		
		for (Evento evento : eventos) {
			if (evento.getDataInicio().equals(sdf.parse(data))){
				return true;
			}
		}
		return false;
	}
	
	public Evento buscarEventoPelaDataFinal(String data) throws ParseException {
		
		for (Evento evento : eventos) {
			if (evento.getDataFinal().equals(sdf.parse(data))){
				
				return evento;
			}
		}
		return null;
	}
}


