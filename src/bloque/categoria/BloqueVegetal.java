package bloque.categoria;

import herramientas.Herramienta;
import juego.Jugador;

/**
 * Bloque vegetal
 * 
 * @author Alvaro M. & Fran V.
 *
 */

public interface BloqueVegetal {
	public static final String HERRAMIENTA ="Hacha";
	
	public void destruir (Herramienta herramienta, Jugador jugador);
}
