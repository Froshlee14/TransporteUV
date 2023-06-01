package modelo;

import java.io.Serializable;
import java.util.Date;

public class Conductor implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int numEmpleado;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date birthday;
	private Date fechaContrato;
	private String direccion;
	private String telefono;
	private int yearsExp;
	
	public Conductor() {
		//Constructor vacio
	}
	
	public Conductor(int numEmpleado) {
		this.numEmpleado = numEmpleado;
	
	}
	
	public Conductor(
				int numEmpleado,
				String nombre,
				String apellidoPaterno,
				String apellidoMaterno,
				Date birthday,
				Date fechaContrato,
				String direccion,
				String telefono,
				int yearsExp
			) {
		
		//Constructor todos atributos
		this.numEmpleado = numEmpleado;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.birthday = birthday;
		this.fechaContrato = fechaContrato; 
		this.direccion = direccion;
		this.telefono = telefono;
		this.yearsExp = yearsExp;
		
	}

	public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int num) {
        this.numEmpleado = num;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apat) {
        this.apellidoPaterno = apat;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String amat) {
        this.apellidoMaterno = amat;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date bday) {
        this.birthday = bday;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fcon) {
        this.fechaContrato = fcon;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String dir) {
        this.direccion = dir;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String tel) {
        this.telefono = tel;
    }

    public int getYearsExp() {
        return yearsExp;
    }

    public void setYearsExp(int years) {
        this.yearsExp = years;
    }
	
	
}