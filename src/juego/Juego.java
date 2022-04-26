package juego;

import java.util.Random;
import java.util.Scanner;

import bloque.Bloque;
import bloque.BloqueAlbero;
import bloque.BloqueAnimal;
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
 * Modulo - Programacion
 * @category Practica V - MineMonroy
 * @author Alvaro Muñoz Adan y Francisco Jose Villa
 * @version 1.1
 */
public class Juego {

	private static Scanner teclado = new Scanner(System.in);

	//Indica el tamano del cubo que contendra el mapa que vamos a crear
	public static final int TAMANO_MUNDO = 10;
	private static final int NUMERO_BLOQUE_VACIO = (TAMANO_MUNDO*TAMANO_MUNDO*TAMANO_MUNDO)/2;
	
	//Opcion para Salir del menu
	private static final int SALIR_MENU = 5;

	/**
	 * Metodo principal, ejecuta el juego
	 */
	public static void main(String[] args) {

		//Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];

		//Rellenamos las dos primeras capaz del suelo con bloques no vacios
		for (int x= 0; x <TAMANO_MUNDO; x++) {
			for (int y= 0; y <TAMANO_MUNDO; y++) {
				for (int z= 0; z < 2; z++) {
					mundo3D[x][y][z] = generaBloqueAleatorioSuelo(x,y,z);
				}
			}
		}
		
		//rellenamos de bloques aleatorios de cualquier tipo, incluso tipo Bloque (vacio)
		//Una vez haya mas de la mitad de bloques no vacios, se rellena el resto de bloques vacios
		for (int x= 0; x <TAMANO_MUNDO; x++) {
			for (int y= 0; y <TAMANO_MUNDO; y++) {
				for (int z= 2; z <TAMANO_MUNDO; z++) {
					if (Bloque.bloqueLleno <= NUMERO_BLOQUE_VACIO) {
						mundo3D[x][y][z] = generaBloqueAleatorio(x,y,z);
					} else {
						try {
							mundo3D[x][y][z] = new BloqueVacio(x, y, z);
						} catch (MineroyException e) {
							System.out.println(e.getMessage());
						}
					}
				}
			}
		}
		
		//Despues de generarse el mundo ramdon da mensaje de bienvenida que indica se ha creado el mapa
		System.out.println("* Mundo Generado *");

		//El usuario introduce su nombre para crear el jugador
		System.out.println("¿Como se llamara tu jugador?");
		String nombreJugador = teclado.nextLine();

		//Creamos el jugador
		Jugador jugador1 = new Jugador(nombreJugador);
		
		//El jugador se agrega al mapa
		agregarJugadorAlMapa(jugador1, mundo3D);

		//Se mostrara el menu del juego

		int opcionMenu;

		do {
			opcionMenu = mostrarMenu();
			try {
				tratarMenu(opcionMenu, jugador1,mundo3D);
			} catch (MineroyException e) {
				System.out.println(e.getMessage());
			}
		} while (opcionMenu != SALIR_MENU);

	}
	
