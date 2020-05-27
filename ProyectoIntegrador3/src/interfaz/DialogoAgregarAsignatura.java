package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		setSize(new Dimension(290,200));
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
		general.setLayout(new GridLayout(5,2));
		NumberFormat nf = NumberFormat.getNumberInstance();
		
		String[] areas = {Asignatura.ESPECIFICIAS_INGENIERIA, Asignatura.CIENCIAS_BASICAS, };
		txtCodigo = new JFormattedTextField(nf);
		txtCreditos = new JFormattedTextField(nf);
		txtNombre = new JTextField();	
		txtHorario = new JTextField();
		comboAreaFormacion = new JComboBox<String>(areas);
		comboAreaFormacion.setSelectedIndex(0);
		labNombre = new JLabel("Nombre");
		labCreditos = new JLabel("Créditos");
		labHorario = new JLabel("Horario");
		labCodigo = new JLabel("Código");
		labAreaFormacion = new JLabel("Área formación");
		
		general.add(labCodigo); general.add(txtCodigo);
		general.add(labNombre); general.add(txtNombre);
		general.add(labHorario); general.add(txtHorario);
		general.add(labCreditos); general.add(txtCreditos);
		general.add(labAreaFormacion); general.add(comboAreaFormacion);
		
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
	
	public void guardar() throws Exception {
		if(txtCodigo.getText().equals("") || txtNombre.getText().equals("") || txtCreditos.getText().equals("") || txtHorario.getText().equals("")) {
			throw new Exception();
		}else {
			Asignatura as = new Asignatura(Integer.parseInt(txtCodigo.getText()), txtNombre.getText(), Integer.parseInt(txtCreditos.getText()), txtHorario.getText(), comboAreaFormacion.getSelectedItem().toString());
			principal.guardarMateria(as);
			principal.cerrarDialogoAgregarMateria();
		}
	}
	
	public boolean materiaCorrecta() {
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(GUARDAR)) {
			try {
				guardar();
			}catch(Exception e) {
				JOptionPane.showMessageDialog(this, "Error al agregar la materia, puede que llenó un campo de forma incorrecta o esa materia ya exista", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else {
			principal.cerrarDialogoAgregarMateria();
		}
	}

}
