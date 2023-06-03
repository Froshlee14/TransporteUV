<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Conductor"%>
<!DOCTYPE html>

<html>

<head>
<title>TransporteUV</title>
<link rel="stylesheet" href="https://unpkg.com/98.css">
</head>

<body>

	<jsp:useBean id="conductores" class="modelo.Conductor" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">listaConductores.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">

			 <div class="field-row" style="margin-bottom: 20px;">
			 
			 	<label for="numEmpleado">No.de empleado </label>
			    <input id="numEmpleado" type="text" name="inputNumEmpleado"> 
			    
			    <form action="ServletContactoLista" method="get">
			    	<input type="hidden" name="inputNumEmpleado" value="<%= request.getParameter("inputNumEmpleado") %>">
					<input type="submit" name="updateData" value="Modificar datos">
				</form>
			    
			    <form action="ServletContactoLista" method="get">
			   	 <input type="hidden" name="inputNumEmpleado" value="<%= request.getParameter("inputNumEmpleado") %>">
					<input type="submit" name="updateData" value="Ver contactos">
				</form>
				
				<form action="ServletConductor" method="get">
					<input type="hidden" name="inputNumEmpleado" value="<%= request.getParameter("inputNumEmpleado") %>">
        			<input type="submit" name="updateData" value="Borrar conductor">
    			</form>
    			
			</div>

			<div class="sunken-panel">
				<table class="interactive">

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
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Conductor> lista = (List<Conductor>) request.getAttribute("lista");
					if (lista != null) {
						for (Conductor conductor : lista) {
					%>
					<tr>
						<td><%out.print(conductor.getNumEmpleado());%></td>
						<td><%out.print(conductor.getNombre());%></td>
						<td><%out.print(conductor.getApellidoPaterno());%></td>
						<td><%out.print(conductor.getApellidoMaterno());%></td>
						<td><%out.print(conductor.getBirthday());%></td>
						<td><%out.print(conductor.getFechaContrato());%></td>
						<td><%out.print(conductor.getDireccion());%></td>
						<td><%out.print(conductor.getTelefono());%></td>
						<td>

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
				
			 <div class="field-row" style="margin-top: 20px; justify-content: flex-end;">
				<form action="ServletContactoLista" method="get">
        			<input type="submit" name="updateData" value="Nuevo conductor">
    			</form>
			</div>
			
		</div>
	</div>

</body>

</html>