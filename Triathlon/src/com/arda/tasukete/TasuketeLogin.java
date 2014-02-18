package com.arda.tasukete;


import com.arda.screens.Login;
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
public class TasuketeLogin extends Activity {
	public void onCreate(Bundle savedInstance ){
        super.onCreate(savedInstance);
        Users u = new Users(getApplicationContext());
        Intent i = this.getIntent();
        String User = i.getStringExtra("User");
        String Pass = i.getStringExtra("Pass");
        Intent iOut = new Intent(TasuketeLogin.this, Login.class);
        iOut.putExtra("Res", u.logeo(User, Pass));       
        setResult(Activity.RESULT_OK, iOut);
        TasuketeLogin.this.finish();
        
    }
	
	

}
