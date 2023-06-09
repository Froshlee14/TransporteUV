package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;

import modelo.Conductor;
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
      	
        Usuario usuario = userdao.buscar(user);
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
                	Conductor conductor = condao.buscar(usuario.getNumEmpleado());
                	String nombreEmpleado = conductor.getNombre();
 	
                	request.setAttribute("nombreEmpleado",nombreEmpleado);
                	
                    RequestDispatcher dispatcher = request.getRequestDispatcher("indexEmpleado.jsp");
                    dispatcher.forward(request, response);
                }
                else {
                	request.setAttribute("mensaje","No existe este rol");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                    dispatcher.forward(request, response);
                } 
                
        	}
        	else {
            	request.setAttribute("mensaje","Contraseña invalida");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
        	}
        	
        }
        else {
        	request.setAttribute("mensaje","Usuario invalido");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
            
        

    }

}
