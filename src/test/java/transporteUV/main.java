package transporteUV;

import java.sql.*;
import java.util.*;
import datos.*;
import modelo.*;


public class main {
	public static void main(String[] args) {
		
		//Conexion conexion = new Conexion();
		//Connection connection = null;
		//Conductor conductor = new Conductor();
		ConductorDAO conductordao = new ConductorDAO();
		
		System.out.println(conductordao.selecionar());
		
		List<Conductor> lista = (List<Conductor>) conductordao.selecionar();
        if (lista != null){
        	for (Conductor v : lista){

        		System.out.println(v.getNumEmpleado()); 
        		System.out.println(v.getNombre());
        		System.out.println(v.getApellidoPaterno());
        		System.out.println(v.getApellidoMaterno());
        		System.out.println("\n");
        	}
       	}
        else{
        	System.out.print("No hay nada");
        }
	} 

}
