package com.arda.BBD;

import java.sql.Blob;

import org.apache.http.util.ByteArrayBuffer;




import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
/**
 * 
 * @author daamca	
 *
 */
public class Users{
	

	//Aqui tenemos todos los campos de la tabla Users
	public static final String ID_FILA = "_id";
	public static final String ID_USER = "IDUSER";
	public static final String ID_CONTRA = "CONTRA";
	public static final String ID_NOMBRE = "NOMBRE";
	public static final String ID_FECHA = "FECHA";
	public static final String ID_ENTRENADOR = "ENTRENADOR";
	public static final String  ID_DEPORTISTA = "DEPORTISTA";
	public static final String  ID_SEXO = "SEXO";
	public static final String ID_FOTO = "FOTO";
	
	//nombre de la base de datos
	// final para que no cambie la base de datos
	private static final String N_BD = "BD_arda"; 
	
	//nombre de la tabla a seleccionar
	private static final String N_TABLA = "Users";
	
	private crearBD db1;
	
	private SQLiteDatabase nBD;
	private Context nContexto;
	public String  user;
	
	//nombre de la base de datos sqlit
	
	
	public Users(Context context){
		
		db1=new crearBD(context);
		
	}
	
	/**
	 * Este metodo abre la base de datos.
	 * @author daamca
	 */
	public void abrirBd(){
		//Abre la base de datos para escribir.
		//Log.i("SQLite", "Se abre conexion a la base de datos " + db1.getDatabaseName() );
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
	 El siguiente metodo devuelve true o false si el usuario esta en la base de datos y se logea correctamente.
	 *@author daamca
	 * @param usuario
	 * @param contraseña
	 * @return estadoLogeo
	 */
	
	
	
	public boolean logeo(String usuario,String contraseña){
		
		String[] args;
		String[] args1;
		  String user="";
		  String contra="";
		try{
			
			 args = new String[] {usuario};
			 args1=new String[]{contraseña};
			
				Cursor c=nBD.rawQuery("SELECT IDUSER from Users where IDUSER=? LIMIT 1;",args);
				Cursor c2=nBD.rawQuery("SELECT CONTRA from Users where CONTRA=? LIMIT 1;",args1);
		
				
				//Nos aseguramos de que existe al menos un registro
				if (c.moveToFirst()) {
				     //Recorremos el cursor hasta que no haya más registros
				     do {
				    	  user= c.getString(0);
				          
				     } while(c.moveToNext());
				}
				
				//Nos aseguramos de que existe al menos un registro
				if (c2.moveToFirst()) {
				     //Recorremos el cursor hasta que no haya más registros
				     do {
				           contra= c2.getString(0);
				          
				     } while(c2.moveToNext());
				}
		}catch(SQLiteException e){
			
		}
		
		
		
		
		
		
		
		if(user.equalsIgnoreCase(usuario) && contra.equalsIgnoreCase(contraseña)){
				return true;
			}else {
				return false;
			}
		
		
	} 
	
	/**
	 * El siguiente metodo inserta  un usuario en la base de datos Users.
	 * @author daamca
	 * @param USUARIO
	 * @param CONTRASEÑA
	 * @param NOMBRE
	 * @param FECHA
	 * @param ENTRENADOR
	 * @param DEPORTISTA
	 * @param SEXO
	 * @param FOTO
	 */
 public int crearEntrada(String USUARIO, String CONTRASEÑA,String NOMBRE,String FECHA ,boolean ENTRENADOR,boolean DEPORTISTA,boolean SEXO,String FOTO) {
		//Metodo para insertar en la base de datos .Debo realizar un switch con 0 insertado,1 usuario repetido,2 otros fallos.Que devuelva 
		//Meterlo dentro de un try catch.
		//El siguiente metodo devuelve un int en función de si se ha insertado o no. Este metodo inserta en la base de datos los datos.
		int estado =0;
		try {
		//nBD=db1.getWritableDatabase();
		ContentValues cv = new ContentValues();
		//Aqui mediante el metodo put del ContentValues insertamos los campos(ID,Valor)
		cv.put(ID_USER,USUARIO);
		cv.put(ID_CONTRA,CONTRASEÑA);
		cv.put(ID_NOMBRE,NOMBRE);
		cv.put(ID_FECHA, FECHA);
		cv.put(ID_ENTRENADOR, ENTRENADOR);
		cv.put(ID_DEPORTISTA, DEPORTISTA);
		cv.put(ID_SEXO, SEXO);
		cv.put(ID_FOTO,FOTO);
		
		nBD.insert( N_TABLA, null, cv);
		nBD.close();
		
		return estado=0;	
		
		}catch(SQLiteException e){
			if(userBis(USUARIO)==true){
				return estado=1;
			}else {
				return estado=2;
			}
		}
		
	}
 
 /**
  * Este metodo sirve para modificar los datos de un usuario de la tabla Users.
  * @author daamca
  * @param USUARIO
  * @param CONTRASEÑA
  * @param NOMBRE
  * @param FECHA
  * @param ENTRENADOR
  * @param DEPORTISTA
  * @param SEXO
  * @param FOTO
 *  
  *
  */
 public  void modificarEntrada(String USUARIO, String CONTRASEÑA,String NOMBRE,String FECHA, boolean ENTRENADOR,boolean DEPORTISTA,boolean SEXO,String FOTO) {
		
		
		try {
		//nBD=db1.getWritableDatabase();
		ContentValues cv = new ContentValues();
		//Aqui mediante el metodo put del ContentValues insertamos los campos(ID,Valor)
		//cv.put(ID_USER,USUARIO);
		cv.put(ID_CONTRA,CONTRASEÑA);
		cv.put(ID_NOMBRE,NOMBRE);
		cv.put(ID_FECHA,FECHA);
		cv.put(ID_ENTRENADOR,ENTRENADOR);
		cv.put(ID_DEPORTISTA,DEPORTISTA);
		cv.put(ID_SEXO,SEXO);
		cv.put(ID_FOTO,FOTO);
		nBD.update(N_TABLA, cv, ID_USER+"=?", new String []{String.valueOf(ID_USER)});
		nBD.close();
		
		}catch(SQLiteException e){
			Toast adver3 = Toast.makeText(null,"El usuario no ha podido moficarse.Intentelo de nuevo.", Toast.LENGTH_LONG);
			 
	        adver3.show();
		}
		
	}
 
 
 
 
 
 /**
  * Este metodo devuelve el id de las fotografías del perfil del usuario. 
  * @author daamca
  * @param usuario
  * @return idFoto
  */
 
 public String idFoto(String usuario){
	//nBD=db1.getReadableDatabase();
	
	Cursor c= nBD.rawQuery("SELECT IDFOTO  from Users where IDUSER='"+usuario+"' LIMIT 1;",new String [] {});
	String idFoto=c.getString(0);
	nBD.close();
	
	if(idFoto.isEmpty()){
		Toast adver1 = Toast.makeText(null,"El usuario no dispone de fotografía de perfil.Introduzca una foto.", Toast.LENGTH_LONG);
	 
	        adver1.show();
	}else {
		Toast adver2 = Toast.makeText(null,"El usuario ya dispone de fotografia de perfil.", Toast.LENGTH_LONG);
		 
        adver2.show();
	}
	 
	 return idFoto;
	 
 }
	/**
	 * Este metodo esta comprobando si el usuario está repetido. 
	 * @author daamca
	 * @param USUARIO
	 * @return estado
	 */
	 public boolean userBis(String USUARIO) {
		 //Aqui instanciamos al metodo getReadableDatabase,este metodo abre la base de datos para lectura.
		// nBD=db1.getReadableDatabase();
		
			Cursor c= nBD.rawQuery("SELECT IDUSER  from Users where IDUSER='"+USUARIO+"' LIMIT 1;", new String [] {});
			String iduser =c.getString(0);
			nBD.close();	
			if(iduser.equals(USUARIO)){
				
				return true;
			}else{
				return false;
			}
		
	    }
	


}
