package com.utng.buscaminas;

import java.util.ArrayList;
import android.view.*;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* Aqui se creara el tablero graficamente */
public class Tablero extends View{
	ArrayList<Casillero> filas = new ArrayList<Casillero>();
	ArrayList<Casillero> columnas = new ArrayList<Casillero>();
	
	Casillero[][] casillas;
	int tamanoNivel = 9;
	public Tablero(Context context){
		super(context);
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawRGB(0, 0, 0);
		int anchoCasilla;
		if(canvas.getWidth() < canvas.getHeight()){
			anchoCasilla = this.getWidth();
		}else
			anchoCasilla = this.getHeight();
		
		int tamanoCuadro = anchoCasilla/tamanoNivel; 
		
		Paint pincel = new Paint();
		pincel.setTextSize(20);
		
		Paint pincel2 = new Paint();
		pincel2.setTextSize(20);
		pincel2.setTypeface(Typeface.DEFAULT_BOLD);
		pincel2.setARGB(255, 0, 0, 255);
		
		Paint pincelLineal = new Paint();
		pincelLineal.setARGB(255, 255, 255, 255);
		
		int filaActual = 0;
		for(int filasT=0;filasT<tamanoNivel;filasT++){
			for(int columnasT=0;columnasT<tamanoNivel;columnasT++){
				casillas[filasT][columnasT].UbicarCasilla(columnasT*tamanoCuadro, filaActual);
				if(casillas[filasT][columnasT].visible == true){
					pincel.setARGB(153, 204, 204, 204);
				}else{
					pincel.setARGB(255, 153, 153, 153);
				}
				//canvas.drawRect(columnasT,filaActual, paint);
			}
		}
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
