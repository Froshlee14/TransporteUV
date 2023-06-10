<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Conductor"%>
<%@ page import="modelo.Usuario"%>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
		<link rel="stylesheet" href="https://unpkg.com/98.css">
		<link rel="stylesheet" type="text/css" href="misEstilos.css" />
	</head>

<body>

	<jsp:useBean id="conductores" class="modelo.Conductor" scope="request" />
	<%
		Conductor conductor = (Conductor) request.getAttribute("conductor");
		Usuario usuario = (Usuario) request.getAttribute("usuario");
	%>

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">conductorModificar.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">
			
			<form action="ServletConductorModificar" method="post" accept-charset="UTF-8">
			
				<div class="field-row">
				
					<fieldset > <legend>Informacion general</legend>
					
						<input id="numEmpleado" type="hidden" maxlength="30" name="numEmpleado" value="<%=conductor.getNumEmpleado()%>">	
				
						<div class="field-row-stacked">
							<label for="nombre">Nombre:</label>
			    			<input id="nombre" type="text" maxlength="30" name="nombre" value="<%=conductor.getNombre()%>">	
 						</div>

						<div class="field-row-stacked">
							<label for="apPaterno">Apellido paterno:</label>
			    			<input id="apPaterno" type="text" maxlength="30" name="apellidoPaterno" value="<%=conductor.getApellidoPaterno()%>">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="apMaterno">Apellido materno:</label>
			    			<input id="apMaterno" type="text" maxlength="30" name="apellidoMaterno" value="<%=conductor.getApellidoMaterno()%>">    		
 						</div>
 					
 						 <div class="field-row-stacked">
							<label for="dir">Direccion:</label>
			    			<input id="dir" type="text" maxlength="120" name="direccion" value="<%=conductor.getDireccion()%>"> 
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="tel">No. de telefono:</label>
			    			<input id="tel" type="text" maxlength="10" name="telefono" value="<%=conductor.getTelefono()%>">    		
 						</div>
 						
  						<div class="field-row" style="margin-TOP: 15px;">
							<label for="bday">Fecha de nacimiento:</label>
			    			<input id="bday" type="date" name="birthday" value="<%=conductor.getBirthday()%>">		   		
 						</div>
 				
 					</fieldset>
 					
 					<div class="field-row-stacked">
 					
 					<fieldset > <legend>Informacion laboral</legend>
 					
 						<div class="field-row">
							<label for="aExp">Años de experiencia:</label>
			    			<input id="aExp" type="number" name="yearsExp" value="<%=conductor.getYearsExp()%>">    		
 						</div>
 						
 						<div class="field-row">
							<label for="fContrato">Fecha de contratacion:</label>
			    			<input id="fContrato" type="date" name="fechaContrato" value="<%=conductor.getFechaContrato()%>">		
 						</div>
 						
					</fieldset>
					 <fieldset> <legend>Informacion de usuario</legend>
 					
 						<div class="field-row-stacked">
							<label for="nomUsuario">Nombre de usuario:</label>
			    			<input id="nomUsuario" type="text" maxlength="8" name="usuario" value="<%=usuario.getUsuario()%>">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="pass">Contraseña:</label>
			    			<input id="pass" type="text" maxlength="6" name="password" value="<%=usuario.getPasswrd()%>">    		
 						</div>
 						
 						<div class="field-row">
							<label for="stat">Status:</label>
								<select id="stat" name="status">
   								<% 
    							boolean status = conductor.getStatus();
    
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
					</div>
					
				</div>
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>