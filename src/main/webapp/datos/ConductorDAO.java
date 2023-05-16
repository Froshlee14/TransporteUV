package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConductorDAO{
	
	public static final String selectSQL = "SELECT * FROM coductor";
	public static final String insertSQL = "INSERT INTO conductor (nombre,apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp) VALUES (?,?,?,?,?,?,?,?)";
	public static final String updateSQL = "UPDATE conductor SET nombre=?,apellidoPaterno=?,apellidoMaterno=?,birthday=?,fechaContrato=?,direccion=?,telefono=?,yearsExp=? WHERE numEmpleado=?";
	public static final String deleteSQL = "DELETE FRMOM conductor WHERE numEmpleado=?";
	
	public List<Conductor> selecionar(){
		Connection conn = null;
		Statement state = null;	
		ResultSet result = null;
		Conductor con = null;
		
		List<Conductor> conductor = new ArrayList<>();
		
		try {
			conn = Conexion.getConnection();
			state = conn.createStatement();
			result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				String numEmpleado = result.getInt("numEmpleado");
				String nombre = result.getString("nombre");
				String apellidoPaterno = result.getString("apellidoPaterno");
				String apellidoMaterno = result.getString("apellidoMaterno");
				date birthday = result.getDate("birthday");
				date fechaContrato = result.getDate("fechaContrato");
				String direccion = result.getString("direccion");
				String telefono = result.getString("telefono");
				int yearsExp = result.getInt("yearsExp");
				
				con = new Conductor(numEmpleado,nombre.apellidoPaterno,apellidoMaterno,birthday,fechaContrato,direccion,telefono,yearsExp);
				conductor.add(con);
			}
			conexion.close(result);
			conexion.close(state);
			conexion.close(conn)
			
			for(conductor c: conductor) {
				System.out.printl("Numero de empleado: " + c.getNumEmpleado());
				System.out.printl("Nombre: " + c.getNombre());
				System.out.printl("Apellido paterno: " + c.getApellidoPaterno());
				System.out.printl("Apellido materno: " + c.getApellidoMaterno());
				System.out.printl("Fecha de nacimiento: " + c.getBirthday());
				System.out.printl("Fecha de contrato: " + c.getFechaContrato());
				System.out.printl("Dirección: " + c.getDireccion());
				System.out.printl("Telefono: " + c.getTelefono());
				System.out.printl("Años de experiencia: " + c.getYearsExp());
				System.out.printl("\n");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conductor;
	}
	
	public int agregar(Conductor conductor) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,conductor.getNombre());
			state.setString(2,conductor.getApellidoPaterno());
			state.setString(3,conductor.getApellidoMaterno());
			state.setDate(4,(Date)conductor.getBirthday());
			state.setDate(5,(Date)conductor.getFechaContrato());
			state.setString(6,conductor.getDireccion());
			state.setString(7,conductor.getTelefono());
			state.setString(8,conductor.getTearExp());
			
			registros = state.executeUpdate()
			if(registros>0)
				System.out.println("Registro agregado correctamente");
			
			Conexion.close(state);
			Conexion.close(conn);
			Conductor conductorNvo = new Conductor();
			
		} catch(Exeption e) {
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
			
			if(registros>0)
				System.out.println("Registro eliminado");
			
			Conexion.close(state);
			Conexion.close(conn);
			Conductor conductorDelete = new Conductor();
		} catch (Exeption e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(Conductor conductor) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,conductor.getNombre());
			state.setString(2,conductor.getApellidoPaterno());
			state.setString(3,conductor.getApellidoMaterno());
			state.setDate(4,(Date)conductor.getBirthday());
			state.setDate(5,(Date)conductor.getFechaContrato());
			state.setString(6,conductor.getDireccion());
			state.setString(7,conductor.getTelefono());
			state.setString(8,conductor.getTearExp());
			
			registros = state.executeUpdate()
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			Conductor conductorMod = new Conductor();
			
		} catch(SQLExeption e) {
			e.printStackTrace();
		}
		return registros;
	}

}
