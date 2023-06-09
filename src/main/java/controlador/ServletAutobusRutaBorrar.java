package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.AutobusRutaDAO;

@WebServlet("/ServletAutobusRutaBorrar")

public class ServletAutobusRutaBorrar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int numRuta = Integer.parseInt(request.getParameter("numRutaQuitar"));
		int numUnidad = Integer.parseInt(request.getParameter("numUnidad"));
		
		AutobusRutaDAO busrutadao = new AutobusRutaDAO();
		busrutadao.borrar(numRuta);
        
        //request.setAttribute("numEmpleado",numEmpleado);
        response.sendRedirect("ServletAutobusRutaLista?numUnidad=" + numUnidad);
    }

}
