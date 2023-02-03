package a_login_y_register;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import b_ventanas_admin.VentanaAdmin;
import f_ventana_repartidor_una_vez_logeado.VentanaRepartidor;
import z_look_and_field.MyLookAndFeel;
import z_modelo_equipo_repartidores.Repartidor;

public class VentanaLogin extends JFrame implements PropertyChangeListener {

	private ModeloLogin modelo;
	private ControladorLogin controlador;
	private JTextField usuario;
	private JPasswordField password;
	private ControladorLogin ok;
	private ControladorLogin register;
	private ControladorLogin salir;
	
	public VentanaLogin() {
		super("Login");
		MyLookAndFeel look=new MyLookAndFeel(this);
		
		this.modelo=new ModeloLogin();
		this.modelo.addPropertyChangeListener(this);

		this.crearAcciones();
		
		this.setBounds(200, 200, 350, 300);
		this.setContentPane(this.crearVentana());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearAcciones() {
		ok= new ControladorLogin ("Ok", null, "Ok", KeyEvent.VK_O,this,this.modelo);
		
		register = new ControladorLogin ("Register", null, "Register", KeyEvent.VK_O,this,this.modelo);
	
		salir= new ControladorLogin ("Salir", null,"Salir", KeyEvent.VK_C,this,this.modelo);
	}
	
	private Container crearVentana() {
		JPanel panel=new JPanel(new BorderLayout(0,20)); 
		panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); 
		
		panel.add(this.crearEntrada(),BorderLayout.CENTER);
		
		panel.add(this.panelBotones(),BorderLayout.SOUTH);
	
		return panel;
	}

	private Component panelBotones() {
		JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER,20, 10));
		
		JButton boton=new JButton(this.ok);
		panel.add(boton);
		
		JButton boton2=new JButton(this.register);
		panel.add(boton2);
		
		JButton boton3=new JButton(this.salir);
		panel.add(boton3);
		
		return panel;
	}
	
	private Component crearEntrada() {
		JPanel panel=new JPanel(new GridLayout(2,2,20,20)); 
		Border empty=BorderFactory.createEmptyBorder(10, 10, 10, 10);
		
		Border titledBorder=BorderFactory.createTitledBorder(
		BorderFactory.createLineBorder(Color.RED), "Identificacion");
		
		Border compound=BorderFactory.createCompoundBorder(titledBorder,empty);
		
		panel.setBorder(compound);
		
		JLabel label=new JLabel("Username:");
		label.setBorder(BorderFactory.createRaisedBevelBorder());
		label.setHorizontalAlignment(label.CENTER);
		panel.add(label);
		
		this.usuario=new JTextField("");
		panel.add(this.usuario);
		
		JLabel label2=new JLabel("Password:");
		label2.setBorder(BorderFactory.createRaisedBevelBorder());
		label2.setHorizontalAlignment(label2.CENTER);
		panel.add(label2);
		
		this.password=new JPasswordField("");
		panel.add(this.password);
		
		return panel;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch(evt.getPropertyName()) {
			
			case"direccionExistente":{
				JOptionPane.showMessageDialog(this,"La direccion que se a puesto ya existe \n Ponga otro que no este en uso.");
				break;
			}
			case"usuarioExistente":{
				JOptionPane.showMessageDialog(this,"El nombre de usuario ya existe \n Ponga otro que no este en uso.");
				break;
			}
			case"comprobar":{
				Repartidor usuario=(Repartidor) evt.getNewValue();
				
					if(usuario!=null) {
						if(usuario.isAdmin()) {
							VentanaAdmin admin=new VentanaAdmin();
							this.dispose();
						}
						else {
							VentanaRepartidor repartidor=new VentanaRepartidor(usuario);
							this.dispose();
						}					
					}
					else {
						JOptionPane.showMessageDialog(this, "Acceso denegado \n clave no valida");
					}
				
				this.borrarCampos();		
				break;
			}
			case"borrar":{
				this.borrarCampos();
				break;
			}
			case"acabar":{
				this.dispose();
				break;
			}
		}
	}
	
	public void borrarCampos() {
		this.usuario.setText("");
		this.password.setText("");
	}
	
	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JTextField getPassword() {
		return password;
	}

	public ModeloLogin getModelo() {
		return modelo;
	}

	public static void main(String[] args) {
		VentanaLogin programa=new VentanaLogin();
	}
}
