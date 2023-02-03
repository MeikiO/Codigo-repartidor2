import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Painter extends JFrame implements MouseMotionListener {

	private int x= -10, y=-10;
	
	public Painter() {
		// TODO Auto-generated constructor stub
		this.setTitle("Painter");
		this.setSize(800,600);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		//set up layout
		JLabel instructions=new JLabel("drag the mouse to draw",JLabel.RIGHT);
		Container c= this.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(instructions, BorderLayout.SOUTH);
		//configure mouse
		c.addMouseMotionListener(this);
		
		
		
		this.setVisible(true);
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

		x=e.getX();
		y=e.getY();
		repaint(); //llamara a la funcion paint con parametros especiales
		
	}
	
	public void paint(Graphics g) {
		g.fillOval(x, y, 4, 4);
	}
	

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
