package modelo;

public class Mision {

	private int codigoMision;
	private String descripcion;
	
	public Mision(int codigoMision, String descripcion) {
		super();
		this.codigoMision = codigoMision;
		this.descripcion = descripcion;
	}

	public int getCodigoMision() {
		return codigoMision;
	}

	public void setCodigoMision(int codigoMision) {
		this.codigoMision = codigoMision;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
}
