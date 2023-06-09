<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Conductor"%>
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
			<div class="title-bar-text">conductorLista.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">

			<div class="sunken-panel">
				<table >

					<thead>
						<tr>
						
							<th>No.de empleado</th>
							<th>Nombre</th>
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<th>Fecha de nacimiento</th>
							<th>Fecha de contrato</th>
							<th>Direccion</th>
							<th>Telefono</th>
							<th>Status</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Conductor> lista = (List<Conductor>) request.getAttribute("lista");
					if (lista != null) {
						for (Conductor conductor : lista) {
					%>
					<tr onclick="seleccionarEmpleado(<%= conductor.getNumEmpleado() %>,this)">
						<td><%out.print(conductor.getNumEmpleado());%></td>
						<td><%out.print(conductor.getNombre());%></td>
						<td><%out.print(conductor.getApellidoPaterno());%></td>
						<td><%out.print(conductor.getApellidoMaterno());%></td>
						<td><%out.print(conductor.getBirthday());%></td>
						<td><%out.print(conductor.getFechaContrato());%></td>
						<td><%out.print(conductor.getDireccion());%></td>
						<td><%out.print(conductor.getTelefono());%></td>
						<td> 
							<%
							if(conductor.getStatus()){
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
					<label for="usuario"> </label>
			    	<input id="usuario" type="hidden" name="numEmpleado" readonly>    		
 
 					<input id="verContactosBtn" type="submit" formaction="ServletContactoLista" value="Ver contactos" disabled>
					<input id="verAutobusesBtn" type="submit" formaction="ServletConductorAutobusLista" value="Ver autobuses" disabled>
 					<input id="modificarBtn" type="submit" formaction="ServletConductorBuscar" value="Modificar datos" disabled>
					<input id="borrarBtn" type="submit" formaction="ServletConductorBorrar" value="Borrar conductor" disabled>
    			</form>
    			<form action="conductorAgregar.jsp">
					<input type="submit" value="Nuevo conductor">
    			</form>
			</div>
			
		</div>
		
	</div>
	
	<script>
		//Evitemos la flojera del usuario para escribir el numero de empleado
  		function seleccionarEmpleado(num,row) {
  			
			//Movemos el numero de empleado al input oculto.
	  		var inputNumEmpleado = document.getElementById("usuario");
	  		inputNumEmpleado.value = num;
	  		
	  		//Asimismo los botones estaran desactivados mientras el input este vacio
	  	 	var modificarBtn = document.getElementById("modificarBtn");
	  	  	modificarBtn.disabled = false;
	  	  	
	  	  	var verContactosBtn = document.getElementById("verContactosBtn");
	  	 	verContactosBtn.disabled = false;
	  	 	
	  	  	var verAutobusesBtn = document.getElementById("verAutobusesBtn");
	  	  	verAutobusesBtn.disabled = false;
	  	 	
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