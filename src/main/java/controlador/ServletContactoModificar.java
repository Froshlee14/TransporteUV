package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.ContactoEmergenciaDAO;
import modelo.ContactoEmergencia;

@WebServlet("/ServletContactoModificar")

public class ServletContactoModificar extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		int numContacto = Integer.parseInt(request.getParameter("numContacto"));
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
		
		ContactoEmergencia contacto = new ContactoEmergencia(numContacto,nombre,apellidoPaterno,apellidoMaterno,direccion,telefono,numEmpleado);
		ContactoEmergenciaDAO contactodao = new ContactoEmergenciaDAO();
        contactodao.modificar(contacto);
        
        response.sendRedirect("ServletContactoLista?numEmpleado=" + numEmpleado);
    }
	
}
