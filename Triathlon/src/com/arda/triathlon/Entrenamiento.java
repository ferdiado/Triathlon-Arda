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

public class Entrenamiento extends Activity {

	ImageButton ciclismo, natacion,carrera;
	boolean modo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrenamiento);

		Intent recibido = getIntent();
		modo = recibido.getBooleanExtra("modo", false);
		
		ciclismo = (ImageButton) findViewById(R.id.ciclismo);
		ciclismo.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de entrenamiento

				if(modo){
					Intent i = new Intent(Entrenamiento.this,Entrenamiento_Entrenador.class);
					i.putExtra("disciplina", "Ciclismo");
					i.putExtra("modo", modo);
					startActivityForResult(i, 6);	
				}else{
					Intent i = new Intent(Entrenamiento.this,Deportista.class);
					i.putExtra("disciplina", "Ciclismo");
					i.putExtra("modo", modo);
					startActivityForResult(i, 7);
				}

			}

		});
		
		natacion = (ImageButton) findViewById(R.id.natacion);
		natacion.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de entrenamiento

				if(modo){
					Intent i = new Intent(Entrenamiento.this,Entrenamiento_Entrenador.class);
					i.putExtra("disciplina", "Natación");
					i.putExtra("modo", modo);
					startActivityForResult(i, 6);	
				}else{
					Intent i = new Intent(Entrenamiento.this,Deportista.class);
					i.putExtra("disciplina", "Natación");
					i.putExtra("modo", modo);
					startActivityForResult(i, 7);
				}

			}

		});
		
		carrera = (ImageButton) findViewById(R.id.carrera_a_pie);
		carrera.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				//Llama a la pantalla de entrenamiento

				if(modo){
					Intent i = new Intent(Entrenamiento.this,Entrenamiento_Entrenador.class);
					i.putExtra("disciplina", "Carrera a Pie");
					i.putExtra("modo", modo);
					startActivityForResult(i, 6);	
				}else{
					Intent i = new Intent(Entrenamiento.this,Deportista.class);
					i.putExtra("disciplina", "Natación");
					i.putExtra("modo", modo);
					startActivityForResult(i, 7);
				}

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_entrenamiento, menu);
		return true;
	}

}
