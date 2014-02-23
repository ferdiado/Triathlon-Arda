package com.arda.tasukete;

public class ElementoDeportista {
	
	private String nombre;
	private int imagen;
	private boolean seleccionado;
	
	public ElementoDeportista(String nom, int img, boolean selec){
		this.nombre = nom;
		this.imagen = img;
		this.seleccionado= selec;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public int getImagen() {
		return imagen;
	}

}
