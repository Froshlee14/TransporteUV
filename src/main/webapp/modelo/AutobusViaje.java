import java.io.Serializable;

public class AutobusViaje implements Serilizable {
	
	private int numUnidad;
	private int numViaje;
	
	public AutobusViaje () {
		//Constructor vacio
	}
	
	public AutobusViaje(int numUnidad,int numViaje){
		this.numUnidad = numUnidad;
		this.numViaje = numViaje;
	}
	
	public int getNumUnidad() {
		return numUnidad;
	}
	
	public void setNumUnidad(int num) {
		this.numUnidad = num;
	}
	
	public int getNumViaje() {
		return numViaje;
	}
	
	public void setNumViaje(int num) {
		this.numViaje = num;
	}
	
}