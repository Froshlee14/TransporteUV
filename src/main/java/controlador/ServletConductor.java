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
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";

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
            rq.setAttribute("lista",lista);
            rq.getRequestDispatcher("/empleadoIndex.jsp").forward(rq, rp);
        }

        else if (opc.equals("mostrar")) {
            //Conexion con = new Conexion();
            Connection c = Conexion.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            
            int numUnidad = Integer.parseInt(rq.getParameter(("numUnidad")));
            
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
                rq.setAttribute("conductor", auto);

                rq.getRequestDispatcher("empleadoIndex.jsp").forward(rq, rp);
               
            } catch (SQLException ex) {
                System.out.println("Error en SQL " + ex.getMessage());
            }
        }
      
        else if (opc.equals("eliminar")) {

            int numEmpleado = Integer.parseInt(rq.getParameter("numUnidad"));
            Conductor conductor = new Conductor(numEmpleado);
            ConductorDAO condao = new ConductorDAO();
            condao.borrar(conductor);
            rp.sendRedirect("ServletConductor");
        }
    }
	
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op;
        op=(String)rq.getSession().getAttribute("op");
       if (op.equals("nuevo")) {

            int numEmpleado = Integer.parseInt(rq.getParameter("numEmpleado"));
            String nombre = rq.getParameter("nombre");
            String apellidoPaterno = rq.getParameter("apellidoPaterno");
            String apellidoMaterno = rq.getParameter("apellidoMaterno");
            
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = null;
            Date fechaContrato = null;
            try {
                birthday = inputFormat.parse(rq.getParameter("birthday"));
                fechaContrato = inputFormat.parse(rq.getParameter("fechaContrato"));
            } catch (ParseException e) {
                System.out.println("Conversion incorrecta");
            }
            
            String direccion = rq.getParameter("direccion");
            String telefono = rq.getParameter("telefono");
            int yearsExp = Integer.parseInt(rq.getParameter("yearsExp"));

            Conductor conductor = new Conductor(numEmpleado, nombre, apellidoPaterno, apellidoMaterno, birthday, fechaContrato, direccion, telefono, yearsExp);
            ConductorDAO condao = new ConductorDAO();
            condao.agregar(conductor);
            rp.sendRedirect("/ServletConductor");
        }
       
    }

}
