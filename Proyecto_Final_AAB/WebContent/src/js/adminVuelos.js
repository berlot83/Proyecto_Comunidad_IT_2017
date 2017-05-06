
function verVuelos(){

	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/verVuelos";
	
	xhr.onreadystatechange= function(){
		if(this.readyState == 4 && this.status== 200 ){
		
		//Comienza tabla de vuelos		
			var	tablaElegida= document.getElementById("tablaResultados");
			
			var cabecera = ["id-Vuelo", "id-Avion", "Usuario", "id-Empresa", "Destino", "Escalas", "Pasajes", "Fecha de salida", "Horario de salida", "Fecha de arribo", "Horario de arribo"];
			
			for( var i=0; i < cabecera.length; i++)
			{
					var	tablaElegida= document.getElementById("tablaResultados");
					
					var crearTitulos=document.createElement("td");
					
					var textoNombre= document.createTextNode(cabecera[i]);
					
					crearTitulos.appendChild(textoNombre);
					
					tablaElegida.appendChild(crearTitulos).style.border = "solid yellow";
			}

					
					//Esta es la respuesta del servidor, sobre esta recaen todas las acciones.
					var datos= xhr.responseText;
					
					//Parseamos los datos
					var parseDatos= JSON.parse(datos);
					
			
					//Iteramos sobre la respuesta del JSON
					for(var i=0; i < xhr.responseText.length; i++){
				
						
						//Creamos un renglon por cada elemento que iteramos
							var hilera= document.createElement("tr");
							var	tablaElegida= document.getElementById("tablaResultados");
								tablaElegida.appendChild(hilera);
					
								
						//id_vuelo
							//Creamos los td  que contendrán los resultados
							var newtdId_vuelo= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdId_vuelo).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoId_vuelo= document.createTextNode(parseDatos[i].id);
								
							//Adherimos el texto ya creado a los td
							newtdId_vuelo.appendChild(textoId_vuelo);
						
						//id_avion
							//Creamos los td  que contendrán los resultados
							var newtdAvion= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdAvion).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoAvion= document.createTextNode(parseDatos[i].id_avion);
								
							//Adherimos el texto ya creado a los td
							newtdAvion.appendChild(textoAvion);	
							
							
						//usuario INNER JOIN administradores, no borrar
							//Creamos los td  que contendrán los resultados
							var newtdUsuario= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdUsuario).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoUsuario= document.createTextNode(parseDatos[i].usuario);
								
							//Adherimos el texto ya creado a los td
							newtdUsuario.appendChild(textoUsuario);
							
			
						//id_empresa
							//Creamos los td  que contendrán los resultados
							var newtdEmpresa= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdEmpresa).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoEmpresa= document.createTextNode(parseDatos[i].id_empresa);
								
							//Adherimos el texto ya creado a los td
							newtdEmpresa.appendChild(textoEmpresa);
						
						
						//Destino
							//Creamos los td  que contendrán los resultados
							var newtdDestino= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdDestino).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoDestino= document.createTextNode(parseDatos[i].destino);
								
							//Adherimos el texto ya creado a los td
							newtdDestino.appendChild(textoDestino);
						
						
						//Escalas
							//Creamos los td  que contendrán los resultados
							var newtdEscalas= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdEscalas).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoEscalas= document.createTextNode(parseDatos[i].escalas);
								
							//Adherimos el texto ya creado a los td
							newtdEscalas.appendChild(textoEscalas);
						
						
						//Pasajes
							//Creamos los td  que contendrán los resultados
							var newtdPasajes= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdPasajes).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoPasajes= document.createTextNode(parseDatos[i].pasajes);
								
							//Adherimos el texto ya creado a los td
							newtdPasajes.appendChild(textoPasajes);
						
						
						//Salida
							//Creamos los td  que contendrán los resultados
							var newtdSalida= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdSalida).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoSalida= document.createTextNode(parseDatos[i].salida);
								
							//Adherimos el texto ya creado a los td
							newtdSalida.appendChild(textoSalida);
						
							
						//Horario
							//Creamos los td  que contendrán los resultados
							var newtdHorario= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdHorario).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoHorario= document.createTextNode(parseDatos[i].horario);
								
							//Adherimos el texto ya creado a los td
							newtdHorario.appendChild(textoHorario);
						
							
						//Arribo
							//Creamos los td  que contendrán los resultados
							var newtdArribo= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdArribo).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoArribo= document.createTextNode(parseDatos[i].arribo);
								
							//Adherimos el texto ya creado a los td
							newtdArribo.appendChild(textoArribo);
						
						//horarioArribo
							//Creamos los td  que contendrán los resultados
							var newtdHorarioArribo= document.createElement("td");
								
							//Adherimos los td a la tabla ya existente
							tablaElegida.appendChild(newtdHorarioArribo).style.border = "thin solid white";
								
							//Creamos el texto y aherimos las columnas parseadas
							var textoHorarioArribo= document.createTextNode(parseDatos[i].horarioArribo);
								
							//Adherimos el texto ya creado a los td
							newtdHorarioArribo.appendChild(textoHorarioArribo);

							
						//Iconos
							if(parseDatos[i].pasajes>=321)
							{
							
								//Creamos los td  que contendrán los resultados
								var newtdImagen= document.createElement("td");
								
								//Adherimos los td a la tabla ya existente
								tablaElegida.appendChild(newtdImagen);
					
							
								//Inicio creación de imagen
									var img= document.createElement("img");
										img.setAttribute('src', 'src/img/A777.png');
										newtdImagen.appendChild(img);
								//Final creación de imagen	
							}
							
							if(parseDatos[i].pasajes<=320 && parseDatos[i].pasajes>=220)
							{
							
								//Creamos los td  que contendrán los resultados
								var newtdImagen= document.createElement("td");
								
								//Adherimos los td a la tabla ya existente
								tablaElegida.appendChild(newtdImagen);
					
							
								//Inicio creación de imagen
									var img= document.createElement("img");
										img.setAttribute('src', 'src/img/A320.png');
										newtdImagen.appendChild(img);
								//Final creación de imagen	
							}
							
							if(parseDatos[i].pasajes<=219 && parseDatos[i].pasajes>=100)
							{
							
								//Creamos los td  que contendrán los resultados
								var newtdImagen= document.createElement("td");
								
								//Adherimos los td a la tabla ya existente
								tablaElegida.appendChild(newtdImagen);
					
							
								//Inicio creación de imagen
									var img= document.createElement("img");
										img.setAttribute('src', 'src/img/A295.png');
										newtdImagen.appendChild(img);
								//Final creación de imagen	
							}
							
							if(parseDatos[i].pasajes<=99 && parseDatos[i].pasajes>=50)
							{
							
								//Creamos los td  que contendrán los resultados
								var newtdImagen= document.createElement("td");
								
								//Adherimos los td a la tabla ya existente
								tablaElegida.appendChild(newtdImagen);
					
							
								//Inicio creación de imagen
									var img= document.createElement("img");
										img.setAttribute('src', 'src/img/learjet.png');
										newtdImagen.appendChild(img);
								//Final creación de imagen	
							}
							
							if(parseDatos[i].pasajes<=49 && parseDatos[i].pasajes>=20)
							{
							
								//Creamos los td  que contendrán los resultados
								var newtdImagen= document.createElement("td");
								
								//Adherimos los td a la tabla ya existente
								tablaElegida.appendChild(newtdImagen);
					
							
								//Inicio creación de imagen
									var img= document.createElement("img");
										img.setAttribute('src', 'src/img/airjet.png');
										newtdImagen.appendChild(img);
								//Final creación de imagen	
							}
							
							if(parseDatos[i].pasajes<=19 && parseDatos[i].pasajes>=10)
							{
							
								//Creamos los td  que contendrán los resultados
								var newtdImagen= document.createElement("td");
								
								//Adherimos los td a la tabla ya existente
								tablaElegida.appendChild(newtdImagen);
					
							
								//Inicio creación de imagen
									var img= document.createElement("img");
										img.setAttribute('src', 'src/img/jet.png');
										newtdImagen.appendChild(img);
								//Final creación de imagen	
							}
							
							if(parseDatos[i].pasajes<=9)
							{
							
								//Creamos los td  que contendrán los resultados
								var newtdImagen= document.createElement("td");
								
								//Adherimos los td a la tabla ya existente
								tablaElegida.appendChild(newtdImagen);
					
							
								//Inicio creación de imagen
									var img= document.createElement("img");
										img.setAttribute('src', 'src/img/cessna.png');
										newtdImagen.appendChild(img);
								//Final creación de imagen	
							}
							
					//Final tabla de vuelos	
					}
			}
		
		//Comienza código de limpieza
		var	ulElegido= document.getElementById("tablaResultados");
		var body= document.getElementById("body");
			body.onclick= function(){
			ulElegido.innerHTML = '';
	}
		//Termina código de limpieza
		
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value);
}



