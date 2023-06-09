package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Autobus;

public class AutobusDAO {
	
	public static final String selectSQL = "SELECT autobus.numUnidad, autobus.numSerie, fabricante.nombreFabricante as fabricante, autobus.yearFabricacion, autobus.capacidad, autobus.status FROM autobus JOIN fabricante ON autobus.idFabricante = fabricante.idFabricante;";
	public static final String selectEmpleadoSQL = "SELECT autobus.numUnidad, autobus.numSerie, fabricante.nombreFabricante as fabricante, autobus.yearFabricacion, autobus.capacidad, autobus.status FROM autobus JOIN conductorAutobus ON autobus.numUnidad = conductorAutobus.numUnidad JOIN conductor ON conductorAutobus.numEmpleado = conductor.numEmpleado JOIN fabricante ON autobus.idFabricante = fabricante.idFabricante WHERE conductor.numEmpleado=?";
	public static final String selectNoAsignadosSQL = "SELECT autobus.numUnidad, autobus.numSerie, fabricante.nombreFabricante as fabricante, autobus.yearFabricacion, autobus.capacidad, autobus.status FROM autobus JOIN fabricante ON autobus.idFabricante = fabricante.idFabricante WHERE autobus.numUnidad NOT IN (SELECT numUnidad FROM conductorAutobus)";
	public static final String selectBuscaSQL = "SELECT * FROM autobus WHERE numUnidad=?";	
	public static final String insertSQL = "INSERT INTO autobus (numSerie,idFabricante,yearFabricacion,capacidad,status) VALUES (?,?,?,?,?)";
	public static final String updateSQL = "UPDATE autobus SET numSerie=?,idFabricante=?,yearFabricacion=?,capacidad=?,status=? WHERE numUnidad=?";
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
				String fabricante = result.getString("fabricante");
				int yearFabricacion = result.getInt("yearFabricacion");
				int capacidad = result.getInt("capacidad");
				boolean status = result.getBoolean("status");
				
				con = new Autobus(numUnidad,numSerie,fabricante,yearFabricacion,capacidad,status);
				autobuses.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return autobuses;
	}
	
	public List<Autobus> seleccionarPorEmpleado(int num){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		Autobus con = null;
		
		List<Autobus> autobuses = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectEmpleadoSQL);
            
            state.setInt(1,num);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numUnidad = result.getInt("numUnidad");
				String numSerie = result.getString("numSerie");
				String fabricante = result.getString("fabricante");
				int yearFabricacion = result.getInt("yearFabricacion");
				int capacidad = result.getInt("capacidad");
				boolean status = result.getBoolean("status");
				
				con = new Autobus(numUnidad,numSerie,fabricante,yearFabricacion,capacidad,status);
				autobuses.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return autobuses;
	}
	
	public List<Autobus> seleccionarNoAsignados(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		Autobus con = null;
		
		List<Autobus> autobuses = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectNoAsignadosSQL);
			
			while(result.next()) {
				int numUnidad = result.getInt("numUnidad");
				String numSerie = result.getString("numSerie");
				String fabricante = result.getString("fabricante");
				int yearFabricacion = result.getInt("yearFabricacion");
				int capacidad = result.getInt("capacidad");
				boolean status = result.getBoolean("status");
				
				con = new Autobus(numUnidad,numSerie,fabricante,yearFabricacion,capacidad,status);
				autobuses.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return autobuses;
	}
	
	public Autobus buscar(int num){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		Autobus autobus = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectBuscaSQL);
            
            state.setInt(1,num);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numUnidad = result.getInt("numUnidad");
				String numSerie = result.getString("numSerie");
				int fabricante = result.getInt("idFabricante");
				int yearFabricacion = result.getInt("yearFabricacion");
				int capacidad = result.getInt("capacidad");
				boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado AutobusDAO");
				autobus = new Autobus(numUnidad,numSerie,fabricante,yearFabricacion,capacidad,status);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return autobus;
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
			state.setBoolean(5,autobus.getStatus());
			
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
			state.setBoolean(5,autobus.getStatus());
			state.setInt(6,autobus.getNumUnidad());
			
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
	
	public int borrar(int numUnidad) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,numUnidad);
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
