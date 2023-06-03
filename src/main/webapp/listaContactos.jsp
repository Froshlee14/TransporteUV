<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.ContactoEmergencia"%>
<!DOCTYPE html>

<html>

<head>
<title>TransporteUV</title>
<link rel="stylesheet" href="https://unpkg.com/98.css">
</head>

<body>

	<jsp:useBean id="conductores" class="modelo.ContactoEmergencia" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">listaContactos.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">
			
			<% String conductor = (String) request.getAttribute("nombreEmpleado"); %>
			<p> Contactos de emergencia de <%out.print(conductor);%> <p>
			
			<div class="sunken-panel">
				<table class="interactive">

					<thead>
						<tr>
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
					<tr>
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
			
			<p> ¿Que accion desea realizar? <p>
			
			 <div class="field-row">

				<form action="ServletConductor" method="get">
        			<input type="submit" name="updateData" value="Nuevo contacto">
    			</form>
    			<form action="ServletConductor" method="get">
        			<input type="submit" name="updateData" value="Borrar conductor">
    			</form>
			</div>
			
		</div>
	</div>

</body>

</html>