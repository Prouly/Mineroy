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
	private static final int DIMENSION_MUNDO = 3;

	//Indica la opcion para salir del menu principal
	private static final int SALIR_MENU = 5;
	
	/**
	 * Metodo principal, ejecuta el juego
	 */
	public static void main(String[] args) {

		//Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];

		
		//Rellenamos los dos primeros niveles con Bloques No Vacios
		for (int x= 0; x <TAMANO_MUNDO; x++) {
			for (int y= 0; y <TAMANO_MUNDO; y++) {
				for (int z= 0; z < 2; z++) {
					mundo3D[x][y][z] = generaBloqueAleatorioSuelo(x,y,z);
				}
			}
		}
		
		//Rellenamos resto de posiciones de bloques aleatorios de cualquier tipo. 
		//Una vez que la mitad o mas no son bloques Vacios, se rellena de bloques vacios
		
		for (int x= 0; x <TAMANO_MUNDO; x++) {
			for (int y= 0; y <TAMANO_MUNDO; y++) {
				for (int z= 2; z <TAMANO_MUNDO; z++) {
					if (Bloque.bloqueLleno >= ((TAMANO_MUNDO*DIMENSION_MUNDO) /2)) {
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
		
		//Despues de generarse el mundo aleatorio da mensaje de bienvenida que indica se ha creado el mapa.
		System.out.println("* Mundo Generado *");

		//El usuario introduce su nombre para crear el jugador.
		System.out.println("Como se llamara tu jugador?");
		String nombreJugador = teclado.nextLine();

		//Creamos el jugador.
		Jugador jugador1 = new Jugador(nombreJugador);
		
		//TODO completar el metedo para agregar al jugador al Mapa.
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
	 * Metodo para generar los bloques ocuparan las capas 0 y 1 del suelo y que nunca pondran ser Bloques Vacios
	 * @param x coordenada 
	 * @param y coordenada
	 * @param z coordenada
	 * @return bloque generado aleatoriamente no vacio
	 */
	public static Bloque generaBloqueAleatorioSuelo(int x, int y, int z) {

		Bloque bloque = null;
		Random rd = new Random();

		//Ponemos el numero de materias -1, generando unicamente bloques de tipo no vacio
		//cuando se genera un bloque se suma uno a la variable estatica de bloque con la cantidad total de bloques generados.
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
	 * Metodo para generar bloques de tipo aleatorio incluido bloque aleatorio
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
		int tipo = rd.nextInt(Bloque.NUM_MATERIAS+1);

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
			default: {
				bloque = new BloqueVacio(x, y, z);
			}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return bloque;

	}
	
	//Generar metodo que recorra el array e inserte en el mapa al jugador en el primer bloque vacio que encuentre
	
	public static void agregarJugadorAlMapa(Jugador jugador, Bloque[][][] mundo3D) {
		boolean agregado = false;
		
		for (int x = 0; x <TAMANO_MUNDO || agregado == false; x++) {
			for (int y = 0; y < TAMANO_MUNDO; y++) {
				for (int z = 0; z < TAMANO_MUNDO; z++) {
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
	 * @return devuelve int que indica la direccion elegida
	 */
	public static int mostrarMover() {
		int direccionElegida;

		System.out.println("A que direccion te quieres mover?\n1.Izquierda\n2.Derecha\n3.Adelante\n4.Atras\n5.Arriba\n6.Abajo");
		direccionElegida = Integer.parseInt(teclado.nextLine());
		
		return direccionElegida;
	}

	public static void mostrarMapa(Bloque[][][] mundo3d) {
		for (int z =  mundo3d[0][0].length - 1; z >= 0; z--) {
			System.out.println("\n" + " Capa " + z + " de suelo "+"\n");
			for (int y = 0; y < mundo3d[0].length; y++) {
				for (int x = 0; x < mundo3d.length; x++) {
					System.out.print(mundo3d[x][y][z] + " ");
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
		
		//Mover Jugador
		case 1:
			//Se solicita la direccion a donde moverse y si se introduce una correcta el jugador se desplaza una posicion en la direccion indicada
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
				break;
			default:
				throw new MineroyException("Direccion de movimiento erronea. Direcciones admitidas: \n1.Izquierda\n2.Derecha\n3.Adelante\n4.Atras\n5.Arriba\n6.Abajo");

			}

			break;
		
		//Se crean todas las herramientas si el jugador tiene materiales suficientes
		case 2:
			
			try {
				jugador.crearHerramientas();
			} catch (MineroyException e) {
				System.out.println(e.getMessage());

			}
			break;
			
		//Mostramos todos los datos del jugador
		case 3:
			System.out.println(jugador);
			break;
			
		//Opcion secreta para mostrar todo el mapa
		case 4:
			
			mostrarMapa(mundo3D);
			break;
			
		//Salir	
		case 5:
			System.out.println("Gracias por jugar a Mineroy!");
			break;
		default:
			throw new MineroyException("ERROR: Has elegido una opcion incorrecta.\nVolviendo a mostrar menu...\n");
		}
	}

}