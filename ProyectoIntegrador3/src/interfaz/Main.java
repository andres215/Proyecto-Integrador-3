package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelo.Asignatura;
import modelo.ProgramaSIS;
import modelo.Semestre;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {
	
	public static final String VER_PERFIL_OCUPACIONAL = "Perfil ocupacional";
	public static final String VER_PERFIL_PROFESIONAL = "Perfil profesional";
	public static final String VER_PENSUM = "Pénsum";
	
	private PanelBanner banner;
	private PanelMisionVision panelMisionVision;
	private PanelObjetivoFormacion panelObjetivoFormacion;
	private DialogoPerfilProfesional dialogoPerfilProfesional;
	private DialogoPerfilOcupacional dialogoPerfilOcupacional;
	private DialogoPensum dialogoPensum;
	
	private JButton butPerfilOcupacional, butPerfilProfesional, butVerPensum;
	
	private ProgramaSIS modelo;
	
	public Main() {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){	
		}
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(new Dimension(650,480));
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Programa Ingeniería de Sistemas - Institución Universitaria Antonio José Camacho");
		setLayout(new BorderLayout());
		
		modelo = new ProgramaSIS();
		deserializar();

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
		panelMisionVision = new PanelMisionVision(this);
		panelObjetivoFormacion = new PanelObjetivoFormacion(this);
		
		JPanel aux1 = new JPanel();
		aux1.setLayout(new GridLayout(1,1));
		aux1.add(panelMisionVision);
		
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
		
	}
	
	public void serializar() {
		try {    
            FileOutputStream file = new FileOutputStream("datos/datos.ser"); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
            out.writeObject(modelo); 
            out.close(); 
            file.close(); 
        }
        catch(IOException ex) { 
            System.out.println("IOException"); 
        } 
	}
	
	public void deserializar() {
		try {    
            FileInputStream file = new FileInputStream("datos/datos.ser"); 
            ObjectInputStream in = new ObjectInputStream(file); 
            modelo = (ProgramaSIS)in.readObject(); 
            in.close(); 
            file.close(); 
        } catch(IOException ex) { 
        } catch(ClassNotFoundException es) { 
        	es.printStackTrace();
        } 
	}
	
	public void abrirDialogo(String opcion) {
		if(opcion.equals(VER_PERFIL_PROFESIONAL)) {
			dialogoPerfilProfesional = new DialogoPerfilProfesional(this);
			dialogoPerfilProfesional.setLocationRelativeTo(this);
			dialogoPerfilProfesional.setVisible(true);
		}else if(opcion.equals(VER_PERFIL_OCUPACIONAL)){
			dialogoPerfilOcupacional = new DialogoPerfilOcupacional(this);
			dialogoPerfilOcupacional.setLocationRelativeTo(this);
			dialogoPerfilOcupacional.setVisible(true);
		}else {
			dialogoPensum = new DialogoPensum(this);
			dialogoPensum.setLocationRelativeTo(this);
			dialogoPensum.setVisible(true);
		}
		this.setVisible(false);
	}
	
	public void cerrarDialogo(String opcion) {
		if(opcion.equals(VER_PERFIL_PROFESIONAL)) {
			dialogoPerfilProfesional.setVisible(false);
			dialogoPerfilProfesional = null;
		}else if(opcion.equals(VER_PERFIL_OCUPACIONAL)){
			dialogoPerfilOcupacional.setVisible(false);
			dialogoPerfilOcupacional = null;
		}else {
			dialogoPensum.setVisible(false);
			dialogoPensum = null;
		}
		this.setVisible(true);
	}
	
	public int[] darInformacionSemestre(Semestre m) {
		return modelo.verInformacionSemestre(m);
	}
	
	public boolean validarMateria(String codigo, String nombre) {
		return modelo.materiaCorrecta(codigo, nombre);
	}
	
	public String getMisionVision() {
		return modelo.getMisionVision().getDescripcion();
	}
	
	public void guardarMision(String mision) {
		modelo.getMisionVision().setDescripcion(mision);
	}
	
	public String getObjetivoFormacion() {
		return modelo.getObjetivoFormacion().getDescripcion();
	}
	
	public void guardarObjetivoFormacion(String objetivo) {
		modelo.getObjetivoFormacion().setDescripcion(objetivo);
	}
	
	public String getPerfilProfesional() {
		return modelo.getPerfilProfesional().getDescripcion();
	}
	
	public void guardarPerfilProfesional(String perfilProfesional) {
		modelo.getPerfilProfesional().setDescripcion(perfilProfesional);
	}
	
	public String getPerfilOcupacional() {
		return modelo.getPerfilOcupacional().getDescripcion();
	}
	
	public void guardarPerfilOcupacional(String perfilOcupacional) {
		modelo.getPerfilOcupacional().setDescripcion(perfilOcupacional);
	}
	
	public Semestre[] darSemestres() {
		return modelo.darSemestres();
	}
	
	public void agregarMateria(Asignatura a, Semestre s) {
		modelo.agregarMateria(a, s);
	}
	
	public void eliminarAsignatura(Asignatura a, Semestre s) {
		modelo.eliminarAsignatura(a, s);
	}
	
	public void editarAsignatura(Asignatura mActual, Asignatura mNueva, Semestre s) {
		modelo.editarAsignatura(mActual, mNueva, s);
	}
	
	public void dispose() {
		int input = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios?");
		if(input == 0) {
			serializar();
			System.exit(0);
		}else if(input == 1){
			System.exit(0);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(VER_PERFIL_OCUPACIONAL)) {
			abrirDialogo(VER_PERFIL_OCUPACIONAL);
		}else if(comando.equals(VER_PERFIL_PROFESIONAL)) {
			abrirDialogo(VER_PERFIL_PROFESIONAL);
		}else {
			abrirDialogo(VER_PENSUM);
		}
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);
	}

}
