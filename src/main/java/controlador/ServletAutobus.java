package controlador;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.util.*;

import modelo.Autobus;
import datos.AutobusDAO;

@WebServlet("/ServletAutobus")

public class ServletAutobus  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//PETICION GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        AutobusDAO autodao = new AutobusDAO();
        List<Autobus> lista = autodao.selecionar();
        if (lista.isEmpty()) {
          	System.out.println("Lista vacia ");
        }
        else {
        	System.out.println("Aqui hay datos ");
        }
            
        request.setAttribute("lista",lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

      

    }

}
