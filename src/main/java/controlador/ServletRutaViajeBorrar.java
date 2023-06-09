package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.RutaViajeDAO;

@WebServlet("/ServletRutaViajeBorrar")

public class ServletRutaViajeBorrar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int numViaje = Integer.parseInt(request.getParameter("numViajeQuitar"));
		int numRuta = Integer.parseInt(request.getParameter("numUnidad"));
		
		RutaViajeDAO rutaViajedao = new RutaViajeDAO();
		rutaViajedao.borrar(numViaje);
        
        //request.setAttribute("numEmpleado",numEmpleado);
        response.sendRedirect("ServletRutaViajeLista?numRuta=" + numRuta);
    }

}
