package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.ContactoEmergencia;
import datos.ContactoEmergenciaDAO;

@WebServlet("/ServletContactoAgregar")

public class ServletContactoAgregar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");

		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
		
		ContactoEmergencia contacto = new ContactoEmergencia(nombre,apellidoPaterno,apellidoMaterno,direccion,telefono,numEmpleado);
		ContactoEmergenciaDAO contactodao = new ContactoEmergenciaDAO();
        contactodao.agregar(contacto);
        
        response.sendRedirect("ServletContactoLista?numEmpleado=" + numEmpleado);

        
	}
}
