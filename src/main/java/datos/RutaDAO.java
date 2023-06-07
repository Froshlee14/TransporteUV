package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Ruta;

public class RutaDAO {
	
	
	public static final String selectSQL = "SELECT * FROM ruta";
	public static final String selectBuscaSQL = "SELECT * FROM ruta WHERE numRuta=?";
	public static final String insertSQL = "INSERT INTO ruta (descripcion,destinoInicial,destinoFinal) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE ruta SET descripcion=?,destinoInicial=?,destinoFinal=? WHERE numRuta=?";
	public static final String deleteSQL = "DELETE FROM ruta WHERE numRuta=?";
	
	public List<Ruta> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Ruta ru = null;
		
		List<Ruta> rutas = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numRuta = result.getInt("numRuta");
				String descripcion = result.getString("descripcion");
				String destinoInicial = result.getString("destinoInicial");
				String destinoFinal = result.getString("destinoFinal");
				
				ru = new Ruta(numRuta,descripcion,destinoInicial,destinoFinal);
				rutas.add(ru);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return rutas;
	}
	
	public Ruta buscar(int num){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		Ruta ruta = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectBuscaSQL);
            
            state.setInt(1,num);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numRuta = result.getInt("numRuta");
				String descripcion = result.getString("descripcion");
				String destinoInicial = result.getString("destinoInicial");
				String destinoFinal = result.getString("destinoFinal");
				
				System.out.println("registro encontrado RutaDAO");
				ruta = new Ruta(numRuta,descripcion,destinoInicial,destinoFinal);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ruta;
	}
	
	
	public int agregar(Ruta ruta) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,ruta.getDescripcion());
			state.setString(2,ruta.getDestinoInicial());
			state.setString(3,ruta.getDestinoFinal());
			
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
	
	public int modificar(Ruta ruta) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,ruta.getDescripcion());
			state.setString(2,ruta.getDestinoInicial());
			state.setString(3,ruta.getDestinoFinal());
			state.setInt(4,ruta.getNumRuta());
			
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
	
	public int borrar(int numRuta) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,numRuta);
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
