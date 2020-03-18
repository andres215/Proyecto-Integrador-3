package modelo;

public class PerfilOcupacional {
	
	private int codigoPerfilOcupacional;
	private String descripcion;
	
	public PerfilOcupacional(int codigoPerfilOcupacional, String descripcion) {
		super();
		this.codigoPerfilOcupacional = codigoPerfilOcupacional;
		this.descripcion = descripcion;
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
