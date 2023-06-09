package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.RutaViajeDAO;
import modelo.RutaViaje;

@WebServlet("/ServletRutaViajeAgregar")

public class ServletRutaViajeAgregar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		int numViaje = Integer.parseInt(request.getParameter("numViajeAgregar"));
		int numRuta = Integer.parseInt(request.getParameter("numRuta"));
		
		RutaViaje rutaviaje = new RutaViaje(numRuta,numViaje);
		RutaViajeDAO rutaviajedao = new RutaViajeDAO();
		rutaviajedao.agregar(rutaviaje);
        
        //request.setAttribute("numEmpleado",numEmpleado);
        response.sendRedirect("ServletRutaViajeLista?numRuta=" + numRuta);
	}
}
