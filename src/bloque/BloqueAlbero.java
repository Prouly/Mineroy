package bloque;

import bloque.categoria.BloqueTierra;
import juego.Jugador;

public class BloqueAlbero extends Bloque implements BloqueTierra{
	
	private int material;
	
	public BloqueAlbero(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		this.material = Bloque.ALBERO;
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
		return super.toString()+", material Bloque Tierra: " + material;
	}

}