package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.RutaDAO;
import modelo.Ruta;

@WebServlet("/ServletRutaAgregar")

public class ServletRutaAgregar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		String descripcion = request.getParameter("descripcion");
		String destinoInicial = request.getParameter("destinoInicial");
		String destinoFinal = request.getParameter("destinoFinal");
		
		Ruta ruta = new Ruta(descripcion,destinoInicial,destinoFinal);
      	RutaDAO rutadao = new RutaDAO();
        rutadao.agregar(ruta);
        
        response.sendRedirect("ServletRutaLista");
	}
}
