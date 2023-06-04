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
        <div class="window" style="width: 300px">
        
          	<div class="title-bar">
    			<div class="title-bar-text">indexEmplaedo.jsp</div>
    			<div class="title-bar-controls">
     				<button aria-label="Close"></button>
   				</div>
  			</div>

        	<div class="window-body">
            	<p>Bienvenido al sistema de administrador </p>
            	<p> ¿Que accion quieres realizar? </p>
            
            	<form action="ServletConductorLista" method="get">
        			<input type="submit" name="updateData" value="Ver conductores">
    			</form>
    		
    			<form action="ServletAutobusLista" method="get">
        			<input type="submit" name="updateData" value="Ver autobuses">
    			</form>
    		
    			<form action="ServletViajeLista" method="get">
        			<input type="submit" name="updateData" value="Ver viajes">
    			</form>
    			
    			<form action="ServletRutaLista" method="get">
        			<input type="submit" name="updateData" value="Ver rutas">
    			</form>
    			
    			<form action="ServletUsuarioModificar" method="get">
        			<input type="submit" name="updateData" value="Cambiar contraseña">
    			</form>
			</div>
			
    	</div>
	</body>
	
</html>