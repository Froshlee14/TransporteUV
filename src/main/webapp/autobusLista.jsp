<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Autobus"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
		<link rel="stylesheet" type="text/css" href="misEstilos.css" />
	</head>

<body>

	<jsp:useBean id="conductores" class="modelo.Conductor" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">autobusLista.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">

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
					List<Autobus> lista = (List<Autobus>) request.getAttribute("lista");
					if (lista != null) {
						for (Autobus autobus : lista) {
					%>
					<tr onclick="seleccionarAutobus(<%= autobus.getNumUnidad() %>,this)">
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
			
			<div class="field-row" style="margin-top: 15px;  justify-content: flex-end;">
				<form method="get">
					<label for="numUnidad"> </label>
			    	<input id="numUnidad" type="hidden" name="numUnidad" readonly>    		
 
 					<input id="verRutasBtn" type="submit" formaction="ServletAutobusRutaLista" value="Ver rutas" disabled>
 					<input id="modificarBtn" type="submit" formaction="ServletAutobusBuscar" value="Modificar datos" disabled>
					<input id="borrarBtn" type="submit" formaction="ServletAutobusBorrar" value="Borrar autobus" disabled>
    			</form>
    			<form action="ServletAutobusPreparar">
					<input type="submit" value="Nuevo autobus">
    			</form>
			</div>
			
		</div>
	</div>
	
	<script>
		//Evitemos la flojera del usuario para escribir el numero de empleado
  		function seleccionarAutobus(num,row) {
  			
			//Movemos el numero de empleado al input oculto.
	  		var inputNumEmpleado = document.getElementById("numUnidad");
	  		inputNumEmpleado.value = num;
	  		
	  		//Asimismo los botones estaran desactivados mientras el input este vacio
	  	 	var modificarBtn = document.getElementById("modificarBtn");
	  	  	modificarBtn.disabled = false;
	  	  	
	  	  	var verContactosBtn = document.getElementById("verRutasBtn");
	  	 	verContactosBtn.disabled = false;
	  	 	
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