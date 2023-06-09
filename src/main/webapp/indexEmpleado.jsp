<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
	</head>
	
	<body>
	
	<jsp:useBean id="usuarios" class="modelo.Usuario" scope="request"/>
      	
      	<%
      		String nomEmpleado = (String) request.getAttribute("nombreEmpleado");
			Usuario usuario = (Usuario) request.getAttribute("usuario");
        %>
        <div class="window" style="width: 300px">
        
          	<div class="title-bar">
    			<div class="title-bar-text">indexEmplaedo.jsp</div>
    			<div class="title-bar-controls">
     				<button aria-label="Close"></button>
   				</div>
  			</div>

        	<div class="window-body">
            	<p>Bienvenid@ <%out.print(nomEmpleado); %> </p>

				<fieldset>
					<legend> ¿Que accion quieres realizar? </legend>

				<!--     			<form action="ServletAutobusListaEmpleado" method="post"> -->
				<!--         			<input type="submit" name="updateData" value="Ver autobuses"> -->
				<!--     			</form> -->
					<div class="field-row-stacked">

					<form action="ServletViajeListaEmpleado" method="post">
						<input type="submit" name="updateData" value="Ver mis viajes" style="width: 100%">
					</form>

					<form action="ServletConductorModificarEmpleado" method="post">
						<input type="submit" name="updateData" value="Actualizar información" style="width: 100%">
					</form>

					<form action="ServletUsuarioModificar" method="post">
						<input type="submit" name="updateData" value="Cambiar contraseña" style="width: 100%">
					</form>
					
					</div>

				</fieldset>

			</div>
			
    	</div>
	</body>
	
</html>