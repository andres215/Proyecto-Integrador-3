package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Asignatura;
import modelo.Semestre;

@SuppressWarnings("serial")
public class PanelMaterias extends JPanel implements ListSelectionListener, ActionListener{
	
	public final static String AGREGAR_MATERIA = "Agregar asignatura";
	
	private DialogoPensum principal;
	private JButton butAgregarMateria;
	@SuppressWarnings("rawtypes")
	private JList listaMaterias;
	private JScrollPane scroll;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelMaterias(DialogoPensum principal, Semestre semestre) {
		this.principal = principal;
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Asignaturas");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setBorder(border);
		setLayout(new BorderLayout());
		
		butAgregarMateria = new JButton(AGREGAR_MATERIA);
		butAgregarMateria.setActionCommand(AGREGAR_MATERIA);
		butAgregarMateria.addActionListener(this);
		
		listaMaterias = new JList(semestre.getAsignaturas().toArray());

		scroll = new JScrollPane(listaMaterias);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listaMaterias.addListSelectionListener(this);
		listaMaterias.setSelectedIndex(0);
		
		add(scroll, BorderLayout.CENTER);
		add(butAgregarMateria, BorderLayout.SOUTH);
	}
	
	@SuppressWarnings("rawtypes")
	public JList getListaMaterias() {
		return listaMaterias;
	}
	
	public void agregarMateria() {
		principal.abrirDialogoAgregarMateria("Agregar", null);
	}
	
	public Asignatura darAsignaturaSeleccionada() {
		return (Asignatura) listaMaterias.getSelectedValue();
	}

	@Override
	public void valueChanged(ListSelectionEvent evento) {
		principal.refrescarInformacionMateria((Asignatura) listaMaterias.getSelectedValue());
	}
	
	@SuppressWarnings("unchecked")
	public void refrescarLista(Semestre semestre) {
		listaMaterias.setListData(semestre.getAsignaturas().toArray());
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(AGREGAR_MATERIA)) {
			agregarMateria();
		}
	}


}
