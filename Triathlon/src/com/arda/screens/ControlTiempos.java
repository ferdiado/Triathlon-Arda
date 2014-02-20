package com.arda.screens;

import java.util.ArrayList;

import com.arda.BBD.Users;
import com.arda.tasukete.AdaptadorDeportista;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Este metodo es el que contruya la página que controle los tiempos
 * tanto en una competición como en un entrenamiento de todos los deportistas
 * 
 * @author FADAD
 *
 */
public class ControlTiempos extends Activity{
	
	ArrayList<String> nombres, imagenes, deportistas;
	GridView GridDeportistas;
	Users BDUsuarios;
	String usuario;
	int numDeportistas;
	AdaptadorDeportista adaptador;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_deportistas);

		//usuario = //Aquí hay que recoger el usuario que esta logeado.

		deportistas = new ArrayList<String>();
		deportistas.add("ENTRENADOR");
		deportistas.add("JUAN");
		construyeDeportistas();
		/*BDUsuarios = new Users(getApplicationContext());
		BDUsuarios.abrirBd();
		deportistas = BDUsuarios.numeroDeportistas("ENTRENADOR");
		numDeportistas = deportistas.size();
		if(numDeportistas<1){
			Toast.makeText(getApplicationContext(), "ERROR - No existen deportitas para mostrar", Toast.LENGTH_SHORT).show();
		}else{
			construyeDeportistas();
		}*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/*@Override
	public void onMandaDatosToFragment(String nombre, String rutaImg) {
		// TODO Auto-generated method stub
		
		fTransaction = fManager.beginTransaction();
		
		Bundle datos = new Bundle();
		
		datos.putStringArrayList("nombres", nombres);
		datos.putStringArrayList("imagenes", imagenes);
		datos.putString("Usuario", usuario);
		
		fragment = new SeleccionDeportista();
		
		fragment.setArguments(datos);
		
	}*/

	private void construyeDeportistas() {
		// ArrayList para construir los deportistas copia de deportistas.
		//final ArrayList<String> deportistasTempo = deportistas;
		
		GridDeportistas = (GridView) findViewById(R.id.gridDeportista);
		
		registerForContextMenu(GridDeportistas);
		
		adaptador = new AdaptadorDeportista(this, R.layout.fragment_deportista, deportistas);
		
		GridDeportistas.setNumColumns(2);
		GridDeportistas.setAdapter(adaptador);

	}
}
