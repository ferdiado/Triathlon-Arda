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

/**
 * Este activity servirá para controlar el tiempo de cada deportista con sus hilos.
 * @author FADAD
 *
 */
public class TiempoDeportista extends Fragment {

	//Declaramos los datos del deportista que nos tiene que enviar la pantalla principal.
	private OnMandaDatos DatosDeportista;
	String nombreDeportista, img_deportista;
	ImageView IMG_deportista;
	TextView nomDeportista, textCronometro;
	ImageButton inicio, parar;
	EditText distancia;
	boolean play = true; 
	String foto, crono;
	MiHilo mihilo;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
		//Obtenemos el fragment mediante un inflater.
		View view = inflater.inflate(R.layout.fragment_cronometro_deportista, container, false);
		
		Bundle bundle = this.getArguments();
		int numDeportista = bundle.getInt("id_deportista");
		String[] nomDeportistas  =  bundle.getStringArray("nombres");
		String[] imgDeportistas = bundle.getStringArray("imagenes");
		
		IMG_deportista = (ImageView)view.findViewById(R.id.imgDeportista);
		//Lamar al metodo que me devuelva la imagen de este jugador.
		//Con la imgDeportista vamos a vuscar las imagenes que mostraremos en el IMG_deportista
		
		nomDeportista = (TextView) getActivity().findViewById(R.id.nomDeportista);	
		//Lamar al metodo que me de vuelva el nombre de este deportista
		nomDeportista.setText(nomDeportistas[numDeportista]);
        
		textCronometro = (TextView) getActivity().findViewById(R.id.textCrono);
		distancia = (EditText) getActivity().findViewById(R.id.insertDistanciaTotal);
		distancia.setEnabled(false);
		
		mihilo = new MiHilo(textCronometro);
		//iniciamos el hilo
		mihilo.start();
		
		/*
		 * Botón de inicio de cuenta en el cronometro.
		 */
		inicio = (ImageButton) getActivity().findViewById(R.id.playBoton);
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
		
		/*
		 * Botón de parar la cuenta en el cronometro y reseteo.
		 */
		parar = (ImageButton) getActivity().findViewById(R.id.stopBoton);
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
		
		return view;
	}

	/**
	 * Este metodo es para mandar datos
	 * @author FADAD
	 *
	 */
	public interface OnMandaDatos {
		public void onMandaDatosToFragment(String nombre, String rutaImg);
		
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			DatosDeportista = (OnMandaDatos) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " debe implementar la clase OnMandaDatos");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		DatosDeportista = null;
	}
	
}
