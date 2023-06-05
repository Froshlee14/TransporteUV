package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.AutobusDAO;
import modelo.Autobus;

@WebServlet("/ServletAutobusAgregar")

public class ServletAutobusAgregar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		String numSerie = request.getParameter("numSerie");
		int  fabricante =  Integer.parseInt(request.getParameter("fabricante"));
		int yearFabricacion =  Integer.parseInt(request.getParameter("yearFabricacion"));
		int capacidad =  Integer.parseInt(request.getParameter("capacidad"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		Autobus autobus = new Autobus(numSerie,fabricante,yearFabricacion,capacidad,status);
      	AutobusDAO autobusdao = new AutobusDAO();
        autobusdao.agregar(autobus);
        
        response.sendRedirect("ServletAutobusLista");
	}
}
