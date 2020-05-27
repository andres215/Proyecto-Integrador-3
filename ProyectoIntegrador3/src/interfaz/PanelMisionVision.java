package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelMisionVision extends JPanel implements ActionListener {
	
	public final static String GUARDAR_MISION = "Guardar";
	public final static String EDITAR_MISION = "Editar";
	public final static String ELIMINAR_MISION = "Eliminar";
	
	private JButton butGuardarMision, butEditarMision, butEliminarMision;
	private Main principal;
	private JTextArea textMision;
	private JScrollPane scroll;
	
	public PanelMisionVision(Main principal) {
		this.principal = principal;
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Misión y Visión");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setBorder(border);
		setLayout(new BorderLayout());
		
		butGuardarMision = new JButton(GUARDAR_MISION);
		butGuardarMision.setActionCommand(GUARDAR_MISION);
		butGuardarMision.addActionListener(this);
		butEditarMision = new JButton(EDITAR_MISION);
		butEditarMision.setActionCommand(EDITAR_MISION);
		butEditarMision.addActionListener(this);
		butEliminarMision = new JButton(ELIMINAR_MISION);
		butEliminarMision.setActionCommand(ELIMINAR_MISION);
		butEliminarMision.addActionListener(this);
		
		butGuardarMision.setEnabled(false);
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new GridLayout(1,1));
		textMision = new JTextArea(principal.getMisionVision());
		textMision.setLineWrap(true);
		textMision.setEditable(false);
		scroll = new JScrollPane(textMision);
		formulario.add(scroll);		
		
		JPanel opciones = new JPanel();
		opciones.setPreferredSize(new Dimension(0,20));
		opciones.setLayout(new GridLayout(1,3));
		opciones.add(butGuardarMision);
		opciones.add(butEditarMision);
		opciones.add(butEliminarMision);
		
		add(opciones, BorderLayout.SOUTH);		
		add(formulario, BorderLayout.CENTER);
		
	}
	
	public void editarMision() {
		butGuardarMision.setEnabled(true);
		textMision.setEditable(true);
		butEditarMision.setEnabled(false);
	}
	
	public void guardarMision() {
		principal.guardarMision(textMision.getText());
		textMision.setEditable(false);
		butEditarMision.setEnabled(true);
		butGuardarMision.setEnabled(false);
	}
	
	public void eliminarMision() {
		textMision.setText("");
		principal.guardarMision("");
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(EDITAR_MISION)) {
			editarMision();
		}else if(comando.equals(GUARDAR_MISION)) {
			guardarMision();
		}else {
			eliminarMision();
		}
	}

}
