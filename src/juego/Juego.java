package juego;

import java.util.Random;
import java.util.Scanner;

import bloque.Bloque;
import bloque.BloqueAlbero;
import bloque.BloqueArbol;
import bloque.BloqueArcilla;
import bloque.BloqueCobre;
import bloque.BloqueHierro;
import bloque.BloquePlanta;
import bloque.BloqueVacio;
import bloque.MineroyException;
import bloque.categoria.BloqueMineral;
import bloque.categoria.BloqueTierra;
import bloque.categoria.BloqueVegetal;
import herramientas.Hacha;

/**
 * IES Cristobal de Monroy
 * CFGS - Desarrollo de Aplicaciones Multiplataforma
 * Modulo - Programación
 * @category Practica V - MineMonroy
 * @author y0rg
 * @version 1.1
 */
public class Juego {
	
	private static Scanner teclado = new Scanner(System.in);

	
	//Indica el tamano del cubo que contendra el mapa que vamos a crear
	public static final int TAMANO_MUNDO = 10;

	
	/**
	 * Metodo principal, ejecuta el juego
	 */
	public static void main(String[] args) {

		//Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];
		
		//Lo rellenamos de bloques aleatorios de cualquier tipo, incluso tipo Bloque (vacio)
		for (int x= 0; x <TAMANO_MUNDO; x++) {
			for (int y= 0; y <TAMANO_MUNDO; y++) {
				for (int z= 0; z <TAMANO_MUNDO; z++) {
					mundo3D[x][y][z] = generaBloqueAleatorio(x,y,z);
				}
			}
		}
		//Despues de generarse el mundo ramdon da mensaje de bienvenida que indica se ha creado el mapa
		System.out.println("�Mundo Generado!");
		
		//El usuario introduce su nombre para crear el jugador
		System.out.println("�Como se llamará el jugador 1?");
		String nombreJugador1 = teclado.nextLine();
		
		//Creamos el jugador 1 y el jugador 2
		Jugador jugador1 = new Jugador(nombreJugador1);
		
		System.out.println("�Como se llamará el jugador 2?");
		String nombreJugador2 = teclado.nextLine();
		
		Jugador jugador2 = new Jugador (nombreJugador2);
		
		//Se mostrara el menu del juego
		
		int opcionMenu;
		
		do {
			opcionMenu = mostrarMenu();
			tratarMenu(opcionMenu, jugador1);
		} while (opcionMenu != 5);
		
//		//El Jugador recorre el mapa entero recolectando materias primas (Opcion Desactivada)
//		for (int x= 0; x <TAMANO_MUNDO; x++) {
//			for (int y= 0; y <TAMANO_MUNDO; y++) {
//				for (int z= 0; z <TAMANO_MUNDO; z++) {
//					//EN este caso solo utiliza el "Hacha"
//					mundo3D[x][y][z].destruir(jugador1.herramientasJugador[0], jugador1);
//				}
//			}
//		}
		


	}

	
	/**
	 * Metodo para generar bloques de tipo aleatorio
	 * @param x posicion x en la que se encuentra el bloque
	 * @param y posicion y en la que se encuentra el bloque
	 * @param z posicion z en la que se encuentra el bloque
	 * @return el bloque creado
	 */
	public static Bloque generaBloqueAleatorio(int x, int y, int z) {

		Bloque bloque = null;
		Random rd = new Random();

		//Ponemos el numero de materias +2, se sale del rango (default)
		//para que los casos +1 y +2 que no estan contemplados, generen bloques vacios
		int tipo = rd.nextInt(Bloque.NUM_MATERIAS+2);
		
		try {
			switch (tipo) {
			case Bloque.ALBERO: {
				bloque = new BloqueAlbero(x, y, z);
				break;
			}
			case Bloque.ARBOL: {
				bloque = new BloqueArbol(x, y, z);
				break;
			}
			case Bloque.ARCILLA: {
				bloque = new BloqueArcilla(x, y, z);
				break;
			}
			case Bloque.COBRE: {
				bloque = new BloqueCobre(x, y, z);
				break;
			}
			case Bloque.HIERRO: {
				bloque = new BloqueHierro(x, y, z);
				break;
			}
			case Bloque.PLANTA: {
				bloque = new BloquePlanta(x, y, z);
				break;
			}
			default: {
				bloque = new BloqueVacio(x, y, z);
			}

			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bloque;

	}
	
	/**
	 * Muestra las opciones del menu devolviendo la opcion elegida por el jugador
	 * @return int con la opcion elegida
	 */
	public static int mostrarMenu() {
		int opcionMenu;
		
		System.out.println("Bienvenido a Mineroy, elige la opcion del menu: \n1.Mover\n2.Crear herramienta\n3.Estado\n\n4.Opcion secreta\n5.Salir");
		opcionMenu = Integer.parseInt(teclado.nextLine());
		
		return opcionMenu;
	}
	
	/**
	 * Muestra las direcciones a las que puede moverse el jugador
	 * @return devuelve la direccion elegida
	 */
	public static String mostrarMover() {
		String direccionElegida;
		
		System.out.println("�A que direccion te quieres mover? (Izquierda, Derecha, Atras, Arriba o Abajo");
		direccionElegida = teclado.nextLine();
		
		return direccionElegida;
	}
	
	/**
	 * Recoge dos parametros tratando la opcion deseada por el jugador
	 * @param opcionMenu int con la opcion elegida por el jugador
	 * @param jugador objeto jugador
	 */
	public static void tratarMenu(int opcionMenu, Jugador jugador) {
		
		switch (opcionMenu) {
		case 1:
			//Se solicita la direccion a donde moverse y si se introduce una correcta se mueve en el mapa
			String direccion=mostrarMover();
			
			
			break;
		case 2:
			//Se crean todas las herramientas si el jugador tiene materiales suficientes
			try {
				jugador.crearHerramientas();
			} catch (MineroyException e) {
				System.out.println(e.getMessage());

			}
			break;
		case 3:
			//Mostramos todos los datos del jugador
			System.out.println(jugador);
			break;
		case 4:
			//Opcion secreta para mostrar todo el mapa
			break;
		case 5:
			System.out.println("�Gracias por jugar a Mineroy!");
			break;
		default:
			System.out.println("ERROR: Has elegido una opcion incorrecta.\nVolviendo a mostrar menu...\n");
			break;
		}
	}

}