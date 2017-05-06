package org.comunidadIT.proyecto.validaciones;

public class ValidarCaracteres {

/*
	 	//Estos String son sólo de referencia.
	 	String numerosLetras= new String("[^a-zA-Z0-9]+");
		String soloLetras= new String("[^a-zA-Z]+");
		String soloEmail= new String("[^a-zA-Z0-9@._-]");
*/		
	
	
	//Sólo para ara probar por consola. Correr por "run as java application"
	public static void main(String[] args) {
		
		String soloLetras="M·i$sn%o&/m(b)r)?¿e+-E*s()&%·A$/x*-++e+-**l/";
		String numerosLetras="S$c%&a?+-*l/(a)T$b%r&/i&%n(%i&$O%&r$·t&i%·z$%·%4)?2=?/5*/-";
		String soloEmail= "!b·$e%&r/)l=o(t/&8%$3·!@%$y&(a)=h?¿o/*o+.·$c%$o&/m().=a+*r/";
		
			System.out.println(ValidarCaracteres.numerosLetras(soloLetras));
			System.out.println(ValidarCaracteres.numerosLetras(numerosLetras));
			System.out.println(ValidarCaracteres.soloEmail(soloEmail));

	}
	
	
	//Para los controladores u endpoints.
	public static String soloLetras(String string){
		
		String soloLetras= new String("[^a-zA-Z]+");
		
			try
				{
					String str_validado= string.trim().replaceAll(soloLetras, "");
					return str_validado;
				}
			catch(Exception e)
				{
					System.out.println("Debe ingresar letras únicamente.");
					return "Debe ingresar letras únicamente.";
				}
	}
	
	
	public static String numerosLetras(String string){
		
		String numerosLetras= new String("[^a-zA-Z0-9]+");
		
		try
			{
				String str_validado= string.trim().replaceAll(numerosLetras, "");
				return str_validado;
			}
		catch(Exception e)
			{
				System.out.println("Debe ingresar números y letras únicamente.");
				return "Debe ingresar números y letras únicamente.";
			}
	}
	
	
	public static String soloEmail(String string){
		
		String soloEmail= new String("[^a-zA-Z0-9@._-]");
		
		try
			{
				String str_validado= string.trim().replaceAll(soloEmail, "");
				return str_validado;
			}
		catch(Exception e)
			{
				System.out.println("Debe ingresar números, letras y los símbolos '.' y '@' únicamente.");
				return "Debe ingresar números y letras únicamente.";
			}
	}
	
}
