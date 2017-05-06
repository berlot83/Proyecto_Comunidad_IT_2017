package org.comunidadIT.proyecto.deshuso;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.comunidadIT.proyecto.validaciones.ValidarToken;


@Path("/token")
public class Autenticacion_EndPoint{
	
	@POST
	@Path("/autorizadoCrearToken")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String autorizadoCrearToken(){
	
		String autorizado= "Pepapi";
		
		return autorizado;
	}
	
	
	@POST
	@Path("/crearToken")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String crearToken(String usuario){

		String crearToken= null;

			try
				{
					crearToken= ValidarToken.crearToken(usuario);
				}
				catch(Exception e)
					{
						System.out.println("No funciona el token");
						e.printStackTrace();
					}
		
		return crearToken;
	}
}
