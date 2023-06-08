package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.ConductorAutobusDAO;
import modelo.ConductorAutobus;

@WebServlet("/ServletConductorAutobusAgregar")

public class ServletConductorAutobusAgregar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		int numUnidad = Integer.parseInt(request.getParameter("numUnidadAgregar"));
		int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
		
		ConductorAutobus conbus = new ConductorAutobus(numEmpleado,numUnidad);
		ConductorAutobusDAO conbusdao = new ConductorAutobusDAO();
        conbusdao.agregar(conbus);
        
        //request.setAttribute("numEmpleado",numEmpleado);
        response.sendRedirect("ServletConductorAutobusLista?numEmpleado=" + numEmpleado);
	}
}
