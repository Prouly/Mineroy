package herramientas;

import bloque.MineroyException;

public abstract class Herramienta {
	
	public static final int USOS_INICIALES = 5;
	
	public static final int HACHA = 0;
	public static final int PALA = 1;
	public static final int PICO = 2;
	public static final int ESPADA = 3;
	
	private int usosRestantes;
	
	public Herramienta() {
		usosRestantes = USOS_INICIALES;
	}

	public int getUsosRestantes() {
		return usosRestantes;
	}
	
	public void usarHerramienta() throws MineroyException {
		if (usosRestantes <=0) {
			throw new MineroyException("ERROR: La herramienta esta destruida");
		}
		
		usosRestantes--;
	}
	
	public abstract int getTipoHerramienta();

	
}