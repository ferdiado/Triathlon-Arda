package com.arda.screens;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * Este metodo es el que contruya la página que controle los tiempos
 * tanto en una competición como en un entrenamiento de todos los deportistas
 * 
 * @author FADAD
 *
 */
public class Disciplinas extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_disciplinas);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
