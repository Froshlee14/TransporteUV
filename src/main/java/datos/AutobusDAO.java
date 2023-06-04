package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Autobus;

public class AutobusDAO {
	
	public static final String selectSQL = "SELECT * FROM autobus";
	public static final String insertSQL = "INSERT INTO autobus (numSerie,idFabricante,yearFabricacion,capacidad) VALUES (?,?,?,?)";
	public static final String updateSQL = "UPDATE autobus SET numSerie=?,idFabricante=?,yearFabricacion=?,capacidad=? WHERE numUnidad=?";
	public static final String deleteSQL = "DELETE FROM autobus WHERE numUnidad=?";
	
	public List<Autobus> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		Autobus con = null;
		
		List<Autobus> autobuses = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numUnidad = result.getInt("numUnidad");
				String numSerie = result.getString("numSerie");
				int idFabricante = result.getInt("idFabricante");
				int yearFabricacion = result.getInt("yearFabricacion");
				int capacidad = result.getInt("capacidad");
				boolean status = result.getBoolean("status");
				
				con = new Autobus(numUnidad,numSerie,idFabricante,yearFabricacion,capacidad,status);
				autobuses.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(Autobus a: autobuses) {
				System.out.println("Numero de unidad: " + a.getNumUnidad());
				System.out.println("Numero de serie: " + a.getNumSerie());
				System.out.println("ID de fabricante: " + a.getIdFabricante());
				System.out.println("Año de fabricacion: " + a.getYearFabricacion());
				System.out.println("Capacidad: " + a.getCapacidad());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return autobuses;
	}
	
	public int agregar(Autobus autobus) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,autobus.getNumSerie());
			state.setInt(2,autobus.getIdFabricante());
			state.setInt(3,autobus.getYearFabricacion());
			state.setInt(4,autobus.getCapacidad());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Autobus autobusrNvo = new Autobus();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(Autobus autobus) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,autobus.getNumSerie());
			state.setInt(2,autobus.getIdFabricante());
			state.setInt(3,autobus.getYearFabricacion());
			state.setInt(4,autobus.getCapacidad());
			state.setInt(5,autobus.getNumUnidad());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			Autobus autobusMod = new Autobus();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(Autobus autobus) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,autobus.getNumUnidad());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Autobus autobusDelete = new Autobus();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}

}
