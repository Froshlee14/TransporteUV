package controlador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;

import datos.ViajeDAO;
import modelo.Viaje;

@WebServlet("/ServletViajeModificar")

public class ServletViajeModificar extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		int numViaje = Integer.parseInt(request.getParameter("numViaje2"));
		String direccion = request.getParameter("direccion");
		
        String horaPartidaStr = request.getParameter("horaPartida");
        String horaLlegadaStr = request.getParameter("horaLlegada");

        Time horaPartida = formatearHora(horaPartidaStr);
        Time horaLlegada = formatearHora(horaLlegadaStr);
		
		Viaje viaje = new Viaje(numViaje,direccion,horaPartida,horaLlegada);
		ViajeDAO viajedao = new ViajeDAO();
        viajedao.modificar(viaje);
        
        response.sendRedirect("ServletViajeLista");
    }
	
	private Time formatearHora(String hora) {
		
	    try {
	        SimpleDateFormat dateFormatEntrada = new SimpleDateFormat("HH:mm");
	        Date horaDate = dateFormatEntrada.parse(hora);

	        SimpleDateFormat dateFormatSalida = new SimpleDateFormat("HH:mm:ss");
	        String nuevaHora = dateFormatSalida.format(horaDate);

	        return Time.valueOf(nuevaHora);
	       
	    }
	    catch (ParseException e) {
	        e.printStackTrace();
	        return null; 
	    }
	}
}
