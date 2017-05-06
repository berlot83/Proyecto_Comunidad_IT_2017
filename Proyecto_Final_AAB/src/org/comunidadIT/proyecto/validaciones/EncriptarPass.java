package org.comunidadIT.proyecto.validaciones;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//Clase de encriptaci�n de datos usando clase est�tica MessageDigest de java, sin librer�as externas.
public class EncriptarPass {
	
	//Para probar por consola las passwords encriptadas.
	public static void main(String args[])
	{
		String pass="1234";
		System.out.println(EncriptarPass.md5(pass));
		
	}
	
	//Encriptado de Passwords, en este proyecto demostrativo us� md5, pero en otro usar�a otra encriptaci�n.
	public static String md5(String pass){
		
		try {
			
			MessageDigest md= MessageDigest.getInstance("MD5");
			
			byte[] b= md.digest(pass.getBytes());
			
			int size = b.length;
			
			StringBuffer h = new StringBuffer(size);
			
				for (int i = 0; i < size; i++)
				{
						int u = b[i] & 255;
						
						if (u < 16)
							{
								h.append("0" + Integer.toHexString(u));
							} 
						else
							{
								h.append(Integer.toHexString(u));
							}
				}
			return h.toString();
		} 
		
		catch (NoSuchAlgorithmException e)
		
		{
			e.printStackTrace();
			return "Hubo un error, no se pudo encriptar la pass.";
		}
	
	}

}
