package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.AutobusRutaDAO;
import modelo.AutobusRuta;

@WebServlet("/ServletAutobusRutaAgregar")

public class ServletAutobusRutaAgregar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		int numRuta = Integer.parseInt(request.getParameter("numRutaAgregar"));
		int numUnidad = Integer.parseInt(request.getParameter("numUnidad"));
		
		AutobusRuta autobusRuta = new AutobusRuta(numUnidad,numRuta);
		AutobusRutaDAO conbusdao = new AutobusRutaDAO();
        conbusdao.agregar(autobusRuta);
        
        //request.setAttribute("numEmpleado",numEmpleado);
        response.sendRedirect("ServletAutobusRutaLista?numUnidad=" + numUnidad);
	}
}
