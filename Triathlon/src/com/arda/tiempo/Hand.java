package com.arda.tiempo;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * Este metodo se encarga de actualizar el contador en el TextView
 * @author FADAD
 *
 */
public class Hand extends Handler
{
	String hcron;
	TextView tiempo;

	public Hand(TextView t)
	{
		tiempo = t;
	}
	
	public void handleMessage(Message msg)
	{
		tiempo.setText(hcron);
	}
	
	public void setHcron(String hcron) {
		this.hcron = hcron;
	}
	
	public void act()
	{
		super.sendEmptyMessage(0);
	}
}