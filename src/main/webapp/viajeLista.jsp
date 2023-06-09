<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Viaje"%>
<!DOCTYPE html>

<html>

<head>
	<title>TransporteUV</title>
	<link rel="stylesheet" href="https://unpkg.com/98.css">

  	<style>
    	tr:hover {
      		background-color: #c3c3c3;
      		cursor: pointer;
    	}
    	tr.selected {
      		background-color: #409ed0;
    	}
  	</style>

</head>

<body>

	<jsp:useBean id="viajes" class="modelo.Viaje" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">viajeLista.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">

			<div class="sunken-panel">
				<table >

					<thead>
						<tr>
						
							<th>No.de viaje</th>
							<th>Direccion</th>
							<th>Hora de partida</th>
							<th>Hora de llegada</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Viaje> lista = (List<Viaje>) request.getAttribute("lista");
					if (lista != null) {
						for (Viaje viaje : lista) {
					%>
					<tr onclick="seleccionarViaje(<%= viaje.getNumViaje() %>,this)">
						<td><%out.print(viaje.getNumViaje());%></td>
						<td><%out.print(viaje.getDireccion());%></td>
						<td><%out.print(viaje.getHoraPartida());%></td>
						<td><%out.print(viaje.getHoraLlegada());%></td>
					</tr>
					<%
						}
					}
					else {
						out.print("No hay nada");
					}
					%>

				</table>
			</div>
			
			<div class="field-row" style="margin-top: 15px;  justify-content: flex-end;">
				<form method="get">
					<label for="numViaje"> </label>
			    	<input id="numViaje" type="hidden" name="numViaje" readonly>    		
 
 					<input id="modificarBtn" type="submit" formaction="ServletViajeBuscar" value="Modificar datos" disabled>
					<input id="borrarBtn" type="submit" formaction="ServletViajeBorrar" value="Borrar viaje" disabled>
    			</form>
    			<form action="viajeAgregar.jsp">
					<input type="submit" value="Nuevo viaje">
    			</form>
			</div>
			
		</div>
	</div>
	
	<script>
		//Evitemos la flojera del usuario para escribir el numero de la ruta
  		function seleccionarViaje(num,row) {
  			
			//Movemos el numero de empleado al input oculto.
	  		var inputNumRuta = document.getElementById("numViaje");
	  		inputNumRuta.value = num;
	  		
	  		//Asimismo los botones estaran desactivados mientras el input este vacio
	  	 	var modificarBtn = document.getElementById("modificarBtn");
	  	  	modificarBtn.disabled = false;
	  	 	
	  	  	var borrarsBtn = document.getElementById("borrarBtn");
	  	  	borrarsBtn.disabled = false;
	  	 	
	        var filas = document.getElementsByTagName("tr");
	        
	        //Quito la propiedad "selected" al resto de columnas
	        for (var i = 0; i < filas.length; i++) {
	          filas[i].classList.remove("selected");
	        }
	        
	        //Cambio el color la columna seleccionada
	       	row.classList.add("selected");
  		}
	</script>

</body>

</html>