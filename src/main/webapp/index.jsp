<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
	</head>
	
	<body>

		<img src="logo.png" width="200px"/>
		
		<div>
			<form action="ServletLogin" method="post">
			
				<label for="usuario">Usuario:</label><br>
			    <input type="text" id="usuario" name="inputUsuario"> <br>
			    
			    <label for="password">Contraseña:</label><br>
			    <input type="text" id="password" name="inputPassword"> <br>
			    
        		<input type="submit" name="loginBoton" value="Iniciar Sesion">
    		</form>
    	</div>
	</body>
	
</html>