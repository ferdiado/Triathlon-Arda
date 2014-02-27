package com.arda.tiempo;

import android.widget.TextView;


public class MiHilo extends Thread {
	public boolean detenido;
	public boolean pausado;
	int centesimas = 00,minutos=00, segundos=00, horas=00;
	Hand handler;
	String cron;

	//Cuando incio el hilo ya está detenido a false y pausado a true
	public MiHilo(TextView t){
		detenido = false;
		pausado = true;
		handler = new Hand(t); 
	}

	@SuppressWarnings("static-access")
	public void run(){
		while(!detenido)
		{ 
			while(!pausado) 
			{
				try { 
					if(centesimas == 99){
						centesimas = 00; 
						segundos++;
					} 
					if (segundos == 59) {
						segundos = 00; 
						minutos++; 
					} 
					if (minutos == 59) {
						minutos = 00;
						horas++;
					} 
					centesimas++; 
					cron = horas + " : " + minutos + " : " + segundos + " : " + centesimas;
					handler.setHcron(cron); 
					handler.act();   
					this.sleep(10);

				} catch (Exception ex) { 
					ex.printStackTrace();
				}     
			}      
		}    
	}

	public void setDetenido(boolean detenido){  
		this.detenido = detenido;
	}   
	public void setPausado(boolean pausado){   
		this.pausado = pausado;
	}     
	public void setCentesimas(int centesimas){       
		this.centesimas = centesimas;
	}       
	public void setMinutos(int minutos){         
		this.minutos = minutos;
	}       
	public void setSegundos(int segundos){         
		this.segundos = segundos;
	}    
	public void setHoras(int horas){        
		this.horas = horas;
	} 
} 