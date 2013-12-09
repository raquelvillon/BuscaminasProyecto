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
	private SeekBar seekBar;
	 private TextView textViewSeekBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personalizado);
		seekBar = (SeekBar) findViewById(R.id.seekBarAncho);
        textViewSeekBar = (TextView) findViewById(R.id.valorAncho);
        textViewSeekBar.setText("9");
        
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {            
            
           
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                 //la Seekbar siempre empieza en cero, si queremos que el valor mínimo sea otro podemos modificarlo
                 textViewSeekBar.setText(progress + 9 + "");                 
            }

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				// TODO Auto-generated method stub
				
			}
           
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
}
