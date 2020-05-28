package modelo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProgramaSIS implements Serializable {
	
	private MisionVision misionVision;
	private ObjetivoFormacion objetivoFormacion;
	private PerfilOcupacional perfilOcupacional;
	private PerfilProfesional perfilProfesional;
	private Pensum pensum;
	
	public ProgramaSIS() {
		inicializarModelo();
	}
	
	public void inicializarModelo() {
		misionVision = new MisionVision(1);
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
	
	public void eliminarAsignatura(Asignatura m, Semestre s) {
		s.eliminarAsignatura(m);
	}
	
	public void editarAsignatura(Asignatura asignaturaOriginal, Asignatura asignaturaNueva, Semestre s) {
		s.editarAsignatura(asignaturaOriginal, asignaturaNueva);
	}
	
	public int[] verInformacionSemestre(Semestre m) {
		int[] resultado = {m.calcularCreditosSemestre(), m.getAsignaturas().size()};
		return resultado;
	}

	public MisionVision getMisionVision() {
		return misionVision;
	}
	
	public boolean materiaCorrecta(String codigo, String nombre) {
		for (int i = 0; i < pensum.getSemestres().length; i++) {
			for (int j = 0; j < pensum.getSemestres()[i].getAsignaturas().size(); j++) {
				Asignatura as = pensum.getSemestres()[i].getAsignaturas().get(j);
				if(as.getCodigoAsignatura().equals(codigo) || as.getNombre().equals(nombre) ) {
					return true;
				}
			}
		}
		return false;
	}

	public void setMisionVision(MisionVision misionVision) {
		this.misionVision= misionVision;
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
