package modelo;

import java.io.Serializable;
import java.sql.Time;

public class Viaje implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int numViaje;
	private String direccion;
	private Time horaPartida;
	private Time horaLlegada;
	
	public Viaje() {
		//Constructor vacio
	}
	
	public Viaje(
				int numViaje,
				String direccion,
				Time horaPartida,
				Time horaLlegada
			) {
		
		this.numViaje = numViaje;
		this.direccion = direccion;
		this.horaPartida = horaPartida;
		this.horaLlegada = horaLlegada;
		
	}
	
	public Viaje(
				String direccion,
				Time horaPartida,
				Time horaLlegada
			) {
		
		this.direccion = direccion;
		this.horaPartida = horaPartida;
		this.horaLlegada = horaLlegada;
		
	}

	public int getNumViaje() {
		return numViaje;
	}
	
	public void setNumViaje(int num) {
		this.numViaje = num;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String dir) {
		this.direccion = dir;
	}

	public Time getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(Time horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Time getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Time horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	
}