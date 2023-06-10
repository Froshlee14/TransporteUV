package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Viaje;

public class ViajeDAO {
	
	
	public static final String selectSQL = "SELECT * FROM viaje";
	public static final String selectPorRutaSQL = "SELECT viaje.numViaje, viaje.direccion, viaje.horaPartida, viaje.horaLlegada FROM viaje JOIN rutaViaje ON viaje.numViaje = rutaViaje.numViaje JOIN ruta ON rutaViaje.numRuta = ruta.numRuta WHERE ruta.numRuta=?";
	public static final String selectPorEmpleadoSQL = "SELECT viaje.numViaje, viaje.direccion, viaje.horaPartida, viaje.horaLlegada,ruta.descripcion as ruta, autobus.numUnidad as autobus\r\n"
			+ "FROM viaje JOIN rutaViaje ON viaje.numViaje = rutaViaje.numViaje \r\n"
			+ "JOIN ruta ON rutaViaje.numRuta = ruta.numRuta \r\n"
			+ "JOIN autobusRuta ON ruta.numRuta = autobusRuta.numRuta \r\n"
			+ "JOIN autobus ON autobusRuta.numUnidad = autobus.numUnidad\r\n"
			+ "JOIN conductorAutobus ON autobus.numUnidad = conductorAutobus.numUnidad\r\n"
			+ "JOIN conductor ON conductorAutobus.numEmpleado = conductor.numEmpleado\r\n"
			+ "WHERE conductor.numEmpleado=?;";
	
	public static final String selectExtendidoSQL = "SELECT viaje.numViaje, viaje.direccion, viaje.horaPartida, viaje.horaLlegada,ruta.descripcion as ruta, autobus.numUnidad, (conductor.nombre||' '||conductor.apellidoPaterno||' '||conductor.apellidoMaterno) as conductor\r\n"
			+ "	FROM viaje JOIN rutaViaje ON viaje.numViaje = rutaViaje.numViaje \r\n"
			+ "	JOIN ruta ON rutaViaje.numRuta = ruta.numRuta \r\n"
			+ "	JOIN autobusRuta ON ruta.numRuta = autobusRuta.numRuta\r\n"
			+ "	JOIN autobus ON autobusRuta.numUnidad = autobus.numUnidad\r\n"
			+ "	JOIN conductorAutobus ON autobus.numUnidad = conductorAutobus.numUnidad\r\n"
			+ "	JOIN conductor ON conductorAutobus.numEmpleado = conductor.numEmpleado\r\n"
			+ "	ORDER BY viaje.horaPartida ASC;";

	public static final String selectNoAsignadosSQL = "SELECT viaje.numViaje, viaje.direccion, viaje.horaPartida, viaje.horaLlegada FROM viaje LEFT JOIN rutaViaje ON viaje.numViaje = rutaViaje.numViaje WHERE rutaViaje.numViaje IS NULL;";
	public static final String selectBuscaSQL = "SELECT * FROM viaje WHERE numViaje=?";
	public static final String insertSQL = "INSERT INTO viaje (direccion,horaPartida,horaLlegada) VALUES (?,?,?)";
	public static final String updateSQL = "UPDATE viaje SET direccion=?,horaPartida=?,horaLlegada=? WHERE numViaje=?";
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
				Time horaPartida = result.getTime("horaPartida");
				Time horaLlegada = result.getTime("horaLlegada");
				
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
	
	public List<Viaje> selecionarPorRuta(int num){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        Viaje ru = null;
		
		List<Viaje> viajes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            
            state = conn.prepareStatement(selectPorRutaSQL);
            
            state.setInt(1,num);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numViaje = result.getInt("numViaje");
				String direccion = result.getString("direccion");
				Time horaPartida = result.getTime("horaPartida");
				Time horaLlegada = result.getTime("horaLlegada");
				
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
	
	public List<Viaje> selecionarPorEmpleado(int num){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
        Viaje ru = null;
		
		List<Viaje> viajes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            
            state = conn.prepareStatement(selectPorEmpleadoSQL);
            
            state.setInt(1,num);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numViaje = result.getInt("numViaje");
				String direccion = result.getString("direccion");
				Time horaPartida = result.getTime("horaPartida");
				Time horaLlegada = result.getTime("horaLlegada");
				String ruta = result.getString("ruta");
				int numAutobus = result.getInt("autobus");
				
				ru = new Viaje(numViaje,direccion,horaPartida,horaLlegada,ruta,numAutobus);
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
	
	public List<Viaje> selecionarNoAsignados(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Viaje viaje = null;
		
		List<Viaje> viajes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectNoAsignadosSQL);
			
			while(result.next()) {
				int numViaje = result.getInt("numViaje");
				String direccion = result.getString("direccion");
				Time horaPartida = result.getTime("horaPartida");
				Time horaLlegada = result.getTime("horaLlegada");
				
				viaje = new Viaje(numViaje,direccion,horaPartida,horaLlegada);
				viajes.add(viaje);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return viajes;
	}
	
	public List<Viaje> selecionarExtendido(){
        Connection conn = null;
        Statement state = null;
        ResultSet result = null;
        Viaje ru = null;
		
		List<Viaje> viajes = new ArrayList<>();
		
		try {
            conn = Conexion.getConnection();
            state = conn.createStatement();
            result = state.executeQuery(selectExtendidoSQL);
			
			while(result.next()) {
				int numViaje = result.getInt("numViaje");
				String direccion = result.getString("direccion");
				Time horaPartida = result.getTime("horaPartida");
				Time horaLlegada = result.getTime("horaLlegada");
				String ruta =  result.getString("ruta");
				int numUnidad = result.getInt("numUnidad");
				String conductor = result.getString("conductor");
				
				ru = new Viaje(numViaje,direccion,horaPartida,horaLlegada,ruta,numUnidad,conductor);
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
	
	public Viaje buscar(int num){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		Viaje viaje = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectBuscaSQL);
            
            state.setInt(1,num);
            
			result = state.executeQuery();
			
			while(result.next()) {
				int numViaje = result.getInt("numViaje");
				String direccion = result.getString("direccion");
				Time horaPartida = result.getTime("horaPartida");
				Time horaLlegada = result.getTime("horaLlegada");
				
				System.out.println("registro encontrado ViajeDAO");
				viaje = new Viaje(numViaje,direccion,horaPartida,horaLlegada);
			}
			Conexion.close(result);
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return viaje;
	}
	
	public int agregar(Viaje viaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,viaje.getDireccion());
			state.setTime(2,viaje.getHoraPartida());
			state.setTime(3,viaje.getHoraLlegada());
			
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
	
	public int modificar(Viaje viaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,viaje.getDireccion());
			state.setTime(2,viaje.getHoraPartida());
			state.setTime(3,viaje.getHoraLlegada());
			state.setInt(4,viaje.getNumViaje());
			
			registros = state.executeUpdate();
			if(registros>0) {
				System.out.println("Registro actualizado");
			}else {
				System.out.println("Registro no actualizado");
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return registros;
	}
	
	public int borrar(int numViaje) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(deleteSQL);
			
			state.setInt(1,numViaje);
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
