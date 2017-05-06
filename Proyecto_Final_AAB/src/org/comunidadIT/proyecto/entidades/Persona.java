package org.comunidadIT.proyecto.entidades;

//Esta clase sólo existe para tener una clase abstracta en el proyecto, no es funcional al mismo.
public abstract class Persona {
	
	protected String nombre;
	protected String apellido;
	protected int dni;
	
	public Persona(String nombre, String apellido, int dni){
		this.nombre=nombre;
		this.apellido=nombre;
		this.dni=dni;
	}
	
			public String getNombre() {
				return nombre;
			}
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
			public String getApellido() {
				return apellido;
			}
			public void setApellido(String apellido) {
				this.apellido = apellido;
			}
		 
}
