import java.awt.GridLayout;

import javax.swing.JScrollPane;

public class PanelPelicula extends JScrollPane {

	int tama�o;
	public PanelPelicula() {
		this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	public int getTama�o() {
		return tama�o;
	}
	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}
	
}
