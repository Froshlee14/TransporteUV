package datos;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.ContactoEmergencia;

public class ContactoEmergenciaDAO {
	
	public static final String selectSQL = "SELECT numContacto,nombre,apellidoPaterno,apellidoMaterno,direccion,telefono FROM contactoEmergencia WHERE numEmpleado=?";
	public static final String insertSQL = "INSERT INTO contactoEmergencia (nombre,apellidoPaterno,apellidoMaterno,direccion,telefono,numEmpleado) VALUES (?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE contactoEmergencia SET nombre=?,apellidoPaterno=?,apellidoMaterno=?,direccion=?,telefono=?,numEmpleado=? WHERE numContacto=?";
	public static final String deleteSQL = "DELETE FROM contactoEmergencia WHERE numContacto=?";
	
	public List<ContactoEmergencia> selecionar(int numEmpleado){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        ContactoEmergencia conEm = null;
		
		List<ContactoEmergencia> contactosEmergencia = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setInt(1,numEmpleado);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numContacto = result.getInt("numContacto");
				String nombre = result.getString("nombre");
				String apellidoPaterno = result.getString("apellidoPaterno");
				String apellidoMaterno = result.getString("apellidoMaterno");
				String direccion = result.getString("direccion");
				String telefono = result.getString("telefono");
				
				conEm = new ContactoEmergencia(numContacto,nombre,apellidoPaterno,apellidoMaterno,direccion,telefono);
				contactosEmergencia.add(conEm);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return contactosEmergencia;
	}
	
	public int agregar(ContactoEmergencia contactoEmergencia) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,contactoEmergencia.getNombre());
			state.setString(2,contactoEmergencia.getApellidoPaterno());
			state.setString(3,contactoEmergencia.getApellidoMaterno());
			state.setString(4,contactoEmergencia.getDireccion());
			state.setString(5,contactoEmergencia.getTelefono());
			state.setInt(6,contactoEmergencia.getNumEmpleado());
			
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
	
	public int modificar(ContactoEmergencia contactoEmergencia) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,contactoEmergencia.getNombre());
			state.setString(2,contactoEmergencia.getApellidoPaterno());
			state.setString(3,contactoEmergencia.getApellidoMaterno());
			state.setString(6,contactoEmergencia.getDireccion());
			state.setString(7,contactoEmergencia.getTelefono());
			state.setInt(8,contactoEmergencia.getNumEmpleado());
			state.setInt(9,contactoEmergencia.getNumContacto());
			
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
