package org.comunidadIT.proyecto.accesoDatos;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class ValidarToken {		
	
	public static void main(String args[]){
	
	String usuario="Gisell";
	
	System.out.println(ValidarToken.validarToken(usuario));
}
	/*
		public static String token(String usuario)
		{
			// We need a signing key, so we'll create one just for this example. Usually
			// the key would be read from your application configuration instead.
			Key key = MacProvider.generateKey();

			String compactJws = Jwts.builder().setSubject(usuario).signWith(SignatureAlgorithm.HS512, key).compact();
			
			return compactJws;
		}
	 */
		
		public static boolean validarToken(String usuario){
			
			boolean validado= false;
			String compactJws= null;
			Key key= null;
			
			
			try{
				key = MacProvider.generateKey();
				compactJws = Jwts.builder().setSubject(usuario).signWith(SignatureAlgorithm.HS512, key).compact();
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

