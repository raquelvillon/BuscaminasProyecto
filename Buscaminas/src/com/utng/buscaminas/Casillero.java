package com.utng.buscaminas;

public class Casillero {
     int posicionX;
     int posicionY;
     int estado;
     boolean numero, mina, vacio, bandera;
     
     public Casillero(int posicionX, int posicionY, int estado, boolean numero,boolean mina, boolean vacio, boolean bandera){
    	 this.posicionX = posicionX;
    	 this.posicionY = posicionY;
    	 this.estado = estado;
    	 this.numero = numero;
    	 this.mina = mina;
    	 this.vacio = vacio;
    	 this.bandera = bandera;
     }
     
     public int getPosicionX() {
 		return posicionX;
 	}

 	public void setPosicionX(int posicionX) {
 		this.posicionX = posicionX;
 	}

 	public int getPosicionY() {
 		return posicionY;
 	}

 	public void setPosicionY(int posicionY) {
 		this.posicionY = posicionY;
 	}

 	public int getEstado() {
 		return estado;
 	}

 	public void setEstado(int estado) {
 		this.estado = estado;
 	}

 	public boolean isNumero() {
 		return numero;
 	}

 	public void setNumero(boolean numero) {
 		this.numero = numero;
 	}

 	public boolean isMina() {
 		return mina;
 	}

 	public void setMina(boolean mina) {
 		this.mina = mina;
 	}

 	public boolean isVacio() {
 		return vacio;
 	}

 	public void setVacio(boolean vacio) {
 		this.vacio = vacio;
 	}

 	public boolean isBandera() {
 		return bandera;
 	}

 	public void setBandera(boolean bandera) {
 		this.bandera = bandera;
 	}

     
}
