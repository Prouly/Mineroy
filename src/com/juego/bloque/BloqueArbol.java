package bloque;

import categoria.BloqueVegetal;
import juego.Jugador;

public class BloqueArbol extends Bloque implements BloqueVegetal {
	
	private int material;
	
	public BloqueArbol(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		this.material = Bloque.ARBOL;
	}
	
	public void destruir (String herramienta, Jugador jugador) {
		if (!(herramienta.equalsIgnoreCase(HERRAMIENTA))) {
			super.destruir(herramienta, jugador);
		} else {
			super.destruir(herramienta, jugador);	 
			jugador.sumaMateria(material);
		}
		

	}

	@Override
	public String toString() {
		return super.toString()+", material Bloque Arbol: " + material;
	}

}