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
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelMision extends JPanel implements ActionListener {
	
	public final static String AGREGAR_MISION = "Agregar";
	public final static String EDITAR_MISION = "Editar";
	public final static String ELIMINAR_MISION = "Eliminar";
	
	private JButton butAgregarMision, butEditarMision, butEliminarMision;
	private Main principal;
	
	public PanelMision(Main principal) {
		this.principal = principal;
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Misión");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setBorder(border);
		setLayout(new BorderLayout());
		
		butAgregarMision = new JButton(AGREGAR_MISION);
		butAgregarMision.setActionCommand(AGREGAR_MISION);
		butAgregarMision.addActionListener(this);
		butEditarMision = new JButton(EDITAR_MISION);
		butEditarMision.setActionCommand(EDITAR_MISION);
		butEditarMision.addActionListener(this);
		butEliminarMision = new JButton(ELIMINAR_MISION);
		butEliminarMision.setActionCommand(ELIMINAR_MISION);
		butEliminarMision.addActionListener(this);
		
		JPanel opciones = new JPanel();
		opciones.setPreferredSize(new Dimension(0,20));
		opciones.setLayout(new GridLayout(1,3));
		opciones.add(butAgregarMision);
		opciones.add(butEditarMision);
		opciones.add(butEliminarMision);
		
		add(opciones, BorderLayout.SOUTH);		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
