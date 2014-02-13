package com.arda.tasukete;

import com.arda.BBD.Users;
import com.arda.triathlon.Login;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
/**
 * Esta clase se utiliza para ayudar con la recogida
 * @author CNSAKS
 * 
 *
 */
public class tasuketeLogin extends Activity {
	public void onCreate(Bundle savedInstance ){
        super.onCreate(savedInstance);
        Users u = new Users(null);
        Intent i = this.getIntent();
        String nombre = i.getStringExtra("User");
        String apellidos = i.getStringExtra("Pass");
        Intent iOut = new Intent(tasuketeLogin.this, Login.class);
        iOut.putExtra("Res", u.logeo(nombre, apellidos));       
        setResult( Activity.RESULT_OK, iOut);
        tasuketeLogin.this.finish();
    }
	
	

}
