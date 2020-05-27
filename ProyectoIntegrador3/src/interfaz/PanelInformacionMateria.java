package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import modelo.Asignatura;

@SuppressWarnings("serial")
public class PanelInformacionMateria extends JPanel implements ActionListener {
	
	public static final String ELIMINAR = "Eliminar";
	public static final String EDITAR = "Editar";
	
	private JButton butEliminar, butEditar;
	private JLabel labNombre, labCodigo, labCreditos, labHorario, labAreaFormacion;
	private JLabel nombre, codigo, creditos, horario, areaFormacion;
	
	private DialogoPensum principal;
	
	public PanelInformacionMateria(DialogoPensum principal) {
		this.principal = principal;
		Font font = new Font("Verdana", Font.BOLD, 15);
		Font font2 = new Font("Verdana", Font.BOLD, 13);
		TitledBorder border = BorderFactory.createTitledBorder("Información");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setBorder(border);
		setLayout(new BorderLayout());
		
		JPanel aux = new JPanel();
		aux.setLayout(new GridLayout(5,2));
		
		nombre = new JLabel();
		creditos = new JLabel();
		horario = new JLabel();
		areaFormacion = new JLabel();
		codigo = new JLabel();
		
		labNombre = new JLabel("Nombre:");
		labNombre.setForeground(Color.RED);
		labNombre.setFont(font2);
		labCreditos = new JLabel("Créditos:");
		labCreditos.setForeground(Color.RED);
		labCreditos.setFont(font2);
		labHorario = new JLabel("Horario:");
		labHorario.setForeground(Color.RED);
		labHorario.setFont(font2);
		labCodigo = new JLabel("Código:");
		labCodigo.setForeground(Color.RED);
		labCodigo.setFont(font2);
		labAreaFormacion = new JLabel("Área formación:");
		labAreaFormacion.setForeground(Color.RED);
		labAreaFormacion.setFont(font2);
		
		aux.add(labNombre); aux.add(nombre);
		aux.add(labCreditos); aux.add(creditos);
		aux.add(labHorario); aux.add(horario);
		aux.add(labCodigo); aux.add(codigo);
		aux.add(labAreaFormacion); aux.add(areaFormacion);
		
		
		butEliminar = new JButton(ELIMINAR);
		butEliminar.setActionCommand(ELIMINAR);
		butEliminar.addActionListener(this);
		butEditar = new JButton(EDITAR);
		butEditar.setActionCommand(EDITAR);
		butEditar.addActionListener(this);
		
		JPanel opciones = new JPanel();
		opciones.setLayout(new GridLayout(1, 2));
		opciones.add(butEditar);
		opciones.add(butEliminar);
		
		add(aux, BorderLayout.CENTER);
		add(opciones, BorderLayout.SOUTH);
		
	}
	
	public void refrescar(Asignatura as) {
		if(as!=null) {
			nombre.setText(as.getNombre());
			creditos.setText(as.getCreditos()+"");
			horario.setText(as.getHorario());
			codigo.setText(as.getCodigoAsignatura()+"");
			areaFormacion.setText(as.getAreaFormacion());
		}else {
			nombre.setText("");
			creditos.setText("");
			horario.setText("");
			codigo.setText("");
			areaFormacion.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(EDITAR)) {
			principal.editarMateria("Editar");
		}else {
			principal.eliminarMateria();
		}
	}

}
