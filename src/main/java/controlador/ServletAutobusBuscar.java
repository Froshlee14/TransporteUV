package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;
import javax.servlet.*;

import modelo.Fabricante;
import datos.FabricanteDAO;
import modelo.Autobus;
import datos.AutobusDAO;

@WebServlet("/ServletAutobusBuscar")

public class ServletAutobusBuscar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Autobus autobus = new Autobus();
		AutobusDAO autobusdao = new AutobusDAO();
      	
      	int numUnidad = Integer.parseInt(request.getParameter(("numUnidad")));
      	
        autobus = autobusdao.buscar(numUnidad);
        request.setAttribute("autobus", autobus);
        
        //Tambien mando los fabricantes para mostrarlos en el <option>
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
        List<Fabricante> fabricantes = fabricanteDAO.selecionar();
            
        request.setAttribute("fabricantes",fabricantes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("autobusModificar.jsp");
        dispatcher.forward(request, response);
     
	}
}
