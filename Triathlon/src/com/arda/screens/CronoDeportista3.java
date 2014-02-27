package com.arda.screens;

import com.arda.tiempo.MiHilo;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CronoDeportista3 extends Fragment{

	private OnSendDeportista EnviaDeportista;
	
	ImageView imgDeportista;
	TextView txtNomDeportista, txtCrono, txtVueltas, txtPulsaciones;
	EditText etxtDistancia;
	ImageButton btnPlay, btnStop, btnDispoitivo, btnPulsaciones;
	boolean play = true;
	MiHilo hilo;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.elemento_crono, container, false);
		
		imgDeportista = (ImageView) view.findViewById(R.id.imgDeportista);
		imgDeportista.setImageResource(R.drawable.tinizaray);
		txtNomDeportista = (TextView) view.findViewById(R.id.nomDeportista);
		txtNomDeportista.setLines(2);
		txtNomDeportista.setText("Tinizaray\nRomero");
		txtCrono = (TextView) view.findViewById(R.id.textCrono);
		txtVueltas = (TextView) view.findViewById(R.id.textVueltas);
		txtPulsaciones = (TextView) view.findViewById(R.id.textPulsaciones);
		etxtDistancia = (EditText) view.findViewById(R.id.insertDistanciaTotal);
		etxtDistancia.setEnabled(false);
		
		hilo = new MiHilo(txtCrono);
		hilo.start();
		
		btnPlay = (ImageButton) view.findViewById(R.id.playBoton);
		btnPlay.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				if(play){
					Toast.makeText(getActivity().getApplicationContext(), "Play", Toast.LENGTH_LONG).show();
					//iniciarCuenta();
					btnPlay.setImageResource(R.drawable.ic_action_pause);
					btnStop.setEnabled(true);
					hilo.setPausado(false);
					hilo.setDetenido(false);
					play = false;
					etxtDistancia.setEnabled(false);
				}else{
					Toast.makeText(getActivity().getApplicationContext(), "Pausa", Toast.LENGTH_LONG).show();
					pausarCuenta();
				}
			}
			});
		
		btnStop = (ImageButton) view.findViewById(R.id.stopBoton);
		btnStop.setEnabled(false);
		btnStop.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Toast.makeText(getActivity().getApplicationContext(), "Parar", Toast.LENGTH_LONG).show();
				pararCuenta();	
			}
			});
		
		btnDispoitivo = (ImageButton) view.findViewById(R.id.dispositivoBoton);
		btnDispoitivo.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Toast.makeText(getActivity().getApplicationContext(), "Dispositivo", Toast.LENGTH_LONG).show();			
			}
			});
		btnPulsaciones = (ImageButton) view.findViewById(R.id.pulsacionesBoton);
		btnPulsaciones.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Toast.makeText(getActivity().getApplicationContext(), "Pulsaciones", Toast.LENGTH_LONG).show();
			}
			});
		return view;
	}
	
	public interface OnSendDeportista{
		public void onSendDeportistaToFragment(String text);
			
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			EnviaDeportista = (OnSendDeportista) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " debe implementar la clase OnSendName");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		EnviaDeportista = null;
	}
	
	public void iniciarCuenta(){
		btnPlay.setImageResource(R.drawable.ic_action_pause);
		btnStop.setEnabled(true);
		hilo.setPausado(false);
		hilo.setDetenido(false);
		play = false;
		etxtDistancia.setEnabled(false);
	}
	
	public void pausarCuenta(){
		btnPlay.setImageResource(R.drawable.ic_action_play);
		hilo.setPausado(true);
		txtVueltas.setText(txtCrono.getText());
		play = true;
		etxtDistancia.setEnabled(false);
	}
	
	public void pararCuenta(){
		txtCrono.setText("00:00:00:00");
		btnPlay.setImageResource(R.drawable.ic_action_play);
		hilo.setCentesimas(0);
		hilo.setSegundos(0);
		hilo.setMinutos(0);
		hilo.setHoras(0);
		btnStop.setEnabled(false);
		etxtDistancia.setEnabled(true);
		play = true;
		hilo.setPausado(true);
		hilo.setDetenido(true);
		hilo.interrupt();
	}
}
