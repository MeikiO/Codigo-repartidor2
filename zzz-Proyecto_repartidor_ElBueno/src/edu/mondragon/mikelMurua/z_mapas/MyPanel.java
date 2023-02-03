package z_mapas;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	Image imagen;

	public MyPanel(Image imagen) {
		this.imagen = imagen;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D gr=(Graphics2D) g;
		
		if(this.imagen!=null) {
			gr.drawImage(this.imagen, 0, 0,this.getWidth(),this.getHeight(), this);
			this.setOpaque(false); 
		}

		super.paint(g);
	}
		
}
