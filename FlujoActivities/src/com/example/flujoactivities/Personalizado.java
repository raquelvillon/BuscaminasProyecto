package com.example.flujoactivities;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Personalizado extends Activity {
	private SeekBar seekBarAncho, seekBarAlto, seekBarMinas;
	 private TextView textSeekBarAncho;
	 private TextView textSeekBarAlto;
	 private TextView textSeekBarMinas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personalizado);
		seekBarAncho = (SeekBar) findViewById(R.id.seekBarAncho);
		seekBarAlto = (SeekBar) findViewById(R.id.seekBarAlto);
		seekBarMinas = (SeekBar) findViewById(R.id.seekBarMinas);
        textSeekBarAncho = (TextView) findViewById(R.id.valorAncho);
        textSeekBarAncho.setText("9");
        textSeekBarAlto = (TextView) findViewById(R.id.valorAlto);
        textSeekBarAlto.setText("9");
        textSeekBarMinas = (TextView) findViewById(R.id.valorMinas);
        textSeekBarMinas.setText("10");
        
        
        seekBarAncho.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {            
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {	 textSeekBarAncho.setText(progress + 9 + "");  
            }

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {}
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {}
           
        });
        seekBarAlto.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {            
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {	 textSeekBarAlto.setText(progress + 9 + "");  }

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {}
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {}
           
        });
        seekBarMinas.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {            
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {	 textSeekBarMinas.setText(progress + 10 + "");  }

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {}
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {}
           
        });
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
	public void JugarPersonalizado(View v){
		Intent juegoPersonalizado = new Intent(this, JugarPersonalizado.class);
		Bundle bolsa= new Bundle();
		bolsa.putString("altoP", textSeekBarAlto.getText().toString());
		
		bolsa.putString("anchoP", textSeekBarAncho.getText().toString());
		bolsa.putString("minasP", textSeekBarMinas.getText().toString());
		juegoPersonalizado.putExtra("bolsa", bolsa);
		//Toast toast = Toast.makeText(this, textSeekBarAlto.getText().toString(), Toast.LENGTH_SHORT);
        //toast.show();  
		startActivity(juegoPersonalizado);
	}
}
