<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Conductor"%>
<!DOCTYPE html>

<html>

<head>
	<title>TransporteUV</title>
	<link rel="stylesheet" href="https://unpkg.com/98.css">
	<link rel="stylesheet" type="text/css" href="misEstilos.css" />
</head>

<body>

	<jsp:useBean id="conductores" class="modelo.Conductor" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">conductorAgregar.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletConductorAgregar" method="post" accept-charset="UTF-8">
			
				<div class="field-row">
				
					<fieldset > <legend>Informacion general</legend>
						
						<div class="field-row-stacked">
							<label for="nombre">Nombre:</label>
			    			<input id="nombre" type="text" maxlength="30" name="nombre">    		
 						</div>

						<div class="field-row-stacked">
							<label for="apPaterno">Apellido paterno:</label>
			    			<input id="apPaterno" type="text" maxlength="30" name="apellidoPaterno">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="apMaterno">Apellido materno:</label>
			    			<input id="apMaterno" type="text" maxlength="30" name="apellidoMaterno">    		
 						</div>
 					
 						 <div class="field-row-stacked">
							<label for="dir">Direccion:</label>
			    			<input id="dir" type="text" maxlength="120" name="direccion">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="tel">No. de telefono:</label>
			    			<input id="tel" type="text" maxlength="10" name="telefono">    		
 						</div>
 						
  						<div class="field-row" style="margin-TOP: 15px;">
							<label for="bday">Fecha de nacimiento:</label>
			    			<input id="bday" type="date" name="birthday" value="2000-04-11">		   		
 						</div>
 				
 					</fieldset>
 					
 					<div class="field-row-stacked">
 					
 					<fieldset > <legend>Informacion laboral</legend>
 					
 						<div class="field-row">
							<label for="aExp">Años de experiencia:</label>
			    			<input id="aExp" type="number" name="yearsExp">    		
 						</div>
 						
 						<div class="field-row">
							<label for="fContrato">Fecha de contratacion:</label>
			    			<input id="fContrato" type="date" name="fechaContrato" value="2018-07-22">		
 						</div>
 						
					</fieldset>
					 <fieldset> <legend>Informacion de usuario</legend>
 					
 						<div class="field-row-stacked">
							<label for="nomUsuario">Nombre de usuario:</label>
			    			<input id="nomUsuario" type="text" maxlength="8" name="usuario">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="pass">Contraseña:</label>
			    			<input id="pass" type="text" maxlength="6" name="password">    		
 						</div>
 						
 						<div class="field-row">
							<label for="stat">Status:</label>
			    			<select id="stat" name="status">
  								<option>Activo</option>
  								<option>Inactivo</option>
							</select>  		
 						</div>
 						
					</fieldset>
					
					<input type="submit" value="Agregar conductor">
					</div>
					
				</div>
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>