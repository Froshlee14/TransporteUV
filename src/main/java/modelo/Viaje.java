package modelo;

import java.io.Serializable;
import java.sql.Time;

public class Viaje implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int numViaje;
	private String direccion;
	private Time horaPartida;
	private Time horaLlegada;
	private String ruta;
	private int numUnidad;
	private String numSerie;
	private String conductor;
	
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

	public Viaje(
			int numViaje,
			String direccion,
			Time horaPartida,
			Time horaLlegada,
			String ruta,
			int numUnidad
			) {

		this.numViaje = numViaje;
		this.direccion = direccion;
		this.horaPartida = horaPartida;
		this.horaLlegada = horaLlegada;
		this.ruta = ruta;
		this.numUnidad = numUnidad;
		
	}

	public Viaje(
			int numViaje,
			String direccion,
			Time horaPartida,
			Time horaLlegada,
			String ruta,
			int numUnidad,
			String conductor
			) {

		this.numViaje = numViaje;
		this.direccion = direccion;
		this.horaPartida = horaPartida;
		this.horaLlegada = horaLlegada;
		this.ruta = ruta;
		this.numUnidad = numUnidad;
		this.conductor = conductor;
		
	}

	public String getConductor() {
		return conductor;
	}

	public void setConductor(String conductor) {
		this.conductor = conductor;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public int getNumAutobus() {
		return numUnidad;
	}

	public void setNumAutobus(int numAutobus) {
		this.numUnidad = numAutobus;
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