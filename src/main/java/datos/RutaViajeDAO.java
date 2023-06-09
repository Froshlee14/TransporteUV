package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.RutaViaje;

public class RutaViajeDAO {
	
	public static final String selectSQL = "SELECT * FROM rutaViaje";
	public static final String insertSQL = "INSERT INTO rutaViaje (numRuta,numViaje) VALUES (?,?)";
	public static final String updateSQL = "UPDATE rutaViaje SET numRuta=?, WHERE numRuta=?";
	public static final String deleteSQL = "DELETE FROM rutaViaje WHERE numViaje=?";
	
	public List<RutaViaje> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        RutaViaje rutaviaje = null;
		
		List<RutaViaje> autobusRutas = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numRuta = result.getInt("numRuta");
				int numViaje = result.getInt("numViaje");
				
				rutaviaje = new RutaViaje(numRuta,numViaje);
				autobusRutas.add(rutaviaje);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return autobusRutas;
	}
	
	public int agregar(RutaViaje rutaviaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,rutaviaje.getNumRuta());
			state.setInt(2,rutaviaje.getNumViaje());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(RutaViaje rutaviaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,rutaviaje.getNumRuta());
			state.setInt(2,rutaviaje.getNumViaje());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(int num) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,num);
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}

}
