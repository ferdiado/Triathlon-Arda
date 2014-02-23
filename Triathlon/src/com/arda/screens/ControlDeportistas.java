package com.arda.screens;

import java.util.ArrayList;

import com.arda.tasukete.AdaptadorRejilla;
import com.arda.tasukete.ElementoDeportista;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Este metodo es el que contruye un gridview donde seleccionamos
 * los deportistas que deseamos añadir o bien a la gestión de los cronometros
 * u otras pantallas
 * 
 * @author FADAD / GarciaFigueres
 *
 */
public class ControlDeportistas extends Activity{
	
	ArrayList<String> nombres, imagenes, deportistas= new ArrayList<String>();
	private ArrayList<String> deportistasSeleccionados = new ArrayList<String>();
	private GridView rejilla;
	/*Users BDUsuarios;
	String usuario;
	int numDeportistas;
	AdaptadorDeportista adaptador;*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_deportistas);

		//usuario = //Aquí hay que recoger el usuario que esta logeado.		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,R.layout.rejilla,deportistas);

		//Estamos grabando a fuego 19 deportistas esto debería venir de la BB.DD. 
		for(int i=0;i<19;i++){
			Log.d("ARDA",i+"");
			deportistas.add("deportista:"+i);
		}
		
		//Creamos el Array con los datos de los deportistas
		ArrayList<ElementoDeportista> datosDeportista = new ArrayList<ElementoDeportista>();

		for(int i=0;i<deportistas.size();i++){
			datosDeportista.add(new ElementoDeportista(deportistas.get(i),R.drawable.nousuario,false));
		}
		
		rejilla = (GridView) findViewById(R.id.gridView1);
		
		rejilla.setAdapter(new AdaptadorRejilla(this,R.layout.elemento_deportista,datosDeportista){

			@Override
			public void onEntrada(Object entrada, View view) {
				// TODO Auto-generated method stub
				if(entrada != null){
					ImageView imagenDep = (ImageView) view.findViewById(R.id.imgDeportista);
					if(imagenDep != null){
						imagenDep.setImageResource(((ElementoDeportista) entrada).getImagen());
						/*Bitmap b=BitmapFactory.decodeFile("/data/data/app_Img_Arda/");
						imagenDep.setImageBitmap(b);*/
					}
					TextView nomDep = (TextView) view.findViewById(R.id.nomDeportista);
					if(nomDep != null){
						nomDep.setText(((ElementoDeportista) entrada).getNombre());
					}
				}
			}
			
		});
		
		rejilla.setOnItemClickListener(new OnItemClickListener() {


			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				ElementoDeportista eld=(ElementoDeportista)arg0.getItemAtPosition(arg2);
				TextView txtNombre = (TextView) arg1.findViewById(R.id.nomDeportista);
				LinearLayout fondo = (LinearLayout) arg1.findViewById(R.id.elLinearLayout);
				if(!eld.isSeleccionado()){	
					fondo.setBackgroundResource(R.drawable.marco_usuario_gris);
					txtNombre.setTextColor(Color.BLACK);
					txtNombre.setTypeface(null,Typeface.BOLD);
					eld.setSeleccionado(true);
					deportistasSeleccionados.add(eld.getNombre());
				}else{
					fondo.setBackgroundResource(R.drawable.marco_usuario_gris_claro);
					txtNombre.setTextColor(Color.DKGRAY);
					txtNombre.setTypeface(null,Typeface.NORMAL);
					eld.setSeleccionado(false);
					deportistasSeleccionados.remove(eld.getNombre());
				}
			}

		});
		
		/*Button btnAceptar = (Button) findViewById(R.id.botonAceptarDeportistas);
		btnAceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*Intent i = new Intent(MainActivity.this,Cronometro.class);
				i.putStringArrayListExtra("deportistas", deportistasSeleccionados);
				startActivity(i);*/
				/*Toast.makeText(getApplicationContext(), "salta", Toast.LENGTH_SHORT).show();
			}
		});*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
