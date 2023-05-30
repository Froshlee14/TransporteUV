package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Conductor;
import datos.ConductorDAO;

@WebServlet("/ServletConductor")

public class ServletConductor extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	ConductorDAO condao = new ConductorDAO();
        List<Conductor> lista = condao.selecionar();
        if (lista.isEmpty()) {
          	System.out.println("Esta vacio, vez? ");
        }
        else {
        	System.out.println("Aqui hay datos ");
        }
        System.out.println("Hola ");
            
        request.setAttribute("lista",lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("empleadoIndex.jsp");
        dispatcher.forward(request, response);
    }

}
