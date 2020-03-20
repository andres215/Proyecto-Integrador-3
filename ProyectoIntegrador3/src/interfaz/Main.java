package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	
	public static final String VER_PERFIL_OCUPACIONAL = "Perfil ocupacional";
	public static final String VER_PERFIL_PROFESIONAL = "Perfil profesional";
	public static final String VER_PENSUM = "P�nsum";
	
	private PanelBanner banner;
	private PanelMision panelMision;
	private PanelVision panelVision;
	private PanelObjetivoFormacion panelObjetivoFormacion;
	
	private JButton butPerfilOcupacional, butPerfilProfesional, butVerPensum;
	
	public Main() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(650,480));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Programa Ingenier�a de Sistemas - Instituci�n Universitaria Antonio Jos� Camacho");
		setLayout(new BorderLayout());

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
		panelMision = new PanelMision();
		panelVision = new PanelVision();
		panelObjetivoFormacion = new PanelObjetivoFormacion();
		
		JPanel aux1 = new JPanel();
		aux1.setLayout(new GridLayout(1,2));
		aux1.add(panelMision);
		aux1.add(panelVision);
		
		JPanel aux2 = new JPanel();
		aux2.setLayout(new GridLayout(2,1));
		aux2.add(aux1);
		aux2.add(panelObjetivoFormacion);
		
		JPanel aux3 = new JPanel();
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
