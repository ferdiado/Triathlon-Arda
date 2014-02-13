package com.arda.triathlon;

import com.arda.screens.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Login extends Activity {

	Button iniciar, registrar;
	EditText usuario, password;
	RadioButton entrenador, deportista;
	//Modo: true = entrenador, false = deportista
	//por defecto deportista
	boolean modo = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login0);

		usuario = (EditText) findViewById(R.id.usuario);
		password = (EditText) findViewById(R.id.password);
		
		iniciar = (Button) findViewById(R.id.iniciar);
		iniciar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {     
				/*if(entrenador.isChecked()){
					modo = true;
				}else if(deportista.isChecked()){
					modo = false;
				}*/
				modo = true;
				//Llama a la segunda pantalla
				Intent i = new Intent(Login.this,Modo.class);
				i.putExtra("usuario",usuario.getText().toString());
				i.putExtra("password",password.getText().toString());
				i.putExtra("modo", modo);
				startActivityForResult(i, 2);
			}

		});

		registrar = (Button) findViewById(R.id.resgistrarse);
		registrar.setOnClickListener(new OnClickListener( ){

			@Override
			public void onClick(View v) {     
				//Llama a la segunda pantalla
				Toast.makeText(getApplicationContext(), "Se enviará a la pagina web para registrarse", Toast.LENGTH_SHORT).show();
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
