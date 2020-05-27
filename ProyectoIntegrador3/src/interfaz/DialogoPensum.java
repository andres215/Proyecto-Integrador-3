package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Asignatura;
import modelo.Semestre;

@SuppressWarnings("serial")
public class DialogoPensum extends JDialog implements ActionListener {
	
	public final static String VOLVER ="Volver";
	
	private DialogoAgregarAsignatura dialogoAgregarAsignatura;
	private JButton butVolver;
	private PanelSemestres panelSemestres;
	private PanelMaterias panelMaterias;
	private PanelInformacionMateria panelInformacionMateria;
	private Main principal;
	
	public DialogoPensum(Main principal) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.principal = principal;
		setSize(new Dimension(850,480));
		setLayout(new BorderLayout());
		setTitle("PÉNSUM Programa Ingeniería de Sistemas - Institución Universitaria Antonio José Camacho");
		setResizable(false);
		setLocationRelativeTo(null);
		
		panelSemestres = new PanelSemestres(this);
		panelInformacionMateria = new PanelInformacionMateria(this);
		panelMaterias = new PanelMaterias(this, darSemestre());
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(1,3));
		aux.add(panelSemestres);
		aux.add(panelMaterias);
		aux.add(panelInformacionMateria);
		
		butVolver = new JButton(VOLVER);
		butVolver.setActionCommand(VOLVER);
		butVolver.addActionListener(this);
		
		add(butVolver, BorderLayout.SOUTH);
		add(aux, BorderLayout.CENTER);
	}
	
	public void editarMateria(String metodo) {
		Asignatura as = panelMaterias.darAsignaturaSeleccionada();
		if(as != null ) {
			abrirDialogoAgregarMateria(metodo, as);
		}else {
			JOptionPane.showMessageDialog(this, "Seleccione primero una materia", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void abrirDialogoAgregarMateria(String metodo, Asignatura as) {
		dialogoAgregarAsignatura = new DialogoAgregarAsignatura(this, metodo, true);
		dialogoAgregarAsignatura.setLocationRelativeTo(this);
		if(metodo.equals("Editar")) {
			dialogoAgregarAsignatura.rellenarCampos(as);
		}
		dialogoAgregarAsignatura.setVisible(true);
	}
	
	public void cerrarDialogoAgregarMateria() {
		dialogoAgregarAsignatura.setVisible(false);
		dialogoAgregarAsignatura = null;
	}
	
	public void guardarMateria(Asignatura as) {
		principal.agregarMateria(as, darSemestre());
		refrescar(panelSemestres.darSemestre());
	}
	
	public void refrescar(Semestre semestre) {
		if(panelMaterias!=null) {
			panelMaterias.refrescarLista(semestre);
		}
	}
	
	public void refrescarInformacionMateria(Asignatura as) {
		panelInformacionMateria.refrescar(as);
	}
	
	public void eliminarMateria() {
		Asignatura as = panelMaterias.darAsignaturaSeleccionada();
		if(as != null) {
			int input = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar esta materia?");
			if(input == 0) {
				principal.eliminarAsignatura(as, darSemestre());
				refrescar(darSemestre());
				refrescarInformacionMateria(panelMaterias.darAsignaturaSeleccionada());
			}
		}else {
			JOptionPane.showMessageDialog(this, "Seleccione primero una materia", "Error", JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	public void verInformacionSemestre(Semestre m) {
		int numeroMaterias = principal.darInformacionSemestre(m)[1];
		int creditos = principal.darInformacionSemestre(m)[0];
		JOptionPane.showMessageDialog(this, "Semestre "+m.getNumeroSemestre()+":\n\nNúmero de materias: "+numeroMaterias+"\nTotal créditos: "+creditos);
	}
	
	public boolean validarMateria(int codigo, String nombre) {
		return principal.validarMateria(codigo, nombre);
	}
	
	public Main darPrincipal() {
		return principal;
	}
	
	public Semestre darSemestre() {
		return panelSemestres.darSemestre();
	}
	
	public void dispose() {
		principal.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(VOLVER)) {
			principal.cerrarDialogo(Main.VER_PENSUM);
		}
	}

}
