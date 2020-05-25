package persistencia;

public class BDRelatorio {
	
	private static BDRelatorio INSTANCE;
	
	private BDRelatorio() {

	}
	
	public static BDRelatorio getInstance() {
		
		if(INSTANCE == null) {
			INSTANCE = new BDRelatorio();
		}
		
		return INSTANCE;
	}

}
