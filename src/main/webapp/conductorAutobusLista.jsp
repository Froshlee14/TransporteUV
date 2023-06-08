<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Autobus"%>
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

	<jsp:useBean id="conductores" class="modelo.Conductor" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">conductorAutobusLista.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">


			<p> Autobuses asignados </p>
			<div class="sunken-panel">
				<table >

					<thead>
						<tr>
						
							<th>No.de unidad</th>
							<th>No. de serie</th>
							<th>Fabricante</th>
							<th>Año de fabricacion</th>
							<th>Capacidad</th>
							<th>Status</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Autobus> autobusesAsignados = (List<Autobus>) request.getAttribute("autobusesAsignados");
					if (autobusesAsignados != null) {
						for (Autobus autobus : autobusesAsignados) {
					%>
					<tr onclick="seleccionarAutobus(<%= autobus.getNumUnidad() %>,this,false)">
						<td><%out.print(autobus.getNumUnidad());%></td>
						<td><%out.print(autobus.getNumSerie());%></td>
						<td><%out.print(autobus.getFabricante());%></td>
						<td><%out.print(autobus.getYearFabricacion());%></td>
						<td><%out.print(autobus.getCapacidad());%></td>
						<td> 
							<%
							if(autobus.getStatus()){
								out.print("Activo");
							}
							else{
								out.print("Inactivo");
							}
							%>
						</td>
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
			
			
			<div class="field-row" style="margin-top: 15px; margin-bottom: 15px;  justify-content: flex-end;">
				<form method="get">
					<label for="numUnidad"> </label>
			    	<input id="numUnidad" type="text" name="numUnidad" readonly>    		
 
 					<input id="asignarBtn" type="submit" formaction="ServletConductorAutobusAgregar" value="Asignar autobus" disabled>
					<input id="quitarBtn" type="submit" formaction="ServletConductorAutobusBorrar" value="Quitar autobus" disabled>
    			</form>
			</div>
			
			<p> Autobuses sin asignar </p>
			
			<div class="sunken-panel">
				<table >

					<thead>
						<tr>
						
							<th>No.de unidad</th>
							<th>No. de serie</th>
							<th>Fabricante</th>
							<th>Año de fabricacion</th>
							<th>Capacidad</th>
							<th>Status</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Autobus> autobusesNoAsignados = (List<Autobus>) request.getAttribute("autobusesNoAsignados");
					if (autobusesNoAsignados != null) {
						for (Autobus autobus : autobusesNoAsignados) {
					%>
					<tr onclick="seleccionarAutobus(<%= autobus.getNumUnidad() %>,this,true)">
						<td><%out.print(autobus.getNumUnidad());%></td>
						<td><%out.print(autobus.getNumSerie());%></td>
						<td><%out.print(autobus.getFabricante());%></td>
						<td><%out.print(autobus.getYearFabricacion());%></td>
						<td><%out.print(autobus.getCapacidad());%></td>
						<td> 
							<%
							if(autobus.getStatus()){
								out.print("Activo");
							}
							else{
								out.print("Inactivo");
							}
							%>
						</td>
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
			
		</div>
	</div>
	
	<script>
		//Evitemos la flojera del usuario para escribir el numero de empleado
  		function seleccionarAutobus(num,row,agregar) {
  			
			//Movemos el numero de empleado al input oculto.
	  		var inputNumUnidad = document.getElementById("numUnidad");
	  		inputNumUnidad.value = num;
	  		
  	 		var asignarBtn = document.getElementById("asignarBtn");
  	  		var quitarBtn = document.getElementById("quitarBtn");
  	 		
	  		if (agregar){
	  	 		asignarBtn.disabled = false;
	  	 		quitarBtn.disabled = true;
	  		}
	  		else{
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