package modelo;

import java.io.Serializable;
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String passwrd;
	private int numEmpleado;
	private String rol;
	private boolean status;
	
	public Usuario() {
	}
	
	public Usuario(String usuario, String passwrd, int numEmpleado, String rol, boolean status) {
		this.usuario = usuario;
		this.passwrd = passwrd;
		this.numEmpleado = numEmpleado;
		this.rol = rol;
		this.status = status;
	}

	public Usuario(String passwrd, int numEmpleado, String rol,boolean status) {
		this.passwrd = passwrd;
		this.numEmpleado = numEmpleado;
		this.rol = rol;
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPasswrd() {
		return passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public int getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
	

}