function descargarCVSVuelos(){

	var usuario= document.getElementById("usuario").value;
	var	pass= document.getElementById("pass").value;
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/verVuelos";
	
	
	
	if(usuario=="" && pass==""){
		
			alert("Los campos 'usuario' y 'pass' no pueden quedar en blanco.")
	
		}
	else
		{
		
		xhr.onreadystatechange= function(){
		if(this.readyState==4 && this.status==200){
			
					//Inicio de Papaparse básico
						var papa=Papa.unparse(xhr.responseText, {  
							download: true,
						    complete: function(results) {
						        alert("Se parsearon los resultados", results);
						    }
						});
					//Final de Papaparse básico
						alert("Se comenzara la descarga del archivo CVS en su computadora. Dentro de excel puede convertir ese archivo a formato tabla de datos. Siga los siguientes pasos: 1) Seleccione las celdas a convertir. 2) Datos. 3) Texto en columnas. 4) Delimitar por ancho y comas. 5) Finalizar. ");
					
					
					//Inicio de Comandos de descarga de archivo cvs.
						var csvData = new Blob([papa], {type: 'text/csv;charset=utf-8;'});
						var csvURL = window.URL.createObjectURL(csvData);
						var tempLink = document.createElement('a');
							tempLink.href = csvURL;
							tempLink.setAttribute('download', 'Tabla_de_vuelos.csv');
							tempLink.click();
					//Final de Comandos de descarga de archivo cvs.
							
				}
			}
		}
		//Captamos el endpoint lo declaramos asincrono le decimos que se fije en los parametros que requiera y por último lo enviamos
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("usuario="+usuario+"&pass="+pass);
	}


