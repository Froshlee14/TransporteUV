<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Ruta"%>
<!DOCTYPE html>

<html>

<head>
	<title>TransporteUV</title>
	<link rel="stylesheet" href="https://unpkg.com/98.css">
</head>

<body>

	<jsp:useBean id="conductores" class="modelo.Conductor" scope="request" />
	
		<%
		Ruta ruta = (Ruta) request.getAttribute("ruta");
		%>

	<div class="window" style="width: 400px;">

		<div class="title-bar">
			<div class="title-bar-text">rutaModificar.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletRutaModificar" method="post" accept-charset="UTF-8">
			
				<div class="field-row-stacked">
				
					<fieldset > <legend>Informacion general</legend>
					
						<div class="field-row-stacked">
			    			<input id="numRuta" type="hidden" name="numRuta" value="<%=ruta.getNumRuta()%>">    		
 						</div>
						
						<div class="field-row-stacked">
							<label for="descripcion">Descripcion:</label>
			    			<input id="descripcion" type="text" maxlength="100" name="descripcion" value="<%=ruta.getDescripcion()%>">    		
 						</div>

						<div class="field-row-stacked">
							<label for="destinoInicial">Destino inicial:</label>
			    			<input id="destinoInicial" type="text" maxlength="50" name="destinoInicial" value="<%=ruta.getDestinoInicial()%>">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="destinoFinal">Destino Final:</label>
			    			<input id="destinoFinal" type="text" maxlength="50" name="destinoFinal" value="<%=ruta.getDestinoFinal()%>">    		
 						</div>
 					
 					</fieldset>
					
					<input type="submit" value="Modificar ruta">
					
				</div>
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>