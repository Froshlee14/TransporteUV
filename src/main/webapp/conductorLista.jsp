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
					<tr onclick="seleccionarEmpleado('<%= conductor.getNumEmpleado() %>')">
						<td> <%out.print(conductor.getNumEmpleado());%> </td>
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
					<label for="usuario">No. de empleado:</label>
			    	<input id="usuario" type="number" name="numEmpleado" value="">    		
 
 					<input type="submit" formaction="ServletContactoModificar" value="Modificar datos">
					<input type="submit" formaction="ServletContactoLista" value="Ver contactos">
    			</form>
    			<form action="conductorAgregar.jsp">
					<input type="submit" value="Nuevo conductor">
    			</form>
			</div>
			
		</div>
	</div>

</body>

</html>