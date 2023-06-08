package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Autobus;
import datos.AutobusDAO;

@WebServlet("/ServletConductorAutobusLista")

public class ServletConductorAutobusLista extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	int numEmpleado = Integer.parseInt(request.getParameter(("numEmpleado")));
		AutobusDAO adao = new AutobusDAO();
		List<Autobus> autobusesAsignados  = adao.seleccionarPorEmpleado(numEmpleado);
      	
		if (autobusesAsignados.isEmpty()) {
          	System.out.println("Lista de asignados vacia ");
        }
            
		List<Autobus> autobusesNoAsignados  = adao.seleccionarNoAsignados();
		
		if (autobusesNoAsignados.isEmpty()) {
          	System.out.println("Lista de no asignados vacia ");
        }
		
        request.setAttribute("autobusesAsignados",autobusesAsignados);
        request.setAttribute("autobusesNoAsignados",autobusesNoAsignados);
        RequestDispatcher dispatcher = request.getRequestDispatcher("conductorAutobusLista.jsp");
        dispatcher.forward(request, response);

       
        
        
    }

}