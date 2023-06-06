package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Ruta;
import datos.RutaDAO;

@WebServlet("/ServletRutaLista")

public class ServletRutaLista extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RutaDAO rutadao = new RutaDAO();
        List<Ruta> lista = rutadao.selecionar();
        if (lista.isEmpty()) {
          	System.out.println("Lista vacia ");
        }
        else {
        	System.out.println("Aqui hay datos ");
        }
            
        request.setAttribute("lista",lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("rutaLista.jsp");
        dispatcher.forward(request, response);
    }

}
