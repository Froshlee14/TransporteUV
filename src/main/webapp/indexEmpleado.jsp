<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Conductor" %>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
	</head>
	
	<body>
	
	<jsp:useBean id="usuarios" class="modelo.Usuario" scope="request"/>
      	
      	<%
			Conductor conductor = (Conductor) request.getAttribute("conductor");
        %>
        <div class="window" style="width: 300px">
        
          	<div class="title-bar">
    			<div class="title-bar-text">indexEmplaedo.jsp</div>
    			<div class="title-bar-controls">
     				<button aria-label="Close"></button>
   				</div>
  			</div>

        	<div class="window-body">
            	<p>Bienvenid@ <% out.println(conductor.getNombre()); %> </p>

				<fieldset>
					<legend> ¿Que accion quieres realizar? </legend>

					<div class="field-row-stacked">

					<form action="ServletViajeListaEmpleado" method="get">
						<input type="hidden" name="numEmpleado" value="<%= conductor.getNumEmpleado() %>">
						<input type="submit" value="Ver mis viajes" style="width: 100%">
					</form>
					
					<form action="ServletAutobusListaEmpleado" method="get">
						<input type="hidden" name="numEmpleado" value="<%= conductor.getNumEmpleado() %>">
						<input type="submit" value="Ver mis autobuses" style="width: 100%">
					</form>

					<form action="ServletConductorBuscarEmpleado" method="get">
						<input type="hidden" name="numEmpleado" value="<%= conductor.getNumEmpleado() %>">
						<input type="submit" value="Actualizar información" style="width: 100%">
					</form>
					
					</div>

				</fieldset>

			</div>
			
    	</div>
	</body>
	
</html>