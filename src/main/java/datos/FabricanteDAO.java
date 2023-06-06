package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Fabricante;

public class FabricanteDAO {

	public static final String selectSQL = "SELECT * FROM fabricante";
	public static final String insertSQL = "INSERT INTO fabricante (nombreFabricante) VALUES (?)";
	public static final String updateSQL = "UPDATE fabricante SET nombreFabricante=?, WHERE idFabricante=?";
	public static final String deleteSQL = "DELETE FROM fabricante WHERE idFabricante=?";
	
	public List<Fabricante> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Fabricante con = null;
		
		List<Fabricante> fabricantes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int idFabricante = result.getInt("idFabricante");
				String nombreFabricante = result.getString("nombreFabricante");
				
				con = new Fabricante(idFabricante,nombreFabricante);
				fabricantes.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return fabricantes;
	}
	
	public int agregar(Fabricante fabricante) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,fabricante.getNombreFabricante());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Fabricante fabricanteNvo = new Fabricante();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(Fabricante fabricante) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,fabricante.getNombreFabricante());
			state.setInt(2,fabricante.getIdFabricante());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			Fabricante fabricanteMod = new Fabricante();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(Fabricante fabricante) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,fabricante.getIdFabricante());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Fabricante fabricanteDelete = new Fabricante();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
}
