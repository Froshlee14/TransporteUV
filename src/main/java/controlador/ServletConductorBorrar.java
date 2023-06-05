package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.ConductorDAO;
import datos.UsuarioDAO;

@WebServlet("/ServletConductorBorrar")

public class ServletConductorBorrar  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numEmpleado = Integer.parseInt(request.getParameter(("numEmpleado")));
        ConductorDAO condao = new ConductorDAO();
        condao.borrar(numEmpleado);
        
        UsuarioDAO udao = new UsuarioDAO();
        udao.borrarPorEmpleado(numEmpleado);
        response.sendRedirect("ServletConductorLista");
    }

}
