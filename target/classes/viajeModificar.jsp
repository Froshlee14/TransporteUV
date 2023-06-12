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
	
	<%
		Viaje viaje = (Viaje) request.getAttribute("viaje");
	%>

	<div class="window" style="width: 250px;">

		<div class="title-bar">
			<div class="title-bar-text">viajeModificar.jsp</div>
			<div class="title-bar-controls">
				<form action="ServletViajeLista">
					<button aria-label="Close"></button>
				</form>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletViajeModificar" method="post" accept-charset="UTF-8">
			
				<div class="field-row-stacked">
				
					<fieldset > <legend>Informacion general</legend>
					
					
						<div class="field-row-stacked">
			    			<input id="numViaje" type="hidden" name="numViaje2" value="<%=viaje.getNumViaje()%>">    		
 						</div>
						
						<div class="field-row-stacked">
							<label for="direccion">Direccion:</label>
			    			<input id="direccion" type="text" maxlength="100" name="direccion" value="<%=viaje.getDireccion()%>">    		
 						</div>

						<div class="field-row-stacked">
							<label for="horaPartida">Hora de partida:</label>
			    			<input id="horaPartida" type="time" maxlength="20" name="horaPartida" value="<%=viaje.getHoraPartida()%>">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="horaLlegada">Hora de llegada:</label>
			    			<input id="horaLlegada" type="time" maxlength="20" name="horaLlegada" value="<%=viaje.getHoraLlegada()%>">    		
 						</div>
 					
 					</fieldset>
					
					<input type="submit" value="Actualizar viaje">
					
				</div>
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>