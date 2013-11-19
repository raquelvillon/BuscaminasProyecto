package com.utng.buscaminas;

import android.view.*;
import android.content.Context;

public class Casillero {
     public int posicionX;
     public int posicionY;
     public int anchoCasilla;
     public boolean visible = false;
     public int contenido; /*Aqui se informara, que va a contener el casillero se este
      						 0 - vacio
      						 1 - mina
      						 2 - numero
      						 3 - bandera */
	
    
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
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getContenido() {
		return contenido;
	}
	public void setContenido(int contenido) {
		this.contenido = contenido;
	}
     
    public void UbicarCasilla(int x, int y){
    	this.posicionX = x;
    	this.posicionY = y;
    }
	public int getAnchoCasilla() {
		return anchoCasilla;
	}
	public void setAnchoCasilla(int anchoCasilla) {
		this.anchoCasilla = anchoCasilla;
	}
	     
}
