package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Viaje;
import datos.ViajeDAO;

@WebServlet("/ServletRutaViajeLista")

public class ServletRutaViajeLista extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	int numRuta = Integer.parseInt(request.getParameter(("numRuta")));
      	
		ViajeDAO viajedao = new ViajeDAO();
		
        List<Viaje> viajesAsignadosLista = viajedao.selecionarPorRuta(numRuta);
        if (viajesAsignadosLista.isEmpty()) {
          	System.out.println("Lista asignada vacia ");
        }     
        
        List<Viaje> viajesNoAsignadosLista = viajedao.selecionarNoAsignados();
        if (viajesNoAsignadosLista.isEmpty()) {
          	System.out.println("Lista no asignados vacia ");
        }
         
        request.setAttribute("viajesAsignadosLista",viajesAsignadosLista);
        request.setAttribute("viajesNoAsignadosLista",viajesNoAsignadosLista);
        request.setAttribute("numRuta",numRuta);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("rutaViajeLista.jsp");
        dispatcher.forward(request, response);
    }

}
