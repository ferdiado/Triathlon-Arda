package com.arda.screens;

import java.util.ArrayList;

import com.arda.BBD.Users;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Este metodo es el que contruya la página que controle los tiempos
 * tanto en una competición como en un entrenamiento de todos los deportistas
 * 
 * @author FADAD
 *
 */
public class Estadisticas extends Activity{
	ArrayList <String> contenedor = new ArrayList<String>();
	TableLayout ll = (TableLayout) findViewById(R.id.tableLayout);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estadisticas);
		//metodo dani
		//TableIniciator();
		/*TableRow row= new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);
		Users u = new Users(getApplicationContext());
		int num = u.numeroDeportistas("pepe").size();
		for(int i=0;i<num;i++){
			row.removeAllViews();
			for(int x=0;x<5;x++){
			contenedor.get(0);
			contenedor.remove(0);			
	        TextView tv1= new TextView(this);
	        row.addView(tv1);
			}
			ll.addView(row,i+1);
		}*/
	}
	
	public void TableIniciator(){
				/*ll.removeAllViews();
				TableRow row=(TableRow)findViewById(R.id.row);
		        //TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
		        //row.setLayoutParams(lp);
		        TextView tv1= new TextView(this);
		        TextView tv2= new TextView(this);
		        TextView tv3= new TextView(this);
		        TextView tv4= new TextView(this);
		        TextView tv5= new TextView(this);
		        TextView tv6= new TextView(this);
		        tv1.setText("Deportista");
		        tv2.setText("Tiempo Ciclismo");
		        tv3.setText("Tiempo Natacion");
		        tv4.setText("Tiempo Atletismo");
		        tv5.setText("Distancia Total");
		        tv6.setText("Tiempo Total");
		        row.addView(tv1);
		        row.addView(tv2);
		        row.addView(tv3);
		        row.addView(tv4);
		        row.addView(tv5);
		        row.addView(tv6);
		        ll.addView(row,1);*/
		ll.removeAllViews();
		TableRow row = (TableRow) LayoutInflater.from(Estadisticas.this).inflate(R.layout.row, null);
        //TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        //row.setLayoutParams(lp);
		TextView tv1 = (TextView) findViewById(R.id.tv1);
		TextView tv2 = (TextView) findViewById(R.id.tv2);
		//tv1.setText("Mep1");
		//tv2.setText("Mep2");
        ll.addView(row,0);


	   
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
