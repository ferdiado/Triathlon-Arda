package com.arda.tasukete;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Adaptador para contruir una lista de deportistas
 * @author FADAD
 *
 */
public abstract class adaptadorDeportista extends BaseAdapter{

	private Context contexto;
	private int idLayout;
	private ArrayList<?> lista;

	/**
	 * Constructor del adaptador para los deportistas.
	 * @param context
	 * @param idLay
	 * @param listaRecibida
	 */
	public adaptadorDeportista(Context context, int idLay, ArrayList<?> listaRecibida){
		super();
		this.contexto = context;
		this.idLayout = idLay;
		this.lista = listaRecibida;
	}

	/**
	 * Metodo que nos devuelve la cantidad de objetos que hay en la lista
	 * a construir.
	 */
	public int getCount(){
		return lista.size();
	}


	/**
	 * Metodo que nos devuelve un Objeto del formato de la lista
	 * del adaptdor.
	 */
	public Object getItem(int arg0){
		return lista.get(arg0);
	}

	/**
	 * Metodo que nos devuelve el Id de un Objeto de la lista.
	 */
	public long getItemId(int arg0){
		return arg0;
	}

	/**
	 * Metodo con el que inflamos el layout deseado.
	 */
	public View getView(int posicion,View convertView, ViewGroup parent){
		if(convertView == null){
			LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(idLayout, null);
		}
		onEntrada (lista.get(posicion),convertView);
		return convertView;

	}

	/**
	 * Metodo para crear la Entrada
	 * @param objet
	 * @param view
	 */
	public abstract void onEntrada(Object objet, View view);
}
