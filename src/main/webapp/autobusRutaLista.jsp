<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="modelo.Ruta"%>
<!DOCTYPE html>

<html>

<head>
	<title>TransporteUV</title>
	<link rel="stylesheet" href="https://unpkg.com/98.css">

  	<style>
    	tr:hover {
      		background-color: #c3c3c3;
      		cursor: pointer;
    	}
    	tr.selected {
      		background-color: #409ed0;
    	}
  	</style>

</head>

<body>

	<jsp:useBean id="rutas" class="modelo.Ruta" scope="request" />

	<div class="window" style="display: inline-block;">

		<div class="title-bar">
			<div class="title-bar-text">autobusRutaLista.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">
		
			<p> Rutas asignadas </p>

			<div class="sunken-panel">
				<table style="width: 100%;">

					<thead>
						<tr>
						
							<th>No.de ruta</th>
							<th>Descripcion</th>
							<th>Destino inicial</th>
							<th>Destino final</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Ruta> listaRutasAsignadas = (List<Ruta>) request.getAttribute("listaRutasAsignadas");
					if (listaRutasAsignadas != null) {
						for (Ruta ruta : listaRutasAsignadas) {
					%>
					<tr onclick="seleccionarRuta(<%= ruta.getNumRuta() %>,this,false)">
						<td><%out.print(ruta.getNumRuta());%></td>
						<td><%out.print(ruta.getDescripcion());%></td>
						<td><%out.print(ruta.getDestinoInicial());%></td>
						<td><%out.print(ruta.getDestinoFinal());%></td>
					</tr>
					<%
						}
					}
					else {
						out.print("No hay nada");
					}
					%>

				</table>
			</div>
			
			<div class="field-row" style="margin-top: 15px;  justify-content: flex-end;">
				<form method="get">
			    	<input id="numRutaQuitar" type="hidden" name="numRutaQuitar" readonly> 
			    	<input id="numUnidad" type="hidden" name="numUnidad" value="<%=request.getAttribute("numUnidad")%>" readonly>   		
 
					<input id="quitarBtn" type="submit" formaction="ServletAutobusRutaBorrar" value="Quitar ruta" disabled>
    			</form>
			</div>
			
			<p> Rutas sin asignar </p>
			
			<div class="sunken-panel">
				<table style="width: 100%;">

					<thead>
						<tr>
						
							<th>No.de ruta</th>
							<th>Descripcion</th>
							<th>Destino inicial</th>
							<th>Destino final</th>
							
						</tr>
					</thead>

					<%
					@SuppressWarnings("unchecked")
					List<Ruta> listaRutasNoAsignadas = (List<Ruta>) request.getAttribute("listaRutasNoAsignadas");
					if (listaRutasNoAsignadas != null) {
						for (Ruta ruta : listaRutasNoAsignadas) {
					%>
					<tr onclick="seleccionarRuta(<%= ruta.getNumRuta() %>,this,true)">
						<td><%out.print(ruta.getNumRuta());%></td>
						<td><%out.print(ruta.getDescripcion());%></td>
						<td><%out.print(ruta.getDestinoInicial());%></td>
						<td><%out.print(ruta.getDestinoFinal());%></td>
					</tr>
					<%
						}
					}
					else {
						out.print("No hay nada");
					}
					%>

				</table>
			</div>
			
			<div class="field-row" style="margin-top: 15px;  justify-content: flex-end;">
				<form method="post">
			    	<input id="numRutaAgregar" type="hidden" name="numRutaAgregar" readonly>
			    	<input id="numUnidad" type="hidden" name="numUnidad" value="<%=request.getAttribute("numUnidad")%>" readonly>   
 
 					<input id="asignarBtn" type="submit" formaction="ServletAutobusRutaAgregar" value="Asignar Ruta" disabled>
    			</form>
			</div>
			
		</div>
	</div>
	
	<script>
		//Evitemos la flojera del usuario para escribir el numero de la ruta
  		function seleccionarRuta(num,row,agregar) {
  			
			//Movemos el numero de empleado al input oculto.
	  		var inputNumRutaQuitar = document.getElementById("numRutaQuitar");
	  		var inputNumRutaAgregar = document.getElementById("numRutaAgregar");
	  		
	  		//Asimismo los botones estaran desactivados mientras el input este vacio
  	 		var asignarBtn = document.getElementById("asignarBtn");
  	  		var quitarBtn = document.getElementById("quitarBtn");
	  	 	
	  	  	if (agregar){
		  		inputNumRutaAgregar.value = num;
	  	 		asignarBtn.disabled = false;
	  	 		quitarBtn.disabled = true;
	  	  	}
	  	  	else{
		  		inputNumRutaQuitar.value = num;
	  			asignarBtn.disabled = true;
	  	 		quitarBtn.disabled = false;
	  	  	}

	        var filas = document.getElementsByTagName("tr");
	        
	        //Quito la propiedad "selected" al resto de columnas
	        for (var i = 0; i < filas.length; i++) {
	          filas[i].classList.remove("selected");
	        }
	        
	        //Cambio el color la columna seleccionada
	       	row.classList.add("selected");
  		}
	</script>

</body>

</html>