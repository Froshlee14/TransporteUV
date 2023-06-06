package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Viaje;

public class ViajeDAO {
	
	
	public static final String selectSQL = "SELECT * FROM viaje";
	public static final String insertSQL = "INSERT INTO viaje (direccion,horaPartida,horaLlegada) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE viaje SET direccion=?,horaPartida=?,horaLlegada=?, WHERE numViaje=?";
	public static final String deleteSQL = "DELETE FROM viaje WHERE numViaje=?";
	
	public List<Viaje> selecionar(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Viaje ru = null;
		
		List<Viaje> viajes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectSQL);
			
			while(result.next()) {
				int numViaje = result.getInt("numViaje");
				String direccion = result.getString("direccion");
				String horaPartida = result.getString("horaPartida");
				String horaLlegada = result.getString("horaLlegada");
				
				ru = new Viaje(numViaje,direccion,horaPartida,horaLlegada);
				viajes.add(ru);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return viajes;
	}
	
	public int agregar(Viaje viaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,viaje.getDireccion());
			state.setString(2,viaje.getHoraPartida());
			state.setString(3,viaje.getHoraLlegada());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro agregado correctamente");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Viaje viajeNvo = new Viaje();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int modificar(Viaje viaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,viaje.getDireccion());
			state.setString(2,viaje.getHoraPartida());
			state.setString(3,viaje.getHoraLlegada());
			state.setInt(4,viaje.getNumViaje());
			
			registros = state.executeUpdate();
			if(registros>0)
				System.out.println("Registro actualizado");
			
			Conexion.close(state);
			Conexion.close(conn);
			Viaje viajeMod = new Viaje();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(Viaje viaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,viaje.getNumViaje());
			registros = state.executeUpdate();
			
			if(registros>0) {
				System.out.println("Registro eliminado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			Viaje viajeDelete = new Viaje();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return registros;
	}


}
