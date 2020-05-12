package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Asignatura implements Serializable {
	
	public static final String CIENCIAS_BASICAS = "Ciencias Básicas";
	public static final String ESPECIFICIAS_INGENIERIA = "Específicas de Ingeniería";
	
	private int codigoAsignatura;
	private String nombre;
	private int creditos;
	private String horario;
	private String areaFormacion;
	
	public Asignatura(int codigoAsignatura, String nombre, int creditos, String horario, String areaFormacion) {
		super();
		this.codigoAsignatura = codigoAsignatura;
		this.nombre = nombre;
		this.creditos = creditos;
		this.horario = horario;
		this.setAreaFormacion(areaFormacion);
	}

	public int getCodigoAsignatura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignatura(int codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getAreaFormacion() {
		return areaFormacion;
	}

	public void setAreaFormacion(String areaFormacion) {
		this.areaFormacion = areaFormacion;
	}

}
