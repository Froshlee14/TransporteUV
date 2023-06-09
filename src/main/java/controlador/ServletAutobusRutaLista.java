package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Ruta;
import datos.RutaDAO;

@WebServlet("/ServletAutobusRutaLista")

public class ServletAutobusRutaLista extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	int numUnidad = Integer.parseInt(request.getParameter(("numUnidad")));
		RutaDAO rutadao = new RutaDAO();
		
        List<Ruta> listaRutasAsignadas = rutadao.selecionarPorAutobus(numUnidad);
        if (listaRutasAsignadas.isEmpty()) {
          	System.out.println("Lista vacia ");
        }
        
        List<Ruta> listaRutasNoAsignadas = rutadao.selecionarNoAsignadas();
        if (listaRutasNoAsignadas.isEmpty()) {
          	System.out.println("Lista no asignadas vacia ");
        }
           
        request.setAttribute("numUnidad",numUnidad);
        request.setAttribute("listaRutasAsignadas",listaRutasAsignadas);
        request.setAttribute("listaRutasNoAsignadas",listaRutasNoAsignadas);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("autobusRutaLista.jsp");
        dispatcher.forward(request, response);
    }

}
