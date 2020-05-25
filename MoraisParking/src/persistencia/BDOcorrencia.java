package persistencia;

public class BDOcorrencia {
	
	private static BDOcorrencia INSTANCE;
	
	private BDOcorrencia() {

	}
	
	public static BDOcorrencia getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new BDOcorrencia();
		}
		
		return INSTANCE;
	}

}
