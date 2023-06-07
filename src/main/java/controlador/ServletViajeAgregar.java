package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import datos.ViajeDAO;
import modelo.Viaje;

@WebServlet("/ServletViajeAgregar")

public class ServletViajeAgregar extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		String direccion = request.getParameter("direccion");
		
        String horaPartidaStr = request.getParameter("horaPartida");
        String horaLlegadaStr = request.getParameter("horaLlegada");

        Time horaPartida = formatearHora(horaPartidaStr);
        Time horaLlegada = formatearHora(horaLlegadaStr);
		
		Viaje viaje = new Viaje(direccion,horaPartida,horaLlegada);
      	ViajeDAO rutadao = new ViajeDAO();
        rutadao.agregar(viaje);
        
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
