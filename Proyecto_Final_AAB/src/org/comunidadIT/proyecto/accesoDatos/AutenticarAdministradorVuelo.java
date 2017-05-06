package org.comunidadIT.proyecto.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.comunidadIT.proyecto.validaciones.EncriptarPass;
import org.comunidadIT.proyecto.validaciones.ValidarToken;


@Path("/validacionAdminVuelos")
public class AutenticarAdministradorVuelo {
	
	//Esta clase debería ser estática y ser llamada antes del pedido de token.
	//En este caso será necesario un .html o .jsp con formulario>, si no se tiene cambiar anotación a @GET
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public static boolean autenticarAdministradorVuelo(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
    	
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
					ResultSet rs= st.executeQuery("select usuario, pass from administradores where usuario= '" + usuario + "' and pass= '" + EncriptarPass.md5(pass) + "' and tipo_admin= 'adminVuelos' ");
					
					while(rs.next())
					{
						str_usuario= rs.getString("usuario"); 
						str_pass= rs.getString("pass");
								
					}
					
							if(usuario.equals(str_usuario) && EncriptarPass.md5(pass).equals(str_pass))
							{
								System.out.println("Usuario: " + usuario + " Correcto.");
								System.out.println("Password: " + pass + " Correcta.");
								//Lo más importante es retornar este true asi libera la entrada.
								autorizado= true;
								
								//Si el usuario y pass son correctos creamos un token copiando el instante exacto en que el usuario ingresó mediante una clase estática.
									PreparedStatement ps;
									String sql="UPDATE administradores SET token=? WHERE usuario=?";
									ps= con.prepareStatement(sql);
									ps.setString(1, ValidarToken.crearToken(usuario));
									ps.setString(2, usuario);
									ps.executeUpdate();
									ps.close();
							
							}	
							
				 }
	    		
	    		//Falta código de Token
	    	
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("No tiene autorización para ingresar.");
	    	}
    	
    	return autorizado;
    }

    //Este método es experimental y aún no resuelve el problema del token.
    public static boolean autenticarTokenVuelo(String usuario){
    	
    	boolean validado= false;
    	String str_token= null;
    	
    		try
    		{
	    		ConexionAeropuerto c= new ConexionAeropuerto();
				Connection con= c.connectarAhora();
				
				if(con!= null)
					{
		    			Statement st;
		    			st= con.createStatement();
		    			String sql="SELECT token FROM administradores WHERE usuario='"+usuario+"' ";
		    			ResultSet rs= st.executeQuery(sql);
	    			
				    			while(rs.next())
				    			{
				    				str_token= rs.getString("token");
				    			}
			    			
			    			if(str_token.equals(str_token))
				    			{
			    				System.out.println("Los token son iguales.");
				    				validado= true;
				    			}
					    			else
					    			{
					    				System.out.println("No son iguales los token.");
					    				validado= false;
					    			}
					}
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    			System.out.println("No se realizó la consulta.");
    		}
    	
    	return validado;
    }
    
}

