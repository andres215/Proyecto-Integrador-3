package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PerfilProfesional implements Serializable {
	
	private int codigoPerfilProfesional;
	private String descripcion;
	
	public PerfilProfesional(int codigoPerfilProfesional) {
		super();
		this.codigoPerfilProfesional = codigoPerfilProfesional;
	}

	public int getCodigoPerfilProfesional() {
		return codigoPerfilProfesional;
	}

	public void setCodigoPerfilProfesional(int codigoPerfilProfesional) {
		this.codigoPerfilProfesional = codigoPerfilProfesional;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
