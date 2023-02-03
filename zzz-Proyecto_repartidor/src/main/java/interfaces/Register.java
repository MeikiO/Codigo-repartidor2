package interfaces;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import base_de_datos.UsersData;
import controladores.ControladorRegister;
import controladores.ControlerPantallaIntegrantes;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.Usuario;  

public class Register extends JFrame{

	ControladorRegister controlRe;
	
	
	JTextField nombre,apellidos,dni,direccion,tlf,zonaTrabajo,username,contraseña;
	
	 JSpinner m_numberSpinner;


	private ControlerPantallaIntegrantes controler2;
	
	
	public Register() {
		// TODO Auto-generated constructor stub
		
		controlRe=new ControladorRegister(this);
		
		this.ventanaRegister();
	
	}




	public void ventanaRegister() {

		this.setTitle("Login");
		
		JLabel label1=new JLabel("Nombre ");
		label1.setBounds(20,50,150,20);
		
		nombre=new JTextField();  
		this.getNombre().setBounds(100,50, 150,20);  
		
		   
		JLabel label2=new JLabel("Apellidos ");
		label2.setBounds(20,100,150,20);
		
	    apellidos=new JTextField();  
	    this.getApellidos().setBounds(100,100, 150,20);  
	    

		JLabel label3=new JLabel("Dni ");
		label3.setBounds(20,150,150,20);
		
	    dni=new JTextField();  
	    this.getDni().setBounds(100,150, 150,20);  
	    
	    
		JLabel label4=new JLabel("Direccion ");
		label4.setBounds(20,200,150,20);
		
	    direccion=new JTextField();  
	    this.getDireccion().setBounds(100,200, 150,20); 
	    
	    
		JLabel label5=new JLabel("Tlf ");
		label5.setBounds(20,250,150,20);
		
	    tlf=new JTextField();  
	    this.getTlf().setBounds(100,250, 150,20);
	    
	    
		JLabel label6=new JLabel("Zona trabajo ");
		label6.setBounds(20,300,150,20);
		
	    zonaTrabajo=new JTextField();  
	    this.getZonaTrabajo().setBounds(100,300, 150,20);
	    
	    
		JLabel label7=new JLabel("Username ");
		label7.setBounds(20,350,150,20);
		
	    username=new JTextField();  
	    this.getUsername().setBounds(100,350, 150,20);
	    
	    
		JLabel label8=new JLabel("Contraseña ");
		label8.setBounds(20,400,150,20);
		
	    contraseña=new JPasswordField();  
	    this.getContraseña().setBounds(100,400, 150,20);
	    
				
		JButton b1=new JButton("Register");//creating instance of JButton   
		b1.setBounds(200,450,100, 40);//x axis, y axis, width, height  
		b1.setActionCommand("Register");
		b1.addActionListener(this.getControlRe()); 
		
		
	    JButton b2=new JButton("Exit");//creating instance of JButton   
		b2.setBounds(70,450,100, 40);//x axis, y axis, width, height  
		b2.setActionCommand("ToLogin");
		b2.addActionListener(this.getControlRe()); 
		
		
		JLabel label9=new JLabel("GroupID: ");
		label9.setBounds(340,250,70,20);
		
		    SpinnerNumberModel m_numberSpinnerModel;
		    Integer current = 1;
		    Integer min = 1;
		    Integer max = 10;
		    Integer step = 1;
		    m_numberSpinnerModel = new SpinnerNumberModel(current, min, max, step);
		    m_numberSpinner = new JSpinner(m_numberSpinnerModel);
		
		    
		    m_numberSpinner.setBounds(400,250,50,20);
		    this.add(this.getM_numberSpinner());
		    
		    
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		this.add(label7);
		this.add(label8);
		this.add(label9);
		
		this.add(this.getNombre());
		this.add(this.getApellidos());
		 this.add(this.getDni());
		 this.add(this.getDireccion());
		 this.add(this.getTlf());
		 this.add(this.getZonaTrabajo());
		 this.add(this.getUsername());
		 this.add(this.getContraseña());
		
		this.add(b1);
		this.add(b2);
		
		
		this.setSize(500,550);//400 width and 500 height  
		this.setLayout(null);//using no layout managers  
		this.setVisible(true);//making the frame visible  
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	
	
	public Usuario devolverUsuarioRegister() {
		
		String value =this.getM_numberSpinner().getModel().getValue().toString();

		int id_grupo=Integer.parseInt(value);
		
		Usuario registrado=new Usuario(
				this.getNombre().getText(),
				this.getApellidos().getText(),
				this.getDni().getText(),
				this.getDireccion().getText(), 
				this.getTlf().getText(),
				this.getZonaTrabajo().getText() ,
				this.getUsername().getText(),
				this.getContraseña().getText(), 
				false,
				id_grupo);
		
		return registrado;
	}
	
	
	


	public boolean allFieldsFilled() {
		// TODO Auto-generated method stub
		
		boolean allFilled=true;
		
		if(this.getNombre().getText().equals("")) {
			allFilled=false;
		}
		if(this.getApellidos().getText().equals("")) {
			allFilled=false;
		}
		if(this.getDni().getText().equals("")) {
			allFilled=false;
		}
		if(this.getDireccion().getText().equals("")) {
			allFilled=false;
		}
		if(this.getTlf().getText().equals("")) {
			allFilled=false;
		}
		if(this.getZonaTrabajo().getText().equals("")) {
			allFilled=false;
		}
		if(this.getUsername().getText().equals("")) {
			allFilled=false;
		}
		if(this.getContraseña().getText().equals("")) {
			allFilled=false;
		}
		
		
		return allFilled;
	}

	
	
	
 	public ControlerPantallaIntegrantes getControler2() {
		return controler2;
	}




	public void setControler2(ControlerPantallaIntegrantes controler2) {
		this.controler2 = controler2;
	}




	public JFrame getthis() {
		return this;
	}



	public JTextField getNombre() {
		return nombre;
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public JTextField getApellidos() {
		return apellidos;
	}

	public void setApellidos(JTextField apellidos) {
		this.apellidos = apellidos;
	}

	public JTextField getDni() {
		return dni;
	}

	public void setDni(JTextField dni) {
		this.dni = dni;
	}

	public JTextField getDireccion() {
		return direccion;
	}

	public void setDireccion(JTextField direccion) {
		this.direccion = direccion;
	}

	public JTextField getTlf() {
		return tlf;
	}

	public void setTlf(JTextField tlf) {
		this.tlf = tlf;
	}

	public JTextField getZonaTrabajo() {
		return zonaTrabajo;
	}

	public void setZonaTrabajo(JTextField zonaTrabajo) {
		this.zonaTrabajo = zonaTrabajo;
	}

	public JTextField getUsername() {
		return username;
	}

	public void setUsername(JTextField username) {
		this.username = username;
	}

	public JTextField getContraseña() {
		return contraseña;
	}

	public void setContraseña(JTextField contraseña) {
		this.contraseña = contraseña;
	}



	public ControladorRegister getControlRe() {
		return controlRe;
	}

	public void setControlRe(ControladorRegister controlRe) {
		this.controlRe = controlRe;
	}

	public JSpinner getM_numberSpinner() {
		return m_numberSpinner;
	}

	public void setM_numberSpinner(JSpinner m_numberSpinner) {
		this.m_numberSpinner = m_numberSpinner;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return 	this.getNombre().getText()
				+" "+ this.getApellidos().getText() 
				+" "+ this.getDni().getText() 
					+" "+ this.getDireccion().getText() 
					+" "+ this.getTlf().getText() 
					+" "+ this.getZonaTrabajo().getText()
					+" "+ this.getUsername().getText()
					+" "+ this.getContraseña().getText();
	}

	
}	 
 	

