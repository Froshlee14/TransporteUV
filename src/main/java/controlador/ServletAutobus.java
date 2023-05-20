package controlador;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.sql.DataSource;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;

import datos.Conexion;
import modelo.Autobus;
import datos.AutobusDAO;

@WebServlet(name = "ServletAutobus", urlPatterns = {"/ServletAutobus"})

public class ServletAutobus  extends HttpServlet{
	
	 //PETICION GET
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException {
        String opc = (rq.getParameter("opc") != null) ? rq.getParameter("opc") : "list";

        if (opc.equals("list")) {
        	AutobusDAO autodao = new AutobusDAO();
            List<Autobus> lista = autodao.selecionar();
            rq.setAttribute("lista",lista);
            rq.getRequestDispatcher("vistas/clientes/index.jsp").forward(rq, rp);
        }

        else if (opc.equals("mostrar")) {
            Conexion con = new Conexion();
            Connection c = con.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            int numUnidad = Integer.parseInt(rq.getParameter(("numUnidad")));
            try {
                String updateSql = "SELECT * FROM autobus WHERE numUnidad = ? ";
                ps = c.prepareStatement(updateSql);
                ps.setInt(1, numUnidad);
                rs = ps.executeQuery();
                Autobus auto = new Autobus();
                while (rs.next()) {

                    auto.setNumUnidad(rs.getInt("numUnidad"));
                    auto.setNumSerie(rs.getString("numSerie"));
                    auto.setIdFabricante(rs.getInt("idFabricante"));
                    auto.setYearFabricacion(rs.getInt("yearFabricacion"));
                    auto.setCapacidad(rs.getInt("capacidad"));
                }
                rq.setAttribute("autobus", auto);

                rq.getRequestDispatcher("vistas/clientes/modificar.jsp").forward(rq, rp);
               
            } catch (SQLException ex) {
                System.out.println("Error en SQL " + ex.getMessage());
            }
        }
      
        else if (opc.equals("eliminar")) {

            int numUnidad = Integer.parseInt(rq.getParameter(("numUnidad")));
            Autobus auto = new Autobus(numUnidad);
            AutobusDAO autodao = new AutobusDAO();
            autodao.borrar(auto);
            rp.sendRedirect("ServletAutobus");
        }
    }
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String op;
        op=(String)rq.getSession().getAttribute("op");
       if (op.equals("nuevo")) {

            int numUnidad = Integer.parseInt(rq.getParameter("numUnidad"));
            String numSerie = rq.getParameter("numSerie");
            int idFabricante = Integer.parseInt(rq.getParameter("idFabricante"));
            int yearFabricacion = Integer.parseInt(rq.getParameter("yearFabricacion"));
            int capacidad = Integer.parseInt(rq.getParameter("capacidad"));

            Autobus autobus = new Autobus(numUnidad, numSerie, idFabricante, yearFabricacion, capacidad);
            AutobusDAO autodao = new AutobusDAO();
            autodao.agregar(autobus);
            rp.sendRedirect("/ServletAutobus");
        }
       
    }

}
