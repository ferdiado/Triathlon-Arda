package com.arda.triathlon;

import com.arda.screens.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Modo extends Activity {

	ImageButton entrenamiento, competicion, estadisticas;
	boolean modo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modo);
		
		Intent recibido = getIntent();
		modo = recibido.getBooleanExtra("modo", false);
		entrenamiento = (ImageButton) findViewById(R.id.modoEntrenamiento);
		entrenamiento.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de entrenamiento
				Intent i = new Intent(Modo.this,Entrenamiento.class);
				i.putExtra("modo", modo);
				startActivityForResult(i, 3);
			}

		});
		
		competicion = (ImageButton) findViewById(R.id.modoCompeticion);
		competicion.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de competicion
				Intent i = new Intent(Modo.this,Competicion.class);
				i.putExtra("modo", modo);
				startActivityForResult(i, 4);
			}

		});
		
		estadisticas = (ImageButton) findViewById(R.id.modoEstadisticas);
		estadisticas.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la segunda pantalla
				Intent i = new Intent(Modo.this,Estadisticas.class);
				startActivityForResult(i, 5);
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
		return true;
	}
}