function descargarCVSaviones(){

	var usuario= document.getElementById("usuario").value;
	var	pass= document.getElementById("pass").value;
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/verTodosAviones";
	
	
	
	if(usuario=="" && pass==""){
		
			alert("Los campos 'usuario' y 'pass' no pueden quedar en blanco.")
	
		}
	else
		{
		
		xhr.onreadystatechange= function(){
		if(this.readyState==4 && this.status==200){
			
					//Inicio de Papaparse básico
						var papa=Papa.unparse(xhr.responseText, {  
							download: true,
						    complete: function(results) {
						        alert("Se parsearon los resultados", results);
						    }
						});
					//Final de Papaparse básico
						alert("Se comenzara la descarga del archivo CVS en su computadora. Dentro de excel puede convertir ese archivo a formato tabla de datos. Siga los siguientes pasos: 1) Seleccione las celdas a convertir. 2) Datos. 3) Texto en columnas. 4) Delimitar por ancho y comas. 5) Finalizar. ");
					
					
					//Inicio de Comandos de descarga de archivo cvs.
						var csvData = new Blob([papa], {type: 'text/csv;charset=utf-8;'});
						var csvURL = window.URL.createObjectURL(csvData);
						var tempLink = document.createElement('a');
							tempLink.href = csvURL;
							tempLink.setAttribute('download', 'Tabla_de_aviones.csv');
							tempLink.click();
					//Final de Comandos de descarga de archivo cvs.
							
				}
			}
		}
		//Captamos el endpoint lo declaramos asincrono le decimos que se fije en los parametros que requiera y por último lo enviamos
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("usuario="+usuario+"&pass="+pass);
	}


