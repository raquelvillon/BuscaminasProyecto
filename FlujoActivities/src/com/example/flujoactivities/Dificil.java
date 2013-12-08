package com.example.flujoactivities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Dificil extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dificil);
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

}
