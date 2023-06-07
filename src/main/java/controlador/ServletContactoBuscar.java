package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.ContactoEmergencia;
import datos.ContactoEmergenciaDAO;
@WebServlet("/ServletContactoBuscar")

public class ServletContactoBuscar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ContactoEmergencia contacto = new ContactoEmergencia();
		ContactoEmergenciaDAO contactodao = new ContactoEmergenciaDAO();
      	
      	int numContacto = Integer.parseInt(request.getParameter("numContacto"));
      	
        contacto = contactodao.buscar(numContacto);
		
        request.setAttribute("contacto", contacto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contactoModificar.jsp");
        dispatcher.forward(request, response);
     
	}
}
