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
			<div class="title-bar-text">rutaAgregar.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletRutaAgregar" method="post" accept-charset="UTF-8">
			
				<div class="field-row">
				
					<fieldset > <legend>Informacion general</legend>
						
						<div class="field-row-stacked">
							<label for="descripcion">Descripcion:</label>
			    			<input id="descripcion" type="text" maxlength="100" name="descripcion">    		
 						</div>

						<div class="field-row-stacked">
							<label for="destinoInicial">Destino inicial:</label>
			    			<input id="destinoInicial" type="text" maxlength="50" name="destinoInicial">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="destinoFinal">Destino Final:</label>
			    			<input id="destinoFinal" type="text" maxlength="50" name="destinoFinal">    		
 						</div>
 					
 					</fieldset>
					
					<input type="submit" value="Agregar ruta">
					
				</div>
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>