package interfaces;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;

import base_de_datos.UsersData;
import controladores.ControladorLogin;
import modelo.Usuario;  

public class Login extends JFrame {

	
	ControladorLogin controlLogin;
	
	
	final JTextField username;
	final JTextField passfield;
	JLabel l;
	
	
	
	public Login() {
		// TODO Auto-generated constructor stub
		
		controlLogin=new ControladorLogin(this);
		
		
		this.setTitle("Login");
		
		JLabel user=new JLabel("Username ");
		user.setBounds(20,50,150,20);
		
		JLabel pass=new JLabel("Password ");
		pass.setBounds(20,100,150,20);
		
		
	    username=new JTextField();  
	    this.getUsername().setBounds(100,50, 150,20);  
	    
	    passfield= new JPasswordField(20); 
	    this.getPassfield().setBounds(100,100, 150,20); 
	    
        l=new JLabel();  
        l.setBounds(50,100, 250,20);     
        
		JButton b=new JButton("Login");//creating instance of JButton   
		b.setBounds(130,150,100, 40);//x axis, y axis, width, height  
		b.setActionCommand("login");
		b.addActionListener(this.getControlLogin()); 
				
		JButton b2=new JButton("Register");//creating instance of JButton   
		b2.setBounds(130,200,100, 40);//x axis, y axis, width, height  
		b2.setActionCommand("ToRegister");
		b2.addActionListener(this.getControlLogin()); 
		
		
		this.add(user);
		this.add(pass);
	
		this.add(this.getUsername());
		this.add(this.getPassfield());
	
		this.add(b);
		this.add(b2);
		
		this.setSize(400,400);//400 width and 500 height  
		this.setLayout(null);//using no layout managers  
		this.setVisible(true);//making the frame visible  
	
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	


	public JFrame getthis() {
		return this;
	}




	public JLabel getL() {
		return l;
	}



	public void setL(JLabel l) {
		this.l = l;
	}



	public JTextField getUsername() {
		return username;
	}



	public JTextField getPassfield() {
		return passfield;
	}





	public ControladorLogin getControlLogin() {
		return controlLogin;
	}





	public void setControlLogin(ControladorLogin controlLogin) {
		this.controlLogin = controlLogin;
	} 
 		 
 	
 	
 	
 	
 }  
