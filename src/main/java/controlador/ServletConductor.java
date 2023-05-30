package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import datos.Conexion;
import modelo.Conductor;
import datos.ConductorDAO;

@WebServlet(name = "ServletConductor", urlPatterns = {"/ServletConductor"})

public class ServletConductor extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String opc = (request.getParameter("opc") != null) ? request.getParameter("opc") : "list";

        if (opc.equals("list")) {
        	ConductorDAO condao = new ConductorDAO();
            List<Conductor> lista = condao.selecionar();
            if (lista.isEmpty()) {
            	System.out.println("Esta vacio, vez? ");
            }
            else {
            	System.out.println("Aqui hay datos ");
            }
            System.out.println("Hola ");
            
            request.setAttribute("lista",lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("empleadoIndex.jsp");
            dispatcher.forward(request, response);
        }

        else if (opc.equals("mostrar")) {
            //Conexion con = new Conexion();
            Connection c = Conexion.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            
            int numUnidad = Integer.parseInt(request.getParameter(("numUnidad")));
            
            try {
                String updateSql = "SELECT * FROM conductor WHERE numEmpleado = ? ";
                ps = c.prepareStatement(updateSql);
                ps.setInt(1, numUnidad);
                rs = ps.executeQuery();
                Conductor auto = new Conductor();
                while (rs.next()) {

                    auto.setNumEmpleado(rs.getInt("numEmpleado"));
                    auto.setNombre(rs.getString("nombre"));
                    auto.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    auto.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    auto.setBirthday(rs.getDate("birthday"));
                    auto.setFechaContrato(rs.getDate("fechaContrato"));
                    auto.setDireccion(rs.getString("direccion"));
                    auto.setTelefono(rs.getString("telefono"));
                    auto.setYearsExp(rs.getInt("yearsExp"));
                }
                
                request.setAttribute("conductor", auto);
                RequestDispatcher dispatcher = request.getRequestDispatcher("empleadoIndex.jsp");
                dispatcher.forward(request, response);
               
            } catch (SQLException ex) {
                System.out.println("Error en SQL " + ex.getMessage());
            }
        }
      
        else if (opc.equals("eliminar")) {

            int numEmpleado = Integer.parseInt(request.getParameter("numUnidad"));
            Conductor conductor = new Conductor(numEmpleado);
            ConductorDAO condao = new ConductorDAO(); 
            condao.borrar(conductor);
            
            response.sendRedirect("ServletConductor");
        }
    }
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String op;
        op=(String)request.getSession().getAttribute("op");
       if (op.equals("nuevo")) {

            int numEmpleado = Integer.parseInt(request.getParameter("numEmpleado"));
            String nombre = request.getParameter("nombre");
            String apellidoPaterno = request.getParameter("apellidoPaterno");
            String apellidoMaterno = request.getParameter("apellidoMaterno");
            
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = null;
            Date fechaContrato = null;
            try {
                birthday = inputFormat.parse(request.getParameter("birthday"));
                fechaContrato = inputFormat.parse(request.getParameter("fechaContrato"));
            } catch (ParseException e) {
                System.out.println("Conversion incorrecta");
            }
            
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            int yearsExp = Integer.parseInt(request.getParameter("yearsExp"));

            Conductor conductor = new Conductor(numEmpleado, nombre, apellidoPaterno, apellidoMaterno, birthday, fechaContrato, direccion, telefono, yearsExp);
            ConductorDAO condao = new ConductorDAO();
            condao.agregar(conductor);
            
            response.sendRedirect("/ServletConductor");
        }
       
    }

}
