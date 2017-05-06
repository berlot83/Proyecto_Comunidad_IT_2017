package org.comunidadIT.proyecto.controladores;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.comunidadIT.proyecto.accesoDatos.AutenticarAdministradorVuelo;
import org.comunidadIT.proyecto.accesoDatos.ConexionAeropuerto;
import org.comunidadIT.proyecto.entidades.Avion;
import org.comunidadIT.proyecto.entidades.Empresa;
import org.comunidadIT.proyecto.entidades.Vuelo;
import org.comunidadIT.proyecto.validaciones.ValidarCantidadPasajeros;
import org.comunidadIT.proyecto.validaciones.ValidarCaracteres;
import org.comunidadIT.proyecto.validaciones.ValidarFechaSalida;
import com.google.gson.Gson;



@Path("/adminVuelos")
public class AdminVuelos {
	
	@POST
	@Path("/verVuelos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verVuelos(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
	
	List<Vuelo> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);	
	
	int int_id= 0;
	int int_id_avion=0;
	String str_usuario=null;
	int int_id_empresa= 0;
	String str_destino= null;
	int int_escalas= 0;
	int int_pasajes= 0;
	String str_fechaSalida= null;
	String str_horarioSalida= null;
	String str_fechaArribo= null;
	String str_horarioArribo= null;
	
	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		
		if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true /*  || acá pienso poner una clase estática que valide el token */ )
		{
			//Capturamos el id del administrador consultando la tabla administradores
			int int_id_administrador= 0;
			Statement st1;
			String sql1= "SELECT id_administrador FROM administradores WHERE usuario='"+usuario+"' ";
			st1= con.createStatement();
			ResultSet rs1= st1.executeQuery(sql1);
				while(rs1.next())
					{
						int_id_administrador= rs1.getInt("id_administrador");
					}
				st1.close();
			
			//Usamos la consulta anterior para tomar una variable temporal y consultar los vuelos sólo del admin deseado.
			Statement st;
			String sql= "SELECT id, id_avion, administradores.usuario, id_empresa, destino, escalas, pasajes, fechaSalida, horarioSalida, fechaArribo, horarioArribo FROM vuelos INNER JOIN administradores ON vuelos.id_administrador=administradores.id_administrador WHERE vuelos.id_administrador="+int_id_administrador;
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next())
			{
				int_id= rs.getInt("id");
				int_id_avion= rs.getInt("id_avion");
				str_usuario= rs.getString("usuario");
				int_id_empresa= rs.getInt("id_empresa");
				str_destino= rs.getString("destino");
				int_escalas= rs.getInt("escalas");
				int_pasajes= rs.getInt("pasajes");
				str_fechaSalida= rs.getString("fechaSalida");
				str_horarioSalida= rs.getString("horarioSalida");
				str_fechaArribo= rs.getString("fechaArribo");
				str_horarioArribo= rs.getString("horarioArribo");
				
				listado.add(new Vuelo(int_id, int_id_avion, str_usuario, int_id_empresa, str_destino, int_escalas, int_pasajes, str_fechaSalida, str_horarioSalida, str_fechaArribo, str_horarioArribo));	
			}
			st.close();
			return respuesta_Json= gson.toJson(listado);
			
		}
		else
			{
				return respuesta_Json="La consulta no pudo realizarse.";
			}
	}
	catch(Exception e)
		{
			
		}
	return respuesta_Json; 	
}
	
	
	@POST
	@Path("/agregarVuelo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarVuelo(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("empresa") int empresa, @FormParam("destino") String destino, @FormParam("escalas") int escalas, @FormParam("pasajes") int pasajes, @FormParam("fechaSalida") String fechaSalida, @FormParam("horarioSalida") String horarioSalida, @FormParam("fechaArribo") String fechaArribo, @FormParam("horarioArribo") String horarioArribo, @FormParam("id_avion") int id_avion){
		
		Gson gson= new Gson();
		List<Vuelo> listado= new ArrayList<>();
		String  str_toJson= null;
		
		int int_sql_pasajeros= 0;
		int int_id_usuarioAdmin= 0;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con !=null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true){
				
				
				if(usuario.equalsIgnoreCase("")||pass.equalsIgnoreCase("")||destino.equalsIgnoreCase("")||pasajes<0||fechaSalida.equalsIgnoreCase("")||horarioSalida.equalsIgnoreCase("")||fechaArribo.equalsIgnoreCase("")||horarioArribo.equalsIgnoreCase(""))
					{
						//System.out.println("hay algun campo vacío");
					return str_toJson= "Hay algún campo del formulario puede haber quedado vacío.";
					}
				else
					{
					
					//Averiguamos la cantidad de pasajeros que tiene el avión asignado y la comparamos con los pasajes.
						Statement st;
						String sql_pasajeros= "SELECT cantidad_pasajeros FROM aviones WHERE id="+id_avion;
						st= con.createStatement();
						ResultSet rsPasajeros= st.executeQuery(sql_pasajeros);
						
						while(rsPasajeros.next())
							{
								int_sql_pasajeros= rsPasajeros.getInt("cantidad_pasajeros");
							}
						st.close();
						
					//Condicionamos a que la cantidad de pasajes es igual o menor a la capacidad del avión	
					if(ValidarCantidadPasajeros.validarCantidadPasajeros(pasajes, int_sql_pasajeros)==true && ValidarFechaSalida.validarFechaSalida(fechaSalida, fechaArribo)==true){
						
							//Averiguamos el id_administrador del usuario en la tabla 'administradores' para colocarlo en la tabla vuelos
							Statement stmt;
							String sql_Id= "SELECT id_administrador FROM administradores WHERE usuario='"+usuario+"' ";
							stmt= con.createStatement();
							ResultSet rs= stmt.executeQuery(sql_Id);
							
							while(rs.next())
								{
									int_id_usuarioAdmin= rs.getInt("id_administrador");
								}
							stmt.close();
							
							
							//Agregamos un vuelo y tomamos el id anterior para colocar como foreing key.
							PreparedStatement ps;
							String sql="INSERT INTO vuelos(id_avion, id_administrador, id_empresa, destino, escalas, pasajes, fechaSalida, horarioSalida, fechaArribo, horarioArribo, tipo_administrador) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
							ps= con.prepareStatement(sql);
							
							ps.setInt(1, id_avion);
							ps.setInt(2, int_id_usuarioAdmin);
							ps.setInt(3, empresa);
							ps.setString(4, ValidarCaracteres.soloLetras(destino));
							ps.setInt(5, escalas);
							ps.setInt(6, pasajes);
							ps.setString(7, fechaSalida);
							ps.setString(8, horarioSalida);
							ps.setString(9, fechaArribo);
							ps.setString(10, horarioArribo);
							ps.setString(11, "adminVuelos");
							
							ps.executeUpdate();
							ps.close();
							
							listado.add(new Vuelo(0,empresa,destino, escalas, pasajes, fechaSalida, horarioSalida,fechaArribo, horarioArribo));
							
							str_toJson= gson.toJson(listado);
							return str_toJson;
							
							}
						
					
						else
						{
							return "Verifique que la cantidad de pasajes sea igual o menor a la capacidad de pasajeros del avión, o verifique la 'fecha de salida' sea anterior a la de 'Arribo'.";
						}
					}
				
			}
			else
				{
					return str_toJson= "No se pudo conectar a la DB o las credenciales no son correctas.";
				}
		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la DB.");
		}
		
		return str_toJson;
	}
	
	//Cambiar esto agregarle el select de aviones
	@POST
	@Path("modificarVuelo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String modificarVuelo(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("id_avion") int id_avion, @FormParam("empresa") int id_empresa, @FormParam("destino") String destino, @FormParam("escalas") int escalas, @FormParam("pasajes") int pasajes, @FormParam("fechaSalida") String fechaSalida, @FormParam("horarioSalida") String horarioSalida, @FormParam("fechaArribo") String fechaArribo, @FormParam("horarioArribo") String horarioArribo, @FormParam("id") int id){
		
		Gson gson= new Gson();
		ArrayList<Vuelo> listado=  new ArrayList<>();
		String jsonToString= null;
		
		int int_sql_pasajeros= 0;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true){
				
				
				if(usuario.equalsIgnoreCase("")||pass.equalsIgnoreCase("")||destino.equalsIgnoreCase("")||pasajes<0||fechaSalida.equalsIgnoreCase("")||horarioSalida.equalsIgnoreCase("")||fechaArribo.equalsIgnoreCase("")||horarioArribo.equalsIgnoreCase("")||id<0)
				{
					//System.out.println("hay algun campo vacío");
				return jsonToString= "Hay algún campo del formulario puede haber quedado vacío.";
				}
			else
				{
				
				
			//Averiguamos la cantidad de pasajeros que tiene el avión asignado y la comparamos con los pasajes.
			Statement st;
			String sql_pasajeros= "SELECT cantidad_pasajeros FROM aviones WHERE id="+id_avion;
			st= con.createStatement();
			ResultSet rsPasajeros= st.executeQuery(sql_pasajeros);
				
				while(rsPasajeros.next())
					{
						int_sql_pasajeros= rsPasajeros.getInt("cantidad_pasajeros");
					}
				
				
			
			//Averiguamos el id_administrador del que pide la consulta.
			int int_id_administrador=0;
			Statement st1;
			String sql_id_administrador= "SELECT id_administrador FROM administradores WHERE usuario='"+usuario+"' ";
			st1= con.createStatement();
			ResultSet rs_id_administrador= st1.executeQuery(sql_id_administrador);
					
				while(rs_id_administrador.next())
					{
						int_id_administrador= rs_id_administrador.getInt("id_administrador");
					}
			st1.close();
			
				
			//Condicionamos a que la cantidad de pasajes es igual o menor a la capacidad del avión	
			if(ValidarCantidadPasajeros.validarCantidadPasajeros(pasajes, int_sql_pasajeros)==true && ValidarFechaSalida.validarFechaSalida(fechaSalida, fechaArribo)==true){
				
				PreparedStatement ps;
				String sql= "UPDATE vuelos SET id_avion=?, id_empresa=?, destino=?, escalas=?, pasajes=?, fechaSalida=?, horarioSalida=?, fechaArribo=?, horarioArribo=? WHERE id=? AND id_administrador=?";
				ps= con.prepareStatement(sql);
				
				ps.setInt(1, id_avion);
				ps.setInt(2, id_empresa);
				ps.setString(3, ValidarCaracteres.soloLetras(destino));
				ps.setInt(4, escalas);
				ps.setInt(5, pasajes);
				ps.setString(6, fechaSalida);
				ps.setString(7, horarioSalida);
				ps.setString(8, fechaArribo);
				ps.setString(9, horarioArribo);
				ps.setInt(10, id);
				ps.setInt(11, int_id_administrador);
				ps.executeUpdate();
				ps.close();
				
				listado.add(new Vuelo(0,id_empresa,destino, escalas, pasajes, fechaSalida, horarioSalida,fechaArribo, horarioArribo));
				return jsonToString= gson.toJson(listado);
				
			}
			
			
				else
					{
						return "Verifique que la cantidad de pasajes sea igual o menor a la capacidad de pasajeros del avión, o verifique la 'fecha de salida' sea anterior a la de 'Arribo'.";
					}
			
			}
			
			
			}
			else
			{
				return jsonToString="Los datos no pudieron modificarse en la DB hubo un error o las credenciales no son correctas";
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la DB.");
		}
		
		return jsonToString;
	}
	
	
	@DELETE
	@Path("/deleteVuelo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteVuelo(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("id") int id){
		
		Gson gson= new Gson();
		ArrayList<Vuelo> listado= new ArrayList<>();
		String RespuestaToJson;
		
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true)
			{
				//Averiguamos el id_administrador del que pide la consulta.
				int int_id_administrador=0;
				Statement st1;
				String sql_id_administrador= "SELECT id_administrador FROM administradores WHERE usuario='"+usuario+"' ";
				st1= con.createStatement();
				ResultSet rs_id_administrador= st1.executeQuery(sql_id_administrador);
						
					while(rs_id_administrador.next())
						{
							int_id_administrador= rs_id_administrador.getInt("id_administrador");
						}
				st1.close();
				
				
				Statement st;
				st= con.createStatement();			
				st.executeUpdate("DELETE FROM vuelos WHERE id="+id+" AND id_administrador='"+int_id_administrador+"' ");
				st.close();
				
				
				listado.add(new Vuelo(id));
				RespuestaToJson= gson.toJson(listado);
				return "El vuelo "+ RespuestaToJson +" fue borrado de la DB.";
			}
			else
			{
				return "Controle su usuario y pass\nSi los mismos están bien puede que un error interno haya ocurrido.";
			}
		}
		catch(Exception e)
		{
			System.out.println("La conexión no fue posible.");
		}
		
		RespuestaToJson= gson.toJson(listado);
		return RespuestaToJson;
	}
	
	
	@POST
	@Path("/verTodosAviones")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String verTodosAviones(@FormParam("usuario") String usuario, @FormParam("pass") String pass){
	
	List<Avion> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);	
	
	int int_id= 0;
	String str_tipo_avion= null;
	String str_matricula= null;
	int int_cantidad_pasajeros= 0;

	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true)
		{
			Statement st;
			String sql= "SELECT * FROM aviones";
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			while(rs.next())
			{
				int_id= rs.getInt("id");
				str_tipo_avion= rs.getString("tipo_avion");
				str_matricula= rs.getString("matricula");
				int_cantidad_pasajeros= rs.getInt("cantidad_pasajeros");
				
			
				listado.add(new Avion(int_id, str_tipo_avion, str_matricula, int_cantidad_pasajeros));
				respuesta_Json= gson.toJson(listado);
			}
			return respuesta_Json;
		}
		else
		{
			return respuesta_Json="La consulta no pudo realizarse.";
		}
	}
	catch(Exception e)
	{
		
	}
		return respuesta_Json; 
	}
	
	
	@POST
	@Path("/agregarAvion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarAvion(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("tipo_avion") String tipo_avion, @FormParam("matricula") String matricula, @FormParam("cantidad_pasajeros") int cantidad_pasajeros){
		
		Gson gson= new Gson();
		List<Avion> listado= new ArrayList<>();
		String  str_toJson= null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con !=null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true){
				
				
				if(usuario.equalsIgnoreCase("")||pass.equalsIgnoreCase("")||tipo_avion.equalsIgnoreCase("")||matricula.equalsIgnoreCase("")||cantidad_pasajeros<0)
					{
						//System.out.println("hay algun campo vacío");
					return str_toJson= "Hay algún campo del formulario puede haber quedado vacío.";
					}
				else
					{
				
						PreparedStatement ps;
						String sql="INSERT INTO aviones(tipo_avion, matricula, cantidad_pasajeros) values(?,?,?)";
						ps= con.prepareStatement(sql);
						
						ps.setString(1, tipo_avion);
						ps.setString(2, matricula);
						ps.setInt(3, cantidad_pasajeros);
						ps.executeUpdate();
						ps.close();
						
						listado.add(new Avion(tipo_avion, matricula, cantidad_pasajeros));
						
						str_toJson= gson.toJson(listado);
						return str_toJson;
			
					}
				
			}
			else
				{
					return str_toJson= "No se pudo conectar a la DB o las credenciales no son correctas.";
				}
		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la DB.");
		}
		
		return str_toJson;
	}
	
	
	@DELETE
	@Path("/deleteAvion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteAvion(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("id") int id){
		
		Gson gson= new Gson();
		ArrayList<Avion> listado= new ArrayList<>();
		String RespuestaToJson;
		
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true)
			{
				Statement st;
				st= con.createStatement();			
				st.executeUpdate("DELETE FROM aviones WHERE id="+id);
				st.close();
				
				listado.add(new Avion(id));
				RespuestaToJson= gson.toJson(listado);
				return "El avion "+ RespuestaToJson +" fue borrado de la DB.";
			}
			else
			{
				return "Controle su usuario y pass\nSi los mismos están bien puede que un error interno haya ocurrido.";
			}
		}
		catch(Exception e)
		{
			System.out.println("La conexión no fue posible.");
		}
		RespuestaToJson= gson.toJson(listado);
		return RespuestaToJson;
	}
	
	
	@POST
	@Path("/agregarEmpresa")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String agregarEmpresa(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("agregarEmpresa") String agregarEmpresa){
		
		Gson gson= new Gson();
		List<Empresa> listado= new ArrayList<>();
		String  str_toJson= null;
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con !=null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true){
				
				
				if(usuario.equalsIgnoreCase("")||pass.equalsIgnoreCase("")||agregarEmpresa.equalsIgnoreCase(""))
					{
						//System.out.println("hay algun campo vacío");
					return str_toJson= "Hay algún campo del formulario puede haber quedado vacío.";
					}
				else
					{
				
						PreparedStatement ps;
						String sql="INSERT INTO empresas(empresa) values(?)";
						ps= con.prepareStatement(sql);
						
						ps.setString(1, agregarEmpresa);
						ps.executeUpdate();
						ps.close();
						
						listado.add(new Empresa(agregarEmpresa));
						
						str_toJson= gson.toJson(listado);
						return str_toJson;
			
					}
				
			}
			else
				{
					return str_toJson= "No se pudo conectar a la DB o las credenciales no son correctas.";
				}
		}
		catch(Exception e)
		{
			System.out.println("No se pudo conectar a la DB.");
		}
		
		return str_toJson;
	}
	
	
	@DELETE
	@Path("/deleteEmpresa")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteEmpresa(@FormParam("usuario") String usuario, @FormParam("pass") String pass, @FormParam("eliminarEmpresa") int id){
		
		Gson gson= new Gson();
		ArrayList<Empresa> listado= new ArrayList<>();
		String RespuestaToJson;
		
		
		try{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null && AutenticarAdministradorVuelo.autenticarAdministradorVuelo(usuario, pass)==true)
			{
				Statement st;
				st= con.createStatement();			
				st.executeUpdate("DELETE FROM empresas WHERE id="+id);
				st.close();
				
				
				listado.add(new Empresa(id));
				RespuestaToJson= gson.toJson(listado);
				return "La empresa "+ RespuestaToJson +" fue borrada de la DB.";
			}
			else
			{
				return "Controle su usuario y pass\nSi los mismos están bien puede que un error interno haya ocurrido.";
			}
		}
		catch(Exception e)
		{
			System.out.println("La conexión no fue posible.");
		}
		
		RespuestaToJson= gson.toJson(listado);
		return RespuestaToJson;
	}
	
	
	@POST
	@Path("/rellenoSelectAviones")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String rellenoSelectAviones(){
	
	List<Avion> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);	
	
	int int_id= 0;
	String str_matricula= null;
	int int_cantidad_pasajeros=0;
	
	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		if(con != null)
		{
			Statement st;
			String sql= "SELECT id, matricula, cantidad_pasajeros FROM aviones";
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			
			while(rs.next())
				{
					int_id= rs.getInt("id");
					str_matricula= rs.getString("matricula");
					int_cantidad_pasajeros= rs.getInt("cantidad_pasajeros");
							
					listado.add(new Avion(int_id, str_matricula, int_cantidad_pasajeros));
					respuesta_Json= gson.toJson(listado);
					
				}
			st.close();
			return respuesta_Json;
		}
		else
		{
			return respuesta_Json="La consulta no pudo realizarse.";
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return respuesta_Json; 
	}
	
	
	@POST
	@Path("/rellenoSelectVuelos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String rellenoSelectVuelos(){
	
	List<Vuelo> listado= new ArrayList<>();
	Gson gson= new Gson();
	String	respuesta_Json= gson.toJson(listado);	
	
	int int_id= 0;
	int int_id_avion=0;
	String str_usuario= null;
	int int_id_empresa= 0;
	String str_destino= null;
	int int_escalas= 0;
	int int_pasajes= 0;
	String str_fechaSalida= null;
	String str_fechaArribo= null;
	
	try
	{
		ConexionAeropuerto c= new ConexionAeropuerto();
		Connection con= c.connectarAhora();
		if(con != null)
		{
			//En deshuso al momento:   String sql= "SELECT id, id_avion, id_empresa, destino, escalas, pasajes, fechaSalida, fechaArribo FROM vuelos";
			Statement st;
			String sql= "SELECT id, id_avion, administradores.usuario, id_empresa, destino, escalas, pasajes, fechaSalida, horarioSalida, fechaArribo, horarioArribo from vuelos inner join administradores on vuelos.id_administrador=administradores.id_administrador";
			st= con.createStatement();
			ResultSet rs= st.executeQuery(sql);
			
			
			while(rs.next())
				{
					int_id= rs.getInt("id");
					int_id_avion= rs.getInt("id_avion");
					str_usuario= rs.getString("usuario").toUpperCase();	//INNER JOIN de 'vuelos' con administradores, en mayusculas para que sobresalga
					int_id_empresa= rs.getInt("id_empresa");
					str_destino= rs.getString("destino");
					int_escalas= rs.getInt("escalas");
					int_pasajes= rs.getInt("pasajes");
					str_fechaSalida= rs.getString("fechaSalida");
					str_fechaArribo= rs.getString("fechaArribo");
					
					listado.add(new Vuelo(int_id, int_id_avion, str_usuario, int_id_empresa, str_destino, int_escalas, int_pasajes, str_fechaSalida, str_fechaArribo));
					respuesta_Json= gson.toJson(listado);
					
				}
			st.close();
			return respuesta_Json;
		}
		else
		{
			return respuesta_Json="La consulta no pudo realizarse.";
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return respuesta_Json; 
	}
	
	@POST
	@Path("/rellenoSelectEmpresas")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String rellenoSelectEmpresas(){
		
	String respuesta= null;
	Gson gson= new Gson();
	ArrayList<Empresa> listado= new ArrayList<>();
		
		try
		{
			ConexionAeropuerto c= new ConexionAeropuerto();
			Connection con= c.connectarAhora();
			
			if(con != null)
			{
				Statement st;
				st= con.createStatement();
				String sql= "SELECT id, empresa FROM empresas";
				ResultSet rs= st.executeQuery(sql);
				
				while(rs.next())
				{
					int id= rs.getInt("id");
					String empresa= rs.getString("empresa");
					
					listado.add(new Empresa(id, empresa));
				}
				
				return respuesta= gson.toJson(listado);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("No se pudo conectar a la DB.");
			return "No se pudo conectar a la DB.";
		}
		return respuesta;
	}
	
}
