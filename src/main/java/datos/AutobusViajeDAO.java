package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.AutobusViaje;

public class AutobusViajeDAO {
	
	public static final String selectSQL = "SELECT * FROM autobusViaje";
	public static final String insertSQL = "INSERT INTO autobusViaje (numUnidad,numViaje) VALUES (?,?)";
	public static final String updateSQL = "UPDATE autobusViaje SET numViaje=?, WHERE numUnidad=?";
	public static final String deleteSQL = "DELETE FROM autobusViaje WHERE numUnidad=?";
	
	public List<AutobusViaje> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		AutobusViaje con = null;
		
		List<AutobusViaje> autobusViajes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numUnidad = result.getInt("numUnidad");
				int numRuta = result.getInt("numRuta");
				
				con = new AutobusViaje(numUnidad,numRuta);
				autobusViajes.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(AutobusViaje a: autobusViajes) {
				System.out.println("Numero de unidad: " + a.getNumUnidad());
				System.out.println("Numero de viaje: " + a.getNumViaje());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return autobusViajes;
	}
	
	public int agregar(AutobusViaje autobusViaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,autobusViaje.getNumUnidad());
			state.setInt(2,autobusViaje.getNumViaje());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			AutobusViaje autobusViajeNvo = new AutobusViaje();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(AutobusViaje autobusViaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,autobusViaje.getNumViaje());
			state.setInt(2,autobusViaje.getNumUnidad());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			AutobusViaje autobusRutaMod = new AutobusViaje();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(AutobusViaje autobusViaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,autobusViaje.getNumUnidad());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			AutobusViaje autobusViajeDelete = new AutobusViaje();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}

}
