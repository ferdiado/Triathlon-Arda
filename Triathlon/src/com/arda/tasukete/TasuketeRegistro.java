package com.arda.tasukete;


import com.arda.screens.Login;
import com.arda.screens.Registro;
import com.arda.BBD.Users;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
/**
 * Esta clase se utiliza para ayudar con la recogida de datos de registro y enviarlos a la BD. Una
 * vez hecho esto enviara un resultado a la pantalla "login" segun el resultado enviado por la BD
 * @author CNSAKS
 *
 *
 */
public class TasuketeRegistro extends Activity {
    public void onCreate(Bundle savedInstance ){
        super.onCreate(savedInstance);
        Intent i = this.getIntent();
        int caso = 0;
        Users u = new Users(getApplicationContext());
        String User = i.getStringExtra("IDus");
        String Pass = i.getStringExtra("Pwrd");
        String Nombre1 = i.getStringExtra("Nomb");
        String Fecha = i.getStringExtra("Fech");
        String Apellido1 = i.getStringExtra("Ape1");
        String Apellido2 = i.getStringExtra("Ape2");
        String Nombre = Nombre1+" "+Apellido1+" "+Apellido2;
        Boolean Sexo = i.getBooleanExtra("Sexo", false);
        //caso = i.getIntExtra("case", 4);
        Intent iOut = new Intent(TasuketeRegistro.this, Registro.class);
        switch(caso){
        case 0:
            iOut.putExtra("Reg", u.crearEntrada(User, Pass, Nombre, Fecha, null, false, Sexo, "sa.png"));
            setResult(Activity.RESULT_OK, iOut);
            TasuketeRegistro.this.finish();
            break;
        case 1:            
            
            break;
        default:            
            setResult(Activity.RESULT_CANCELED, iOut);
            TasuketeRegistro.this.finish();
            break;
        }
        
    }
    
    

}
