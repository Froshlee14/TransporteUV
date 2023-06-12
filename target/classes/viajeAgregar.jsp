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

	<div class="window" style="width: 250px;">

		<div class="title-bar">
			<div class="title-bar-text">viajeAgregar.jsp</div>
			<div class="title-bar-controls">
				<form action="ServletViajeLista">
					<button aria-label="Close"></button>
				</form>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletViajeAgregar" method="post" accept-charset="UTF-8">
			
				<div class="field-row-stacked">
				
					<fieldset > <legend>Informacion general</legend>
						
						<div class="field-row-stacked">
							<label for="direccion">Direccion:</label>
			    			<input id="direccion" type="text" maxlength="100" name="direccion">    		
 						</div>

						<div class="field-row-stacked">
							<label for="horaPartida">Hora de partida:</label>
			    			<input id="horaPartida" type="time" maxlength="20" name="horaPartida">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="horaLlegada">Hora de llegada:</label>
			    			<input id="horaLlegada" type="time" maxlength="20" name="horaLlegada">    		
 						</div>
 					
 					</fieldset>
					
					<input type="submit" value="Agregar viaje">
					
				</div>
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>