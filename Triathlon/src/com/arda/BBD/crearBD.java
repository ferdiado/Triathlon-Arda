package com.arda.BBD;

import java.sql.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class crearBD extends SQLiteOpenHelper{

		public static final String N_BD = "BD_arda";
		private static final int VERSION = 3;
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
		
		

		
		public String sql1="CREATE TABLE Users (IDUSER     VARCHAR PRIMARY KEY NOT NULL,CONTRA     VARCHAR NOT NULL,NOMBRE     VARCHAR NOT NULL,FECHA      DATE NOT NULL,ENTRENADOR VARCHAR,DEPORTISTA BOOLEAN NOT NULL,SEXO       BOOLEAN NOT NULL,FOTO       VARCHAR,FECHABAJA  DATETIME );";
	    public String sql2="CREATE TABLE Tiempos ( IDUSER    VARCHAR  NOT NULL REFERENCES Users ( IDUSER ) ON DELETE CASCADE ON UPDATE CASCADE,MODO      VARCHAR NOT NULL,TPOFORMAT DATETIME,PRUEBA    VARCHAR,DISREC    VARCHAR NOT NULL,VELOCIDAD INTEGER NOT NULL,IDSESION  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,SEG       INTEGER,MINUTOS   INTEGER,HORAS     INTEGER, IDCOM     VARCHAR  REFERENCES TIPOSCOMP ( IDCOM ) ON UPDATE CASCADE );";
		public String sql3="CREATE TABLE TIPOSCOMP ( IDCOM  VARCHAR PRIMARY KEY NOT NULL,DISNAT VARCHAR,DISCAR VARCHAR,DISCI  VARCHAR );";

		
		public String sql5="INSERT INTO Users (IDUSER,CONTRA,NOMBRE,FECHA,ENTRENADOR,DEPORTISTA,SEXO,FOTO,FECHABAJA)VALUES('ENTRENADOR','1234','entrene','2000-10-20',NULL,'false','true','entrenador.png',null);";
		public String sql6="INSERT INTO Users (IDUSER,CONTRA,NOMBRE,FECHA,ENTRENADOR,DEPORTISTA,SEXO,FOTO,FECHABAJA)VALUES('DEPOR1','1234','DEPOR','2000-10-20','ENTRENADOR','false','true','depor.png',null);');";
		public String sql13="INSERT INTO Users (IDUSER,CONTRA,NOMBRE,FECHA,ENTRENADOR,DEPORTISTA,SEXO,FOTO,FECHABAJA)VALUES('DEPOR2','1234','DEPOR','2000-10-20','ENTRENADOR','false','true','depor.png','2014-02-20');');";
		
		public String sql7="INSERT INTO TIPOSCOMP (IDCOM,DISNAT,DISCAR,DISCI)VALUES('IRON','3800','180000','42195');";
		public String sql10="INSERT INTO TIPOSCOMP (IDCOM,DISNAT,DISCAR,DISCI)VALUES('OLIM','1500','40000','10000');";
		public String sql14="INSERT INTO TIPOSCOMP (IDCOM, DISNAT, DISCAR, DISCI) VALUES (null, null, null, null);";
		public String sql11="INSERT INTO Tiempos (IDUSER,MODO,PRUEBA,DISREC,VELOCIDAD,IDSESION,SEG,MINUTOS,HORAS,IDCOM)VALUES('DEPOR1','ENTRENAMIENTO','NATACION','1000','28','1','45','45','45',null);";
		public String sql12="INSERT INTO Tiempos (IDUSER,MODO,PRUEBA,DISREC,VELOCIDAD,IDSESION,SEG,MINUTOS,HORAS,IDCOM)VALUES('DEPOR1','COMPETICION','NATACION','10000','28',null,'25','25','25','OLIM');";
		
		
		
		public crearBD(Context contexto) {
		super(contexto,N_BD,null,VERSION);
		// TODO Auto-generated constructor stub
	}
	
	@Override // Solo se va a llamar la  vez que se crea la base de datos . Si esta ya creada, lo salta.
	public void onCreate(SQLiteDatabase db) {
		
		
		// Creamos tabla  
		
		
		db.execSQL(sql1);
		db.execSQL(sql5);
		db.execSQL(sql6);
		db.execSQL(sql13);
		db.execSQL(sql2);
		db.execSQL(sql3);
		db.execSQL(sql7);
		db.execSQL(sql11);
		db.execSQL(sql12);
		
		
		db.execSQL(sql10); 
	
		
		
		
	}
	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+ N_TABLA1);
		//db.execSQL("DROP TABLE IF EXISTS "+ N_TABLA2);
		onCreate(db);
		
	}

	

	
	
	
}
