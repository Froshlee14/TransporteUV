package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.AutobusRuta;

public class AutobusRutaDAO {
	
	public static final String selectSQL = "SELECT * FROM autobusRuta";
	public static final String insertSQL = "INSERT INTO autobusRuta (numUnidad,numRuta) VALUES (?,?)";
	public static final String updateSQL = "UPDATE autobusRuta SET numRuta=?, WHERE numUnidad=?";
	public static final String deleteSQL = "DELETE FROM autobusRuta WHERE numUnidad=?";
	
	public List<AutobusRuta> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		AutobusRuta con = null;
		
		List<AutobusRuta> autobusRutas = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numUnidad = result.getInt("numUnidad");
				int numRuta = result.getInt("numRuta");
				
				con = new AutobusRuta(numUnidad,numRuta);
				autobusRutas.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(AutobusRuta a: autobusRutas) {
				System.out.println("Numero de unidad: " + a.getNumUnidad());
				System.out.println("Numero de ruta: " + a.getNumRuta());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return autobusRutas;
	}
	
	public int agregar(AutobusRuta autobusRuta) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,autobusRuta.getNumUnidad());
			state.setInt(2,autobusRuta.getNumRuta());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			AutobusRuta autobusRutaNvo = new AutobusRuta();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(AutobusRuta autobusRuta) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,autobusRuta.getNumRuta());
			state.setInt(2,autobusRuta.getNumUnidad());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			AutobusRuta autobusRutaMod = new AutobusRuta();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(AutobusRuta autobusRuta) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,autobusRuta.getNumUnidad());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			AutobusRuta autobusRutaDelete = new AutobusRuta();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}

}
