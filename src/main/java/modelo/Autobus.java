package modelo;

import java.io.Serializable;

public class Autobus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int numUnidad;
	private String numSerie;
	private int idFabricante;
	private int yearFabricacion;
	private int capacidad;
	private boolean status;
	
	public Autobus() {
		//Constructor vacio
	}
	
	public Autobus(int numUnidad) {
		this.numUnidad = numUnidad;
	}
	
	public Autobus(
				int numUnidad,
				String numSerie,
				int idFabricante,
				int yearFabricacion,
				int capacidad,
				boolean status
			) {
		
		//Constructor con todos atributos
		this.numUnidad = numUnidad;
		this.numSerie = numSerie;
		this.idFabricante = idFabricante;
		this.yearFabricacion = yearFabricacion;
		this.capacidad = capacidad;
		this.status = status;
		
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getNumUnidad() {
		return numUnidad;
	}
	    
	public void setNumUnidad(int num) {
		this.numUnidad = num;
	}
	
	public String getNumSerie() {
		return numSerie;
	}
	    
	public void setNumSerie(String num) {
		this.numSerie = num;
	}
	
	public int getIdFabricante() {
		return idFabricante;
	}
	    
	public void setIdFabricante(int idf) {
		this.idFabricante = idf;
	}
	
	public int getYearFabricacion() {
		return yearFabricacion;
	}
	    
	public void setYearFabricacion(int year) {
		this.yearFabricacion = year;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	    
	public void setCapacidad(int cap) {
		this.capacidad = cap;
	}

}
