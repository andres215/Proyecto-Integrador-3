package modelo;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Semestre implements Serializable {
	
	private String numeroSemestre;
	private ArrayList<Asignatura> asignaturas;
	
	public Semestre(String numeroSemestre, ArrayList<Asignatura> asignaturas) {
		super();
		this.numeroSemestre = numeroSemestre;
		this.asignaturas = asignaturas;
	}

	public String getNumeroSemestre() {
		return numeroSemestre;
	}

	public void setNumeroSemestre(String numeroSemestre) {
		this.numeroSemestre = numeroSemestre;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public int calcularCreditosSemestre() {
		int total = 0;
		for (int i = 0; i < asignaturas.size(); i++) {
			total += asignaturas.get(i).getCreditos();
		}
		return total;
	}
	
	public void agregarAsignatura(Asignatura asignatura) {
		asignaturas.add(asignatura);
	}
	
}
