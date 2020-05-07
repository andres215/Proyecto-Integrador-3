package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelo.ProgramaSIS;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	
	public static final String VER_PERFIL_OCUPACIONAL = "Perfil ocupacional";
	public static final String VER_PERFIL_PROFESIONAL = "Perfil profesional";
	public static final String VER_PENSUM = "Pénsum";
	
	private PanelBanner banner;
	private PanelMision panelMision;
	private PanelVision panelVision;
	private PanelObjetivoFormacion panelObjetivoFormacion;
	
	private JButton butPerfilOcupacional, butPerfilProfesional, butVerPensum;
	
	private ProgramaSIS modelo;
	
	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(650,480));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Programa Ingeniería de Sistemas - Institución Universitaria Antonio José Camacho");
		setLayout(new BorderLayout());
		
		modelo = new ProgramaSIS();

		butPerfilProfesional = new JButton(VER_PERFIL_PROFESIONAL);
		butPerfilProfesional.setActionCommand(VER_PERFIL_PROFESIONAL);
		butPerfilProfesional.addActionListener(this);
		butPerfilOcupacional = new JButton(VER_PERFIL_OCUPACIONAL);
		butPerfilOcupacional.setActionCommand(VER_PERFIL_OCUPACIONAL);
		butPerfilOcupacional.addActionListener(this);
		butVerPensum = new JButton(VER_PENSUM);
		butVerPensum.setActionCommand(VER_PENSUM);
		butVerPensum.addActionListener(this);
		
		banner = new PanelBanner();
		panelMision = new PanelMision(this);
		panelVision = new PanelVision(this);
		panelObjetivoFormacion = new PanelObjetivoFormacion(this);
		
		JPanel aux1 = new JPanel();
		aux1.setLayout(new GridLayout(1,2));
		aux1.add(panelMision);
		aux1.add(panelVision);
		
		JPanel aux2 = new JPanel();
		aux2.setLayout(new GridLayout(2,1));
		aux2.add(aux1);
		aux2.add(panelObjetivoFormacion);
		
		JPanel aux3 = new JPanel();
		TitledBorder border = BorderFactory.createTitledBorder("Otras opciones");
		border.setTitleColor(Color.BLUE);
		aux3.setBorder(border);
		aux3.setLayout(new GridLayout(1,3));
		aux3.add(butPerfilProfesional);
		aux3.add(butPerfilOcupacional);
		aux3.add(butVerPensum);
		
		add(banner, BorderLayout.NORTH);
		add(aux2, BorderLayout.CENTER);
		add(aux3, BorderLayout.SOUTH);
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){	
		}
	}
	
	public void inicializar() {
		
	}
	
	public String getVision() {
		return modelo.getVision().getDescripcion();
	}
	
	public void guardarVision(String vision) {
		modelo.getVision().setDescripcion(vision);
	}
	
	public String getMision() {
		return modelo.getMision().getDescripcion();
	}
	
	public void guardarMision(String mision) {
		modelo.getMision().setDescripcion(mision);
	}
	
	public String getObjetivoFormacion() {
		return modelo.getObjetivoFormacion().getDescripcion();
	}
	
	public void guardarObjetivoFormacion(String objetivo) {
		modelo.getObjetivoFormacion().setDescripcion(objetivo);
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(VER_PERFIL_OCUPACIONAL)) {
			
		}else if(comando.equals(VER_PERFIL_PROFESIONAL)) {
			
		}else {
			
		}
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);
	}

}
