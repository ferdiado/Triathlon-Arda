package com.arda.screens;

import com.arda.BBD.Users;
import com.arda.BBD.crearBD;
import com.arda.tasukete.TasuketeLogin;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Gestion extends Activity {
Button bSes;
Button bCom;
ImageButton bAna;
ImageButton bMod;
ImageButton bDel;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gestion);
		bAna = (ImageButton) this.findViewById(R.id.imageButton1);
		bMod = (ImageButton) this.findViewById(R.id.imageButton2);
		bDel = (ImageButton) this.findViewById(R.id.imageButton3);
		bSes = (Button) this.findViewById(R.id.button4);
		bCom = (Button) this.findViewById(R.id.button5);
		bAna.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Gestion.this, Registro.class);     		
                startActivity(i);
            	
	}
		});
		bMod.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Gestion.this, Registro.class);     		
                startActivity(i);
            	
	}
		});
		bDel.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Gestion.this, Registro.class);     		
                startActivity(i);
            	
	}
		});
		bSes.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Gestion.this, Estadisticas.class);     		
                startActivity(i);
            	
	}
		});
		bCom.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Gestion.this, Estadisticas.class);     		
                startActivity(i);
            	
	}
		});
		
	}
}
