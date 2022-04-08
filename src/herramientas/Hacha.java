package herramientas;

public class Hacha extends Herramienta {
	
	private int tipoHerramienta;
	
	public Hacha() {
		super();
		this.tipoHerramienta = Herramienta.HACHA;
	}

	public int getTipoHerramienta() {
		return tipoHerramienta;
	}

}
