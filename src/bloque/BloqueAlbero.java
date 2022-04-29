package bloque;

import bloque.categoria.BloqueTierra;
import herramientas.Herramienta;
import herramientas.Pala;
import juego.Jugador;

public class BloqueAlbero extends Bloque implements BloqueTierra{
	
	private int material;
	
	public BloqueAlbero(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		this.material = Bloque.ALBERO;
	}
	
	public void destruir(Herramienta herramienta, Jugador jugador) {
		if (herramienta instanceof Pala) {
			jugador.sumaMateria(material);
		}
		super.destruir(herramienta, jugador);

	}


	@Override
	public String toString() {
		return "|alb|";
	}

}