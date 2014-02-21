package com.arda.tasukete;

import com.arda.BBD.*;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class ServicioBD extends Service {
	Context c;
    public void onCreate() {
    	
          Toast.makeText(this,"Servicio creado",Toast.LENGTH_SHORT).show();
    }
    public int onStartCommand(Intent intenc, int flags, int idArranque) {
    	c=getApplicationContext();
    	Toast.makeText(this,"Servicio creado 2",Toast.LENGTH_SHORT).show();
    	Users u = new Users(c);
    	u.crearEntrada("jozu", "123", "jozu", "1994-12-12", null, false, false, "sa.png");
    	this.stopSelf();
        return START_STICKY;
    }
    public void onDestroy() {
          //Toast.makeText(this,"Servicio detenido",Toast.LENGTH_SHORT).show();
          
    }
    public IBinder onBind(Intent intencion) {
          return null;
    }
}