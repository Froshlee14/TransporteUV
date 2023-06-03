package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Conductor;

public class ConductorDAO{
	
	public static final String selectSQL = "SELECT * FROM conductor";
	public static final String selectNombreSQL = "SELECT nombre FROM conductor WHERE numEmpleado=?";
	public static final String insertSQL = "INSERT INTO conductor (nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp) VALUES (?,?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE conductor SET nombre=?,apellidoPaterno=?,apellidoMaterno=?,birthday=?,fechaContrato=?,direccion=?,telefono=?,yearsExp=? WHERE numEmpleado=?";
	public static final String deleteSQL = "DELETE FROM conductor WHERE numEmpleado=?";
	
	public List<Conductor> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		Conductor con = null;
		
	    System.out.println("Hola ");
		
		List<Conductor> conductores = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numEmpleado = result.getInt("numEmpleado");
				String nombre = result.getString("nombre");
				String apellidoPaterno = result.getString("apellidoPaterno");
				String apellidoMaterno = result.getString("apellidoMaterno");
				Date birthday = result.getDate("birthday");
				Date fechaContrato = result.getDate("fechaContrato");
				String direccion = result.getString("direccion");
				String telefono = result.getString("telefono");
				int yearsExp = result.getInt("yearsExp");
				
				con = new Conductor(numEmpleado,nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp);
				conductores.add(con);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conductores;
	}
	
	public String seleccionarNombre(int us){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		Conductor conductor = null;
		String nombre = "Usuario";
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectNombreSQL);
            
            state.setInt(1,us);
            
			result = state.executeQuery();
			if(result.next()) {
				System.out.println("Registro encontrado ConductorDAO");
				nombre = result.getString("nombre");
				
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return nombre;
	}
	
	public int agregar(Conductor conductor) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,conductor.getNombre());
			state.setString(2,conductor.getApellidoPaterno());
			state.setString(3,conductor.getApellidoMaterno());
			state.setDate(4,(Date)conductor.getBirthday());
			state.setDate(5,(Date)conductor.getFechaContrato());
			state.setString(6,conductor.getDireccion());
			state.setString(7,conductor.getTelefono());
			state.setInt(8,conductor.getYearsExp());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Conductor conductorNvo = new Conductor();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(Conductor conductor) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,conductor.getNombre());
			state.setString(2,conductor.getApellidoPaterno());
			state.setString(3,conductor.getApellidoMaterno());
			state.setDate(4,(Date)conductor.getBirthday());
			state.setDate(5,(Date)conductor.getFechaContrato());
			state.setString(6,conductor.getDireccion());
			state.setString(7,conductor.getTelefono());
			state.setInt(8,conductor.getYearsExp());
			state.setInt(9,conductor.getNumEmpleado());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			Conductor conductorMod = new Conductor();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(Conductor conductor) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,conductor.getNumEmpleado());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Conductor conductorDelete = new Conductor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}

}
