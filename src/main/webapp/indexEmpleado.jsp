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

			Usuario usuario = (Usuario) request.getAttribute("usuario");
        %>
            <p>NumEmpleado <%out.print(usuario.getNumEmpleado()); %> </p>
            <p>Rol <%out.print(usuario.getRol()); %> </p>

    	
	</body>
	
</html>