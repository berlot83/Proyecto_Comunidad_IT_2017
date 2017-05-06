package org.comunidadIT.proyecto.entidades;

public class Empresa {

	protected int id;
	protected String empresa;
	
	
			public Empresa(int id, String empresa){
				
				this.id=id;
				this.empresa= empresa;
			}
			
			
			public Empresa(int id){
				
				this.id= id;
			}
			
			
			public Empresa(String empresa){
				
				this.empresa= empresa;
			}
}
