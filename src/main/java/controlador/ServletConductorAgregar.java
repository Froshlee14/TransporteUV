package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import modelo.Conductor;
import datos.ConductorDAO;
import modelo.Usuario;
import datos.UsuarioDAO;

@WebServlet("/ServletConductorAgregar")

public class ServletConductorAgregar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
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
		
		Conductor conductor = new Conductor(nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp,status);
      	ConductorDAO condao = new ConductorDAO();
        int numEmpleado = condao.agregar(conductor);
        System.out.println("numEmpelado");
        
        if (numEmpleado!=0) {
        	System.out.println("Registro guardado, creando usuario");
    		String nomUsuario = request.getParameter("usuario");
    		String password = request.getParameter("password");
    		String rol = "empleado";
    		
    		Usuario usuario = new Usuario(nomUsuario,password,numEmpleado,rol);
          	UsuarioDAO udao = new UsuarioDAO();
            udao.agregar(usuario);
        }
        else {
        	System.out.println("No se pudo guardar el registro");
        }
        
        
        response.sendRedirect("ServletConductorLista");
        
	}
}
