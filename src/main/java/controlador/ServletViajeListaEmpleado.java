package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Viaje;
import datos.ViajeDAO;

@WebServlet("/ServletViajeListaEmpleado")

public class ServletViajeListaEmpleado extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
		
		ViajeDAO viajedao = new ViajeDAO();
        List<Viaje> lista = viajedao.selecionarPorEmpleado(numEmpleado);
        if (lista.isEmpty()) {
          	System.out.println("Lista vacia ");
        }
        else {
        	System.out.println("Aqui hay datos ");
        }
            
        request.setAttribute("lista",lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viajeListaEmpleado.jsp");
        dispatcher.forward(request, response);
    }

}
