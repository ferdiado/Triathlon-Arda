package com.arda.screens;

import java.util.ArrayList;

import com.arda.BBD.Users;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Este metodo es el que contruya la página que controle los tiempos
 * tanto en una competición como en un entrenamiento de todos los deportistas
 * 
 * @author FADAD
 *
 */
public class ControlTiempos extends Activity implements SeleccionDeportista.OnMandaDatos{
	
	FragmentManager fManager; // Declaramos objetos.
	FragmentTransaction fTransaction;
	Fragment fragment; // Contiene los fragment 2 y 3.
	ArrayList<String> nombres, imagenes, deportistas;
	GridView GridDeportistas;
	Users BDUsuarios;
	int numDeportistas;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_deportistas);
		fManager = getFragmentManager();
		GridDeportistas = (GridView) findViewById(R.id.gridDeportista);
		//GridDeportistas.setAdapter(nombres);
		BDUsuarios = new Users(getApplicationContext());
		BDUsuarios.abrirBd();
		deportistas = BDUsuarios.numeroDeportistas("ENTRENADOR");
		numDeportistas = deportistas.size();
		if(numDeportistas<1){
			Toast.makeText(getApplicationContext(), "ERROR - No existen deportitas para mostrar", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onMandaDatosToFragment(String nombre, String rutaImg) {
		// TODO Auto-generated method stub
		
		fTransaction = fManager.beginTransaction();
		
		Bundle datos = new Bundle();
		
		datos.putStringArrayList("nombres", nombres);
		datos.putStringArrayList("imagenes", imagenes);
		
		fragment = new SeleccionDeportista();
		
		fragment.setArguments(datos);
		
		
	}
}
