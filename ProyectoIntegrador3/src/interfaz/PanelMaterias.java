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

@SuppressWarnings("serial")
public class PanelMaterias extends JPanel implements ListSelectionListener, ActionListener{
	
	public final static String AGREGAR_MATERIA = "Agregar asignatura";
	
	private DialogoPensum principal;
	private JButton butAgregarMateria;
	private JList<Asignatura> listaMaterias;
	private JScrollPane scroll;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PanelMaterias(DialogoPensum principal) {
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
		
		listaMaterias = new JList(principal.darSemestre().getAsignaturas().toArray());
		scroll = new JScrollPane(listaMaterias);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listaMaterias.addListSelectionListener(this);
		listaMaterias.setSelectedIndex(0);
		
		add(scroll, BorderLayout.CENTER);
		add(butAgregarMateria, BorderLayout.SOUTH);
	}
	
	public void agregarMateria() {
		principal.abrirDialogoAgregarMateria();
	}

	@Override
	public void valueChanged(ListSelectionEvent evento) {
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void refrescarLista() {
		listaMaterias = new JList(principal.darSemestre().getAsignaturas().toArray());
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(AGREGAR_MATERIA)) {
			agregarMateria();
		}
	}


}
