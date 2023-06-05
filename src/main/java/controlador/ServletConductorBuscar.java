package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.Conductor;
import datos.ConductorDAO;

import modelo.Usuario;
import datos.UsuarioDAO;

@WebServlet("/ServletConductorBuscar")

public class ServletConductorBuscar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Conductor conductor = new Conductor();
      	ConductorDAO condao = new ConductorDAO();
      	
		Usuario usuario = new Usuario();
      	UsuarioDAO udao = new UsuarioDAO();
      	
      	int numEmpleado = Integer.parseInt(request.getParameter(("numEmpleado")));
      	
        conductor = condao.buscar(numEmpleado);
        usuario = udao.buscarPorEmpleado(numEmpleado);
		
        request.setAttribute("conductor", conductor);
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("conductorModificar.jsp");
        dispatcher.forward(request, response);
     
	}
}
