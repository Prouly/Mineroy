package bloque.categoria;

import juego.Jugador;

/**
 * Bloque tierra
 * 
 * @author Alvaro M. & Fran V.
 *
 */

public interface BloqueTierra {
	public static final String HERRAMIENTA ="Pala";
	
	public void destruir (String herramienta, Jugador jugador);
}
