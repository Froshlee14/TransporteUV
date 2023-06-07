package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.Viaje;
import datos.ViajeDAO;

@WebServlet("/ServletViajeBuscar")

public class ServletViajeBuscar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Viaje viaje = new Viaje();
		ViajeDAO viajedao = new ViajeDAO();
      	
      	int numViaje = Integer.parseInt(request.getParameter(("numViaje")));
      	
        viaje = viajedao.buscar(numViaje);
        request.setAttribute("viaje", viaje);

        RequestDispatcher dispatcher = request.getRequestDispatcher("viajeModificar.jsp");
        dispatcher.forward(request, response);
     
	}
}