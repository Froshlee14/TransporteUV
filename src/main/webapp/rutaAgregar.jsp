<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Ruta"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
		<link rel="stylesheet" type="text/css" href="misEstilos.css" />
	</head>

<body>

	<jsp:useBean id="rutas" class="modelo.Ruta" scope="request" />

	<div class="window" style="width: 400px;">

		<div class="title-bar">
			<div class="title-bar-text">rutaAgregar.jsp</div>
			<div class="title-bar-controls">
				<form action="ServletRutaLista">
					<button aria-label="Close"></button>
				</form>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletRutaAgregar" method="post" accept-charset="UTF-8">
			
				<div class="field-row-stacked">
				
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