package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import datos.ViajeDAO;

@WebServlet("/ServletViajeBorrar")

public class ServletViajeBorrar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int numViaje = Integer.parseInt(request.getParameter(("numViaje")));
        ViajeDAO rutadao = new ViajeDAO();
        rutadao.borrar(numViaje);
        
        response.sendRedirect("ServletViajeLista");
    }

}
