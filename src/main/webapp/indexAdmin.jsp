<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
		<link rel="stylesheet" type="text/css" href="misEstilos.css" />
	</head>
	
	<body>
	
	<jsp:useBean id="usuarios" class="modelo.Usuario" scope="request"/>
      	
      	<%
			Usuario usuario = (Usuario) request.getAttribute("usuario");
        %>
        <div class="window" style="width: 300px">
        
          	<div class="title-bar">
    			<div class="title-bar-text">indexAdmin.jsp</div>
    			<div class="title-bar-controls">
					<form action="index.jsp">
						<button aria-label="Close"></button>
					</form>
   				</div>
  			</div>

		<div class="window-body">
			<p>Bienvenido a TransporteUV</p>

			<fieldset>
				<legend> ¿Que accion quieres realizar? </legend>

				<div class="field-row-stacked">

					<form action="ServletConductorLista" method="get">
						<input type="submit" value="Administrar conductores" style="width: 100%">
					</form>

					<form action="ServletAutobusLista" method="get">
						<input type="hidden" name="rol" value="administrador">
						<input type="submit" value="Administrar autobuses" style="width: 100%">
					</form>

					<form action="ServletViajeLista" method="get">
						<input type="hidden" name="rol" value="administrador">
						<input type="submit" value="Administrar viajes" style="width: 100%">
					</form>

					<form action="ServletRutaLista" method="get">
						<input type="hidden" name="rol" value="administrador">
						<input type="submit" value="Administrar rutas" style="width: 100%">
					</form>

				</div>

			</fieldset>

			<!--     			<form action="ServletUsuarioModificar" method="get"> -->
			<!--         			<input type="submit" name="updateData" value="Cambiar contraseña" style="width: 100%"> -->
			<!--     			</form> -->
		</div>

	</div>
	</body>
	
</html>