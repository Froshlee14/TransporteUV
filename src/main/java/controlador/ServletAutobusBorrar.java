package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.AutobusDAO;

@WebServlet("/ServletAutobusBorrar")

public class ServletAutobusBorrar  extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numUnidad = Integer.parseInt(request.getParameter(("numUnidad")));
        AutobusDAO autobusdao = new AutobusDAO();
        autobusdao.borrar(numUnidad);
        
        response.sendRedirect("ServletAutobusLista");
    }

}
