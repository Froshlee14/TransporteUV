package modelo;

import java.io.Serializable;

public class Viaje implements Serializable {
	
	private int numViaje;
	private String direccion;
	private String horaPartida;
	private String horaLlegada;
	
	public Viaje() {
		//Constructor vacio
	}
	
	public Viaje(
				int numViaje,
				String direccion,
				String horaPartida,
				String horaLlegada
			) {
		
		this.numViaje = numViaje;
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
	
	public String getHoraPartida() {
		return horaPartida;
	}
	
	public void setHoraPartida(String hor) {
		this.horaPartida = hor;
	}
	
	public String getHoraLlegada() {
		return horaLlegada;
	}
	
	public void setHoraLlegada(String hor) {
		this.horaLlegada = hor;
	}
	
}