package modelo;

import java.io.Serializable;

public class AutobusRuta implements Serializable {
	
	private int numUnidad;
	private int numRuta;
	
	public AutobusRuta () {
		//Constructor vacio
	}
	
	public AutobusRuta (int numUnidad,int numRuta){
		this.numUnidad = numUnidad;
		this.numRuta = numRuta;
	}
	
	public int getNumUnidad() {
		return numUnidad;
	}
	
	public void setNumUnidad(int num) {
		this.numUnidad = num;
	}
	
	public int getNumRuta() {
		return numRuta;
	}
	
	public void setNumRuta(int num) {
		this.numRuta = num;
	}
	
}