package com.arda.BBD;

import java.sql.Blob;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
	
	public static final String ID_USER = "IDUSER";
	public static final String ID_CONTRA = "CONTRA";
	public static final String ID_NOMBRE = "NOMBRE";
	public static final String ID_FECHA = "FECHA";
	public static final String ID_ENTRENADOR = "ENTRENADOR";
	public static final String  ID_DEPORTISTA = "DEPORTISTA";
	public static final String  ID_SEXO = "SEXO";
	public static final String ID_FOTO = "FOTO";
	public static final String FECHABAJA= "FECHABAJA";

	//nombre de la base de datos
	// final para que no cambie la base de datos
	private static final String N_BD = "BD_arda"; 

	//nombre de la tabla a seleccionar
	private static final String N_TABLA = "Users";

	private crearBD db1;

	//private  SQLiteDatabase nBD;
	private Context nContexto;
	public String  user;
	public String idFoto;
	public String userBis;

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
		
		Log.d("BBDD", "llega al metodo de abrirBBDD");
		
		SQLiteDatabase nBD= db1.getWritableDatabase();
		
	}

	//Metodo que cierra la base de datos al completo
	public void cerrar() {
		//Log.i("SQLite", "Se cierra conexion a la base de datos " + db1.getDatabaseName() );
		//SQLiteDatabase nBD= db1.close();

	}

	/**
	 El siguiente metodo devuelve true o false si el usuario esta en la base de datos y se logea correctamente.
	 *@author daamca
	 * @param usuario
	 * @param contrase�a
	 * @return estadoLogeo
	 */
	public boolean logeo(String usuario,String contrase�a){

		String[] args;
		String[] args1;
		String user="";
		String contra="";
		SQLiteDatabase nBD= db1.getReadableDatabase();
		try{
			
			args = new String[] {usuario};
			args1=new String[]{contrase�a};

			Cursor c=nBD.rawQuery("SELECT IDUSER from Users where IDUSER=? AND FECHABAJA IS NULL LIMIT 1;",args);
			Cursor c2=nBD.rawQuery("SELECT CONTRA from Users where CONTRA=? AND FECHABAJA IS NULL LIMIT 1;",args1);


			//Nos aseguramos de que existe al menos un registro
			if (c.moveToFirst()) {
				//Recorremos el cursor hasta que no haya m�s registros
				do {
					user= c.getString(0);

				} while(c.moveToNext());
			}

			//Nos aseguramos de que existe al menos un registro
			if (c2.moveToFirst()) {
				//Recorremos el cursor hasta que no haya m�s registros
				do {
					contra= c2.getString(0);

				} while(c2.moveToNext());
			}
		}catch(SQLiteException e){

		}

		nBD.close();





		if(user.equalsIgnoreCase(usuario) && contra.equalsIgnoreCase(contrase�a)){
			return true;
		}else {
			return false;
		}


	} 

	/**
	 * El siguiente metodo inserta  un usuario en la base de datos Users.
	 * @author daamca
	 * @param USUARIO
	 * @param CONTRASE�A
	 * @param NOMBRE
	 * @param FECHA
	 * @param ENTRENADOR
	 * @param DEPORTISTA
	 * @param SEXO
	 * @param FOTO
	 */
	public int crearEntrada(String USUARIO, String CONTRASE�A,String NOMBRE,String FECHA ,String ENTRENADOR,boolean DEPORTISTA,boolean SEXO,String FOTO) {
		//Metodo para insertar en la base de datos .Debo realizar un switch con 0 insertado,1 usuario repetido,2 otros fallos.Que devuelva 
		//Meterlo dentro de un try catch.
		//El siguiente metodo devuelve un int en funci�n de si se ha insertado o no. Este metodo inserta en la base de datos los datos.
		SQLiteDatabase nBD= db1.getWritableDatabase();
		int estado =0;
		try {
			//nBD=db1.getWritableDatabase();
			ContentValues cv = new ContentValues();
			//Aqui mediante el metodo put del ContentValues insertamos los campos(ID,Valor)
			cv.put(ID_USER,USUARIO);
			cv.put(ID_CONTRA,CONTRASE�A);
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
	 * @param CONTRASE�A
	 * @param NOMBRE
	 * @param FECHA
	 * @param ENTRENADOR
	 * @param DEPORTISTA
	 * @param SEXO
	 * @param FOTO
	 *  
	 *
	 */
	public  void modificarEntrada(String USUARIO, String CONTRASE�A,String NOMBRE,String FECHA,String ENTRENADOR,boolean DEPORTISTA,boolean SEXO,String FOTO) {
		
		SQLiteDatabase nBD= db1.getWritableDatabase();
		
		try {
			//nBD=db1.getWritableDatabase();
			ContentValues cv = new ContentValues();
			//Aqui mediante el metodo put del ContentValues insertamos los campos(ID,Valor)
			cv.put(ID_USER,USUARIO);
			cv.put(ID_CONTRA,CONTRASE�A);
			cv.put(ID_NOMBRE,NOMBRE);
			cv.put(ID_FECHA,FECHA);
			cv.put(ID_ENTRENADOR, ENTRENADOR);
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
	 * Este metodo devuelve el id de las fotograf�as del perfil del usuario. 
	 * @author daamca
	 * @param usuario
	 * @return idFoto
	 */

	public String idFoto(String usuario){
		SQLiteDatabase nBD= db1.getReadableDatabase();
		String[] args = new String[] {usuario};
		Cursor c= nBD.rawQuery("SELECT IDFOTO  from Users where IDUSER=? LIMIT 1;",args);
		if (c.moveToFirst()) {
			//Recorremos el cursor hasta que no haya m�s registros
			do {
				idFoto= c.getString(0);

			} while(c.moveToNext());
		}

		nBD.close();

		if(idFoto.isEmpty()){
			Toast adver1 = Toast.makeText(null,"El usuario no dispone de fotograf�a de perfil.Introduzca una foto.", Toast.LENGTH_LONG);

			adver1.show();
		}else {
			Toast adver2 = Toast.makeText(null,"El usuario ya dispone de fotografia de perfil.", Toast.LENGTH_LONG);

			adver2.show();
		}

		return idFoto;

	}
	/**
	 * Este metodo esta comprobando si el usuario est� repetido. 
	 * @author daamca
	 * @param USUARIO
	 * @return estado
	 */
	public boolean userBis(String USUARIO) {
		//Aqui instanciamos al metodo getReadableDatabase,este metodo abre la base de datos para lectura.
		// nBD=db1.getReadableDatabase();
		SQLiteDatabase nBD= db1.getReadableDatabase();

		String[] args = new String[] {USUARIO};
		Cursor c= nBD.rawQuery("SELECT IDUSER  from Users where IDUSER=? LIMIT 1;", args);

		if (c.moveToFirst()) {
			//Recorremos el cursor hasta que no haya m�s registros
			do {
				userBis= c.getString(0);

			} while(c.moveToNext());
		}

		nBD.close();	
		if(userBis.equals(USUARIO)){

			return true;
		}else{
			return false;
		}

	}

	/**
	 * Este m�todo devuelve un ArrayList con todos los deportistas en base a un entrenador. 
	 * @param entrenador
	 * @return iduser(deportistas)
	 */
	public ArrayList<String> numeroDeportistas(String entrenador){
		Log.d("BBDD", "llega al metodo de numerodeportistas");
		SQLiteDatabase nBD= db1.getReadableDatabase();
		ArrayList<String> resultados= null;
		String[] args = new String[] {entrenador};
		Cursor c= nBD.rawQuery("SELECT IDUSER  from Users where ENTRENADOR=? AND FECHABAJA IS NULL ;", args);

	
			resultados = new ArrayList<String>();

			//Recorremos el cursor hasta que no haya m�s registros
			while(c.moveToNext()){
				Log.d("BBDD", "entra aqui?");
				String resultado= c.getString(0);
				resultados.add(resultado);
			};
			Log.d("BBDD", "longitud:"+resultados.size());
		
		c.close();
		nBD.close();
		return resultados;


	}

	/**
	 * Este m�todo devuelve un ArrayList todos los datos de un deportista en base a un IDUSER
	 * @param iduser(deportista)
	 * @return Todos los parametros de un deportista. 
	 */
	public ArrayList<String> datosDeportistas(String iduser){
		Log.d("BBDD", "llega al metodo de datosDeportistas");
		SQLiteDatabase nBD= db1.getReadableDatabase();
		ArrayList<String> resultados= null;
		String[] args = new String[] {iduser};
		Cursor c= nBD.rawQuery("select * from users where IDUSER=? AND FECHABAJA IS NULL;", args);

	
			resultados = new ArrayList<String>();

			//Recorremos el cursor hasta que no haya m�s registros
			while(c.moveToNext()){
				Log.d("BBDD", "entra aqui?");
				String resultado= c.getString(0);
				resultados.add(resultado);
			};
			Log.d("BBDD", "longitud:"+resultados.size());
		
		c.close();
		nBD.close();
		return resultados;


	}
	
	/**
	 * Este m�todo da de baja a un deportista,pasandole la fecha de baja. Desactivandolo en la base de datos. 
	 * @param deportista
	 */
	 public void darBaja(String deportista){
		 SQLiteDatabase nBD= db1.getWritableDatabase();
		 Calendar c = Calendar.getInstance();
		 SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		 String fechabaja = df1.format(c.getTime());
		 ContentValues cv = new ContentValues();
		 cv.put(FECHABAJA, fechabaja);
		 
		 nBD.update(N_TABLA, cv, ID_USER+"=?", new String []{String.valueOf(ID_USER)});
		 
		 
		 
		 
	 }	

}
