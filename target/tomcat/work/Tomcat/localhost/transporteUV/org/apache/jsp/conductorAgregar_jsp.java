/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-10 04:13:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.Conductor;

public final class conductorAgregar_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write("\t<title>TransporteUV</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://unpkg.com/98.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"misEstilos.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      modelo.Conductor conductores = null;
      conductores = (modelo.Conductor) _jspx_page_context.getAttribute("conductores", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (conductores == null){
        conductores = new modelo.Conductor();
        _jspx_page_context.setAttribute("conductores", conductores, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"window\" style=\"display: inline-block;\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"title-bar\">\r\n");
      out.write("\t\t\t<div class=\"title-bar-text\">conductorAgregar.jsp</div>\r\n");
      out.write("\t\t\t<div class=\"title-bar-controls\">\r\n");
      out.write("\t\t\t\t<form action=\"ServletConductorLista\">\r\n");
      out.write("\t\t\t\t\t<button aria-label=\"Close\"></button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"window-body\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<form action=\"ServletConductorAgregar\" method=\"post\" accept-charset=\"UTF-8\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"field-row\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<fieldset > <legend>Informacion general</legend>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field-row-stacked\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"nombre\">Nombre:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"nombre\" type=\"text\" maxlength=\"30\" name=\"nombre\">    \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"field-row-stacked\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"apPaterno\">Apellido paterno:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"apPaterno\" type=\"text\" maxlength=\"30\" name=\"apellidoPaterno\">    \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t\t<div class=\"field-row-stacked\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"apMaterno\">Apellido materno:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"apMaterno\" type=\"text\" maxlength=\"30\" name=\"apellidoMaterno\">    \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t\t <div class=\"field-row-stacked\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"dir\">Direccion:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"dir\" type=\"text\" maxlength=\"120\" name=\"direccion\">    \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t\t<div class=\"field-row-stacked\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"tel\">No. de telefono:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"tel\" type=\"text\" maxlength=\"10\" name=\"telefono\">    \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\t\t<div class=\"field-row\" style=\"margin-TOP: 15px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"bday\">Fecha de nacimiento:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"bday\" type=\"date\" name=\"birthday\" value=\"2000-04-11\">\t\t   \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\r\n");
      out.write(" \t\t\t\t\t</fieldset>\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t<div class=\"field-row-stacked\">\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t<fieldset > <legend>Informacion laboral</legend>\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t\t<div class=\"field-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"aExp\">Años de experiencia:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"aExp\" type=\"number\" name=\"yearsExp\">    \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t\t<div class=\"field-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"fContrato\">Fecha de contratacion:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"fContrato\" type=\"date\" name=\"fechaContrato\" value=\"2018-07-22\">\t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t <fieldset> <legend>Informacion de usuario</legend>\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t\t<div class=\"field-row-stacked\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"nomUsuario\">Nombre de usuario:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"nomUsuario\" type=\"text\" maxlength=\"8\" name=\"usuario\">    \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t\t<div class=\"field-row-stacked\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"pass\">Contraseña:</label>\r\n");
      out.write("\t\t\t    \t\t\t<input id=\"pass\" type=\"text\" maxlength=\"6\" name=\"password\">    \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\t\r\n");
      out.write(" \t\t\t\t\t\t<div class=\"field-row\">\r\n");
      out.write("\t\t\t\t\t\t\t<label for=\"stat\">Status:</label>\r\n");
      out.write("\t\t\t    \t\t\t<select id=\"stat\" name=\"status\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<option>Activo</option>\r\n");
      out.write("  \t\t\t\t\t\t\t\t<option>Inactivo</option>\r\n");
      out.write("\t\t\t\t\t\t\t</select>  \t\t\r\n");
      out.write(" \t\t\t\t\t\t</div>\r\n");
      out.write(" \t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Agregar conductor\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("    \t\t</form>\r\n");
      out.write("    \t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
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
