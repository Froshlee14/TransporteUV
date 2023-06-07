<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.ContactoEmergencia"%>
<!DOCTYPE html>

<html>

<head>
	<title>TransporteUV</title>
	<link rel="stylesheet" href="https://unpkg.com/98.css">
</head>

<body>

	<jsp:useBean id="contactos" class="modelo.ContactoEmergencia" scope="request" />
		
	<%
		ContactoEmergencia contacto = (ContactoEmergencia) request.getAttribute("contacto");
	%>
	

	<div class="window" style="width: 220px;">

		<div class="title-bar">
			<div class="title-bar-text">contactoModificar.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body">
			
			<form action="ServletContactoModificar" method="post" accept-charset="UTF-8">
			
				<div class="field-row-stacked">
				
					<fieldset > <legend>Informacion general</legend>
					
					 	<input type="hidden" maxlength="10" name="numContacto" value="<%=contacto.getNumContacto()%>">    	
						
						<div class="field-row-stacked">
							<label for="nombre">Nombre:</label>
			    			<input id="nombre" type="text" maxlength="30" name="nombre" value="<%=contacto.getNombre()%>">    		
 						</div>

						<div class="field-row-stacked">
							<label for="apPaterno">Apellido paterno:</label>
			    			<input id="apPaterno" type="text" maxlength="30" name="apellidoPaterno" value="<%=contacto.getApellidoPaterno()%>">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="apMaterno">Apellido materno:</label>
			    			<input id="apMaterno" type="text" maxlength="30" name="apellidoMaterno" value="<%=contacto.getApellidoMaterno()%>">    		
 						</div>
 					
 						 <div class="field-row-stacked">
							<label for="dir">Direccion:</label>
			    			<input id="dir" type="text" maxlength="120" name="direccion" value="<%=contacto.getDireccion()%>">    		
 						</div>
 					
 						<div class="field-row-stacked">
							<label for="tel">No. de telefono:</label>
			    			<input id="tel" type="text" maxlength="10" name="telefono" value="<%=contacto.getTelefono()%>">    		
 						</div>
 						
 						<input type="hidden" maxlength="10" name="numEmpleado" value="<%=contacto.getNumEmpleado()%>">    		


 				
 					</fieldset>
					
					<input type="submit" value="Modificar contacto">
					
				</div>
				
    		</form>
    			
		</div>
		
	</div>

</body>

</html>