<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Viaje"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
		<link rel="stylesheet" type="text/css" href="misEstilos.css" />
	</head>

<body>

	<jsp:useBean id="viajes" class="modelo.Viaje" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">viajeListaMonitorear.jsp</div>
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
							<th>Conductor</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Viaje> lista = (List<Viaje>) request.getAttribute("listaExtendida");
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
						<td><%out.print(viaje.getConductor());%></td>
					</tr>
					<%
						}
					}
					else {
						out.print("No existen viajes programados");
					}
					%>

				</table>
			</div>
			
		</div>
	</div>

</body>

</html>