function agregarVuelo(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var empresa= document.getElementById("empresa");
	var destino= document.getElementById("destino");
	var escalas= document.getElementById("escalas");
	var pasajes= document.getElementById("pasajes");
	var fechaSalida= document.getElementById("fechaSalida");
	var horarioSalida= document.getElementById("horarioSalida");
	var fechaArribo= document.getElementById("fechaArribo");
	var horarioArribo= document.getElementById("horarioArribo");
	var id_avion= document.getElementById("selectAvionesDisponibles");
	
	var xhr= new XMLHttpRequest();
	url= "/Proyecto_Final_AAB/rest/adminVuelos/agregarVuelo";
	
	xhr.onreadystatechange= function(){
		if(this.readyState == 4 && this.status== 200 ){
			alert(xhr.responseText);

		}
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&empresa="+empresa.value+"&destino="+destino.value+"&pasajes="+pasajes.value+"&escalas="+escalas.value+"&fechaSalida="+fechaSalida.value+"&horarioSalida="+horarioSalida.value+"&fechaArribo="+fechaArribo.value+"&horarioArribo="+horarioArribo.value+"&id_avion="+id_avion.value);
	
}


function modificarVuelo(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var empresa= document.getElementById("modificarEmpresa");
	var destino= document.getElementById("modificarDestino");
	var escalas= document.getElementById("modificarEscalas");
	var pasajes= document.getElementById("modificarPasajes");
	var fechaSalida= document.getElementById("modificarFechaSalida");
	var horarioSalida= document.getElementById("modificarHorarioSalida");
	var fechaArribo= document.getElementById("modificarFechaArribo");
	var horarioArribo= document.getElementById("modificarHorarioArribo");
	var id_avion= document.getElementById("modificarSelectAvionesDisponibles");
	var id= document.getElementById("selectVuelosDisponibles");
	
	var xhr= new XMLHttpRequest();
	url= "/Proyecto_Final_AAB/rest/adminVuelos/modificarVuelo";
	
	xhr.onreadystatechange= function(){
		if(this.readyState == 4 && this.status== 200 ){
			alert(xhr.responseText);

		}
	}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&id_avion="+id_avion.value+"&empresa="+empresa.value+"&destino="+destino.value+"&pasajes="+pasajes.value+"&escalas="+escalas.value+"&fechaSalida="+fechaSalida.value+"&horarioSalida="+horarioSalida.value+"&fechaArribo="+fechaArribo.value+"&horarioArribo="+horarioArribo.value+"&id="+id.value);
}

function eliminarVuelo(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var id= document.getElementById("selectEliminarId");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/deleteVuelo";
	
	if(id.value=="")
		{
			alert("Ningún campo debe quedar vacío.");
		}
	else
		{
			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					alert(xhr.responseText);
				}
			}
		}
	xhr.open("DELETE", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&id="+id.value);
}


function verTodosAviones(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/verTodosAviones";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					alert(xhr.responseText);
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value);
}



function agregarAvion(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var tipo_avion= document.getElementById("tipo_avion");
	var matricula= document.getElementById("matricula");
	var cantidad_pasajeros= document.getElementById("cantidad_pasajeros");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/agregarAvion";
	
	if(tipo_avion.value=="" || matricula.value=="" || cantidad_pasajeros=="")
		{
			alert("Ningun campo debe quedar vacio.");
		}
	else
		{
			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					alert(xhr.responseText);
				}
			}
		}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&tipo_avion="+tipo_avion.value+"&matricula="+matricula.value+"&cantidad_pasajeros="+cantidad_pasajeros.value);
}


function eliminarAvion(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var selectAvionesDisponiblesEliminar= document.getElementById("selectAvionesDisponiblesEliminar");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/deleteAvion";
	
	if(selectAvionesDisponiblesEliminar.value=="")
		{
			alert("Ningún campo debe quedar vacío.");
		}
	else
		{
			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					if(xhr.responseText=="[]")
						{
							alert("No se pudo eliminar el 'avion', probablemente este asignado a un 'vuelo' u otro administrador está usando el mismo y no puede ser eliminado.\n\nIntente Modificar el 'avion asignado' desde la accion 'modificar vuelo' y luego intente nuevamente. \n si apesar de no tener vuelos asignados a ese avion no puede ser eliminado entonces otro administrador está haciendo uso del mismo.");
						}
					else
						{
							alert(xhr.responseText);
						}
				}
			}
		}
	xhr.open("DELETE", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&id="+selectAvionesDisponiblesEliminar.value);
}


function agregarEmpresa(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var agregarEmpresa= document.getElementById("agregarEmpresa");

	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/agregarEmpresa";
	
	if(agregarEmpresa.value=="")
		{
			alert("Ningun campo debe quedar vacio.");
		}
	else
		{
			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					alert(xhr.responseText);
				}
			}
		}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&agregarEmpresa="+agregarEmpresa.value);
}