	/**
	 * Metodo para generar bloques aleatorios (No vacios) en las capas 0 y 1
	 * @param x int coordenada x
	 * @param y int coordenada y
	 * @param z int coordenada z
	 * @return BloqueTipoNoVacio generado
	 */
	public static Bloque generaBloqueAleatorioSuelo(int x, int y, int z) {

		Bloque bloque = null;
		Random rd = new Random();

		//Ponemos el numero de materias -1 ya que una de las materias no se genera (Bloque Animal)
		//No se generan bloques vacios
		int tipo = rd.nextInt(Bloque.NUM_MATERIAS-1);

		try {
			switch (tipo) {
			case Bloque.ALBERO: {
				bloque = new BloqueAlbero(x, y, z);
				Bloque.bloqueLleno ++;
				break;
			}
			case Bloque.ARBOL: {
				bloque = new BloqueArbol(x, y, z);
				Bloque.bloqueLleno ++;
				break;
			}
			case Bloque.ARCILLA: {
				bloque = new BloqueArcilla(x, y, z);
				Bloque.bloqueLleno ++;
				break;
			}
			case Bloque.COBRE: {
				bloque = new BloqueCobre(x, y, z);
				Bloque.bloqueLleno ++;
				break;
			}
			case Bloque.HIERRO: {
				bloque = new BloqueHierro(x, y, z);
				Bloque.bloqueLleno ++;
				break;
			}
			case Bloque.PLANTA: {
				bloque = new BloquePlanta(x, y, z);
				Bloque.bloqueLleno ++;
				break;
			}


			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bloque;

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
					Bloque.bloqueLleno ++;
					break;
				}
				case Bloque.ARBOL: {
					bloque = new BloqueArbol(x, y, z);
					Bloque.bloqueLleno ++;
					break;
				}
				case Bloque.ARCILLA: {
					bloque = new BloqueArcilla(x, y, z);
					Bloque.bloqueLleno ++;
					break;
				}
				case Bloque.COBRE: {
					bloque = new BloqueCobre(x, y, z);
					Bloque.bloqueLleno ++;
					break;
				}
				case Bloque.HIERRO: {
					bloque = new BloqueHierro(x, y, z);
					Bloque.bloqueLleno ++;
					break;
				}
				case Bloque.PLANTA: {
					bloque = new BloquePlanta(x, y, z);
					Bloque.bloqueLleno ++;
					break;
				}
				case Bloque.CARNE: {
					if (Bloque.bloqueAnimal == 0) {
						bloque = new BloqueAnimal (x,y,z);
						Bloque.bloqueAnimal++;
					} else {
						bloque = new BloqueVacio(x, y, z);
					}
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
	 * Metodo que incluye al jugador en el mapa en el primer BloqueVacio que haya
	 * @param jugador a agregar
	 * @param mundo3D mapa donde se agregara el jugador
	 */
	public static void agregarJugadorAlMapa(Jugador jugador, Bloque[][][] mundo3D) {
		
		boolean agregado = false;
		
		for (int x= 0; x <TAMANO_MUNDO || agregado == false; x++) {
			for (int y= 0; y <TAMANO_MUNDO; y++) {
				for (int z= 0; z <TAMANO_MUNDO; z++) {
					//Se agrega el jugador en el primer bloque vacio
					if (mundo3D[x][y][z] instanceof BloqueVacio) {
						agregado = true;
						jugador.posicionarJugadorMapa(x, y, z);
					}
				}
			}
		}
		
	}


	/**
	 * Muestra las opciones del menu devolviendo la opcion elegida por el jugador
	 * @return int con la opcion elegida
	 */
	public static int mostrarMenu() {
		int opcionMenu;


		System.out.println("\nBienvenido a Mineroy, elige la opcion del menu: \n1.Mover\n2.Crear herramienta\n3.Estado\n4.Opcion secreta\n5.Salir");
		
		opcionMenu = Integer.parseInt(teclado.nextLine());

		return opcionMenu;
	}

	/**
	 * Muestra las direcciones a las que puede moverse el jugador
	 * @return devuelve la direccion elegida
	 */
	public static int mostrarMover() {
		int direccionElegida;

		System.out.println("A que direccion te quieres mover?\n1.Izquierda\n2.Derecha\n3.Adelante\n4.Atras\n5.Arriba\n6.Abajo");
		direccionElegida = Integer.parseInt(teclado.nextLine());
		
		return direccionElegida;
	}
	
	/**
	 * Metodo que mostrara los bloques generados en mundo3d que hay en todo el mapa y al jugador
	 * @param mundo3d
	 * @param jugador
	 */
	public static void mostrarMapa(Bloque[][][] mundo3d, Jugador jugador) {
		for (int z =  mundo3d[0][0].length - 1; z >= 0; z--) {
			System.out.println("\n" + " Capa " + z + " de suelo "+"\n");
			for (int y = 0; y < mundo3d[0].length; y++) {
				for (int x = 0; x < mundo3d.length; x++) {
					if (mundo3d[x][y][z] == mundo3d[jugador.getX()][jugador.getY()][jugador.getZ()]) {
						System.out.println("| JUG |");
					} else {
						System.out.print(mundo3d[x][y][z] + " ");
					}
					
				}
				System.out.println();
			}
		}
	}

	/**
	 * Recoge dos parametros tratando la opcion deseada por el jugador
	 * @param opcionMenu int con la opcion elegida por el jugador
	 * @param jugador objeto jugador
	 * @throws MineroyException
	 */
	public static void tratarMenu(int opcionMenu, Jugador jugador, Bloque[][][] mundo3D) throws MineroyException {

		switch (opcionMenu) {

		case 1:
			//Se solicita la direccion a donde moverse y si se introduce una correcta se mueve en el mapa
			int direccionMovimiento;
			direccionMovimiento=mostrarMover();

			switch (direccionMovimiento) {

				case 1:
					jugador.moverIzquierda();
					break;
				case 2:
					jugador.moverDerecha();
					break;
				case 3:
					jugador.moverAdelante();
					break;
				case 4:
					jugador.moverAtras();
					break;
				case 5:
					jugador.moverArriba();
					break;
				case 6:
					jugador.moverAbajo();
				default:
					throw new MineroyException("Direccion de movimiento erronea");

			}

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
			//Muestra todo el Mapa
			mostrarMapa(mundo3D, jugador);
			break;
		case 5:
			//Salir del Juego
			System.out.println("Gracias por jugar a Mineroy!");
			break;
		default:
			throw new MineroyException("ERROR: Has elegido una opcion incorrecta.\nVolviendo a mostrar menu...\n");
		}
	}

}