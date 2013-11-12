package com.utng.buscaminas;
import java.util.ArrayList;


public class Tablero{
	ArrayList<Casillero> filas = new ArrayList<Casillero>();
	ArrayList<Casillero> columnas = new ArrayList<Casillero>();
	
	
	public Tablero(){
	}

	public ArrayList<Casillero> getFilas() {
		return filas;
	}


	public void setFilas(ArrayList<Casillero> filas) {
		this.filas = filas;
	}


	public ArrayList<Casillero> getColumnas() {
		return columnas;
	}


	public void setColumnas(ArrayList<Casillero> columnas) {
		this.columnas = columnas;
	}
}
