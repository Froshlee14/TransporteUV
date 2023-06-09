package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Autobus;
import datos.AutobusDAO;

@WebServlet("/ServletAutobusListaEmpleado")

public class ServletAutobusListaEmpleado extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
      	int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
		
		AutobusDAO adao = new AutobusDAO();
		List<Autobus> lista = adao.seleccionarPorEmpleado(numEmpleado);
			
		if (lista.isEmpty()) {
	         System.out.println("Lista vacia ");
		}
		
		request.setAttribute("lista",lista);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("autobusListaEmpleado.jsp");
	    dispatcher.forward(request, response);   
        
    }

}
