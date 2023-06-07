package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Conductor;

public class ConductorDAO{
	
	public static final String selectSQL = "SELECT * FROM conductor";
	public static final String selectNombreSQL = "SELECT nombre FROM conductor WHERE numEmpleado=?";
	public static final String selectBuscaSQL = "SELECT * FROM conductor WHERE numEmpleado=?";
	public static final String insertSQL = "INSERT INTO conductor (nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp) VALUES (?,?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE conductor SET nombre=?,apellidoPaterno=?,apellidoMaterno=?,birthday=?,fechaContrato=?,direccion=?,telefono=?,yearsExp=?,status=? WHERE numEmpleado=?";
	public static final String deleteSQL = "DELETE FROM conductor WHERE numEmpleado=?";
	
	public List<Conductor> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
		Conductor con = null;
		
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
				boolean status = result.getBoolean("status");
				
				con = new Conductor(numEmpleado,nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp,status);
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
	
	public Conductor buscar(int num){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		Conductor conductor = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectBuscaSQL);
            
            state.setInt(1,num);
            
			result = state.executeQuery();
			
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
				boolean status = result.getBoolean("status");
				
				System.out.println("registro encontrado");
				conductor = new Conductor(numEmpleado,nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp,status);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conductor;
	}
	
	public int agregar(Conductor conductor) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		int idGenerado = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
			
			state.setString(1,conductor.getNombre());
			state.setString(2,conductor.getApellidoPaterno());
			state.setString(3,conductor.getApellidoMaterno());
			state.setDate(4,(Date)conductor.getBirthday());
			state.setDate(5,(Date)conductor.getFechaContrato());
			state.setString(6,conductor.getDireccion());
			state.setString(7,conductor.getTelefono());
			state.setInt(8,conductor.getYearsExp());
			
			registros = state.executeUpdate();
	        if (registros > 0) {
	            ResultSet generatedKeys = state.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                idGenerado = generatedKeys.getInt(1);
	                System.out.println("ID generada: " + idGenerado);
	            }
	        }
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return idGenerado;
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
			state.setBoolean(9, conductor.getStatus());
			state.setInt(10,conductor.getNumEmpleado());
			
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
	
	public int borrar(int numEmpleado) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,numEmpleado);
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
