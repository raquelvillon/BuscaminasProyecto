package com.example.flujoactivities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Facil extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_facil);
	}
	public void RegresarMenu(View v){
		Intent menu = new Intent(this, MenuPrincipal.class);
		startActivity(menu);
	}



}
