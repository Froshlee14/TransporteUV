package datos;

import java.sql.*;

import modelo.Usuario;

public class UsuarioDAO {
	
	public static final String selectSQL = "SELECT passwrd,numEmpleado,rol FROM usuarios WHERE usuario=?";
	public static final String selectEmpleadoSQL = "SELECT usuario,passwrd,numEmpleado,rol FROM usuarios WHERE numEmpleado=?";
	public static final String insertSQL = "INSERT INTO usuarios (usuario,passwrd,numEmpleado,rol) VALUES (?,?,?,?)";
	public static final String updateSQL = "UPDATE usuarios SET usuario=?,passwrd=?,rol=? WHERE numEmpleado=?";
	public static final String deleteSQL = "DELETE FROM usuarios WHERE numEmpleado=?";
	
	public Usuario buscar(String us){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		Usuario usuario = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectSQL);
            
            state.setString(1,us);
            
			result = state.executeQuery();
			if(result.next()) {
				System.out.println("Registro encontrado");
				String passwrd = result.getString("passwrd");
				int numEmpleado = result.getInt("numEmpleado");
				String rol = result.getString("rol");
				
				usuario = new Usuario(passwrd,numEmpleado,rol);
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public Usuario buscarPorEmpleado(int numEm){
        Connection conn = null;
        PreparedStatement state = null;
        ResultSet result = null;
		Usuario usuario = null;
		
		try {
            conn = Conexion.getConnection();
            state = conn.prepareStatement(selectEmpleadoSQL);
            
            state.setInt(1,numEm);
            
			result = state.executeQuery();
			if(result.next()) {
				System.out.println("Registro encontrado");
				String nomUsuario = result.getString("usuario");
				String passwrd = result.getString("passwrd");
				int numEmpleado = result.getInt("numEmpleado");
				String rol = result.getString("rol");
				
				usuario = new Usuario(nomUsuario,passwrd,numEmpleado,rol);
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public int agregar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		int idGenerado = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(insertSQL);
			
			state.setString(1,usuario.getUsuario());
			state.setString(2,usuario.getPasswrd());
			state.setInt(3,usuario.getNumEmpleado());
			state.setString(4,usuario.getRol());
			
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
	
	public int modificar(Usuario usuario) {
		Connection conn = null;
		PreparedStatement state = null;
		int registros = 0;
		
		try {
			conn = Conexion.getConnection();
			state = conn.prepareStatement(updateSQL);
			
			state.setString(1,usuario.getUsuario());
			state.setString(2,usuario.getPasswrd());
			state.setString(3,usuario.getRol());
			state.setInt(4,usuario.getNumEmpleado());
			
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
	
	public int borrarPorEmpleado(int numEmpleado) {
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
