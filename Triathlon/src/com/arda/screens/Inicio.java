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
import android.widget.Toast;

public class Inicio extends Activity {
Button bComp;
Button bEntr;
Button bGest;

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		bComp = (Button) this.findViewById(R.id.button1);
		bEntr = (Button) this.findViewById(R.id.button2);
		bGest = (Button) this.findViewById(R.id.button3);
		bComp.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Inicio.this, ControlTiempos.class);     		
                startActivity(i);
            	
	}
		});
		bEntr.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Inicio.this, ControlTiempos.class);     		
                startActivity(i);
            	
	}
		});
		bGest.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Inicio.this, Gestion.class);     		
                startActivity(i);
            	
	}
		});
	}
}

	