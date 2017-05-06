package org.comunidadIT.proyecto.deshuso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnection_Leer_Token {

	//Sólo para prueba por consola.
	public static void main(String[] args) {
		// Funciona muy bien llama a un endpoint a modo inverso, sin embargo está en deshuso
		new HttpUrlConnection_Leer_Token();
	}
	
	public HttpUrlConnection_Leer_Token(){
		
	    try
	    {
	      String myUrl = "http://localhost:8079/Proyecto_Final_AAB/rest/token/crearToken";
	      // if your url can contain weird characters you will want to 
	      // encode it here, something like this:
	      // myUrl = URLEncoder.encode(myUrl, "UTF-8");

	      String results = doHttpUrlConnectionAction(myUrl);
	      System.out.println(results);
	    }
	    catch (Exception e)
	    {
	      // deal with the exception in your "controller"
	    }
		
	}
	
	
	private String doHttpUrlConnectionAction(String desiredUrl)
			  throws Exception
			  {
			    URL url = null;
			    BufferedReader reader = null;
			    StringBuilder stringBuilder;

			    try
			    {
			      // create the HttpURLConnection
			      url = new URL(desiredUrl);
			      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			      
			      // just want to do an HTTP POST here
			      connection.setRequestMethod("POST");
			      
			      //borrar estas lineas si hay error
			     connection.setRequestProperty("Authorization", "Bearer");
			      
			      // uncomment this if you want to write output to this url
			      //connection.setDoOutput(true);
			      
			      // give it 15 seconds to respond
			      connection.setReadTimeout(15*1000);
			      connection.connect();

			      // read the output from the server
			      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			      stringBuilder = new StringBuilder();

			      String line = null;
			      while ((line = reader.readLine()) != null)
			      {
			        stringBuilder.append(line + "\n");
			      }
			      return stringBuilder.toString();
			    }
			    catch (Exception e)
			    {
			      e.printStackTrace();
			      throw e;
			    }
			    finally
			    {
			      // close the reader; this can throw an exception too, so
			      // wrap it in another try/catch block.
			      if (reader != null)
			      {
			        try
			        {
			          reader.close();
			        }
			        catch (IOException ioe)
			        {
			          ioe.printStackTrace();
			        }
			      }
			    }
			  }

}
