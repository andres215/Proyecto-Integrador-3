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
public class PanelObjetivoFormacion extends JPanel implements ActionListener {
	
	public final static String GUARDAR_OBJETIVO = "Guardar";
	public final static String EDITAR_OBJETIVO = "Editar";
	public final static String ELIMINAR_OBJETIVO = "Eliminar";
	
	private JButton butGuardarObjetivo, butEditarObjetivo, butEliminarObjetivo;
	private Main principal;
	private JTextArea textObjetivo;
	private JScrollPane scroll;
	
	public PanelObjetivoFormacion(Main principal) {
		this.principal = principal;
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Objetivo de formación");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setBorder(border);
		setLayout(new BorderLayout());
		
		butGuardarObjetivo = new JButton(GUARDAR_OBJETIVO);
		butGuardarObjetivo.setActionCommand(GUARDAR_OBJETIVO);
		butGuardarObjetivo.addActionListener(this);
		butEditarObjetivo = new JButton(EDITAR_OBJETIVO);
		butEditarObjetivo.setActionCommand(EDITAR_OBJETIVO);
		butEditarObjetivo.addActionListener(this);
		butEliminarObjetivo = new JButton(ELIMINAR_OBJETIVO);
		butEliminarObjetivo.setActionCommand(ELIMINAR_OBJETIVO);
		butEliminarObjetivo.addActionListener(this);
		
		butGuardarObjetivo.setEnabled(false);
		
		JPanel formulario = new JPanel();
		formulario.setLayout(new GridLayout(1,1));
		textObjetivo = new JTextArea(principal.getObjetivoFormacion());
		textObjetivo.setLineWrap(true);
		textObjetivo.setEditable(false);
		scroll = new JScrollPane(textObjetivo);
		formulario.add(scroll);		
		
		JPanel opciones = new JPanel();
		opciones.setPreferredSize(new Dimension(0,20));
		opciones.setLayout(new GridLayout(1,3));
		opciones.add(butGuardarObjetivo);
		opciones.add(butEditarObjetivo);
		opciones.add(butEliminarObjetivo);
		
		add(opciones, BorderLayout.SOUTH);		
		add(formulario, BorderLayout.CENTER);
	}
	
	public void editarObjetivo() {
		butGuardarObjetivo.setEnabled(true);
		textObjetivo.setEditable(true);
		butEditarObjetivo.setEnabled(false);
	}
	
	public void guardarObjetivo() {
		principal.guardarObjetivoFormacion(textObjetivo.getText());
		textObjetivo.setEditable(false);
		butEditarObjetivo.setEnabled(true);
		butGuardarObjetivo.setEnabled(false);
	}
	
	public void eliminarObjetivo() {
		textObjetivo.setText("");
		principal.guardarObjetivoFormacion("");
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(EDITAR_OBJETIVO)) {
			editarObjetivo();
		}else if(comando.equals(GUARDAR_OBJETIVO)) {
			guardarObjetivo();
		}else {
			eliminarObjetivo();
		}
	}

}
