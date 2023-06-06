package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.AutobusDAO;
import modelo.Autobus;

@WebServlet("/ServletAutobusModificar")

public class ServletAutobusModificar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		int numUnidad = Integer.parseInt(request.getParameter("numUnidad"));
		String numSerie = request.getParameter("numSerie");
		int idFabricante = Integer.parseInt(request.getParameter("idFabricante"));
		int yearFabricacion = Integer.parseInt(request.getParameter("yearFabricacion"));
		int capacidad = Integer.parseInt(request.getParameter("capacidad"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		Autobus autobus = new Autobus(numUnidad,numSerie,idFabricante,yearFabricacion,capacidad,status);
		AutobusDAO autobusdao = new AutobusDAO();
        autobusdao.modificar(autobus);
        
        response.sendRedirect("ServletAutobusLista");
    }
}
