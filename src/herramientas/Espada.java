package herramientas;

public class Espada extends Herramienta {
	
	public static int HIERRO_NECESARIO = 2;
	public static int ARBOL_NECESARIO = 1;
	public static int COBRE_NECESARIO = 1;
	
	private int tipoHerramienta;
	
	public Espada () {
		super();
		this.tipoHerramienta = Herramienta.ESPADA;
	}

	public int getTipoHerramienta() {
		return tipoHerramienta;
	}
	
	
}