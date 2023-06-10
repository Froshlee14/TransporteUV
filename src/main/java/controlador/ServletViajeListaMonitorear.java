package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Viaje;
import datos.ViajeDAO;

@WebServlet("/ServletViajeListaMonitorear")

public class ServletViajeListaMonitorear extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		ViajeDAO viajedao = new ViajeDAO();
        List<Viaje> lista = viajedao.selecionarExtendido();
        if (lista.isEmpty()) {
          	System.out.println("Lista vacia ");
        }
        else {
        	System.out.println("Aqui hay datos ");
        }
            
        request.setAttribute("listaExtendida",lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("viajeListaMonitorear.jsp");
        dispatcher.forward(request, response);
    }

}
