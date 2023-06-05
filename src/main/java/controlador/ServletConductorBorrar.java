package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import datos.ConductorDAO;

@WebServlet("/ServletConductorBorrar")

public class ServletConductorBorrar  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numEmpleado = Integer.parseInt(request.getParameter(("numEmpleado")));
        ConductorDAO condao = new ConductorDAO();
        condao.borrar(numEmpleado);
        response.sendRedirect("ServletConductorLista");
    }

}
