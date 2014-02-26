package com.arda.screens;

import java.util.ArrayList;

import com.arda.BBD.Users;
import com.arda.tasukete.ServicioBD;
import com.arda.tasukete.TasuketeLogin;
import com.arda.tasukete.TasuketeRegistro;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Registro extends Activity {
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
CheckBox chEntrenador;
CheckBox chDeportista;
int code = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		rbHombre = (RadioButton) this.findViewById(R.id.radioButtonHombre);
		rbMujer = (RadioButton) this.findViewById(R.id.radioButtonMujer);
		etUser = (EditText) this.findViewById(R.id.editUsuario);
		etPass = (EditText) this.findViewById(R.id.editPassword);
		etFecha = (EditText) this.findViewById(R.id.editFechaNacimiento);
		etNombre = (EditText) this.findViewById(R.id.editNombre);
		chEntrenador = (CheckBox) this.findViewById(R.id.checkBoxEntrenador);
		chDeportista = (CheckBox) this.findViewById(R.id.checkBoxDeportista);
		bAceptar = (Button) this.findViewById(R.id.bAcep);
		bCancelar = (Button) this.findViewById(R.id.bCanc);
		code = this.getIntent().getIntExtra("Cod", 2);
		switch(code){
		case 0:			
			break;
		case 1:
			/*Users u = new Users(getApplicationContext());
			ArrayList<String> dep =u.datosDeportistas(this.getIntent().getStringExtra("iduser"));			
			etUser.setText(dep.get(0));
			etPass.setText(dep.get(1));
			etNombre.setText(dep.get(2));
			etFecha.setText(dep.get(3));
			if(dep.get(6)=="true"){
				rbHombre.setChecked(true);
			}else{
				rbMujer.setChecked(true);
			}*/
			etUser.setText("pepe");
			etPass.setText("123");
			etNombre.setText("Pepe");
			etFecha.setText("2000/10/10");
			rbHombre.setChecked(true);
			break;
		default:
			break;
		}
		bAceptar.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Registro.this, TasuketeRegistro.class);
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
                				if(etNombre.getText().toString().isEmpty())
                					{Toast toast = Toast.makeText(getApplicationContext(), "Nombre no puede esta vacio", Toast.LENGTH_SHORT);
                            		toast.show();
                            		}else{
                            			i.putExtra("IDus", etUser.getText().toString());
                                		i.putExtra("Pwrd", etPass.getText().toString());
                                		i.putExtra("Fech", etFecha.getText().toString());
                                		i.putExtra("Nomb", etNombre.getText().toString());
                                		//hombre = true ; mujer = false;
                                		if(rbHombre.isChecked()){i.putExtra("Sexo", true);}
                                		else{i.putExtra("Sexo", false);}
                                		if(chEntrenador.isChecked()){i.putExtra("Entr", true);}
                                		else{i.putExtra("Entr", false);}
                                		if(chDeportista.isChecked()){i.putExtra("Depo", true);}
                                		else{i.putExtra("Depo", false);}
                                		i.putExtra("code", code);
                                		startActivityForResult(i, 1);
                                		//startService(new Intent(Registro.this,ServicioBD.class));
                            		}
                        		}	
	           			           			
            		}        			
        		}
        }

 });
		bCancelar.setOnClickListener(new OnClickListener( ){
			 
            @Override
            public void onClick(View v) {
            	Intent i = new Intent(Registro.this, Login.class);
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
				 		Registro.this.finish();
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
