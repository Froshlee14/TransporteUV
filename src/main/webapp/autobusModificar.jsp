<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Fabricante"%>
<%@ page import="modelo.Autobus"%>
<!DOCTYPE html>

<html>

		<head>
			<title>TransporteUV</title>
			<link rel="stylesheet" href="https://unpkg.com/98.css">
			<link rel="stylesheet" type="text/css" href="misEstilos.css" />
		</head>

<body>

	<jsp:useBean id="autobuses" class="modelo.Autobus" scope="request" />
	
	<%
		Autobus autobus = (Autobus) request.getAttribute("autobus");
	%>

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">autobusModificar.jsp</div>
			<div class="title-bar-controls">
				<form action="ServletAutobusLista">
					<button aria-label="Close"></button>
				</form>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletAutobusModificar" method="post" accept-charset="UTF-8">
				
					<fieldset > <legend>Informacion general</legend>
					
						<div class="field-row-stacked">
			    			<input id="numUnidad" type="hidden" name="numUnidad" value="<%=autobus.getNumUnidad()%>">    		
 						</div>
						
						<div class="field-row-stacked">
							<label for="numSerie">Numero de serie:</label>
			    			<input id="numSerie" type="text" maxlength="17" name="numSerie" value="<%=autobus.getNumSerie()%>">    		
 						</div>
 						
 						<%
							@SuppressWarnings("unchecked")
							List<Fabricante> fabricantes = (List<Fabricante>) request.getAttribute("fabricantes");
						%>
 						
 						<div class="field-row">
							<label for="fabricante">Fabricante:</label>
			    			<select id="fabricante" name="idFabricante">
 								<% for (Fabricante f : fabricantes) { %>
            						<option value="<%= f.getIdFabricante() %>" <% if (f.getIdFabricante()==autobus.getIdFabricante()) { %> selected <% } %>>
                						<%= f.getNombreFabricante()%>
            						</option>
        						<% } %>
							</select>  		
 						</div>

						<div class="field-row-stacked">
							<label for="yearFabricacion">Año de fabricacion:</label>
			    			<input id="yearFabricacion" type="number" maxlength="20" name="yearFabricacion" value="<%=autobus.getYearFabricacion()%>">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="capacidad">Capacidad:</label>
			    			<input id="capacidad" type="number" maxlength="20" name="capacidad" value="<%=autobus.getCapacidad()%>">    		
 						</div>
 					
 						<div class="field-row">
							<label for="status">Status:</label>
			    			<select id="status" name="status">
 								<% 
    							boolean status = autobus.getStatus();
    
    							if (status) {
    							    out.println("<option value='true' selected>Activo</option>");
    							    out.println("<option value='false'>Inactivo</option>");
   								}
    							else {
        							out.println("<option value='true'>Activo</option>");
      							  	out.println("<option value='false' selected>Inactivo</option>");
   								}
    							%>
							</select>  		
 						</div>
 				
 					</fieldset>
 					
 					<input type="submit" value="Actualizar datos">
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>