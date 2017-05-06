package org.comunidadIT.proyecto.entidades;

public class Vuelo {
	
	protected int id;
	protected String usuario;
	protected int id_avion;
	protected int id_empresa;
	protected String destino;
	protected int escalas;
	protected int pasajes;
	protected String salida;
	protected String horario;
	protected String arribo;
	protected String horarioArribo;
	
	
			public Vuelo(int id, int id_empresa, String destino, int escalas, int pasajes, String salida, String horario, String arribo, String horarioArribo){
			
				this.id=id;
				this.id_empresa=id_empresa;
				this.destino=destino;
				this.escalas=escalas;
				this.pasajes=pasajes;
				this.salida=salida;
				this.horario=horario;
				this.arribo=arribo;
				this.horarioArribo=horarioArribo;	
			}
			
			public Vuelo(int id, int id_avion, int id_empresa, String destino, int escalas, int pasajes, String salida, String horario, String arribo, String horarioArribo){
				
				this.id=id;
				this.id_avion=id_avion;
				this.id_empresa=id_empresa;
				this.destino=destino;
				this.escalas=escalas;
				this.pasajes=pasajes;
				this.salida=salida;
				this.horario=horario;
				this.arribo=arribo;
				this.horarioArribo=horarioArribo;	
			}
			
			
			public Vuelo(int id, int id_empresa, String destino, int escalas, int pasajes, String salida, String arribo){
				
				this.id=id;
				this.id_empresa= id_empresa;
				this.destino=destino;
				this.escalas=escalas;
				this.pasajes=pasajes;
				this.salida=salida;
				this.arribo=arribo;
			}
			
			
			public Vuelo(int id, int id_avion, int id_empresa, String destino, int escalas, int pasajes, String salida, String arribo){
				
				this.id=id;
				this.id_avion=id_avion;
				this.id_empresa= id_empresa;
				this.destino=destino;
				this.escalas=escalas;
				this.pasajes=pasajes;
				this.salida=salida;
				this.arribo=arribo;
			}
			
			
			public Vuelo(int id){
				
				this.id=id;
			}
	
			//Solo usada en el endpoint 'verVuelos', INNER JOIN con la tabla administradores.
			public Vuelo(int id, int id_avion, String usuario, int id_empresa, String destino, int escalas, int pasajes, String salida, String horario, String arribo, String horarioArribo){
				
				this.id=id;
				this.id_avion=id_avion;
				this.usuario=usuario;
				this.id_empresa=id_empresa;
				this.destino=destino;
				this.escalas=escalas;
				this.pasajes=pasajes;
				this.salida=salida;
				this.horario=horario;
				this.arribo=arribo;
				this.horarioArribo=horarioArribo;	
			}
			
			
			
			//Solo usada en el endpoint 'rellenarSelectVuelos', INNER JOIN con la tabla administradores.
			public Vuelo(int id, int id_avion, String usuario, int id_empresa, String destino, int escalas, int pasajes, String salida, String arribo){
				
				this.id=id;
				this.id_avion=id_avion;
				this.usuario=usuario;
				this.id_empresa=id_empresa;
				this.destino=destino;
				this.escalas=escalas;
				this.pasajes=pasajes;
				this.salida=salida;
				this.arribo=arribo;
			}
}
