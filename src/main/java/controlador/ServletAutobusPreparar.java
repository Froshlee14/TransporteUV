package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.FabricanteDAO;
import modelo.Fabricante;

@WebServlet("/ServletAutobusPreparar")

public class ServletAutobusPreparar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
        List<Fabricante> fabricantes = fabricanteDAO.selecionar();
        if (fabricantes.isEmpty()) {
          	System.out.println("Lista vacia ");
        }
        else {
        	System.out.println("Aqui hay datos ");
        }
            
        request.setAttribute("fabricantes",fabricantes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("autobusAgregar.jsp");
        dispatcher.forward(request, response);
    }

}
