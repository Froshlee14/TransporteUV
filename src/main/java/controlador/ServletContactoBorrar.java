package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.ContactoEmergenciaDAO;

@WebServlet("/ServletContactoBorrar")

public class ServletContactoBorrar  extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numContacto = Integer.parseInt(request.getParameter(("numContacto")));
        ContactoEmergenciaDAO contactodao = new ContactoEmergenciaDAO();
        contactodao.borrar(numContacto);

		int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
		System.out.println(numEmpleado);
        response.sendRedirect("ServletContactoLista?numEmpleado=" + numEmpleado);
    }

}
