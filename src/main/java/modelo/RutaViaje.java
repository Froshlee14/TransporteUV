package modelo;

import java.io.Serializable;

public class RutaViaje implements Serializable {


	private static final long serialVersionUID = 1L;

	private int numRuta;
	private int numViaje;
	
	public RutaViaje () {
		//Constructor vacio
	}

	public RutaViaje (int numRuta,int numViaje){
		this.numRuta = numRuta;
		this.numViaje = numViaje;
	}
	
	public int getNumRuta() {
		return numRuta;
	}

	public void setNumRuta(int numRuta) {
		this.numRuta = numRuta;
	}

	public int getNumViaje() {
		return numViaje;
	}

	public void setNumViaje(int numViaje) {
		this.numViaje = numViaje;
	}

	
}
