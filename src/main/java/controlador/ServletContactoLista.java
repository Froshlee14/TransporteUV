package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.ContactoEmergencia;
import datos.ContactoEmergenciaDAO;
import datos.ConductorDAO;

@WebServlet("/ServletContactoLista")
public class ServletContactoLista extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	ContactoEmergenciaDAO condao = new ContactoEmergenciaDAO();
      	
      	int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
      	
        List<ContactoEmergencia> lista = condao.selecionar(numEmpleado);
        
      	ConductorDAO conductordao = new ConductorDAO();
    	String nomEmpleado = conductordao.seleccionarNombre(numEmpleado);
    	System.out.println(nomEmpleado);
    	request.setAttribute("nombreEmpleado",nomEmpleado);
            
        request.setAttribute("lista",lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaContactos.jsp");
        dispatcher.forward(request, response);

    }


}
