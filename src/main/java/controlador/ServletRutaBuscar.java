package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.Ruta;
import datos.RutaDAO;

@WebServlet("/ServletRutaBuscar")

public class ServletRutaBuscar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Ruta ruta = new Ruta();
		RutaDAO rutadao = new RutaDAO();
      	
      	int numRuta = Integer.parseInt(request.getParameter(("numRuta")));
      	
        ruta = rutadao.buscar(numRuta);
        request.setAttribute("ruta", ruta);

        RequestDispatcher dispatcher = request.getRequestDispatcher("rutaModificar.jsp");
        dispatcher.forward(request, response);
     
	}
}