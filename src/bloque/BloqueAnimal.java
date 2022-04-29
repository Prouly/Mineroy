package bloque;

import herramientas.Espada;
import herramientas.Herramienta;
import juego.Jugador;

public class BloqueAnimal extends Bloque {
	
	public static final String HERRAMIENTA ="Espada";
	
	private int material;
	
	public BloqueAnimal(int x, int y, int z) throws MineroyException {
		super(x, y, z);
		this.material = Bloque.CARNE;
	}
	
	public void destruir(Herramienta herramienta, Jugador jugador) {
		if (herramienta instanceof Espada) {
			jugador.sumaMateria(material);
		}
		super.destruir(herramienta, jugador);

	}


	@Override
	public String toString() {
		return "|PIG|";
	}


}
