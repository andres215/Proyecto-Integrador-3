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
public class PanelVision extends JPanel implements ActionListener {
	
	public final static String GUARDAR_VISION = "Guardar";
	public final static String EDITAR_VISION = "Editar";
	public final static String ELIMINAR_VISION = "Eliminar";
	
	private JButton butGuardarVision, butEditarVision, butEliminarVision;
	private Main principal;
	private JTextArea textVision;
	private JScrollPane scroll;
	
	public PanelVision(Main principal) {
		this.principal = principal;
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Visión");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setBorder(border);
		setLayout(new BorderLayout());
		
		butGuardarVision = new JButton(GUARDAR_VISION);
		butGuardarVision.setActionCommand(GUARDAR_VISION);
		butGuardarVision.addActionListener(this);
		butEditarVision = new JButton(EDITAR_VISION);
		butEditarVision.setActionCommand(EDITAR_VISION);
		butEditarVision.addActionListener(this);
		butEliminarVision = new JButton(ELIMINAR_VISION);
		butEliminarVision.setActionCommand(ELIMINAR_VISION);
		butEliminarVision.addActionListener(this);
		
		butGuardarVision.setEnabled(false);
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new GridLayout(1,1));
		textVision = new JTextArea(principal.getVision());
		textVision.setLineWrap(true);
		textVision.setEditable(false);
		scroll = new JScrollPane(textVision);
		formulario.add(scroll);		
		
		JPanel opciones = new JPanel();
		opciones.setPreferredSize(new Dimension(0,20));
		opciones.setLayout(new GridLayout(1,3));
		opciones.add(butGuardarVision);
		opciones.add(butEditarVision);
		opciones.add(butEliminarVision);
		
		add(formulario, BorderLayout.CENTER);
		add(opciones, BorderLayout.SOUTH);
	}
	
	public void editarVision() {
		butGuardarVision.setEnabled(true);
		textVision.setEditable(true);
		butEditarVision.setEnabled(false);
	}
	
	public void guardarVision() {
		principal.guardarVision(textVision.getText());
		textVision.setEditable(false);
		butEditarVision.setEnabled(true);
		butGuardarVision.setEnabled(false);
	}
	
	public void eliminarVision() {
		textVision.setText("");
		principal.guardarVision("");
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(EDITAR_VISION)) {
			editarVision();
		}else if(comando.equals(GUARDAR_VISION)) {
			guardarVision();
		}else {
			eliminarVision();
		}
	}

}
