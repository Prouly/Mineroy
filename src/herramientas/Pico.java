package herramientas;

public class Pico extends Herramienta {
	
	public static int HIERRO_NECESARIO = 1;
	public static int ARBOL_NECESARIO = 2;
	public static int COBRE_NECESARIO = 1;
	
	private int tipoHerramienta;
	
	public Pico() {
		super();
		this.tipoHerramienta = Herramienta.PICO;
	}

	public int getTipoHerramienta() {
		return tipoHerramienta;
	}
	
}