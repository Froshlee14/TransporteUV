package datos;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.ConductorAutobus;

public class ConductorAutobusDAO {
	
	public static final String selectSQL = "SELECT * FROM conductorAutobus";
	public static final String insertSQL = "INSERT INTO conductorAutobus (numEmpleado,numUnidad) VALUES (?,?)";
	public static final String updateSQL = "UPDATE conductorAutobus SET numUnidad=?, WHERE numEmpleado=?";
	public static final String deleteSQL = "DELETE FROM conductorAutobus WHERE numEmpleado=?";
	
	public List<ConductorAutobus> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        ConductorAutobus conAuto = null;
		
		List<ConductorAutobus> conductorAutobuses = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numEmpleado = result.getInt("numEmpleado");
				int numUnidad = result.getInt("numUnidad");
				
				conAuto = new ConductorAutobus(numEmpleado,numUnidad);
				conductorAutobuses.add(conAuto);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(ConductorAutobus a: conductorAutobuses) {
				System.out.println("Numero de empleado: " + a.getNumEmpleado());
				System.out.println("Numero de unidad: " + a.getNumUnidad());
				System.out.println("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conductorAutobuses;
	}
	
	public int agregar(ConductorAutobus conductorAutobus) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setInt(1,conductorAutobus.getNumEmpleado());
			state.setInt(2,conductorAutobus.getNumUnidad());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			ConductorAutobus conductorAutobusNvo = new ConductorAutobus();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(ConductorAutobus conductorAutobus) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setInt(1,conductorAutobus.getNumUnidad());
			state.setInt(2,conductorAutobus.getNumEmpleado());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			ConductorAutobus conductorAutobusMod = new ConductorAutobus();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(ConductorAutobus conductorAutobus) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,conductorAutobus.getNumEmpleado());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			ConductorAutobus conductorAutobusDelete = new ConductorAutobus();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}

}
