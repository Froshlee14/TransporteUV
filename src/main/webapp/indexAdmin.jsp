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
			Usuario usuario = (Usuario) request.getAttribute("usuario");
        %>
        <div class="window" style="width: 200px">
        
          	<div class="title-bar">
    			<div class="title-bar-text">indexEmplaedo.jsp</div>
    			<div class="title-bar-controls">
     				<button aria-label="Close"></button>
   				</div>
  			</div>

        	<div class="window-body">
            	<p>Bienvenido al sistema de administrador </p>
            	
            	<fieldset > <legend> ¿Que accion quieres realizar?  </legend>
            
            	<div class="field-row-stacked">
            	
            	<form action="ServletConductorLista" method="get">
        			<input type="submit" name="updateData" value="Administrar conductores" style="width: 100%">
    			</form>
    		
    			<form action="ServletAutobusLista" method="get">
        			<input type="submit" name="updateData" value="Administrar autobuses" style="width: 100%">
    			</form>
    		
    			<form action="ServletViajeLista" method="get">
        			<input type="submit" name="updateData" value="Administrar viajes" style="width: 100%">
    			</form>
    			
    			<form action="ServletRutaLista" method="get">
        			<input type="submit" name="updateData" value="Administrar rutas" style="width: 100%">
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