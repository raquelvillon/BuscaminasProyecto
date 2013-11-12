package com.utng.buscaminas;

public class Nivel {
	
	Tablero tablero = new Tablero();
	static int numeroMinas=0;
		static int dificultad;
	
	public Nivel(int dificultad){
		Nivel.dificultad = dificultad;
	}
	
	public Nivel(){}
	
	public static int getNumeroMinas() {
		return numeroMinas;
	}

	public static void setNumeroMinas(int numeroMinas) {
		Nivel.numeroMinas = numeroMinas;
	}

	public static int getDificultad() {
		return dificultad;
	}

	public static void setDificultad(int dificultad) {
		Nivel.dificultad = dificultad;
	}

}
