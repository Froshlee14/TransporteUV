<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Fabricante"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
		<link rel="stylesheet" type="text/css" href="misEstilos.css" />
	</head>

<body>

	<jsp:useBean id="autobus" class="modelo.Autobus" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">autobusAgregar.jsp</div>
			<div class="title-bar-controls">
				<form action="ServletAutobusLista">
					<button aria-label="Close"></button>
				</form>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletAutobusAgregar" method="post" accept-charset="UTF-8">
				
					<fieldset > <legend>Informacion general</legend>
						
						<div class="field-row-stacked">
							<label for="numSerie">Numero de serie:</label>
			    			<input id="numSerie" type="text" maxlength="17" name="numSerie">    		
 						</div>
 						
 						<%
							@SuppressWarnings("unchecked")
							List<Fabricante> fabricantes = (List<Fabricante>) request.getAttribute("fabricantes");
						%>
 						
 						<div class="field-row">
							<label for="fabricante">Fabricante:</label>
			    			<select id="fabricante" name="fabricante">
			    				<% for (Fabricante fabricante : fabricantes) { %>
        							<option value="<%= fabricante.getIdFabricante() %>"> <%= fabricante.getNombreFabricante() %> </option>
        						<% } %>
							</select>  		
 						</div>

						<div class="field-row-stacked">
							<label for="yearFabricacion">Año de fabricacion:</label>
			    			<input id="yearFabricacion" type="number" maxlength="20" name="yearFabricacion">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="capacidad">Capacidad:</label>
			    			<input id="capacidad" type="number" maxlength="20" name="capacidad">    		
 						</div>
 					
 						<div class="field-row">
							<label for="status">Status:</label>
			    			<select id="status" name="status">
  								<option value="true">Activo</option>
  								<option value="false">Inactivo</option>
							</select>  		
 						</div>
 				
 					</fieldset>
 					
 					<input type="submit" value="Agregar autobus">
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>