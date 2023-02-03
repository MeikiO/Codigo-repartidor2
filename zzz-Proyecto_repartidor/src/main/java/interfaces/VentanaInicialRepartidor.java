package interfaces;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class VentanaInicialRepartidor extends JFrame implements ActionListener {

	JFrame frameVIR;
	
	public VentanaInicialRepartidor() {
		// TODO Auto-generated constructor stub
		frameVIR=new JFrame();
		this.setTitle("Ventana inicial Repartidor");
		
		JButton b=new JButton("click");//creating instance othis JButton  
		b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
		          
		this.add(b);//adding button in Jthisrame  
		          
		this.setSize(400,500);//400 width and 500 height  
		this.setLayout(null);//using no layout managers  
		this.setVisible(true);//making the thisrame visible  
	}



	public JFrame getFrameVIR() {
		return frameVIR;
	}



	public void setFrameVIR(JFrame frameVIR) {
		this.frameVIR = frameVIR;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
