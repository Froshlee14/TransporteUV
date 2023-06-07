<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.ContactoEmergencia"%>
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

	<jsp:useBean id="conductores" class="modelo.ContactoEmergencia" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">contactoLista.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">
			
			<% Conductor conductor = (Conductor) request.getAttribute("conductor"); %>
			<p> Contactos de emergencia de <%out.print(conductor.getNombre());%> <p>
			
			<div class="sunken-panel">
				<table class="interactive">

					<thead>
						<tr>
							<th>No. de contacto</th>
							<th>Nombre</th>
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<th>Direccion</th>
							<th>Telefono</th>
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<ContactoEmergencia> lista = (List<ContactoEmergencia>) request.getAttribute("lista");
					if (lista != null) {
						for (ContactoEmergencia contacto : lista) {
					%>
					<tr onclick="seleccionarContacto(<%= contacto.getNumContacto() %>,this)">
						<td><%out.print(contacto.getNumContacto());%></td>
						<td><%out.print(contacto.getNombre());%></td>
						<td><%out.print(contacto.getApellidoPaterno());%></td>
						<td><%out.print(contacto.getApellidoMaterno());%></td>
						<td><%out.print(contacto.getDireccion());%></td>
						<td><%out.print(contacto.getTelefono());%></td>

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
					<label for="numContacto"> </label>
			    	<input id="numContacto" type="hidden" name="numContacto" readonly>    		
 
 					<input id="modificarBtn" type="submit" formaction="ServletContactoBuscar" value="Modificar contacto" disabled>
					<input id="borrarBtn" type="submit" formaction="ServletContactoBorrar" value="Borrar contacto" disabled>
    			</form>
    			<form action="contactoAgregar.jsp">
    				<input type="hidden" name="numEmpleado" value="<%= conductor.getNumEmpleado() %>">
					<input type="submit" value="Nuevo contacto">
    			</form>
			</div>
			
		</div>
	</div>
	
	<script>
		//Evitemos la flojera del usuario para escribir el numero del contacto
  		function seleccionarContacto(num,row) {
  			
			//Movemos el numero de contacto al input oculto.
	  		var inputNumContacto = document.getElementById("numContacto");
	  		inputNumContacto.value = num;
	  		
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