package com.arda.triathlon;


import com.arda.screens.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ProgressBar;
//import android.widget.Toast;

public class Inicio extends Activity {
	
	ProgressBar barra;
	int cuenta = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		
		//Toast.makeText(getApplicationContext(),"Se van a crear las barras" , 2).show();
		
		barra = (ProgressBar) findViewById(R.id.barraCarga);
		barra.setMax(100);
		barra.setEnabled(false);
		barra.setActivated(true);
		//Contamos 1000 ciclos de reloj.
		//this.contador();
		this.login();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
		return true;
		
	}
	
	/**
	 * Contador de carga de la pantalla de login
	 */
	public void contador(){
		//Toast.makeText(getApplicationContext(),"Inicia el contador" , 5).show();
		for(int i=0;i<100;i++){
			barra.incrementProgressBy(1);
			barra.setProgress(i);
			cuenta++;
		}
	}
	
	/**
	 *Metodo para llamar a la pantalla de login
	 */
	public void login(){
		//Toast.makeText(getApplicationContext(),"Ha llegado al login" , Toast.LENGTH_SHORT).show();
		Intent i = new Intent(Inicio.this,Login.class);
		//Toast.makeText(getApplicationContext(),"Vamos a iniciar el starActivity" , 5).show();
		//barra.setActivated(false);
		startActivityForResult(i, 1);
	}

}
