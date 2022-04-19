package bloque.categoria;

import herramientas.Herramienta;
import juego.Jugador;

/**
 * Bloque mineral
 * 
 * @author Alvaro M. & Fran V.
 *
 */

public interface BloqueMineral {
	
	public static final String HERRAMIENTA ="Pico";
	
	public void destruir (Herramienta herramienta, Jugador jugador);
}
