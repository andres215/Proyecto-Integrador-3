package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBanner extends JPanel {

	private ImageIcon fondo;

	public PanelBanner() {
		setPreferredSize(new Dimension(0, 120));
		fondo = new ImageIcon("img/sistemas.jpg");
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
	}
	
}
