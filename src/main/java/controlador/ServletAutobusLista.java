package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Autobus;
import datos.AutobusDAO;

@WebServlet("/ServletAutobusLista")

public class ServletAutobusLista extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		AutobusDAO adao = new AutobusDAO();
		List<Autobus> lista = adao.selecionar();
		
		if (lista.isEmpty()) {
          	System.out.println("Lista vacia ");
        }
            
        request.setAttribute("lista",lista);

        RequestDispatcher dispatcher = request.getRequestDispatcher("autobusLista.jsp");
        dispatcher.forward(request, response);

        
        
    }

}
