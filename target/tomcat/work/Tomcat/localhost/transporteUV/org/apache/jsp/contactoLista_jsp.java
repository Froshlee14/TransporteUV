/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2023-06-10 04:12:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import modelo.ContactoEmergencia;
import modelo.Conductor;

public final class contactoLista_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>TransporteUV</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://unpkg.com/98.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"misEstilos.css\" />\r\n");
      out.write("  \t</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      modelo.ContactoEmergencia conductores = null;
      conductores = (modelo.ContactoEmergencia) _jspx_page_context.getAttribute("conductores", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (conductores == null){
        conductores = new modelo.ContactoEmergencia();
        _jspx_page_context.setAttribute("conductores", conductores, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"window\" style=\"display: inline-block;\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"title-bar\">\r\n");
      out.write("\t\t\t<div class=\"title-bar-text\">contactoLista.jsp</div>\r\n");
      out.write("\t\t\t<div class=\"title-bar-controls\">\r\n");
      out.write("\t\t\t\t<form action=\"ServletConductorLista\">\r\n");
      out.write("\t\t\t\t\t<button aria-label=\"Close\"></button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"window-body\"  style=\"margin: 15px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 Conductor conductor = (Conductor) request.getAttribute("conductor"); 
      out.write("\r\n");
      out.write("\t\t\t<p> Contactos de emergencia de ");
out.print(conductor.getNombre());
      out.write(" <p>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"sunken-panel\">\r\n");
      out.write("\t\t\t\t<table class=\"interactive\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>No. de contacto</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Nombre</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Apellido Paterno</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Apellido Materno</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Direccion</th>\r\n");
      out.write("\t\t\t\t\t\t\t<th>Telefono</th>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");

					@SuppressWarnings("unchecked")
					List<ContactoEmergencia> lista = (List<ContactoEmergencia>) request.getAttribute("lista");
					if (lista != null) {
						for (ContactoEmergencia contacto : lista) {
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<tr onclick=\"seleccionarContacto(");
      out.print( contacto.getNumContacto() );
      out.write(",this)\">\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(contacto.getNumContacto());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(contacto.getNombre());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(contacto.getApellidoPaterno());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(contacto.getApellidoMaterno());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(contacto.getDireccion());
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
out.print(contacto.getTelefono());
      out.write("</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t");

						}
					}
					else {
						out.print("No hay nada");
					}
					
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"field-row\" style=\"margin-top: 15px;  justify-content: flex-end;\">\r\n");
      out.write("\t\t\t\t<form method=\"get\">\r\n");
      out.write("\t\t\t\t\t<label for=\"numContacto\"> </label>\r\n");
      out.write("\t\t\t    \t<input id=\"numContacto\" type=\"hidden\" name=\"numContacto\" readonly>\r\n");
      out.write("\t\t\t    \t<input type=\"hidden\" name=\"numEmpleado\" value=\"");
      out.print( conductor.getNumEmpleado() );
      out.write("\">\t\t\r\n");
      out.write(" \r\n");
      out.write(" \t\t\t\t\t<input id=\"modificarBtn\" type=\"submit\" formaction=\"ServletContactoBuscar\" value=\"Modificar contacto\" disabled>\r\n");
      out.write("\t\t\t\t\t<input id=\"borrarBtn\" type=\"submit\" formaction=\"ServletContactoBorrar\" value=\"Borrar contacto\" disabled>\r\n");
      out.write("    \t\t\t</form>\r\n");
      out.write("    \t\t\t<form action=\"contactoAgregar.jsp\">\r\n");
      out.write("    \t\t\t\t<input type=\"hidden\" name=\"numEmpleado\" value=\"");
      out.print( conductor.getNumEmpleado() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Nuevo contacto\">\r\n");
      out.write("    \t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//Evitemos la flojera del usuario para escribir el numero del contacto\r\n");
      out.write("  \t\tfunction seleccionarContacto(num,row) {\r\n");
      out.write("  \t\t\t\r\n");
      out.write("\t\t\t//Movemos el numero de contacto al input oculto.\r\n");
      out.write("\t  \t\tvar inputNumContacto = document.getElementById(\"numContacto\");\r\n");
      out.write("\t  \t\tinputNumContacto.value = num;\r\n");
      out.write("\t  \t\t\r\n");
      out.write("\t  \t\t//Asimismo los botones estaran desactivados mientras el input este vacio\r\n");
      out.write("\t  \t \tvar modificarBtn = document.getElementById(\"modificarBtn\");\r\n");
      out.write("\t  \t  \tmodificarBtn.disabled = false;\r\n");
      out.write("\t  \t \t\r\n");
      out.write("\t  \t  \tvar borrarsBtn = document.getElementById(\"borrarBtn\");\r\n");
      out.write("\t  \t  \tborrarsBtn.disabled = false;\r\n");
      out.write("\t  \t \t\r\n");
      out.write("\t        var filas = document.getElementsByTagName(\"tr\");\r\n");
      out.write("\t        \r\n");
      out.write("\t        //Quito la propiedad \"selected\" al resto de columnas\r\n");
      out.write("\t        for (var i = 0; i < filas.length; i++) {\r\n");
      out.write("\t          filas[i].classList.remove(\"selected\");\r\n");
      out.write("\t        }\r\n");
      out.write("\t        \r\n");
      out.write("\t        //Cambio el color la columna seleccionada\r\n");
      out.write("\t       \trow.classList.add(\"selected\");\r\n");
      out.write("  \t\t}\r\n");
      out.write("\t</script>\r\n");
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
