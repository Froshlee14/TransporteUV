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
  	</style>

</head>

<body>

	<jsp:useBean id="viajes" class="modelo.Viaje" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">viajeListaEmpleado.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">
			
			<p> Estos son tus viajes </p>

			<div class="sunken-panel">
				<table >

					<thead>
						<tr style="margin: 5px;">
						
							<th>No.de viaje</th>
							<th>Direccion</th>
							<th>Hora de partida</th>
							<th>Hora de llegada</th>
							<th>Ruta</th>
							<th>No. de autobus</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Viaje> lista = (List<Viaje>) request.getAttribute("lista");
					if (lista != null) {
						for (Viaje viaje : lista) {
					%>
					<tr>
						<td><%out.print(viaje.getNumViaje());%></td>
						<td><%out.print(viaje.getDireccion());%></td>
						<td><%out.print(viaje.getHoraPartida());%></td>
						<td><%out.print(viaje.getHoraLlegada());%></td>
						<td><%out.print(viaje.getRuta());%></td>
						<td><%out.print(viaje.getNumAutobus());%></td>
					</tr>
					<%
						}
					}
					else {
						out.print("No tienes viajes asignados");
					}
					%>

				</table>
			</div>
			
		</div>
	</div>

</body>

</html>