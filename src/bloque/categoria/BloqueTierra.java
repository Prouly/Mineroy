package bloque.categoria;

import herramientas.Herramienta;
import herramientas.Pala;
import juego.Jugador;

/**
 * Bloque tierra
 * 
 * @author Alvaro M. & Fran V.
 *
 */

public interface BloqueTierra {
	public static final String HERRAMIENTA ="Pala";
	
	public void destruir (Herramienta herramienta, Jugador jugador);
	
}
