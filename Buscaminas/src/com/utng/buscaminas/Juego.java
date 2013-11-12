package com.utng.buscaminas;

import android.text.format.Time;

public class Juego {
	
	Nivel nivel = new Nivel();
	static float puntaje;
	static Time tiempo;
	
	public static float getPuntaje() {
		return puntaje;
	}
	public static void setPuntaje(float puntaje) {
		Juego.puntaje = puntaje;
	}
	public static Time getTiempo() {
		return tiempo;
	}
	public static void setTiempo(Time tiempo) {
		Juego.tiempo = tiempo;
	}
	
}
