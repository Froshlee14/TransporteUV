package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.Usuario;
import datos.UsuarioDAO;
import datos.ConductorDAO;

@WebServlet("/ServletLogin")

public class ServletLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      	UsuarioDAO userdao = new UsuarioDAO();
      	String user = request.getParameter("inputUsuario");
      	String password = request.getParameter("inputPassword").trim();
      	
        Usuario usuario = userdao.mostrar(user);
    	//System.out.println("hola");
        
        if (usuario!=null) {
        	if (usuario.getPasswrd().equals(password)) {
              
        		 request.setAttribute("usuario",usuario);
                
                if (usuario.getRol().equals("admin")) {
                    //Si el rol es de admin reedirige al jsp correspondiente
                    RequestDispatcher dispatcher = request.getRequestDispatcher("indexAdmin.jsp");
                    dispatcher.forward(request, response);
                }
                else if (usuario.getRol().equals("empleado")) {
                    //Si se trata de un empleado obtenemos su nombre  para saludarlo en el jsp
                	
                	ConductorDAO condao = new ConductorDAO();
                	String nomEmpleado = condao.seleccionarNombre(usuario.getNumEmpleado());
                	
                	request.setAttribute("nombreEmpleado",nomEmpleado);
                	
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
