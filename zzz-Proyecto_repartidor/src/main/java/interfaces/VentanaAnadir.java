package interfaces;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import base_de_datos.UsersData;
import contrasenas.GestorContrasenas;
import controladores.ControladorRegister;
import controladores.ControlerPantallaIntegrantes;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.Usuario;  

public class VentanaAnadir extends JFrame{

	
	JTextField nombre,apellidos,dni,direccion,tlf,zonaTrabajo,username,contraseña;

	private ControlerPantallaIntegrantes controler;
	
	
	public VentanaAnadir(ControlerPantallaIntegrantes controler,String comando) {
		// TODO Auto-generated constructor stub
		
		this.controler=controler;
		
		this.ventanaRegister(comando);
	
	}



	public void ventanaRegister(String comando) {
		
		this.añadirPanel();
	    
		this.añadirBotones(comando);
		
		    	
		this.setSize(500,550);//400 width and 500 height  
		this.setLayout(null);//using no layout managers  
		this.setVisible(true);//making the frame visible  
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void añadirPanel() {
		// TODO Auto-generated method stub

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
	    
		this.add(label1);
		this.add(label2);
		this.add(label3);
		this.add(label4);
		this.add(label5);
		this.add(label6);
		
		this.add(this.getNombre());
		this.add(this.getApellidos());
		 this.add(this.getDni());
		 this.add(this.getDireccion());
		 this.add(this.getTlf());
		 this.add(this.getZonaTrabajo());
		
		
	}


	private void añadirBotones(String comando) {
		// TODO Auto-generated method stub
		JButton b1=new JButton("Register");//creating instance of JButton   
		b1.setBounds(200,450,100, 40);//x axis, y axis, width, height  
		b1.setActionCommand(comando);
		b1.addActionListener(this.getControler()); 
		this.add(b1);
		
		
	    JButton b2=new JButton("Exit");//creating instance of JButton   
		b2.setBounds(70,450,100, 40);//x axis, y axis, width, height  
		b2.setActionCommand("exit");
		b2.addActionListener(this.getControler()); 
		this.add(b2);
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
		
		return allFilled;
	}
	
	
	
	public Usuario devolverUsuarioEntero() {
		
		GestorContrasenas contrasena=new GestorContrasenas() ;
		
	
			
		String username=this.devolverUsername();
		String password=contrasena.generateRandomPassword();

		
		

		Usuario registrado=new Usuario(
				this.getNombre().getText(),
				this.getApellidos().getText(),
				this.getDni().getText(),
				this.getDireccion().getText(), 
				this.getTlf().getText(),
				this.getZonaTrabajo().getText() ,
				username,
				password, 
				false,
				this.controler.gestor.selectedGroup.getIdGrupo());
		
		return registrado;
	}
	
	

	
	public String devolverUsername() {
		StringBuilder usuario_generado = new StringBuilder("");
		
		
		usuario_generado.append(this.getNombre().getText());
		usuario_generado.append(this.getApellidos().getText());
		
	
		return usuario_generado.toString();
	}
	

	
	public void fillAlJTextfields(Usuario user) {
		 this.getNombre().setText(user.getNombre());
		 this.getApellidos().setText(user.getApellido());
		 this.getDni().setText(user.getDni());
		 this.getDireccion().setText(user.getDireccion());
		 this.getTlf().setText(user.getTlf());
		 this.getZonaTrabajo().setText(user.getZona_trabajo());
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

	public ControlerPantallaIntegrantes getControler() {
		return controler;
	}



	public void setControler(ControlerPantallaIntegrantes controler) {
		this.controler = controler;
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
 	

