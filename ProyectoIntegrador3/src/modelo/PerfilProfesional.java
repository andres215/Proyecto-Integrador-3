package modelo;

public class PerfilProfesional {
	
	private int codigoPerfilProfesional;
	private String descripcion;
	
	public PerfilProfesional(int codigoPerfilProfesional, String descripcion) {
		super();
		this.codigoPerfilProfesional = codigoPerfilProfesional;
		this.descripcion = descripcion;
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
