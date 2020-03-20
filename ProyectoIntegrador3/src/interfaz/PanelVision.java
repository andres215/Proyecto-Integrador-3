package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelVision extends JPanel {
	
	public PanelVision() {
		Font font = new Font("Verdana", Font.BOLD, 15);
		TitledBorder border = BorderFactory.createTitledBorder("Visi�n");
		border.setTitleColor(Color.BLUE);
		border.setTitleFont(font);
		setBorder(border);
	}

}