function eliminarEmpresa(){
	
	var usuario= document.getElementById("usuario");
	var pass= document.getElementById("pass");
	var eliminarEmpresa= document.getElementById("eliminarEmpresa");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/deleteEmpresa";
	
	if(eliminarEmpresa.value=="")
		{
			alert("Ningún campo debe quedar vacío.");
		}
	else
		{
			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					if(xhr.responseText=="[]")
					{
						alert("No se pudo eliminar la 'empresa', probablemente este asignada a un 'vuelo'.\n\nModifique la 'linea aerea' desde la accion 'modificar vuelo' y luego intente nuevamente");
					}
				else
					{
						alert(xhr.responseText);
					}
					
				}
			}
		}
	xhr.open("DELETE", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("usuario="+usuario.value+"&pass="+pass.value+"&eliminarEmpresa="+eliminarEmpresa.value);
}


function acciones(){
	
	var menu= document.getElementById("menu");
	var tablaAgregarVuelo= document.getElementById("tablaAgregarVuelo");
	var tablaModificarVuelo= document.getElementById("tablaModificarVuelo");
	var tablaEliminarVuelo= document.getElementById("tablaEliminarVuelo");
	var tablaAgregarAvion= document.getElementById("tablaAgregarAvion");
	var tablaVerVuelos= document.getElementById("tablaVerVuelos");
	var tablaVerAviones= document.getElementById("tablaVerAviones");
	var tablaEmpresas= document.getElementById("tablaEmpresa");
	var tablaEliminarAvion= document.getElementById("tablaEliminarAvion");
	
	if(menu.value=="agregar"){
		tablaAgregarVuelo.style.display= 'block';
		tablaModificarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaAgregarAvion.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
		tablaEmpresas.style.display= 'none';
		tablaEliminarAvion.style.display=  'none';
	}
	
	if(menu.value=="modificar"){
		tablaModificarVuelo.style.display='block';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaAgregarAvion.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
		tablaEmpresas.style.display= 'none';
		tablaEliminarAvion.style.display=  'none';
	}
	
	if(menu.value=="eliminar"){
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'block';
		tablaAgregarAvion.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
		tablaEmpresas.style.display= 'none';
		tablaEliminarAvion.style.display=  'none';
	}
	
	if(menu.value=="avion"){
		tablaAgregarAvion.style.display= 'block';
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
		tablaEmpresas.style.display= 'none';
		tablaEliminarAvion.style.display=  'none';
	}
	
	if(menu.value=="consultas"){
		tablaAgregarAvion.style.display= 'none';
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaVerVuelos.style.display= 'block';
		tablaVerAviones.style.display='none';
		tablaEmpresas.style.display= 'none';
		tablaEliminarAvion.style.display=  'none';
	}	
	
	if(menu.value=="disponibilidad"){
		tablaVerAviones.style.display='block';
		tablaAgregarAvion.style.display= 'none';
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaEmpresas.style.display= 'none';
		tablaEliminarAvion.style.display=  'none';
	}
	
	if(menu.value=="empresas"){
		tablaEmpresas.style.display= 'block';
		tablaVerAviones.style.display='none';
		tablaAgregarAvion.style.display= 'none';
		tablaModificarVuelo.style.display='none';
		tablaAgregarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaEliminarAvion.style.display=  'none';
		
		alert("Para poder eliminar una Linea aerea es necesario que 'no tenga vuelos asignados'.\n\nEn ese caso puede optar por:\n\na) Eliminar los vuelos asignados a esa linea aerea.\nb) Modificar los vuelos asignados a esa Linea aerea.\n\nEstas opciones estan disponibles desde la accion 'modificar vuelo' del menu.");
	}
	
	if(menu.value=="eliminarAvion"){
		tablaAgregarVuelo.style.display= 'none';
		tablaModificarVuelo.style.display= 'none';
		tablaEliminarVuelo.style.display= 'none';
		tablaAgregarAvion.style.display= 'none';
		tablaVerVuelos.style.display= 'none';
		tablaVerAviones.style.display='none';
		tablaEmpresas.style.display= 'none';
		tablaEliminarAvion.style.display=  'block';
		
		alert("Para poder eliminar un 'avion' es necesario que 'no tenga vuelos asignados'. .\n\nEn ese caso puede optar por:\n\na) Eliminar los vuelos asignados a esa avion.\nb) Modificar los vuelos asignados a ese avion.\n\nEstas opciones estan disponibles desde la accion 'modificar vuelo' del menu.")
		
		
	}
}

