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
  	</style>

</head>

<body>

	<jsp:useBean id="conductores" class="modelo.Conductor" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">autobusListaEmpleado.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">

			<p> Tus autobuses asignados</p>
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
					<tr>
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

</body>

</html>