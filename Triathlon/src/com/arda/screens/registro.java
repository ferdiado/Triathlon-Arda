package com.arda.screens;

import com.arda.tasukete.tasuketeLogin;
import com.arda.tasukete.tasuketeRegistro;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class registro extends Activity {
Button bAceptar;
Button bCancelar;
EditText etUser;
EditText etPass;
EditText etFecha;
EditText etApellido1;
EditText etApellido2;
EditText etNombre;
RadioButton rbHombre;
RadioButton rbMujer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		rbHombre = (RadioButton) this.findViewById(R.id.radioButtonHombre);
		rbMujer = (RadioButton) this.findViewById(R.id.radioButtonMujer);
		etUser = (EditText) this.findViewById(R.id.editUsuario);
		etPass = (EditText) this.findViewById(R.id.editPassword);
		etFecha = (EditText) this.findViewById(R.id.editFechaNacimiento);
		etApellido1 = (EditText) this.findViewById(R.id.editPrimerApellido);
		etApellido2 = (EditText) this.findViewById(R.id.editSegundoApellido);
		etNombre = (EditText) this.findViewById(R.id.editNombre);
		bAceptar = (Button) this.findViewById(R.id.bAcep);
		bCancelar = (Button) this.findViewById(R.id.bCanc);
		bAceptar.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(registro.this, tasuketeRegistro.class);
        		if(etUser.getText().toString().isEmpty())
        		{Toast toast = Toast.makeText(getApplicationContext(), "User no puede esta vacio", Toast.LENGTH_SHORT);
        		toast.show();
        		}else{
        			if(etPass.getText().toString().isEmpty())
        			{Toast toast = Toast.makeText(getApplicationContext(), "Pass no puede esta vacio", Toast.LENGTH_SHORT);
            		toast.show();
            		}else{
            			if(etFecha.getText().toString().isEmpty())
            			{Toast toast = Toast.makeText(getApplicationContext(), "Fecha no puede esta vacio", Toast.LENGTH_SHORT);
                		toast.show();
                		}else{
                			if(etApellido1.getText().toString().isEmpty())
                			{Toast toast = Toast.makeText(getApplicationContext(), "Primer Apellido no puede esta vacio", Toast.LENGTH_SHORT);
                    		toast.show();
                    		}else{
                    			if(etApellido2.getText().toString().isEmpty())
                    			{Toast toast = Toast.makeText(getApplicationContext(), "Segundo Apellido no puede esta vacio", Toast.LENGTH_SHORT);
                        		toast.show();
                        		}else{
                        			if(etNombre.getText().toString().isEmpty())
                        			{Toast toast = Toast.makeText(getApplicationContext(), "Nombre no puede esta vacio", Toast.LENGTH_SHORT);
                            		toast.show();
                            		}else{
                            			i.putExtra("IDus", etUser.getText().toString());
                                		i.putExtra("Pwrd", etPass.getText().toString());
                                		i.putExtra("Fech", etFecha.getText().toString());
                                		i.putExtra("Ape1", etApellido1.getText().toString());
                                		i.putExtra("Ape2", etApellido2.getText().toString());
                                		i.putExtra("Nomb", etNombre.getText().toString());
                                		if(rbHombre.isChecked()){i.putExtra("Sexo", true);}
                                		else{i.putExtra("Sexo", false);}
                                		startActivityForResult(i, 1);
                            		}
                        		}	
                    		}                			
                		}            			           			
            		}        			
        		}
        }

 });
		bCancelar.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(registro.this, login.class);
            	startActivity(i);            			        		
         		
            }

     });
	}
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		  if (requestCode == 1) {

			     if(resultCode == RESULT_OK){      
			    	Context context = getApplicationContext();
			    	int duration = Toast.LENGTH_SHORT;
			    	switch(data.getIntExtra("Reg", 3)){
			    	case 0:
				 		Toast toast1 = Toast.makeText(context, "Registro Completo. Volviendo a la pantalla de login", duration);
				 		toast1.show();				 		
				 		registro.this.finish();
				 		break;
			    	case 1:
			    		Toast toast2 = Toast.makeText(context, "Error en el registro. Usuario ya establecido", duration);
				 		toast2.show();
				 		break;
			    	case 2:
			    		Toast toast3 = Toast.makeText(context, "Error en el registro. Razon desconocida", duration);
				 		toast3.show();
			    		break;
			    	default:
			    		Toast toast4 = Toast.makeText(context, "Error en el registro. Razon desconocida", duration);
				 		toast4.show();
	       
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
