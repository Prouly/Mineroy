package juego;

import bloque.Bloque;
import bloque.MineroyException;
import herramientas.Espada;
import herramientas.Hacha;
import herramientas.Herramienta;
import herramientas.Pala;
import herramientas.Pico;

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
	
	
	/**
	 * Se crea jugador con materias Primas a 0 y con todas las herramientas creadas con 5 usos cada una
	 * @param nombre Como metodo de entrada se indica el nombre del jugador.
	 */
	public Jugador(String nombre) {
		this.nombre = nombre.toUpperCase();
		for (int i = 0; i < materiasPrimas.length; i++) {
			this.materiasPrimas[i]=0;
		}
		
		this.herramientasJugador[Herramienta.HACHA] = new Hacha();
		this.herramientasJugador[Herramienta.PALA] = new Pala();
		this.herramientasJugador[Herramienta.PICO] = new Pico();
		this.herramientasJugador[Herramienta.ESPADA] = new Espada();
	}

	/**
	 * Muestra el nombre del jugador, las materias que tiene recolectadas, su posicion en el mapa y las herramientas
	 */
	public String toString() {
		return this.nombre + " - Materias primas recolectadas\n" + "Plantas: " + materiasPrimas[Bloque.PLANTA] + "\nArboles: "
				+ materiasPrimas[Bloque.ARBOL] + "\nArcilla: " + materiasPrimas[Bloque.ARCILLA] + "\nAlbero: "
				+ materiasPrimas[Bloque.ALBERO] + "\nHierro: " + materiasPrimas[Bloque.HIERRO] + "\nCobre: " + materiasPrimas[Bloque.COBRE]
						+ "\n- Herramientas (usos restantes):\nHacha: "+ herramientasJugador[Herramienta.HACHA].getUsosRestantes()
						+"\nPala: "+ herramientasJugador[Herramienta.PALA].getUsosRestantes()
						+"\nPico: "+ herramientasJugador[Herramienta.PICO].getUsosRestantes()
						+"\nEspada: "+ herramientasJugador[Herramienta.ESPADA].getUsosRestantes();
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
		case Bloque.CARNE: {
			materiasPrimas[Bloque.CARNE]++;	
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}
		
	}
	
	/**
	 * Metodo que crea todas las herramientas si el jugador tiene los materiales suficientes
	 * @throws MineroyException error al no tener materiales suficientes para crearlo
	 */
	public void crearHerramientas() throws MineroyException{
			
		//Se crea Hacha y si no tiene material suficiente lanza excepcion
		if (!(materiasPrimas[Bloque.ARBOL]>=Hacha.ARBOL_NECESARIO && materiasPrimas[Bloque.HIERRO]>=Hacha.HIERRO_NECESARIO)) {
			throw new MineroyException("ERROR: No tienes material sufiente para crear un hacha");
		} else {
			herramientasJugador[Herramienta.HACHA]  = new Hacha();
		}
		
		//Se crea Pala y si no tiene material suficiente lanza excepcion
		if (!(materiasPrimas[Bloque.ARBOL]>=Pala.ARBOL_NECESARIO && materiasPrimas[Bloque.HIERRO]>=Pala.HIERRO_NECESARIO)) {
			throw new MineroyException("ERROR: No tienes material sufiente para crear una pala");
		} else {
			herramientasJugador[Herramienta.PALA]  = new Pala();
		}
		
		//Se crea Pico y si no tiene material suficiente lanza excepcion
		if (!(materiasPrimas[Bloque.ARBOL]>=Pico.ARBOL_NECESARIO && materiasPrimas[Bloque.HIERRO]>=Pico.HIERRO_NECESARIO && materiasPrimas[Bloque.COBRE]>= Pico.COBRE_NECESARIO)) {
			throw new MineroyException("ERROR: No tienes material sufiente para crear un pico");
		} else {
			herramientasJugador[Herramienta.PICO]  = new Pico();
		}
		
		//Se crea Espada y si no tiene material suficiente lanza excepcion
		if (!(materiasPrimas[Bloque.ARBOL]>=Espada.ARBOL_NECESARIO && materiasPrimas[Bloque.HIERRO]>=Espada.HIERRO_NECESARIO && materiasPrimas[Bloque.COBRE]>= Espada.COBRE_NECESARIO)) {
			throw new MineroyException("ERROR: No tienes material sufiente para crear un pico");
		} else {
			herramientasJugador[Herramienta.ESPADA]  = new Espada();
		}
		

	}
	

}