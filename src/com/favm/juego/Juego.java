package juego;

import java.util.Random;

import bloque.Bloque;
import bloque.BloqueAlbero;
import bloque.BloqueArbol;
import bloque.BloqueArcilla;
import bloque.BloqueCobre;
import bloque.BloqueHierro;
import bloque.BloquePlanta;
import bloque.BloqueVacio;
import categoria.BloqueMineral;
import categoria.BloqueTierra;
import categoria.BloqueVegetal;

/**
 * IES Cristobal de Monroy
 * CFGS - Desarrollo de Aplicaciones Multiplataforma
 * Modulo - Programación
 * @category Practica V - MineMonroy
 * @author y0rg
 * @version 1.1
 */
public class Juego {
	
	//Indica el tamano del cub que contendra el mapa que vamos a crear
	public static final int TAMANO_MUNDO = 10;

	
	/**
	 * Metodo principal, ejecuta el juego
	 */
	public static void main(String[] args) {

		//Creamos el mapa del juego
		Bloque[][][] mundo3D = new Bloque[TAMANO_MUNDO][TAMANO_MUNDO][TAMANO_MUNDO];
		
		//Lo rellenamos de bloques aleatorios de cualquier tipo, incluso tipo Bloque (vacio)
		for (int i= 0; i <TAMANO_MUNDO; i++) {
			for (int j= 0; j <TAMANO_MUNDO; j++) {
				for (int k= 0; k <TAMANO_MUNDO; k++) {
					mundo3D[i][j][k] = generaBloqueAleatorio(i,j,k);
				}
			}
		}

		//Creamos el jugador
		Jugador jugador1 = new Jugador("Alvaro");

		//El Jugador recorre el mapa entero recolectando materias primas
		for (int i= 0; i <TAMANO_MUNDO; i++) {
			for (int j= 0; j <TAMANO_MUNDO; j++) {
				for (int k= 0; k <TAMANO_MUNDO; k++) {
					//EN este caso solo utiliza el "Hacha"
					mundo3D[i][j][k].destruir(BloqueTierra.HERRAMIENTA, jugador1);
				}
			}
		}
		
		//Mostramos el resultado de la recolección
		System.out.println(jugador1);
		
		
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

}