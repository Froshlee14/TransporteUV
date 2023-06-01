<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
	</head>
	
	<body>

		<img src="logo.png" width="200px"/>
		
		<div>
			<form action="/ServletLogin" method="post">
			
				<label for="usuario">Usuario:</label><br>
			    <input type="text" id="usuario" name="loginUsuario"> <br>
			    
			    <label for="passwrd">Contraseña:</label><br>
			    <input type="text" id="passwrd" name="loginPassword"> <br>
			    
        		<input type="submit" name="loginBoton" value="Iniciar Sesion">
    		</form>
    	</div>
	</body>
	
</html>