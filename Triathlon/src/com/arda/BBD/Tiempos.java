package com.arda.BBD;

import java.util.ArrayList;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class Tiempos {

	
	private crearBD db1;
	// final para que no cambie la base de datos
	private static final String N_BD = "BD_arda"; 

	//nombre de la tabla a seleccionar
	private static final String N_TABLA = "Tiempos";
	
	//Aqui tenemos todos los campos de la tabla tiempos.
		
		public static final String ID_USER = "IDUSER";
		public static final String ID_MODO = "MODO";
		public static final String ID_PRUEBA = "PRUEBA";
		public static final String ID_DISREC = "DISREC";
		public static final String ID_VELOCIDAD = "VELOCIDAD";
		public static final String  ID_SESION = "IDSESION";
		public static final String  ID_SEG = "SEG";
		public static final String ID_MINUTOS = "MINUTOS";
		public static final String ID_HORAS = "HORAS";
		public static final String ID_COM= "IDCOM";
	
	private SQLiteDatabase nBD;
	
	/**
	 * Este metodo abre la base de datos.
	 * @author daamca
	 */
	public void abrirBd(){
		//Abre la base de datos para escribir.
		//Log.i("SQLite", "Se abre conexion a la base de datos " + db1.getDatabaseName() );
		
		Log.d("BBDD", "llega al metodo de abrirBBDD");
		
		nBD= db1.getWritableDatabase();
		
		

		/*//Comprueba si la base de datos es nula o no.
		 if (nBD!=null){
			 return true;
		 }else {
			 return false;
		 		}*/
	}
	
	//Metodo que cierra la base de datos al completo
		public void cerrar() {
			//Log.i("SQLite", "Se cierra conexion a la base de datos " + db1.getDatabaseName() );
			nBD.close();

		}
		
		/**
		 * El siguiente metodo inserta  un usuario en la base de datos Tiempos.
		 * @author daamca
		 * @param USUARIO
		 * @param MODO
		 * @param PRUEBA
		 * @param DISREC
		 * @param VELOCIDAD
		 * @param IDSESION
		 * @param SEG
		 * @param MINUTOS
		 * @param HORAS
		 * @param IDCOM
		 */
		public void crearTiempos(String USUARIO, String MODO,String PRUEBA,String DISREC ,int VELOCIDAD,int IDSESION,int SEG,int MINUTOS,int HORAS,String IDCOM) {
			//Metodo para insertar en la base de datos .Debo realizar un switch con 0 insertado,1 usuario repetido,2 otros fallos.Que devuelva 
			//Meterlo dentro de un try catch.
			//El siguiente metodo devuelve un int en función de si se ha insertado o no. Este metodo inserta en la base de datos los datos.
			
			
			
			try {
				//nBD=db1.getWritableDatabase();
				ContentValues cv = new ContentValues();
				//Aqui mediante el metodo put del ContentValues insertamos los campos(ID,Valor)
				cv.put(ID_USER,USUARIO);
				cv.put(ID_MODO,MODO);
				cv.put(ID_PRUEBA,PRUEBA);
				cv.put(ID_DISREC, DISREC);
				cv.put(ID_VELOCIDAD, VELOCIDAD);
				cv.put(ID_SESION, IDSESION);
				cv.put(ID_SEG, SEG);
				cv.put(ID_MINUTOS,MINUTOS);
				cv.put(ID_HORAS,HORAS);
				cv.put(ID_COM,IDCOM);


				nBD.insert( N_TABLA, null, cv);
				nBD.close();

					

			}catch(SQLiteException e){
				/*
				if(userBis(USUARIO)==true){
					return estado=1;
				}else {
					return estado=2;
				}*/
			}

		}
	
		
		
	
	
}