//Revisar, el browser marca error en la linea del add value.
function selectAvionesDisponibles(){
	
	var selectRellenar= document.getElementById("selectAvionesDisponibles");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectAviones";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					parseJsonModificar= JSON.parse(xhr.responseText);
					
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							option.value= parseJson[i].id;
							option.appendChild(document.createTextNode("Matricula: "+parseJson[i].matricula+", Capacidad pasajeros:  "+parseJson[i].cantidad_pasajeros));
							selectRellenar.appendChild(option);
					}
					
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}

function selectAvionesDisponiblesModificar(){
	
	var selectRellenar= document.getElementById("modificarSelectAvionesDisponibles");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectAviones";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							option.value= parseJson[i].id;
							option.appendChild(document.createTextNode("Matricula: "+parseJson[i].matricula+", Capacidad pasajeros:  "+parseJson[i].cantidad_pasajeros));
							selectRellenar.appendChild(option);
					}
					
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}


function selectAvionesDisponiblesEliminar(){
	
	var selectRellenar= document.getElementById("selectAvionesDisponiblesEliminar");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectAviones";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					parseJsonModificar= JSON.parse(xhr.responseText);
					
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							option.value= parseJson[i].id;
							option.appendChild(document.createTextNode("id: "+parseJson[i].id+", Matricula: "+parseJson[i].matricula+", Capacidad pasajeros:  "+parseJson[i].cantidad_pasajeros));
							selectRellenar.appendChild(option);
					}
					
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}


function selectVuelosDisponibles(){
	
	var selectRellenar= document.getElementById("selectVuelosDisponibles");
	
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectVuelos";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							option.value= parseJson[i].id;
							option.appendChild(document.createTextNode("id: "+parseJson[i].id+", Usuario: "+parseJson[i].usuario+", Avion:"+parseJson[i].id_avion+", Linea: "+parseJson[i].id_empresa+", Dest: "+parseJson[i].destino+", Esc.: "+parseJson[i].escalas+", Pasaj: "+parseJson[i].pasajes+", F.Sal: "+parseJson[i].salida+", H.Sal: "+parseJson[i].arribo ));
							selectRellenar.appendChild(option);
							
					
					}
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}

function selectEliminarVuelosDisponibles(){
	
	var selectRellenar= document.getElementById("selectEliminarId");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectVuelos";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							option.value= parseJson[i].id;
							option.appendChild(document.createTextNode("id: "+parseJson[i].id+", Usuario: "+parseJson[i].usuario+", Linea: "+parseJson[i].id_empresa+", Dest: "+parseJson[i].destino+", Esc."+parseJson[i].escalas+", Pasaj:"+parseJson[i].pasajes+", F.Salida: "+parseJson[i].salida+", F.Arribo: "+parseJson[i].arribo ));
							selectRellenar.appendChild(option);
							
					
					}
				}
			}
			
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}



function selectEmpresas(){
	
	var selectRellenar= document.getElementById("empresa");
	//var selectRellenarModificar= document.getElementById("modificarEmpresa");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectEmpresas";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);
					
					//Select agregar vuelo
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
							option.value= parseJson[i].id;
							option.appendChild(document.createTextNode(parseJson[i].empresa));
							selectRellenar.appendChild(option);
							
					}
				}
			}
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}


function selectModificarEmpresas(){

	var selectRellenarModificar= document.getElementById("modificarEmpresa");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectEmpresas";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);

					//Select modificar Vuelo
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
						option.value= parseJson[i].id;
						option.appendChild(document.createTextNode(parseJson[i].empresa));
						selectRellenarModificar.appendChild(option);
					}
				}
			}	
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}


function selectEliminarEmpresas(){

	var selectRellenarEliminar= document.getElementById("eliminarEmpresa");
	
	var xhr= new XMLHttpRequest();
	var url= "/Proyecto_Final_AAB/rest/adminVuelos/rellenoSelectEmpresas";

			xhr.onreadystatechange= function(){
				if(this.readyState==4 && this.status== 200){
					
					
					//Resultado en forma de Json
					var datos= xhr.responseText;
					
					parseJson= JSON.parse(xhr.responseText);

					//Select modificar Vuelo
					for(var i=0; i< xhr.responseText.length; i++){
						
						var option = document.createElement("option");
						option.value= parseJson[i].id;
						option.appendChild(document.createTextNode(parseJson[i].id+",  "+parseJson[i].empresa));
						selectRellenarEliminar.appendChild(option);
					}
				}
			}	
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(null);
	
}



