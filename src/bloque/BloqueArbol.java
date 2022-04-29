package bloque;

import bloque.categoria.BloqueVegetal;
import herramientas.Herramienta;
import herramientas.Hacha;
import juego.Jugador;

public class BloqueArbol extends Bloque implements BloqueVegetal {

	private int material;

	public BloqueArbol(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		this.material = Bloque.ARBOL;
	}

	public void destruir(Herramienta herramienta, Jugador jugador) {
		if (herramienta instanceof Hacha) {
			jugador.sumaMateria(material);
		}
		super.destruir(herramienta, jugador);

	}


	@Override
	public String toString() {
		return "|arb|";
	}

}