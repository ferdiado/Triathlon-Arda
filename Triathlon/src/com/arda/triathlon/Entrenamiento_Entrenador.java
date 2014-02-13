package com.arda.triathlon;

import com.arda.screens.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Entrenamiento_Entrenador extends Activity {


	boolean modo;
	String disciplina, titulo;
	Button siguiente;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrenamiento_entrenador);
		
		Intent recibido = getIntent();
		modo = recibido.getBooleanExtra("modo", false);
		disciplina = recibido.getStringExtra("disciplina");
		titulo = getString(R.string.pantallaEntrenamientoEntrenador);
		
		this.setTitle(titulo + " - "+disciplina);
		
		siguiente = (Button) findViewById(R.id.siguienteEntre);
		siguiente.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de entrenamiento
				Intent i = new Intent(Entrenamiento_Entrenador.this,Deportista.class);
				i.putExtra("modo", modo);
				i.putExtra("disciplina", disciplina);
				//Aqui le pasaremos la cantidad de deportistas que se hayan seleccionado.
				i.putExtra("cantidad", 3);
				startActivityForResult(i, 7);
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
