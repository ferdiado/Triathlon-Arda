package com.arda.BBD;

import java.sql.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class crearBD extends SQLiteOpenHelper{

		public static final String N_BD = "BD_arda";
	
	// Parametros tabla Users
		
		public static final String ID_USER = "IDUSER";
		public static final String ID_CONTRA = "CONTRA";
		public static final String ID_NOMBRE = "NOMBRE";
		public static final String ID_FECHA = "FECHA";
		public static final String ID_ENTRENADOR = "ENTRENADOR";
		public static final String  ID_DEPORTISTA = "DEPORTISTA";
		public static final String  ID_SEXO = "SEXO";
		public static final String ID_FOTO = "FOTO";
		
		
	//Parametros tabla tiempos
		public static final String MODO="MODO";
		public static final String TPOFOR="TPOFORMAT";
		public static final String PRUEBA="PRUEBA";
		public static final String DISREC="DISREC";
		public static final String VELOCIDAD="VELOCIDAD";
		
		
		private static final String N_TABLA1 = "Users";
		private static final String N_TABLA2 = "Tiempos";
		private static final String N_TABLA3 = "Im_Se";
		private static final String N_TABLA4 = "TIPOSCOMP";
		
		
		
	//Parametros de tabla Im_se
		public static final String IDSESION="IDSESION";
		public static final String IDUSER="IDUSER";
		public static final String IDFOTO="IDFOTO";
	
	//Parametros de tabla tiposcomp
		
		public static final String IDCOM="IDCOM";
		public static final String DISNAT="DISNAT";
		public static final String DISCAR="DISCAR";
		public static final String DISCI="DISCAR";
		
	public crearBD(Context contexto, String nombre,
            CursorFactory factory, int version) {
		super(contexto,nombre,factory,version);
		// TODO Auto-generated constructor stub
	}
	
	@Override // Solo se va a llamar la primera vez que se crea la base de datos . Si esta ya creada, lo salta.
	public void onCreate(SQLiteDatabase db) {
		
		
		// Creamos tabla  
		
		
		db.execSQL("CREATE TABLE"+N_TABLA1+"(" + 
			    ID_USER+ "VARCHAR PRIMARY KEY, "+
			    ID_CONTRA+"    INTEGER,"+
			    ID_NOMBRE+" VARCHAR,"+
			    ID_NOMBRE+"    VARCHAR,"+
			    ID_FECHA+"     DATE," +
			    ID_ENTRENADOR+" BOOLEAN," +
			    ID_DEPORTISTA+" BOOLEAN,"+
			    ID_SEXO+" BOOLEAN,"+
			   ID_FOTO+"  VARCHAR );");
		
		db.execSQL("CREATE TABLE"+N_TABLA2+"("+ 
			    ID_USER+  "  VARCHAR  PRIMARY KEY, "+
				
                "REFERENCES Users ( IDUSER ) ON DELETE CASCADE"+
                                            "ON UPDATE CASCADE,"+
                MODO+"      VARCHAR, "+
                TPOFOR+" DATETIME,"+
                PRUEBA+"    VARCHAR,"+
                DISREC+"    VARCHAR,"+
                VELOCIDAD+" INTEGER );");
		
		db.execSQL("CREATE TABLE"+N_TABLA3+"("+ 
				IDSESION + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
				IDUSER+"   VARCHAR REFERENCES Users ( IDUSER ),"+
				IDFOTO+"   VARCHAR );");
		db.execSQL("CREATE TABLE"+N_TABLA4+"("+ 
				IDCOM + "VARCHAR PRIMARY KEY,"+
				DISNAT+"   VARCHAR,"+
				DISCAR+"   VARCHAR,"+
				DISCI+"   VARCHAR );");
		
	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ N_TABLA1);
		db.execSQL("DROP TABLE IF EXISTS "+ N_TABLA2);
		onCreate(db);
		
	}

	

	
	
	
}
