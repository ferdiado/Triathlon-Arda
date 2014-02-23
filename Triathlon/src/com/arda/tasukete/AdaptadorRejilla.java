package com.arda.tasukete;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class AdaptadorRejilla extends BaseAdapter {

	private Context context;
	private int idLayout;
	private ArrayList<?> entradas;

	public AdaptadorRejilla(Context context, int idLayout, ArrayList<?> entradas){
		super();
		this.context = context;
		this.entradas = entradas;
		this.idLayout = idLayout;
	}
	
	
	public int getCount(){
		return entradas.size();
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return entradas.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(idLayout, null);
		}
		
		onEntrada(entradas.get(position),convertView);
		
		return convertView;
	}


	public abstract void onEntrada(Object entrada, View view);
}
