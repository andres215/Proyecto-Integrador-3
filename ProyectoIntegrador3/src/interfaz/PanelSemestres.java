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

import modelo.Semestre;

@SuppressWarnings("serial")
public class PanelSemestres extends JPanel implements ListSelectionListener, ActionListener {
	
	public static final String VER_INFORMACION_SEMESTRE = "Ver información semestre";
	
	private DialogoPensum principal;
	private JList<Semestre> listaSemestres;
	private JScrollPane scroll;
	private JButton butVerInformacionSemestre;
	
	public PanelSemestres(DialogoPensum principal) {
		this.principal = principal;
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Semestres");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setLayout(new BorderLayout());
		setBorder(border);
		
		butVerInformacionSemestre = new JButton(VER_INFORMACION_SEMESTRE);
		butVerInformacionSemestre.setActionCommand(VER_INFORMACION_SEMESTRE);
		butVerInformacionSemestre.addActionListener(this);
		
		listaSemestres = new JList<Semestre>(this.principal.darPrincipal().darSemestres());
		scroll = new JScrollPane(listaSemestres);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listaSemestres.addListSelectionListener(this);
		listaSemestres.setSelectedIndex(0);
		
		add(scroll, BorderLayout.CENTER);
		add(butVerInformacionSemestre, BorderLayout.SOUTH);
	}
	
	public void mostrarInformacion() {
		principal.verInformacionSemestre(darSemestre());
	}
	
	public Semestre darSemestre() {
		return listaSemestres.getSelectedValue();
	}

	@Override
	public void valueChanged(ListSelectionEvent evento) {
		principal.refrescar(listaSemestres.getSelectedValue());
		principal.seleccionarPrimera();
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(VER_INFORMACION_SEMESTRE)) {
			mostrarInformacion();
		}
	}

}
