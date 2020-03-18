package modelo;

public class ObjetivoFormacion {
	
	private int codigoObjetivoFormacion;
	private String descripcion;
	
	public ObjetivoFormacion(int codigoObjetivoFormacion, String descripcion) {
		super();
		this.codigoObjetivoFormacion = codigoObjetivoFormacion;
		this.descripcion = descripcion;
	}

	public int getCodigoObjetivoFormacion() {
		return codigoObjetivoFormacion;
	}

	public void setCodigoObjetivoFormacion(int codigoObjetivoFormacion) {
		this.codigoObjetivoFormacion = codigoObjetivoFormacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
