package com.arda.imagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;


/**
 * Clase que gestiona la toma de imagenes, realizandolas en data/data/app_Img_Arda.
 * Carpeta que se borrará cuando desinstalemos la aplicación.
 * @author FADAD
 *
 */
public class GestorImagen extends Activity {
	
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	public static final int MEDIA_TYPE_IMAGE = 1;
	static File rutaFoto;
	Uri fileUri;
	static File mediaFile;
	FileOutputStream  archivo;

	public void onCreate(Bundle savedInstance ){
        super.onCreate(savedInstance);
	}
	
	/**
	 * Metodo por el cual realizamos una foto mediante un intent guardando en el directorío raiz de la aplicación la foto y 
	 * como nombre con la fecha y hora de cuando se ha tomado con formato: ddMMyyyyHHmmss
	 */
	public String hacerFoto(){
		
		//Vamos a crear la carpeta donde vamos a guardar la imagen dentro de data/data/
		rutaFoto = getDir("_Img_Arda", Context.MODE_PRIVATE);
		
		//Generamos el intent de hacer la foto.
		Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		
		//Creamos una Uri donde vamos a crear el archivo de la foto que va a ser tomada.
		fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

		// Mandamos a la aplicación el intent de la cámara.
		startActivityForResult(i, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
		
		/*
		//Devolvemos el nombre del archivo y su ruta de acceso.
		return mediaFile.getPath();*/
		//Devolvemos el nombre del archivo.
		return mediaFile.getName();
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	
		//Recogemos la imagen
		Bundle extras = data.getExtras();
		Bitmap mImage = (Bitmap) extras.get("data");
		//La guardamos
		try {
			archivo = new FileOutputStream(mediaFile);
			mImage.compress(CompressFormat.JPEG, 100, archivo);
			archivo.close();
			Log.d("RUTA", archivo.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}
	
	
	/**
	 *  Create a file Uri for saving an image or video
	 *  
	 * @param type
	 * @return
	 */
	private static Uri getOutputMediaFileUri(int type){
	      return Uri.fromFile(getOutputMediaFile(type));
	}
	
	
	/**
	 * Create a File for saving an image or video
	 * 
	 * @param type
	 * @return
	 */
	private static File getOutputMediaFile(int type){
	    /* To be safe, you should check that the SDCard is mounted
	     using Environment.getExternalStorageState() before doing this.
		 Si quisieramos instalarla en la SD para que se estubieran después de una desinstalación
		 //File mediaStorageDir = new File(Environment.getExternalStorageDirectory(),"Img_Arda");
		 Y si quisieramos que aparecieran en la Galeria
		 //File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Img_Arda");
	     This location works best if you want the created images to be shared
	     between applications and persist after your app has been uninstalled.

	    // Create the storage directory if it does not exist
	    /*if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            Log.d("Arda", "failed to create directory");
	            return null;
	        }
	    }*/

	    // Create a media file name
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    
	    mediaFile = new File(rutaFoto.getPath() + File.separator +"IMG_"+ timeStamp + ".jpg");
	    return mediaFile;
	    
	}


}
