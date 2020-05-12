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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import modelo.Asignatura;

@SuppressWarnings("serial")
public class DialogoAgregarAsignatura extends JDialog implements ActionListener{
	
	public final static String GUARDAR = "Guardar";
	public final static String CANCELAR = "Cancelar";
		
	private JButton butGuardar, butCancelar;
	private JFormattedTextField txtCodigo, txtCreditos;
	private JTextField txtNombre, txtHorario;
	private JComboBox<String> comboAreaFormacion;
	private JLabel labNombre, labCodigo, labCreditos, labHorario, labAreaFormacion;
	private DialogoPensum principal;
	
	public DialogoAgregarAsignatura(DialogoPensum principal) {
		this.principal = principal;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(350,400));
		setTitle("Agregar");
		setResizable(false);
		setLocationRelativeTo(null);
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Agregar asignatura");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setLayout(new BorderLayout());
		JPanel general = new JPanel();
		general.setBorder(border);
		
		String[] areas = {Asignatura.CIENCIAS_BASICAS, Asignatura.ESPECIFICIAS_INGENIERIA};
		txtCodigo = new JFormattedTextField();
		txtCreditos = new JFormattedTextField();
		txtNombre = new JTextField();	
		txtHorario = new JTextField();
		comboAreaFormacion = new JComboBox<String>(areas);
		comboAreaFormacion.setSelectedIndex(1);
		labNombre = new JLabel("Nombre");
		labCreditos = new JLabel("Créditos");
		labHorario = new JLabel("Horario");
		labCodigo = new JLabel("Código");
		labAreaFormacion = new JLabel("Área formación");
		
		butGuardar = new JButton(GUARDAR);
		butGuardar.setActionCommand(GUARDAR);
		butGuardar.addActionListener(this);
		butCancelar = new JButton(CANCELAR);
		butCancelar.setActionCommand(CANCELAR);
		butCancelar.addActionListener(this);
		
		JPanel opciones = new JPanel();
		opciones.setLayout(new GridLayout(1,2));
		opciones.add(butGuardar);
		opciones.add(butCancelar);
		
		add(general, BorderLayout.CENTER);
		add(opciones, BorderLayout.SOUTH);
	}
	
	public void guardar() {
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(GUARDAR)) {
			guardar();
		}else {
			principal.cerrarDialogoAgregarMateria();
		}
	}

}
