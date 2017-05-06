package org.comunidadIT.proyecto.deshuso;

import java.security.Key;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;


public class Validar_Token {		

	//Método de pruebas del token jjwt con header, payload y signature, por acá funciona en forma excelente.
	public static void main(String args[]){
	
		String usuario="Pepapi";
		
		System.out.println(Validar_Token.crearToken(usuario));
	}

	//Método estático encargado de enviar el token(String) al header, el mismo no funciona por incompatibilidad con jersey 1.19
	public static String crearToken(String usuario){

			Key key = MacProvider.generateKey();
			String token = Jwts.builder().setSubject(usuario).signWith(SignatureAlgorithm.HS256, key).compact();
			
		return token;
	}
	
	//Método estático encargado de crear y validar el token jjwt, sólo me funciona por consola
	public static boolean validarToken(String usuario){
			
		boolean validado= false;
		String compactJws= null;
		Key key= null;
			
			try{
					key = MacProvider.generateKey();
					compactJws = Jwts.builder().setSubject(usuario).signWith(SignatureAlgorithm.HS256, key).compact();
				}
				catch(SignatureException e)
					{
						System.out.println("No es de confianza.");
					}
		
					try
						{
							Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);
							System.out.println("Es de confianza.");
							validado= true;	
						}
							catch(SignatureException e1)
								{
									System.out.println("No es de confianza.");
									validado= false;
								}
					
			return validado;
	}

}

