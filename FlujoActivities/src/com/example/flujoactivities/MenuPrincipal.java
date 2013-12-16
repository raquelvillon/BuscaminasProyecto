package com.example.flujoactivities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MenuPrincipal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_principal);
	}
	public void NivelFacil(View v){
		Intent facil = new Intent(this, Facil.class);
		startActivity(facil);
	}
	public void NivelMedio(View v){
		Intent medio = new Intent(this, Medio.class);
		startActivity(medio);
	}
	public void NivelDificil(View v){
		Intent dificil = new Intent(this, Dificil.class);
		startActivity(dificil);
	}
	public void NivelPersonalizado(View v){
		Intent personalizado = new Intent(this, Personalizado.class);
		startActivity(personalizado);
	}
	public void Salir(View v){
		Intent intent = new Intent(Intent.ACTION_MAIN); 
		finish();
	}

}
