package modelo;

public class Asignatura {
	
	private int codigoAsignatura;
	private String nombre;
	private int creditos;
	private String horario;
	
	public Asignatura(int codigoAsignatura, String nombre, int creditos, String horario) {
		super();
		this.codigoAsignatura = codigoAsignatura;
		this.nombre = nombre;
		this.creditos = creditos;
		this.horario = horario;
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

}
