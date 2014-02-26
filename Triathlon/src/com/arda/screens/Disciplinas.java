package com.arda.screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Este metodo es el que contruya la p�gina que controle los tiempos
 * tanto en una competici�n como en un entrenamiento de todos los deportistas
 * 
 * @author FADAD
 *
 */
public class Disciplinas extends Activity{
	Button bCicl;
	Button bNata;
	Button bAtle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_disciplinas);
		bAtle = (Button) this.findViewById(R.id.button1);
		bCicl = (Button) this.findViewById(R.id.button2);
		bNata = (Button) this.findViewById(R.id.button3);
		bAtle.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Disciplinas.this, ControlDeportistas.class); 
            	i.putExtra("Code", 0);
                startActivity(i);
            	
	}
	});
		bCicl.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Disciplinas.this, ControlDeportistas.class); 
            	i.putExtra("Code", 0);
                startActivity(i);
            	
	}
	});
		bNata.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Disciplinas.this, ControlDeportistas.class); 
            	i.putExtra("Code", 0);
                startActivity(i);
            	
	}
	});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
