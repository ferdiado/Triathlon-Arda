package com.arda.screens;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Pantalla de control de la imagen del deportista
 * @author FADAD
 *
 */
public class SeleccionDeportista extends Fragment{

	private OnMandaDatos DatosDeportista;
	ImageView IMG_deportista;
	TextView nomDeportista;
	
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
        // Unflem el Layout amb el fragment 1
		View view = inflater.inflate(R.layout.fragment_deportista, container, false);
		
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
