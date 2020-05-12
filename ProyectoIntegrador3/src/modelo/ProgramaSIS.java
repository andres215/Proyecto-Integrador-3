package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProgramaSIS implements Serializable {
	
	private Mision mision;
	private Vision vision;
	private ObjetivoFormacion objetivoFormacion;
	private PerfilOcupacional perfilOcupacional;
	private PerfilProfesional perfilProfesional;
	private Pensum pensum;
	
	public ProgramaSIS() {
		inicializarModelo();
	}
	
	public void inicializarModelo() {
		mision = new Mision(1);
		vision = new Vision(2);
		objetivoFormacion = new ObjetivoFormacion(3);
		perfilOcupacional = new PerfilOcupacional(4);
		perfilProfesional = new PerfilProfesional(5);
		pensum = new Pensum();
	}
	
	public Semestre[] darSemestres() {
		return pensum.getSemestres();
	}
	
	public void agregarMateria(Asignatura m, Semestre s) {
		s.agregarAsignatura(m);
	}

	public Mision getMision() {
		return mision;
	}

	public void setMision(Mision mision) {
		this.mision = mision;
	}

	public Vision getVision() {
		return vision;
	}

	public void setVision(Vision vision) {
		this.vision = vision;
	}

	public ObjetivoFormacion getObjetivoFormacion() {
		return objetivoFormacion;
	}

	public void setObjetivoFormacion(ObjetivoFormacion objetivoFormacion) {
		this.objetivoFormacion = objetivoFormacion;
	}

	public PerfilOcupacional getPerfilOcupacional() {
		return perfilOcupacional;
	}

	public void setPerfilOcupacional(PerfilOcupacional perfilOcupacional) {
		this.perfilOcupacional = perfilOcupacional;
	}

	public PerfilProfesional getPerfilProfesional() {
		return perfilProfesional;
	}

	public void setPerfilProfesional(PerfilProfesional perfilProfesional) {
		this.perfilProfesional = perfilProfesional;
	}

	public Pensum getPensum() {
		return pensum;
	}

	public void setPensum(Pensum pensum) {
		this.pensum = pensum;
	}

}
