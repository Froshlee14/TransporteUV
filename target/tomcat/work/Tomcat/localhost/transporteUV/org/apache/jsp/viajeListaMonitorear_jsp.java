/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-10 04:08:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.Viaje;

public final class viajeListaMonitorear_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>TransporteUV</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://unpkg.com/98.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"misEstilos.css\" />\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      modelo.Viaje viajes = null;
      viajes = (modelo.Viaje) _jspx_page_context.getAttribute("viajes", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (viajes == null){
        viajes = new modelo.Viaje();
        _jspx_page_context.setAttribute("viajes", viajes, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"window\" style=\"display: inline-block;\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"title-bar\">\r\n");
      out.write("\t\t\t<div class=\"title-bar-text\">viajeListaMonitorear.jsp</div>\r\n");
      out.write("\t\t\t<div class=\"title-bar-controls\">\r\n");
      out.write("\t\t\t\t\t<form action=\"indexAdmin.jsp\">\r\n");
      out.write("\t\t\t\t\t\t<button aria-label=\"Close\"></button>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"window-body\"  style=\"margin: 15px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<p> Estos son tus viajes </p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"sunken-panel\">\r\n");
      out.write("\t\t\t\t<table >\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr style=\"margin: 5px;\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<th>No.de viaje</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Direccion</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Hora de partida</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Hora de llegada</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Ruta</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>No. de autobus</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Conductor</th>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

					@SuppressWarnings("unchecked")
					List<Viaje> lista = (List<Viaje>) request.getAttribute("listaExtendida");
					if (lista != null) {
						for (Viaje viaje : lista) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(viaje.getNumViaje());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(viaje.getDireccion());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(viaje.getHoraPartida());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(viaje.getHoraLlegada());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(viaje.getRuta());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(viaje.getNumAutobus());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(viaje.getConductor());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

						}
					}
					else {
						out.print("No existen viajes programados");
					}
					
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
