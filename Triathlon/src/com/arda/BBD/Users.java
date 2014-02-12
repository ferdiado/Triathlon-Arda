package com.arda.BBD;

import java.sql.Blob;

import org.apache.http.util.ByteArrayBuffer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * 
 * @author Daniel 
 *
 */
public class Users {
	
	// Ponemos el final para no cambiar los parametros
	public static final String ID_FILA = "_id";
	public static final String ID_USER = "IDUSER";
	public static final String ID_CONTRA = "CONTRA";
	public static final String ID_NOMBRE = "NOMBRE";
	public static final String ID_FECHA = "FECHA";
	public static final String ID_ENTRENADOR = "ENTRENADOR";
	public static final String  ID_DEPORTISTA = "DEPORTISTA";
	public static final String  ID_SEXO = "SEXO";
	public static final String ID_FOTO = "FOTO";
	
	private static final String N_BD = "BD_arda"; //nombre de la base de datos
	// final para que no cambie la base de datos
	
	private static final String N_TABLA = "Users";//nombre de la tabla a seleccionar
	
	private static final int  VERSION_BD = 1; // Versión de base de datos 
	
	
	private BDHelper nHelper ; //instancia de la clase BDHelper
	private final  Context nContexto; // instancia para nuestro contexto
	private SQLiteDatabase nBD;//nombre de la base de datos sqlite
	
	

	private static class BDHelper extends SQLiteOpenHelper {

		public BDHelper(Context context) {
			super(context, N_BD, null, VERSION_BD);
			
		}

		@Override // Solo se va a llamar la primera vez que se crea la base de datos . Si esta ya creada, lo salta.
		public void onCreate(SQLiteDatabase db) {
			
			
			// Creamos la base de datos 
			
			
			db.execSQL("CREATE TABLE"+N_TABLA+"(" + 
				    ID_USER+ "VARCHAR PRIMARY KEY, "+
				    ID_CONTRA+"    INTEGER,"+
				    ID_NOMBRE+" VARCHAR,"+
				    ID_NOMBRE+"    VARCHAR,"+
				    ID_FECHA+"     DATE," +
				    ID_ENTRENADOR+" BOOLEAN," +
				    ID_DEPORTISTA+" BOOLEAN,"+
				    ID_SEXO+" BOOLEAN,"+
				    ID_FOTO+"   B);");
			
			
		}

		@Override //COMPROBAR SI LA TABLA EXISTE, se la carga. Y llama al metodo onCreate
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
			db.execSQL("DROP TABLE IF EXISTS "+ N_TABLA);
			onCreate(db);
			
			
		}
		
		
	}
	// constructor de Users.class
	public Users (Context c){
		nContexto = c;
	} 
	
	//Metodo para crear un helper
	public Users abrir(){
		nHelper = new BDHelper(nContexto);
		nBD= nHelper.getWritableDatabase(); // esto lo hace para poder escribir en la base de datos y devuelve this.
		return this;
	}
	//Metodo que cierra la base de datos
	public void cerrar() {
		
		nHelper.close();
	}
	
	/**
	 El siguiente metodo devuelve true o false si el usuario esta en la base de datos y se logea correctamente.
	 * @param usuario
	 * @param contraseña
	 * @return
	 */
	
	public boolean logeo(String usuario,String contraseña){
		boolean estado;
	
		try{
			SQLiteDatabase bd=nHelper.getReadableDatabase();
		bd.rawQuery("SELECT '"+usuario+"' , '"+contraseña+"' from Users;", new String [] {});
		
		}catch(SQLiteException e){
			
		}
		if(comprobarUserRepe(usuario,contraseña)==true){
				return estado=false;
			}else {
				return estado=true;
			}
		
		
	}
	
	/**
	 * El siguiente metodo inserta en la base de datos los datos.
	 * @param USUARIO
	 * @param CONTRASEÑA
	 * @param NOMBRE
	 * @param FECHA
	 * @param ENTRENADOR
	 * @param DEPORTISTA
	 * @param SEXO
	 * @param FOTO
	 */
 public int crearEntrada(String USUARIO, String CONTRASEÑA,String NOMBRE,String FECHA, boolean ENTRENADOR,boolean DEPORTISTA,boolean SEXO,byte[] FOTO) {
		//Metodo para insertar en la base de datos .Debo realizar un switch con 0 insertado,1 usuario repetido,2 otros fallos.Que devuelva 
		//Meterlo dentro de un try catch.
		//El siguiente metodo devuelve un int en función de si se ha insertado o no. Este metodo inserta en la base de datos los datos.
		int estado=0;
		try {
		ContentValues cv = new ContentValues();
		cv.put(ID_USER,USUARIO);//El primer parametro es donde lo va a guardar.Un put para cada valor.
		cv.put(ID_CONTRA,CONTRASEÑA);
		cv.put(ID_NOMBRE,NOMBRE);
		cv.put(ID_FECHA,FECHA);
		cv.put(ID_ENTRENADOR,ENTRENADOR);
		cv.put(ID_DEPORTISTA,DEPORTISTA);
		cv.put(ID_SEXO,SEXO);
		cv.put(ID_FOTO,FOTO);
		nBD.insert(N_TABLA, null, cv);
		return estado;
		}catch(SQLiteException e){
			if(comprobarUserRepe(USUARIO,CONTRASEÑA)==true){
				return estado=1;
			}else {
				return estado=2;
			}
		}
		
	}
	
	 public boolean comprobarUserRepe(String USUARIO, String CONTRASEÑA) {
		 SQLiteDatabase bd=nHelper.getReadableDatabase();
		
			Cursor c= bd.rawQuery("SELECT '"+USUARIO+"' , '"+CONTRASEÑA+"' from Users;", new String [] {});
			if(c.getString(1).equals(USUARIO)){
				
				return true;
			}else{
				return false;
			}
			
	    }


}
