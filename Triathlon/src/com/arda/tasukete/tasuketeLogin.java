package com.arda.tasukete;


import com.arda.screens.login;
import com.arda.BBD.Users;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
/**
 * Esta clase se utiliza para ayudar con la recogida de datos de login y comprobarlos con los
 * datos de la BD. Una vez hecho esto enviara un resultado a la pantalla "login" segun el resultado
 * enviado por la BD y daran permiso a pasar a la siguiente pantalla o mostrar un error.
 * @author CNSAKS
 * 
 *
 */
public class tasuketeLogin extends Activity {
	public void onCreate(Bundle savedInstance ){
        super.onCreate(savedInstance);
        Users u = new Users();
        Intent i = this.getIntent();
        String nombre = i.getStringExtra("User");
        String apellidos = i.getStringExtra("Pass");
        Intent iOut = new Intent(tasuketeLogin.this, login.class);
        iOut.putExtra("Res", /*u.logeo(nombre, apellidos)*/false);       
        setResult(Activity.RESULT_OK, iOut);
        tasuketeLogin.this.finish();
        
    }
	
	

}
