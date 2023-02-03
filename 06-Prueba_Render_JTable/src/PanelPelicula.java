import java.awt.GridLayout;

import javax.swing.JScrollPane;

public class PanelPelicula extends JScrollPane {

	int tamaño;
	public PanelPelicula() {
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	public int getTamaño() {
		return tamaño;
	}
	public void setTamaño(int tamaño) {
		this.tamaño = tamaño;
	}
	
}
