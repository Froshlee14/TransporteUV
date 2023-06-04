package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Conductor;
import datos.ConductorDAO;

@WebServlet("/ServletConductores")

public class ServletConductores extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	ConductorDAO condao = new ConductorDAO();
        List<Conductor> lista = condao.selecionar();
        if (lista.isEmpty()) {
          	System.out.println("Lista vacia ");
        }
        else {
        	System.out.println("Aqui hay datos ");
        }
            
        request.setAttribute("lista",lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaConductores.jsp");
        dispatcher.forward(request, response);
    }

}
