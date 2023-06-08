package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.ConductorAutobusDAO;

@WebServlet("/ServletConductorAutobusBorrar")

public class ServletConductorAutobusBorrar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int numUnidad = Integer.parseInt(request.getParameter("numUnidadQuitar"));
		int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
		
        ConductorAutobusDAO condubusdao = new ConductorAutobusDAO();
        condubusdao.borrar(numUnidad);
        
        //request.setAttribute("numEmpleado",numEmpleado);
        response.sendRedirect("ServletConductorAutobusLista?numEmpleado=" + numEmpleado);
    }

}
