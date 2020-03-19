package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mision implements Serializable {

	private int codigoMision;
	private String descripcion;
	
	public Mision(int codigoMision) {
		super();
		this.codigoMision = codigoMision;
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
