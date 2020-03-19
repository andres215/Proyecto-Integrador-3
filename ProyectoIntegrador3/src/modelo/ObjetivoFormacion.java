package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ObjetivoFormacion implements Serializable {
	
	private int codigoObjetivoFormacion;
	private String descripcion;
	
	public ObjetivoFormacion(int codigoObjetivoFormacion) {
		super();
		this.codigoObjetivoFormacion = codigoObjetivoFormacion;
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
