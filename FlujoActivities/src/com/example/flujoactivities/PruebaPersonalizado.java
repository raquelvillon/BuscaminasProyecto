package com.example.flujoactivities;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.TextView;

public class PruebaPersonalizado extends Activity {
	
	//int anchoP = Integer.parseInt(bundle.getString("anchoP"));
	//int minasP = Integer.parseInt(bundle.getString("minasP"));
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Bundle bundle=getIntent().getBundleExtra("bolsa");
		int altoP = Integer.parseInt(bundle.getString("altoP"));
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prueba_personalizado);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prueba_personalizado, menu);
		return true;
	}

}
