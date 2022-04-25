package herramientas;

public class Hacha extends Herramienta {
	
	public static int HIERRO_NECESARIO = 2;
	public static int ARBOL_NECESARIO = 1;
	
	private int tipoHerramienta;
	
	public Hacha() {
		super();
		this.tipoHerramienta = Herramienta.HACHA;
	}

	public int getTipoHerramienta() {
		return tipoHerramienta;
	}

}
