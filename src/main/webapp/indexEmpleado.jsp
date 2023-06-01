<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
	</head>
	
	<body>
	
	<jsp:useBean id="usuarios" class="modelo.Usuario" scope="request"/>
      	
      	<%
      		String nomEmpleado = (String) request.getAttribute("nombreEmpleado");
			Usuario usuario = (Usuario) request.getAttribute("usuario");
        %>
            <p>Bienvenid@ <%out.print(nomEmpleado); %> </p>
            <p> ¿Que accion quieres realizar? </p>
            
            <form action="ServletActualizarConductor" method="post">
        		<input type="submit" name="updateData" value="Actualizar mis información">
    		</form>
    		
    		<form action="ServletCambiarPassword" method="post">
        		<input type="submit" name="updateData" value="Cambiar mi contraseña">
    		</form>
    		
    		<form action="ServletCambiarPassword" method="post">
        		<input type="submit" name="updateData" value="Ver mis autobuses">
    		</form>
    		
    		<form action="ServletCambiarPassword" method="post">
        		<input type="submit" name="updateData" value="Ver mis viajes">
    		</form>

    	
	</body>
	
</html>