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
				<table class="interactive">

					<thead>
						<tr>
							<th>Numero de empleado</th>
							<th>Nombre</th>
							<th>Apellido Paterno</th>
							<th>Apellido Materno</th>
							<th>Contactos de emergencia</th>
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
						<td>
							<form action="ServletEjemplo" method="POST">
								<input type="hidden" name="<%=conductor.getNumEmpleado()%>"
									value="valor2">
								<button type="submit">Ver contactos</button>
							</form>
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
			
			<p> ¿Que accion desea realizar? <p>
			
			 <div class="field-row">
				<form action="ServletConductor" method="get">
        			<input type="submit" name="updateData" value="Nuevo conductor">
    			</form>
    			<form action="ServletConductor" method="get">
        			<input type="submit" name="updateData" value="Borrar conductor">
    			</form>
			</div>
			
		</div>
	</div>

</body>

</html>