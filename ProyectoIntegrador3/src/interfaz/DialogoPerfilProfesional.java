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
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class DialogoPerfilProfesional extends JDialog implements ActionListener {
	
	public final static String GUARDAR_PERFIL = "Guardar";
	public final static String EDITAR_PERFIL = "Editar";
	public final static String ELIMINAR_PERFIL = "Eliminar";
	public final static String VOLVER = "Volver";
	
	private JButton butGuardarPerfil, butEditarPerfil, butEliminarPerfil, butVolver;
	private Main principal;
	private JTextArea textPerfil;
	private JScrollPane scroll;
	
	public DialogoPerfilProfesional(Main principal) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.principal = principal;
		setSize(new Dimension(650,480));
		setLayout(new BorderLayout());
		setTitle("Programa Ingeniería de Sistemas - Institución Universitaria Antonio José Camacho");
		setResizable(false);
		setLocationRelativeTo(null);
				
		butGuardarPerfil = new JButton(GUARDAR_PERFIL);
		butGuardarPerfil.setActionCommand(GUARDAR_PERFIL);
		butGuardarPerfil.addActionListener(this);
		butEditarPerfil = new JButton(EDITAR_PERFIL);
		butEditarPerfil.setActionCommand(EDITAR_PERFIL);
		butEditarPerfil.addActionListener(this);
		butEliminarPerfil = new JButton(ELIMINAR_PERFIL);
		butEliminarPerfil.setActionCommand(ELIMINAR_PERFIL);
		butEliminarPerfil.addActionListener(this);
		butVolver = new JButton(VOLVER);
		butVolver.setActionCommand(VOLVER);
		butVolver.addActionListener(this);
		
		butGuardarPerfil.setEnabled(false);
		
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Perfil Profesional");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		JPanel formulario = new JPanel();
		formulario.setBorder(border);
		formulario.setLayout(new GridLayout(1,1));
		textPerfil = new JTextArea(principal.getPerfilProfesional());
		textPerfil.setLineWrap(true);
		textPerfil.setEditable(false);
		scroll = new JScrollPane(textPerfil);
		formulario.add(scroll);
		
		JPanel opciones = new JPanel();
		opciones.setPreferredSize(new Dimension(0,20));
		opciones.setLayout(new GridLayout(1,3));
		opciones.add(butGuardarPerfil);
		opciones.add(butEditarPerfil);
		opciones.add(butEliminarPerfil);
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(2,1));
		aux.add(opciones);
		aux.add(butVolver);
		
		add(formulario, BorderLayout.CENTER);		
		add(aux, BorderLayout.SOUTH);
		
	}
	
	public void editarPerfilProfesional() {
		butGuardarPerfil.setEnabled(true);
		textPerfil.setEditable(true);
		butEditarPerfil.setEnabled(false);
	}
	
	public void guardarPerfilProfesional() {
		principal.guardarPerfilProfesional(textPerfil.getText());
		textPerfil.setEditable(false);
		butEditarPerfil.setEnabled(true);
		butGuardarPerfil.setEnabled(false);
	}
	
	public void eliminarPerfilProfesional() {
		textPerfil.setText("");
		principal.guardarPerfilProfesional("");
	}
	
	public void volver() {
		principal.cerrarDialogo(Main.VER_PERFIL_PROFESIONAL);
	}
	
	public void dispose() {
		principal.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(EDITAR_PERFIL)) {
			editarPerfilProfesional();
		}else if(comando.equals(GUARDAR_PERFIL)) {
			guardarPerfilProfesional();
		}else if(comando.equals(ELIMINAR_PERFIL)) {
			eliminarPerfilProfesional();
		}else {
			volver();
		}
	}

}
