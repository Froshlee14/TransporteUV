<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
	</head>
	
	<body>

		
		
		<div  class="window" style="width: 250px; margin: 32px; ">
			<div class="title-bar">
    			<div class="title-bar-text">index.jsp</div>
    			<div class="title-bar-controls">
     				<button aria-label="Close"></button>
   				</div>
  			</div>
  			
  			<img src="logo2.png" style="width: 100%"/>
  			
  			<div class="window-body">
			<form action="ServletLogin" method="post">
			
				<div class="field-row-stacked">
			
				<div class="field-row-stacked" style="width: 100%">
					<label for="usuario">Usuario:</label>
			    	<input id="usuario" type="text" name="inputUsuario"> 
			    </div>
			    
			    <div class="field-row-stacked" style="width: 100%">
			    	<label for="password">Contraseña:</label>
			    	<input id="password" type="password" name="inputPassword"> 
			    </div>
			    
				<%
				String mensaje = (String) request.getAttribute("mensaje");
				if (mensaje != null && !mensaje.isEmpty()) {
				%>
    				<p><%= mensaje %></p>
				<% } %>

        		<input type="submit" name="loginBoton" value="Iniciar Sesion">
        		
        		</div>
        		
    		</form>
    		</div>
    	</div>
	</body>
	
</html>