package com.arda.triathlon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class Deportista extends Activity {


	boolean modo;
	String disciplina, titulo;
	int cantidadDep;
	ImageButton play1, play2, play3, guardar1, guardar2, guardar3, pausa1, pausa2, pausa3,stop1, stop2, stop3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deportista);

		Intent recibido = getIntent();
		modo = recibido.getBooleanExtra("modo", false);
		disciplina = recibido.getStringExtra("disciplina");
		cantidadDep = recibido.getIntExtra("cantidad", 1);
		titulo = getString(R.string.pantallaEntrenamientoEntrenador);

		this.setTitle(titulo + " - "+disciplina);

		play1 = (ImageButton) findViewById(R.id.inicio);
		play1.setEnabled(false);
		play1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de entrenamiento
				
			}

		});

		play2 = (ImageButton) findViewById(R.id.inicio2);
		play2.setEnabled(false);
		play2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de entrenamiento
				
			}

		});
		
		play3 = (ImageButton) findViewById(R.id.inicio3);
		play3.setEnabled(false);
		play3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de entrenamiento
				
			}

		});
		
		switch (cantidadDep){
		case 1:
			play1.setEnabled(true);
			break;
		case 2:
			play1.setEnabled(true);
			play2.setEnabled(true);
			break;
		case 3:
			play1.setEnabled(true);
			play2.setEnabled(true);
			play3.setEnabled(true);
			break;
		default:
			Toast.makeText(getApplicationContext(), "Más deportistas de lso recomentados", Toast.LENGTH_SHORT).show();

		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
		return true;
	}

}
