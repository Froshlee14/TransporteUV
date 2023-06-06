package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.RutaDAO;

@WebServlet("/ServletRutaBorrar")

public class ServletRutaBorrar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numRuta = Integer.parseInt(request.getParameter(("numRuta")));
        RutaDAO rutadao = new RutaDAO();
        rutadao.borrar(numRuta);
        
        response.sendRedirect("ServletRutaLista");
    }

}
