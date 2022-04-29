package bloque;

import bloque.categoria.BloqueVegetal;
import herramientas.Herramienta;
import herramientas.Hacha;
import juego.Jugador;

/**
 * Bloque Planta
 * 
 * @author Alvaro M. & Fran V.
 *
 */

public class BloquePlanta extends Bloque implements BloqueVegetal{
	
	private int material;
	
	public BloquePlanta(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		this.material = Bloque.PLANTA;
	}

	public void destruir (Herramienta herramienta, Jugador jugador) {
		if (herramienta instanceof Hacha) {
			jugador.sumaMateria(material);
		}
		super.destruir(herramienta, jugador);

	}

	@Override
	public String toString() {
		return "|pla|";
	}

}