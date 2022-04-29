package bloque;

import bloque.categoria.BloqueMineral;
import herramientas.Herramienta;
import herramientas.Pico;
import juego.Jugador;

public class BloqueCobre extends Bloque implements BloqueMineral{
	
	private int material;

	public BloqueCobre(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		this.material = Bloque.COBRE;
	}
	
	public void destruir (Herramienta herramienta, Jugador jugador) {
		if (herramienta instanceof Pico) {
			jugador.sumaMateria(material);
		}
		super.destruir(herramienta, jugador);

	}

	@Override
	public String toString() {
		return "|cob|";
	}

}