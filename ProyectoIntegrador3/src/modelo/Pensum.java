package modelo;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Pensum implements Serializable {

	private Semestre[] semestres;

	public Pensum() {
		semestres = new Semestre[10];
		semestres[0] = new Semestre("Primero", new ArrayList<Asignatura>());
		semestres[1] = new Semestre("Segundo", new ArrayList<Asignatura>());
		semestres[2] = new Semestre("Tercero", new ArrayList<Asignatura>());
		semestres[3] = new Semestre("Cuarto", new ArrayList<Asignatura>());
		semestres[4] = new Semestre("Quinto", new ArrayList<Asignatura>());
		semestres[5] = new Semestre("Sexto", new ArrayList<Asignatura>());
		semestres[6] = new Semestre("Séptimo", new ArrayList<Asignatura>());
		semestres[7] = new Semestre("Octavo", new ArrayList<Asignatura>());
		semestres[8] = new Semestre("Noveno", new ArrayList<Asignatura>());
		semestres[9] = new Semestre("Décimo", new ArrayList<Asignatura>());
	}

	public Semestre[] getSemestres() {
		return semestres;
	}

	public void setSemestres(Semestre[] semestres) {
		this.semestres = semestres;
	}
	
	public int calcularTotalCreditos() {
		int total = 0;
		for (int i = 0; i < semestres.length; i++) {
			total += semestres[i].calcularCreditosSemestre();
		}
		return total;
	}
	
}
