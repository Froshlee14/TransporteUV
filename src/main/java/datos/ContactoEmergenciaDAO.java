package datos;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.ContactoEmergencia;

public class ContactoEmergenciaDAO {
	
	public static final String selectSQL = "SELECT * FROM contactoEmergencia";
	public static final String insertSQL = "INSERT INTO contactoEmergencia (nombre,apellidoPaterno,apellidoMaterno,direccion,telefono,numEmpleado) VALUES (?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE contactoEmergencia SET nombre=?,apellidoPaterno=?,apellidoMaterno=?,direccion=?,telefono=?,numEmpleado=? WHERE numContacto=?";
	public static final String deleteSQL = "DELETE FROM contactoEmergencia WHERE numContacto=?";
	
	public List<ContactoEmergencia> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        ContactoEmergencia conEm = null;
		
		List<ContactoEmergencia> contactosEmergencia = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numContacto = result.getInt("numContacto");
				String nombre = result.getString("nombre");
				String apellidoPaterno = result.getString("apellidoPaterno");
				String apellidoMaterno = result.getString("apellidoMaterno");
				String direccion = result.getString("direccion");
				String telefono = result.getString("telefono");
				int numEmpleado = result.getInt("numEmpleado");
				
				conEm = new ContactoEmergencia(numContacto,nombre,apellidoPaterno,apellidoMaterno,direccion,telefono,numEmpleado);
				contactosEmergencia.add(conEm);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
			for(ContactoEmergencia ce: contactosEmergencia) {
				System.out.println("Numero de contacto: " + ce.getNumContacto());
				System.out.println("Nombre: " + ce.getNombre());
				System.out.println("Apellido paterno: " + ce.getApellidoPaterno());
				System.out.println("Apellido materno: " + ce.getApellidoMaterno());
				System.out.println("Dirección: " + ce.getDireccion());
				System.out.println("Telefono: " + ce.getTelefono());
				System.out.println("Numero de empleado: " + ce.getNumEmpleado());
				System.out.println("\n");
			}
			
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
			ContactoEmergencia contactoEmergenciaNvo = new ContactoEmergencia();
			
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
			ContactoEmergencia contactoEmergenciaMod = new ContactoEmergencia();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(ContactoEmergencia contactoEmergencia) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,contactoEmergencia.getNumContacto());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			ContactoEmergencia contactoEmergenciaDelete = new ContactoEmergencia();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}

}
