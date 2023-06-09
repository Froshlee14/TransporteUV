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
			<div class="title-bar-text">rutaViajeLista.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">
		
			<p> Viajes asignados </p>

			<div class="sunken-panel">
				<table >

					<thead>
						<tr>
						
							<th>No.de viaje</th>
							<th>Direccion</th>
							<th>Hora de parida</th>
							<th>Hora de llegada</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Viaje> viajesAsignadosLista = (List<Viaje>) request.getAttribute("viajesAsignadosLista");
					if (viajesAsignadosLista != null) {
						for (Viaje viaje : viajesAsignadosLista) {
					%>
					<tr onclick="seleccionarViaje(<%= viaje.getNumViaje() %>,this,false)">
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
			    	<input id="numViajeQuitar" type="hidden" name="numViajeQuitar" readonly>
			    	<input id="numRuta" type="hidden" name="numRuta" value="<%=request.getAttribute("numRuta")%>" readonly>   	
			    	
 
					<input id="quitarBtn" type="submit" formaction="ServletRutaViajeBorrar" value="Quitar viaje" disabled>
    			</form>
			</div>
			
			<p> Viajes no asignados </p>
			
			<div class="sunken-panel">
				<table >

					<thead>
						<tr>
						
							<th>No.de viaje</th>
							<th>Direccion</th>
							<th>Hora de parida</th>
							<th>Hora de llegada</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Viaje> viajesNoAsignadosLista = (List<Viaje>) request.getAttribute("viajesNoAsignadosLista");
					if (viajesNoAsignadosLista != null) {
						for (Viaje viaje : viajesNoAsignadosLista) {
					%>
					<tr onclick="seleccionarViaje(<%= viaje.getNumViaje() %>,this,true)">
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
				<form method="post">
			    	<input id="numViajeAgregar" type="hidden" name="numViajeAgregar" readonly>    		
 					<input id="numRuta" type="hidden" name="numRuta" value="<%=request.getAttribute("numRuta")%>" readonly>   	
 
 					<input id="asignarBtn" type="submit" formaction="ServletRutaViajeAgregar" value="AsignarViaje" disabled>
    			</form>
			</div>
			
		</div>
	</div>
	
	<script>
		//Evitemos la flojera del usuario para escribir el numero de la ruta
  		function seleccionarViaje(num,row,agregar) {
  			
			//Movemos el numero de empleado al input oculto.
	  		var inputNumViajeQuitar = document.getElementById("numViajeQuitar");
	  		var inputNumViajeAgregar = document.getElementById("numViajeAgregar");
	  		
	  		//Asimismo los botones estaran desactivados mientras el input este vacio
  	 		var asignarBtn = document.getElementById("asignarBtn");
  	  		var quitarBtn = document.getElementById("quitarBtn");
	  	 	
	  	  	if (agregar){
	  	  		inputNumViajeAgregar.value = num;
	  	 		asignarBtn.disabled = false;
	  	 		quitarBtn.disabled = true;
	  	  	}
	  	  	else{
	  	  		inputNumViajeQuitar.value = num;
	  			asignarBtn.disabled = true;
	  	 		quitarBtn.disabled = false;
	  	  	}
	  	 	
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