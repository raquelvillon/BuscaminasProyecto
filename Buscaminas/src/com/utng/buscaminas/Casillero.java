package com.utng.buscaminas;

public class Casillero {
     static int posicionX;
     static int posicionY;
     static int estado;
     static boolean numero, mina, vacio, bandera;
     
     public Casillero(int posicionx, int posiciony, int estado, boolean numero, boolean mina, boolean vacio, boolean bandera){
    	 Casillero.posicionX = posicionx;
    	 Casillero.posicionY = posiciony;
    	 Casillero.estado = estado;
    	 Casillero.numero = numero;
    	 Casillero.mina = mina;
    	 Casillero.vacio = vacio;
    	 Casillero.bandera = bandera;    	 
     }
     
     public Casillero(){
     }
     
     public static int getPosicionX() {
		return posicionX;
	}

	public static void setPosicionX(int posicionX) {
		Casillero.posicionX = posicionX;
	}

	public static int getPosicionY() {
		return posicionY;
	}

	public static void setPosicionY(int posicionY) {
		Casillero.posicionY = posicionY;
	}

	public static int getEstado() {
		return estado;
	}

	public static void setEstado(int estado) {
		Casillero.estado = estado;
	}

	public static boolean isNumero() {
		return numero;
	}

	public static void setNumero(boolean numero) {
		Casillero.numero = numero;
	}

	public static boolean isMina() {
		return mina;
	}

	public static void setMina(boolean mina) {
		Casillero.mina = mina;
	}

	public static boolean isVacio() {
		return vacio;
	}

	public static void setVacio(boolean vacio) {
		Casillero.vacio = vacio;
	}

	public static boolean isBandera() {
		return bandera;
	}

	public static void setBandera(boolean bandera) {
		Casillero.bandera = bandera;
	}     
}
