package com.arda.tasukete;

import java.util.ArrayList;

import com.arda.screens.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Adaptador para contruir una lista de deportistas
 * @author FADAD
 *
 */
public class AdaptadorDeportista extends ArrayAdapter<String>{

	private Context contexto;
	private int idLayout;
	private ArrayList<String> lista, listaImagenes;

	/**
	 * Constructor del adaptador para los deportistas.
	 * @param context
	 * @param idLay
	 * @param listaRecibida
	 */
	public AdaptadorDeportista(Context context,int idLayout, ArrayList<String> listaRecibida){
		super(context, idLayout, listaRecibida);
		this.contexto = context;
		this.lista = listaRecibida;
		this.idLayout = idLayout;
	}

	/**
	 * Metodo con el que inflamos el layout deseado.
	 */
	public View getView(int posicion,View convertView, ViewGroup parent){
		
		LayoutInflater inflater=(LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View vi = inflater.inflate(R.layout.fragment_deportista, parent,false);
		
		//Log.d("TASU", convertView.toString());
		TextView nombreDe = (TextView) vi.findViewById(R.id.nomDeportista);
		ImageView imagen = (ImageView) vi.findViewById(R.id.imgDeportista);
		
		//nombreDe.setText(lista.get(posicion));
		Toast.makeText(getContext(), "Llega:", Toast.LENGTH_LONG).show();
		return convertView;

	}
}
