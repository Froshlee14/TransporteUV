<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modelo.Conductor" %>
<!DOCTYPE html>

<html>

	<head>
		<title>TransporteUV</title>
	</head>
	
	<body>
	
	<jsp:useBean id="conductores" class="modelo.Conductor" scope="request"/>

		<table width="100%">
		
		<thead>
            <tr>
                <th>Numero de empleado </th>
                <th>Nombre </th>
                <th>Apellido Paterno </th>
                <th>Apellido Materno </th>
            </tr>
      	</thead>
      	
      	<%

  		@SuppressWarnings("unchecked")
		List<Conductor> lista = (List<Conductor>) request.getAttribute("lista");
        if (lista != null){
        	for (Conductor conductor : lista){
        %>
            <tr>
            	<td><%out.print(conductor.getNumEmpleado()); %></td>
            	<td><%out.print(conductor.getNombre());%></td>
            	<td><%out.print(conductor.getApellidoPaterno());%></td>
            	<td><%out.print(conductor.getApellidoMaterno());%></td>
        	</tr>
       	<%
        	}
       	}
        else{
        	out.print("No hay nada");
        }
        %>
        
        </table>

    	
	</body>
	
</html>