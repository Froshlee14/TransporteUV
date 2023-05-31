<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
	</head>
	
	<body>
	
		<h2>Bienvenido al sistema de TransporteUV</h2>
		
		<p> Selecciones su tipo de usuario: </p>
		
		<div>
			<form action="ServletConductor" method="get">
        		<input type="submit" name="loginEmpleado" value="Soy Empleado">
    		</form>
    	
    		<form action="/loginAdmin.jsp" method="post">
        		<input type="submit" name="loginEmpleado" value="Soy Administrador">
    		</form>
    	</div>
	</body>
	
</html>