Proyecto Java Rest para Comunidad-IT.
Autor: Axel A. Berlot.

Básicamente es un administrador de taréas comunes dentro de un aeropuerto.

La estructura organizacional es la siguiente:

• Super_Administrador---> puede realizar:
		- Altas de Administradores RH, Vuelos, Seguridad.
		- Bajas de  Administradores RH, Vuelos, Seguridad, siempre y cuando no tengan empleados y/o vuelos relacionados.
		
	• AdminRH---> puede realizar:
	
		- Altas, bajas, y modificaciones de empleados.
		
	• AdminVuelos---> puede realizar:
	
		-Altas, bajas, y modificaciones de vuelos.
		
	• Adminseg---> puede realizar:
	
		-Altas y bajas de servicios, eventos, zonas. 
		
		
La clave de la cuenta Super_Administrador es:

	- Usuario: "admin"
	- Pass: "pass"
	- Token: "yyyy-MM-dd-HH-MM"
	
Los datos están alojados en la tabla "super_administradores" de la DB "aeropuerto.sql". A exceptición de el token que toma los datos directamente de la fecha y horario actual de la pc en uso.

- No hay una interface de registro para super_administradores.
- La columna "token" dela DB aeropuerto.sql quedó en deshuso ya que se cambió su uso, por la validación por fecha y horario.


• AdminRH:

	-Tiene una interface compartida de registro junto con adminVuelos y adminSeg.

		-Altas de empleados, con calculo automático de cargas sociales y vacaciones dependiendo la cantidad de días ingresados.
		- Si no se desea usar el cálculo automático, se pueden ingresar los días  manualmente y la cantidad de porcentaje expresado del 0 al 1 para las cargas sociales.
		

	
	