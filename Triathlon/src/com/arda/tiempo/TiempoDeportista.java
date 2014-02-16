package com.arda.tiempo;

import com.arda.screens.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Este activity servirá para controlar el tiempo de cada deportista con sus hilos.
 * @author FADAD
 *
 */
public class TiempoDeportista extends Activity {

	//Declaramos los datos del deportista que nos tiene que enviar la pantalla principal.
	String nombreDeportista, img_deportista;
	ImageView deportista;
	TextView nomDeportista, textCronometro;
	ImageButton inicio, parar;
	EditText distancia;
	boolean play = true; 
	String foto, crono;
	MiHilo mihilo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_cronometro_deportista);

		Intent i = this.getIntent();
        
		//Obtenemos el nombre del deportista
		nombreDeportista = i.getStringExtra("Deportista");
        nomDeportista = (TextView) findViewById(R.id.nomDeportista);
		nomDeportista.setText(nombreDeportista);
		
		//Obtenemos la imagen del deportista
        img_deportista = i.getStringExtra("foto");
        /*En este caso hemos puesto la imagen de nousuario, hay que construir
        * un metodo para seleccionar la foto y si esta no esta o da algun error
        *  que salga la de nousuario
        */
        deportista.setImageResource(R.drawable.nousuario);
        
        
		textCronometro = (TextView) findViewById(R.id.textCrono);
		distancia = (EditText) findViewById(R.id.insertDistanciaTotal);
		distancia.setEnabled(false);
		mihilo = new MiHilo(textCronometro);
		//iniciamos el hilo
		mihilo.start();

		/*Este metodo es para poder hacer una foto.
		deportista =(ImageView) findViewById(R.id.imgDeportista);
		//Lammamos al método que al pulsar sobre la imagen nos llame a hacer una foto.
		deportista.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				//Esto hay que comrpobarlo me da fallo
				Intent i = new Intent(MainActivity.this, GestorImagen.class);
				startActivityForResult(i, 25);
			}
		});*/
		
		/*
		 * Botón de inicio de cuenta en el cronometro.
		 */
		inicio = (ImageButton) findViewById(R.id.playBoton);
		inicio.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if(play){
					//Estamos en la opción inicio del cronometro
					//Cambiamos la imagen a pausa
					inicio.setImageResource(R.drawable.ic_action_pause);
					//activamos el boton de parar.
					parar.setEnabled(true);
					mihilo.setPausado(false);
					mihilo.setDetenido(false);
					play = false;
					distancia.setEnabled(false);
				}else{
					//Estamos en la opción pause del cronometro
					inicio.setImageResource(R.drawable.ic_action_play);
					mihilo.setPausado(true);
					play = true;
					distancia.setEnabled(false);
				}
			}
		});
		
		parar = (ImageButton) findViewById(R.id.stopBoton);
		parar.setEnabled(false);
		parar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				crono = "00:00:00:00";
				textCronometro.setText(crono);
				inicio.setImageResource(R.drawable.ic_action_play);
				mihilo.setCentesimas(0);
				mihilo.setSegundos(0);
				mihilo.setMinutos(0);
				mihilo.setHoras(0);
				parar.setEnabled(false);
				distancia.setEnabled(true);
				play = true;
				mihilo.setPausado(true);
				mihilo.setDetenido(true);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
}
