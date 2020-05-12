package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

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
		setTitle("P�NSUM Programa Ingenier�a de Sistemas - Instituci�n Universitaria Antonio Jos� Camacho");
		setResizable(false);
		setLocationRelativeTo(null);
		
		panelSemestres = new PanelSemestres(this);
		panelMaterias = new PanelMaterias(this);
		panelInformacionMateria = new PanelInformacionMateria(this);
		
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
	
	public void abrirDialogoAgregarMateria() {
		dialogoAgregarAsignatura = new DialogoAgregarAsignatura(this);
		dialogoAgregarAsignatura.setLocationRelativeTo(this);
		dialogoAgregarAsignatura.setVisible(true);
	}
	
	public void cerrarDialogoAgregarMateria() {
		dialogoAgregarAsignatura.setVisible(false);
		dialogoAgregarAsignatura = null;
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
