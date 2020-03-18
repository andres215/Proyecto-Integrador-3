package modelo;

public class Vision {
	
	private int codigoVision;
	private String descripcion;
	
	public Vision(int codigoVision, String descripcion) {
		super();
		this.codigoVision = codigoVision;
		this.descripcion = descripcion;
	}

	public int getCodigoVision() {
		return codigoVision;
	}

	public void setCodigoVision(int codigoVision) {
		this.codigoVision = codigoVision;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
