import java.io.Serializable;

public class Autobus implements Serializable{
	
	private int numUnidad;
	private String numSerie;
	private int idFabricante;
	private int yearFabricacion;
	private int capacidad;
	
	public Autobus() {
		//Constructor vacio
	}
	
	public Autobus(
				int numUnidad,
				String numSerie,
				int idFabricante,
				int yearFabricante,
				int capacidad
			) {
		
		//Constructor con todos atributos
		this.numUnidad = numUnidad;
		this.numSerie = numSerie;
		this.idFabricante = idFabricante;
		this.yearFabricacion = yearFabricacion;
		this.capacidad = capacidad;
		
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
