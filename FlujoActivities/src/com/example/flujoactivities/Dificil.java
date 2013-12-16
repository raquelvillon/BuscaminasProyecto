package com.example.flujoactivities;

import com.example.flujoactivities.Medio.Tablero;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Dificil extends Activity implements OnTouchListener{

	private Tablero fondo;
	int x, y;
	private Casillero[][] casillas;
	private boolean activo = true;
	int ancho = 0;
	int anchocua;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dificil);
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
		fondo = new Tablero(this);
		fondo.setOnTouchListener(this);				  
		layout.addView(fondo);
		casillas = new Casillero[16][30];
		for (int f = 0; f < 16; f++) {
			for (int c = 0; c < 30; c++) {
				casillas[f][c] = new Casillero();
			}
		}
		this.disponerBombas();
		this.contarBombasPerimetro();
	}
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.medio, menu);
		return true;
	}
*/
	public void RegresarMenu(View v){
		Intent menu = new Intent(this, MenuPrincipal.class);
		startActivity(menu);
	}
	public void presionado(View v) {
		casillas = new Casillero[16][30];
		for (int f = 0; f < 16; f++) {
			for (int c = 0; c < 30; c++) {
				casillas[f][c] = new Casillero();
			}
		}
		this.disponerBombas();
		this.contarBombasPerimetro();
		activo = true;

		fondo.invalidate();
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		Toast toast;
		if (activo)
			for (int f = 0; f < 16; f++) {
				for (int c = 0; c < 30; c++) {
					if (casillas[f][c].dentro((int) event.getX(),
							(int) event.getY())) {
						casillas[f][c].destapado = true;
						if (casillas[f][c].contenido == 80) {
							mostrarBombas();
							toast=Toast.makeText(this, "Game Over",
									Toast.LENGTH_SHORT);
							toast.setGravity(Gravity.CENTER, 0, 0);
							
							toast.show();
							activo = false;
						} else if (casillas[f][c].contenido == 0)
							recorrer(f, c);
						fondo.invalidate();
					}
				}
			}
		if (gano() && activo) {
			toast=Toast.makeText(this, "Ganaste",
					Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
			
			activo = false;
		}

		return true;
	}

	class Tablero extends View {

		public Tablero(Context context) {
			super(context);
		}

		protected void onDraw(Canvas canvas) {
			//canvas.drawRGB(0, 0, 0);
			
			if (canvas.getWidth() < canvas.getHeight())
				ancho = fondo.getWidth();
			else
				ancho = fondo.getHeight();
			int anchocua = ancho / 20;
			Paint paint = new Paint();
			paint.setTextSize(20);
			Paint paint2 = new Paint();
			paint2.setTextSize(20);
			paint2.setTypeface(Typeface.DEFAULT_BOLD);
			paint2.setARGB(255, 0, 0, 255);
			//-------
			Paint paint3 = new Paint();
			paint3.setTextSize(20);
			paint3.setTypeface(Typeface.DEFAULT_BOLD);
			paint3.setARGB(255, 81, 30, 158);
			//------
			Paint paint4 = new Paint();
			paint4.setTextSize(20);
			paint4.setTypeface(Typeface.DEFAULT_BOLD);
			paint4.setARGB(255, 30, 158, 154);
			//------
			Paint paint5 = new Paint();
			paint5.setTextSize(20);
			paint5.setTypeface(Typeface.DEFAULT_BOLD);
			paint5.setARGB(255, 20, 174, 46);
			//-----
			Paint paintlinea1 = new Paint();
			paintlinea1.setARGB(255, 255, 255, 255);
			int filaact = 0;
			for (int f = 0; f < 16; f++) {
				for (int c = 0; c < 30; c++) {
					casillas[f][c].fijarxy(c * anchocua, filaact, anchocua);
					if (casillas[f][c].destapado == false)
						paint.setARGB(153, 204, 204, 204);
					else
						paint.setARGB(255, 153, 153, 153);
					canvas.drawRect(c * anchocua, filaact, c * anchocua
							+ anchocua - 2, filaact + anchocua - 2, paint);
					// linea blanca
					canvas.drawLine(c * anchocua, filaact, c * anchocua
							+ anchocua, filaact, paintlinea1);
					canvas.drawLine(c * anchocua + anchocua - 1, filaact, c
							* anchocua + anchocua - 1, filaact + anchocua,
							paintlinea1);

					if (casillas[f][c].contenido >= 1
							&& casillas[f][c].contenido <= 8
							&& casillas[f][c].destapado){
						switch (casillas[f][c].contenido) {
						case 1:
							canvas.drawText(String.valueOf(casillas[f][c].contenido), c
									* anchocua + (anchocua / 2) - 5,
							filaact + anchocua / 2 + 5, paint2);
							break;
						case 2:
							canvas.drawText(String.valueOf(casillas[f][c].contenido), c
									* anchocua + (anchocua / 2) - 5,
							filaact + anchocua / 2 + 5, paint3);
							break;
						case 3:
							canvas.drawText(String.valueOf(casillas[f][c].contenido), c
									* anchocua + (anchocua / 2) - 5,
							filaact + anchocua / 2 + 5, paint4);
							break;
						case 4:
							canvas.drawText(String.valueOf(casillas[f][c].contenido), c
									* anchocua + (anchocua / 2) - 5,
							filaact + anchocua / 2 + 5, paint5);
							break;

						default:
							break;
						}
					}

					if (casillas[f][c].contenido == 80
							&& casillas[f][c].destapado) {
							/*Paint bomba = new Paint();
							bomba.setARGB(255, 255, 0, 0);
							canvas.drawCircle(c * anchocua + (anchocua / 2),
									filaact + (anchocua / 2), 8, bomba);*/
						Bitmap bmp = BitmapFactory.decodeResource(getResources(),
			                    R.drawable.minas);
			            canvas.drawBitmap(bmp, c * anchocua + (anchocua / 4)-6, filaact + (anchocua / 4)-6, null);
					}

				}
				filaact = filaact + anchocua;
			}
		}
	}

	private void disponerBombas() {
		int cantidad = 99;
		do {
			int fila = (int) (Math.random() * 16);
			int columna = (int) (Math.random() * 30);
			if (casillas[fila][columna].contenido == 0) {
				casillas[fila][columna].contenido = 80;
				cantidad--;
			}
		} while (cantidad != 0);
	}

	private boolean gano() {
		int cant = 0;
		for (int f = 0; f < 16; f++)
			for (int c = 0; c < 30; c++)
				if (casillas[f][c].destapado)
					cant++;
		if (cant == 381)
			return true;
		else
			return false;
	}

	private void contarBombasPerimetro() {
		for (int f = 0; f < 16; f++) {
			for (int c = 0; c < 30; c++) {
				if (casillas[f][c].contenido == 0) {
					int cant = contarCoordenada(f, c);
					casillas[f][c].contenido = cant;
				}
			}
		}
	}

	int contarCoordenada(int fila, int columna) {
		int total = 0;
		if (fila - 1 >= 0 && columna - 1 >= 0) {
			if (casillas[fila - 1][columna - 1].contenido == 80)
				total++;
		}
		if (fila - 1 >= 0) {
			if (casillas[fila - 1][columna].contenido == 80)
				total++;
		}
		if (fila - 1 >= 0 && columna + 1 < 30) {
			if (casillas[fila - 1][columna + 1].contenido == 80)
				total++;
		}

		if (columna + 1 < 30) {
			if (casillas[fila][columna + 1].contenido == 80)
				total++;
		}
		if (fila + 1 < 16 && columna + 1 < 30) {
			if (casillas[fila + 1][columna + 1].contenido == 80)
				total++;
		}

		if (fila + 1 < 16) {
			if (casillas[fila + 1][columna].contenido == 80)
				total++;
		}
		if (fila + 1 < 16 && columna - 1 >= 0) {
			if (casillas[fila + 1][columna - 1].contenido == 80)
				total++;
		}
		if (columna - 1 >= 0) {
			if (casillas[fila][columna - 1].contenido == 80)
				total++;
		}
		return total;
	}

	private void recorrer(int fil, int col) {
		if (fil >= 0 && fil < 16 && col >= 0 && col < 30) {
			if (casillas[fil][col].contenido == 0) {
				casillas[fil][col].destapado = true;
				casillas[fil][col].contenido = 50;
				recorrer(fil, col + 1);
				recorrer(fil, col - 1);
				recorrer(fil + 1, col);
				recorrer(fil - 1, col);
				recorrer(fil - 1, col - 1);
				recorrer(fil - 1, col + 1);
				recorrer(fil + 1, col + 1);
				recorrer(fil + 1, col - 1);
			} else if (casillas[fil][col].contenido >= 1
					&& casillas[fil][col].contenido <= 8) {
				casillas[fil][col].destapado = true;
			}
		}
	}
	
	private void mostrarBombas(){
		for (int f = 0; f < 16; f++) {
			for (int c = 0; c < 30; c++) {
				if (casillas[f][c].contenido == 80) {
					casillas[f][c].destapado=true;
					
				}
			}
		}
	} 
}
