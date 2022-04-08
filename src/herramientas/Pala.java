package herramientas;

public class Pala extends Herramienta {
	
	public static int HIERRO_NECESARIO = 2;
	public static int ARBOL_NECESARIO = 2;
	
	private int tipoHerramienta;
	
	public Pala() {
		super();
		this.tipoHerramienta = Herramienta.PALA;
	}

	public int getTipoHerramienta() {
		return tipoHerramienta;
	}

}