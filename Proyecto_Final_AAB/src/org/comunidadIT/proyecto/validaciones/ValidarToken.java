package org.comunidadIT.proyecto.validaciones;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidarToken {
	
	
	public static void main(String args[]){
		
		String usuario= "UsuarioRegistradoToken";
		
		System.out.println(ValidarToken.crearToken(usuario));
		
	}
	
	
	public static String crearToken(String usuario){
		
		SimpleDateFormat formatoDeseado= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date fechaHoraActual= new Date();
		
		String fechaHoraActualFormato= formatoDeseado.format(fechaHoraActual);
		
		return usuario+fechaHoraActualFormato;
	}
	
	
	public static boolean compararToken(String usuario, String tokenRecibido){
		
		boolean validado= false;
		
				if(ValidarToken.crearToken(usuario).equals(tokenRecibido))
					{
						System.out.println("Se pudo validar el token.");
						validado= true;
					}
				else
					{
						System.out.println("No se pudo validar el token.");
						validado= false;
					}
		return validado;
	}
}
