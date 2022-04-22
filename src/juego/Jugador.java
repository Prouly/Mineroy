package juego;

import bloque.Bloque;
import bloque.MineroyException;
import herramientas.Herramienta;

/**
 * Clase que representa el jugador del MineMonroy
 * @author y0rg
 * Crear Atributo Array de herramientas que tiene el jugador
 * Crear metodo para craftear la herramienta, añadirla al array de herramientas y restar materiales que ha costado
 *
 */
public class Jugador {
	
	//Nombre del jugador
	String nombre;

	//Lista de materias primas del jugador
	int[] materiasPrimas = new int[Bloque.NUM_MATERIAS];
	
	//Herramientas que tiene el jugador (El jugador nace con las herramientas creadas)
	Herramienta[] herramientasJugador = new Herramienta[4];

	public Jugador(String nombre) {
		this.nombre = nombre;
		for (int i = 0; i < materiasPrimas.length; i++) {
			this.materiasPrimas[i]=0;
		}
	}

	/**
	 * No hace falta explicarlo... o si?
	 */
	public String toString() {
		return this.nombre + " - Materias primas recolectadas\n" + "Plantas: " + materiasPrimas[Bloque.PLANTA] + "\nArboles: "
				+ materiasPrimas[Bloque.ARBOL] + "\nArcilla: " + materiasPrimas[Bloque.ARCILLA] + "\nAlbero: "
				+ materiasPrimas[Bloque.ALBERO] + "\nHierro: " + materiasPrimas[Bloque.HIERRO] + "\nCobre: " + materiasPrimas[Bloque.COBRE];
	}

	
	/**
	 * Metodo que añade una unidad de una materia "tipo"
	 * @param tipo, entero que representa el tipo de Materia.
	 * @see bloque.Bloque.java
	 */
	public void sumaMateria(int tipo) {
		switch (tipo) {
		case Bloque.ALBERO: {
			materiasPrimas[Bloque.ALBERO]++;	
			break;
		}
		case Bloque.ARBOL: {
			materiasPrimas[Bloque.ARBOL]++;	
			break;
		}
		case Bloque.ARCILLA: {
			materiasPrimas[Bloque.ARCILLA]++;
			break;
		}
		case Bloque.COBRE: {
			materiasPrimas[Bloque.COBRE]++;
			break;
		}
		case Bloque.HIERRO: {
			materiasPrimas[Bloque.HIERRO]++;
			break;
		}
		case Bloque.PLANTA: {
			materiasPrimas[Bloque.PLANTA]++;	
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}
		
	}
	
	/**
	 * Metodo que crea una herramienta si el jugador tiene los materiales suficientes
	 * @return Herramienta creada
	 * @throws MineroyException error al no tener materiales suficientes para crearlo
	 */
	public Herramienta crearHerramienta() throws MineroyException{
		Herramienta herramientaCreada = null;
		
		return herramientaCreada;
	}
	
	

}