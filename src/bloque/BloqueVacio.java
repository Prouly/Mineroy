package bloque;


public class BloqueVacio extends Bloque {

	public BloqueVacio(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		
	}
	
	@Override
	public String toString() {
		return "|***|";
	}

}