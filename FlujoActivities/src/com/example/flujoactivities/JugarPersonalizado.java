package com.example.flujoactivities;

import com.example.flujoactivities.Facil.Tablero;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class JugarPersonalizado extends Activity implements OnTouchListener{

	private Tablero fondo;
	int x, y;
	private Casillero[][] casillas;
	private boolean activo = true;
	//Bundle bundle=getIntent().getExtras();
	int altoP;
	int anchoP;
	int minasP;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle bundle=getIntent().getBundleExtra("bolsa");
		int altoP = Integer.parseInt(bundle.getString("altoP"));
		int anchoP = Integer.parseInt(bundle.getString("anchoP"));
		int minasP = Integer.parseInt(bundle.getString("minasP"));
		Toast toast = Toast.makeText(this, bundle.getString("altoP") , Toast.LENGTH_SHORT);
        toast.show();  
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facil);
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
		fondo = new Tablero(this);
		fondo.setOnTouchListener(this);				  
		layout.addView(fondo);
		casillas = new Casillero[altoP][anchoP];
		for (int f = 0; f < altoP; f++) {
			for (int c = 0; c < anchoP; c++) {
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
		casillas = new Casillero[altoP][anchoP];
		for (int f = 0; f < altoP; f++) {
			for (int c = 0; c < anchoP; c++) {
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
			for (int f = 0; f < altoP; f++) {
				for (int c = 0; c < anchoP; c++) {
					if (casillas[f][c].dentro((int) event.getX(),
							(int) event.getY())) {
						casillas[f][c].destapado = true;
						if (casillas[f][c].contenido == 80) {
							toast=Toast.makeText(this, "Game Over", Toast.LENGTH_SHORT);
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
			toast=Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT);
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
			int ancho = 0;
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
			Paint paintlinea1 = new Paint();
			paintlinea1.setARGB(255, 255, 255, 255);
			int filaact = 0;
			for (int f = 0; f < altoP; f++) {
				for (int c = 0; c < anchoP; c++) {
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
							&& casillas[f][c].destapado)
						canvas.drawText(
								String.valueOf(casillas[f][c].contenido), c
										* anchocua + (anchocua / 2) - 5,
								filaact + anchocua / 2 + 5, paint2);

					if (casillas[f][c].contenido == 80
							&& casillas[f][c].destapado) {
						Paint bomba = new Paint();
						bomba.setARGB(255, 255, 0, 0);
						canvas.drawCircle(c * anchocua + (anchocua / 2),
								filaact + (anchocua / 2), 8, bomba);
					}

				}
				filaact = filaact + anchocua;
			}
		}
	}

	private void disponerBombas() {
		int cantidad = 99;
		do {
			int fila = (int) (Math.random() * altoP);
			int columna = (int) (Math.random() * anchoP);
			if (casillas[fila][columna].contenido == 0) {
				casillas[fila][columna].contenido = 80;
				cantidad--;
			}
		} while (cantidad != 0);
	}

	private boolean gano() {
		int cant = 0;
		for (int f = 0; f < altoP; f++)
			for (int c = 0; c < anchoP; c++)
				if (casillas[f][c].destapado)
					cant++;
		if (cant == 381)
			return true;
		else
			return false;
	}

	private void contarBombasPerimetro() {
		for (int f = 0; f < altoP; f++) {
			for (int c = 0; c < anchoP; c++) {
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
		if (fila - 1 >= 0 && columna + 1 < anchoP) {
			if (casillas[fila - 1][columna + 1].contenido == 80)
				total++;
		}

		if (columna + 1 < anchoP) {
			if (casillas[fila][columna + 1].contenido == 80)
				total++;
		}
		if (fila + 1 < altoP && columna + 1 < anchoP) {
			if (casillas[fila + 1][columna + 1].contenido == 80)
				total++;
		}

		if (fila + 1 < altoP) {
			if (casillas[fila + 1][columna].contenido == 80)
				total++;
		}
		if (fila + 1 < altoP && columna - 1 >= 0) {
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
		if (fil >= 0 && fil < altoP && col >= 0 && col < anchoP) {
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
}
