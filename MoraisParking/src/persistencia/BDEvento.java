package persistencia;

public class BDEvento {
	
	private static BDEvento INSTANCE;
	
	private BDEvento() {

	}
	
	public static BDEvento getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new BDEvento();
		}
		
		return INSTANCE;
	}

}
