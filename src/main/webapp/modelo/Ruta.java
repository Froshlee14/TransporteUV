import java.io.Serializable;

public class Ruta implements Serilizable {
	
	private int numRuta;
	private String descripcion;
	private String destinoInicial;
	private String destinoFinal;
	
	public Ruta() {
		//Constructor vacio
	}
	
	public Ruta(
				int numRuta,
				String descripcion,
				String destinoInicial,
				String destinoFinal
			) {
		
		this.numRuta = numRuta;
		this.descripcion = descripcion;
		this.destinoInicial = destinoInicial;
		this.destinoFinal = destinoFinal;
	}
	
	public int getNumRuta() {
		return numRuta;
	}
	
	public void setNumRuta(int num) {
		this.numRuta = num;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public String getDestinoIncial() {
		return destinoInicial;
	}
	
	public void setDestinoInicial(String dest) {
		this.destinoInicial = dest;
	}
	
	public String getDestinoFinal() {
		return destinoFinal;
	}
	
	public void setDestinoFinal(String dest) {
		this.destinoFinal = dest;
	}
	
}



