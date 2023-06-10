package modelo;

import java.io.Serializable;

public class ConductorAutobus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int numEmpleado;
	private int numUnidad;
	
	public ConductorAutobus () {
		//Constructor vacio
	}
	
	public ConductorAutobus (int numEmpleado,int numUnidad) {
		
		this.numEmpleado = numEmpleado;
		this.numUnidad = numUnidad;
		
	}
	
	public int getNumEmpleado() {
		return numEmpleado;
	}
	
	public void setNumEmpleado(int num) {
		this.numEmpleado = num;
	}
	
	public int getNumUnidad() {
		return numUnidad;
	}
	
	public void setNumUnidad(int num) {
		this.numUnidad = num;
	}
	
}
