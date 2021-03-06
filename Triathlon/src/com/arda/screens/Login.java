package com.arda.screens;

import com.arda.BBD.Users;
import com.arda.BBD.crearBD;
import com.arda.tasukete.TasuketeLogin;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
EditText etUser;
EditText etPass;
Button bLogin;
Button bRegister;//Decir a josu que ponga pass como id del bPass;
	
	protected void onStart(Bundle savedInstanceState) {
		Users u = new Users(getApplicationContext());
		
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);		
		etUser = (EditText) this.findViewById(R.id.editUsario);
		etPass = (EditText) this.findViewById(R.id.editPassword);
		bLogin = (Button) this.findViewById(R.id.login);
		bRegister = (Button) this.findViewById(R.id.register);
		bLogin.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Login.this, TasuketeLogin.class);
            		if(etUser.getText().toString().isEmpty())
            		{Toast toast = Toast.makeText(getApplicationContext(), "Debes rellenar el campo de Usuario", Toast.LENGTH_SHORT);
            		toast.show();
            		}else{
            			if(etPass.getText().toString().isEmpty())
            			{Toast toast = Toast.makeText(getApplicationContext(), "Debes rellenar el campo de Contraseņa", Toast.LENGTH_SHORT);
                		toast.show();
                		}else{
                			String UserSTR = etUser.getText().toString();
                			if(UserSTR.charAt(UserSTR.length()-1)==' '){UserSTR=UserSTR.substring(0, UserSTR.length()-1);}
                			i.putExtra("User", UserSTR);
                    		i.putExtra("Pass", etPass.getText().toString());
                    		startActivityForResult(i, 1);
                		}
            			
            		}
            		
         		//Toast toast = Toast.makeText(getApplicationContext(), etUser.getText().toString(), Toast.LENGTH_SHORT);
        		//toast.show();
            }

     });
		bRegister.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Login.this, Registro.class);
            	i.putExtra("Cod", 0);
            	startActivity(i);
            			
            		
            		
         		
            }

     });
	}

	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		  if (requestCode == 1) {

		     if(resultCode == RESULT_OK){      
		    	Context context = getApplicationContext();
		    	int duration = Toast.LENGTH_SHORT;
		    	if(data.getBooleanExtra("Res", false))
		    	{

			 		Toast toast = Toast.makeText(context, "Bienvenido : "+etUser.getText().toString(), duration);
			 		toast.show();
			 		Intent i = new Intent(Login.this, Inicio.class);
			 		startActivity(i);
		    		
		    	}else{
		    		Toast toast = Toast.makeText(context, "Esa combinacion de usuario/contraseņa no esta registrada. Vuelva a intentarlo.", Toast.LENGTH_LONG);
			 		toast.show(); 
		    	}
       
		     }
		     if (resultCode == RESULT_CANCELED) {    
		         //Write your code if there's no result
		     }
		  }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
