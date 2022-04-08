package com.favm.bloque;

import juego.Jugador;

/**
 * Bloque donde se almacena las coordenadas y bloques
 * 
 * @author Alvaro M. & Fran V.
 *
 */

public abstract class Bloque {

	//Tipos de bloques posibles.
	public static final int PLANTA = 0;
	public static final int ARBOL = 1;
	public static final int ARCILLA = 2;
	public static final int ALBERO = 3;
	public static final int HIERRO = 4;
	public static final int COBRE = 5;
	
	public static final int NUM_MATERIAS = 6; //Pues contamos desde 0.

	private int x;
	private int y;
	private int z;
	
	public Bloque (int x, int y, int z) throws MineroyException {
		
		if(this.x<0 && this.y<0 && this.z<z) {
			throw new MineroyException("ERROR: Los eje X, Y ,Z deben tener un valor minimo de 0");
		}
		
		this.x=x;
		this.y=y;
		this.z=z;

	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	private void setZ(int z) {
	
		this.z = z;
	}
	
	/**
	 * Metodo para destruir bloques, si las coordenadas introducidas coinciden con el bloque, este pondrá sus coordenadas
	 * @param x
	 * @param y
	 * @param z
	 * @return 
	 * @throws MineroyException si el bloque no se encuentra
	 */
	
	
	public void destruir(String herramienta, Jugador jugador) {
		
		setX(-1);
		setY(-1);
		setZ(-1);
	}

	@Override
	public String toString() {
		return "Bloque: Coordenada x: " + x + ", Coordenada y: " + y + ", Coordenada z: " + z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bloque other = (Bloque) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	
}