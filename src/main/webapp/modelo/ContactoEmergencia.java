import java.io.Serializable;

public class ContactoEmergencia implements Serializable {
	
	private int numContacto;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String direccion;
	private String telefono;
	private int numEmpleado;
	
	public ContactoEmergencia() {
		//Constructor vacio
	}
	
    public ContactoEmergencia(
    			int numContacto,
    			String nombre,
    			String apellidoPaterno,
    			String apellidoMaterno,
    			String direccion,
    			String telefono,
    			int numEmpleado
    		) {
    	
    	//Constructor todos atributos
        this.numContacto = numContacto;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.telefono = telefono;
        this.numEmpleado = numEmpleado;
    }
    
    
    public int getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(int num) {
        this.numContacto = num;
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

}
