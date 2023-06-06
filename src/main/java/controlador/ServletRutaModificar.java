package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.RutaDAO;
import modelo.Ruta;

@WebServlet("/ServletRutaModificar")

public class ServletRutaModificar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		int numRuta = Integer.parseInt(request.getParameter("numRuta"));
		String descripcion = request.getParameter("descripcion");
		String destinoInicial = request.getParameter("destinoInicial");
		String destinoFinal = request.getParameter("destinoFinal");
		
		Ruta ruta = new Ruta(numRuta,descripcion,destinoInicial,destinoFinal);
		RutaDAO rutadao = new RutaDAO();
        rutadao.modificar(ruta);
        
        response.sendRedirect("ServletRutaLista");
    }
}
