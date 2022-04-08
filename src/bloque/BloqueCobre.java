package bloque;

import bloque.categoria.BloqueMineral;
import juego.Jugador;

public class BloqueCobre extends Bloque implements BloqueMineral{
	
	private int material;

	public BloqueCobre(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		this.material = Bloque.COBRE;
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
		return super.toString()+", material Bloque Cobre: " + material;
	}

}