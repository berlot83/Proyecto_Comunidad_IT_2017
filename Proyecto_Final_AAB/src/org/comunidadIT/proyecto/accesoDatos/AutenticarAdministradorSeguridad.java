package org.comunidadIT.proyecto.accesoDatos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.comunidadIT.proyecto.validaciones.EncriptarPass;

@Path("/validacionAdminSeg")
public class AutenticarAdministradorSeguridad {
	
	//Esta clase deber�a ser est�tica y ser llamada antes del pedido de token.
	//En este caso ser� necesario un .html o .jsp con formulario>, si no se tiene cambiar anotaci�n a @GET
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public static boolean autenticarAdministradorSeguridad(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
    	
    	//Response resp= null;
    	String str_usuario= null;
    	String str_pass= null;
    	boolean autorizado= false;
    	
	    	try{
	    		
	    		ConexionAeropuerto c= new ConexionAeropuerto();
				Connection con= c.connectarAhora();
				
				if(con != null )
				{
					Statement st;
					st=con.createStatement();
					ResultSet rs= st.executeQuery("SELECT usuario, pass FROM administradores WHERE usuario= '" + usuario + "' AND pass= '" + EncriptarPass.md5(pass) + "' AND tipo_admin= 'adminSeg'  ");
					
					while(rs.next())
					{
						str_usuario= rs.getString("usuario"); 
						str_pass= rs.getString("pass");
								
					}
					
							if(usuario.equals(str_usuario) && EncriptarPass.md5(pass).equals(str_pass))
							{
								System.out.println("Usuario: " + usuario + " Correcto.");
								System.out.println("Password: " + pass + " Correcta.");
								autorizado= true;
							}
				 }
	    		
	    
	    		//Falta c�digo de Token
	    		
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("No tiene autorizaci�n para ingresar.");
	    	}
    	
    	return autorizado;
    }
    
}


