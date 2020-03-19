package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PerfilOcupacional implements Serializable {
	
	private int codigoPerfilOcupacional;
	private String descripcion;
	
	public PerfilOcupacional(int codigoPerfilOcupacional) {
		super();
		this.codigoPerfilOcupacional = codigoPerfilOcupacional;
	}

	public int getCodigoPerfilOcupacional() {
		return codigoPerfilOcupacional;
	}

	public void setCodigoPerfilOcupacional(int codigoPerfilOcupacional) {
		this.codigoPerfilOcupacional = codigoPerfilOcupacional;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
