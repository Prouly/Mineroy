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
 * @author y0rg, 4lv4r0 y Fr4n
 * Crear Atributo Array de herramientas que tiene el jugador
 * Crear metodo para craftear la herramienta, añadirla al array de herramientas y restar materiales que ha costado
 *
 */
public class Jugador {
	
	private static final int MOVIMIENTOS_TURNO = 1;

	//Nombre del jugador
	String nombre;

	//Lista de materias primas del jugador
	int[] materiasPrimas = new int[Bloque.NUM_MATERIAS];
	
	//Herramientas que tiene el jugador (El jugador nace con las herramientas creadas)
	Herramienta[] herramientasJugador = new Herramienta[4];
	
	//Posicion donde se encuentra el jugador
	private int x;
	private int y;
	private int z;
	
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
		
		//Al crear el jugador se posiciona fuera de coordenadas del mapa
		this.x = -1;
		this.y = -1;
		this.z = -1;
	}

	/**
	 * Muestra el nombre del jugador, las materias que tiene recolectadas, su posicion en el mapa y las herramientas
	 */
	public String toString() {
		return this.nombre + "\n- Materias primas recolectadas:\n" + "Plantas: " + materiasPrimas[Bloque.PLANTA] + "\nArboles: "
				+ materiasPrimas[Bloque.ARBOL] + "\nArcilla: " + materiasPrimas[Bloque.ARCILLA] + "\nAlbero: "
				+ materiasPrimas[Bloque.ALBERO] + "\nHierro: " + materiasPrimas[Bloque.HIERRO] + "\nCobre: " + materiasPrimas[Bloque.COBRE] 
				+ "\nCarne: "+ materiasPrimas[Bloque.CARNE] 
				+ "\n- Herramientas (usos restantes):\nHacha: "+ herramientasJugador[Herramienta.HACHA].getUsosRestantes()
				+"\nPala: "+ herramientasJugador[Herramienta.PALA].getUsosRestantes()
				+"\nPico: "+ herramientasJugador[Herramienta.PICO].getUsosRestantes()
				+"\nEspada: "+ herramientasJugador[Herramienta.ESPADA].getUsosRestantes()
				+"\n- Posicion: [Eje X: "+getX()+" |Eje Y: "+getY()+" |Eje Z: "+getZ()+"]";
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
	
	//Getter y Setter de Atributos que indican o cambian la posicion del jugador
	public int getX() {
		return x;
	}

	public void setX(int x) {
		//Si se encuentra en el valor maximo o minimo aparece en el otro extremo
		if(x<0) {
			this.x = 9;
		} else {
			if(x>9) {
				this.x = 0;
			} else {
				this.x = x;
			}
			
		} 
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		
		//Si se encuentra en el valor maximo o minimo aparece en el otro extremo
		if(y<0) {
			this.y = 9;
		} else {
			if(y>9) {
				this.y = 0;
			} else {
				this.y = y;
			}
			
		} 
		
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		//Si se encuentra en el valor maximo o minimo aparece en el otro extremo
		if(z<0) {
			this.z = 9;
		} else {
			if(z>9) {
				this.z = 0;
			} else {
				this.z = z;
			}
			
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
	
	//TODO En los metodos de mover jugador falta crear que salte excepcion si el bloque al q se va a mover no es vacio
	
	public void moverDerecha() {
		int posicionX;
		
		posicionX = this.x + MOVIMIENTOS_TURNO;
		setX(posicionX);
			
	}

	
	public void moverIzquierda() {
		int posicionX;
		
		posicionX = this.x - MOVIMIENTOS_TURNO;
		setX(posicionX);
		
	}
	
	public void moverAdelante() {
		int posicionY;
		
		posicionY = this.y + MOVIMIENTOS_TURNO;
		setY(posicionY);
		
	}
	
	public void moverAtras() {
		int posicionY;
		
		posicionY = this.y - MOVIMIENTOS_TURNO;
		setY(posicionY);
		
	}
	
	public void moverArriba() {
		int posicionZ;
		
		posicionZ = this.z + MOVIMIENTOS_TURNO;
		setZ(posicionZ);
		
	}
	
	public void moverAbajo() {
		int posicionZ;
		
		posicionZ = this.z - MOVIMIENTOS_TURNO;
		setZ(posicionZ);
		
	}
	
	public void posicionarJugadorMapa(int x, int y, int z) {
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public boolean finDeJuego () {
		boolean finDeJuego = false;
		boolean comprobacion = false;
		
		for (int i = 0; i < materiasPrimas.length && comprobacion == false; i++) {
			
			if (materiasPrimas[i] == 7) {
				finDeJuego = true;
			} else {
				comprobacion = true;
			}
			
		}
		return finDeJuego;
	}

}