package org.comunidadIT.proyecto.validaciones;

import java.text.SimpleDateFormat;
import java.util.Date;


//Valida la fecha de salida y arribo del avión para que la asignación no sea ni igual ni menor al mismo día.
public class ValidarFechaSalida {

	
	public static boolean validarFechaSalida(String fechaSalida, String fechaArribo){
		
	boolean validado=false;
	
	try{
		SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateFechaSalida= format.parse(fechaSalida);
		Date dateFechaArribo= format.parse(fechaArribo);
		
	if(dateFechaSalida.equals(dateFechaArribo) || dateFechaArribo.before(dateFechaSalida))
			{	
				System.out.println("Las dos fechas son iguales o la de arribo es anterior a la de salida, no puede seguir.");
				return validado= false;
				
			}
			else
			{
				System.out.println("La fecha es posterior puede proseguir.");
				return validado= true;
			}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		return validado;
	}

}
