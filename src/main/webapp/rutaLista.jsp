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
			<div class="title-bar-text">rutaLista.jsp</div>
			<div class="title-bar-controls">
				<button aria-label="Close"></button>
			</div>
		</div>

		<div class="window-body"  style="margin: 15px;">

			<div class="sunken-panel">
				<table >

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
					List<Ruta> lista = (List<Ruta>) request.getAttribute("lista");
					if (lista != null) {
						for (Ruta ruta : lista) {
					%>
					<tr onclick="seleccionarRuta(<%= ruta.getNumRuta() %>,this)">
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
					<label for="numRuta"> </label>
			    	<input id="numRuta" type="hidden" name="numRuta" readonly>    		
 
  					<input id="verViajessBtn" type="submit" formaction="ServletRutaViajeLista" value="Viajes asignados" disabled>
 					<input id="modificarBtn" type="submit" formaction="ServletRutaBuscar" value="Modificar datos" disabled>
					<input id="borrarBtn" type="submit" formaction="ServletRutaBorrar" value="Borrar ruta" disabled>
    			</form>
    			<form action="rutaAgregar.jsp">
					<input type="submit" value="Nueva ruta">
    			</form>
			</div>
			
		</div>
	</div>
	
	<script>
		//Evitemos la flojera del usuario para escribir el numero de la ruta
  		function seleccionarRuta(num,row) {
  			
			//Movemos el numero de empleado al input oculto.
	  		var inputNumRuta = document.getElementById("numRuta");
	  		inputNumRuta.value = num;
	  		
	  		//Asimismo los botones estaran desactivados mientras el input este vacio
	  	 	var verViajessBtn = document.getElementById("verViajessBtn");
	  	 	verViajessBtn.disabled = false;
	  		
	  	 	var modificarBtn = document.getElementById("modificarBtn");
	  	  	modificarBtn.disabled = false;
	  	 	
	  	  	var borrarsBtn = document.getElementById("borrarBtn");
	  	  	borrarsBtn.disabled = false;
	  	 	
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