package modelo;

import java.io.Serializable;

public class Fabricante implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idFabricante;
	private String nombreFabricante;
	
	public Fabricante() {
		//Constructor vacio
	}
	
	public Fabricante(int idFabricante,String nombreFabricante) {
		this.idFabricante = idFabricante;
		this.nombreFabricante = nombreFabricante;
	}

    public int getIdFabricante() {
        return idFabricante;
    }
    
    public void setIdFabricante(int id) {
        this.idFabricante = id;
    }

    public String getNombreFabricante() {
        return nombreFabricante;
    }
    
    public void setNombreFabricante(String nomf) {
        this.nombreFabricante = nomf;
    }

	
}
