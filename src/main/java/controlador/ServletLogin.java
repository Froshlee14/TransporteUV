package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.Usuario;
import datos.UsuarioDAO;

@WebServlet("/ServletLogin")

public class ServletLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	UsuarioDAO userdao = new UsuarioDAO();
      	String user = request.getParameter("inputUsuario");
      	String password = request.getParameter("inputPassword").trim();
      	
        Usuario usuario = userdao.mostrar(user);
    	System.out.println("hola");
        
        if (usuario!=null) {
        	if (usuario.getPasswrd().equals(password)) {
              	System.out.println(usuario.getNumEmpleado());
        		 request.setAttribute("usuario",usuario);
                
                if (usuario.getRol().equals("admin")) {
                    // Redirigir a la página indexAdmin.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("indexAdmin.jsp");
                    dispatcher.forward(request, response);
                }
                else if (usuario.getRol().equals("empleado")) {
                    // Redirigir a la página indexEmpleado.jsp
                    RequestDispatcher dispatcher = request.getRequestDispatcher("indexEmpleado.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                    // El rol no coincide con ningún valor esperado
                } 
                
        	}
        	
        }
        else {
        	//No se encontro al usuario en la base de datos
        }
            
        

    }

}
