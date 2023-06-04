package datos;

import java.sql.*;

import modelo.Usuario;

public class UsuarioDAO {
	
	public static final String selectSQL = "SELECT passwrd,numEmpleado,rol,status FROM usuarios WHERE usuario=?";
	public static final String insertSQL = "INSERT INTO usuarios (usuario,passwrd,numEmpleado,rol) VALUES (?,?,?,?)";
	public static final String updateSQL = "UPDATE usuarios SET usuario=?,passwrd=?,numEmpleado=?,rol=? WHERE usuario=?";
	public static final String deleteSQL = "DELETE FROM usuarios WHERE usuario=?";
	
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
				boolean status = result.getBoolean("status");
				
				usuario = new Usuario(passwrd,numEmpleado,rol,status);
			}
			
			Conexion.close(state);
			Conexion.close(conn);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

}
