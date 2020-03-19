package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Vision implements Serializable {
	
	private int codigoVision;
	private String descripcion;
	
	public Vision(int codigoVision) {
		super();
		this.codigoVision = codigoVision;
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
