package com.arda.triathlon;


import com.arda.screens.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Competicion extends Activity {
	
	ArrayAdapter<CharSequence> competicion, deportistas;
	Spinner tipoCompeticion, cantDeportistas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_competicion);
		
		/*competicion = ArrayAdapter.createFromResource(this,R.array.disciplinas,android.R.layout.simple_spinner_item);
		deportistas = ArrayAdapter.createFromResource(this,R.array.cantidadDeportistas,android.R.layout.simple_spinner_item);
		
		tipoCompeticion = (Spinner) findViewById(R.id.disciplina);
		tipoCompeticion.setAdapter(competicion);
		tipoCompeticion.setOnItemSelectedListener(
				new AdapterView.OnItemSelectedListener(){
				public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
					// TODO Auto-generated method stub
	
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				}
				);
		cantDeportistas = (Spinner) findViewById(R.id.cantDeportistas);
		cantDeportistas.setAdapter(deportistas);
		cantDeportistas.setOnItemSelectedListener(
				new AdapterView.OnItemSelectedListener(){
				public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
					// TODO Auto-generated method stub
	
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
				}
				);*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inicio, menu);
		return true;
	}

}
