package com.arda.screens;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;

public class Cronometros extends Activity implements CronoDeportista.OnSendDeportista, CronoDeportista2.OnSendDeportista,
CronoDeportista3.OnSendDeportista, CronoDeportista4.OnSendDeportista{

	FragmentManager fm;
	FragmentTransaction ft;
	Fragment f1, f2, f3, f4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crono);
		fm = getFragmentManager();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onSendDeportistaToFragment(String text) {
		// TODO Auto-generated method stub
	}
	

}
