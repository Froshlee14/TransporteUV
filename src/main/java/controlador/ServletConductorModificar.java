package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.servlet.*;

import datos.ConductorDAO;
import modelo.Conductor;
import datos.UsuarioDAO;
import modelo.Usuario;

@WebServlet("/ServletConductorModificar")

public class ServletConductorModificar extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
		String nombre = request.getParameter("nombre");
		String apellidoPaterno = request.getParameter("apellidoPaterno");
		String apellidoMaterno = request.getParameter("apellidoMaterno");
		Date birthday = null;
		Date fechaContrato = null;

		String bday = request.getParameter("birthday");
		String fcon = request.getParameter("fechaContrato");
		LocalDate bdayLocal = null;
		LocalDate fconLocal = null;

		try {
			bdayLocal = LocalDate.parse(bday);
		    birthday = Date.valueOf(bdayLocal);
			fconLocal = LocalDate.parse(fcon);
		    fechaContrato = Date.valueOf(fconLocal);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}
		
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		int yearsExp = Integer.parseInt(request.getParameter("yearsExp"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		Conductor conductor = new Conductor(numEmpleado,nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp,status);
      	ConductorDAO condao = new ConductorDAO();
        condao.modificar(conductor);
        
		String nomUsuario = request.getParameter("usuario");
		String passwrd = request.getParameter("password");
		String rol = "empleado";
		
		Usuario usuario = new Usuario(nomUsuario,passwrd,numEmpleado,rol);
		UsuarioDAO udao = new UsuarioDAO();
        udao.modificar(usuario);
        
        response.sendRedirect("ServletConductorLista");
    }
	
}
