package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.Conductor;
import datos.ConductorDAO;

@WebServlet("/ServletConductorBuscar")

public class ServletConductorBuscar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Conductor conductor = new Conductor();
      	ConductorDAO condao = new ConductorDAO();
      	
      	int numEmpleado = Integer.parseInt(request.getParameter(("numEmpleado")));
        conductor = condao.buscar(numEmpleado);
		
        request.setAttribute("conductor", conductor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("conductorModificar.jsp");
        dispatcher.forward(request, response);
     
	}
}
