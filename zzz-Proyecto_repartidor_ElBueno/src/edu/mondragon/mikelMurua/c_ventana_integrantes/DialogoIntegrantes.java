package c_ventana_integrantes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import z_enumeraciones.Poblacion;
import z_modelo_equipo_repartidores.Repartidor;

public class DialogoIntegrantes extends JDialog implements  ActionListener {

	private JTextField nombreRepartidor;
	private JTextField apellidoRepartidor;
	private JTextField dniRepartidor;
	private JTextField direccionRepartidor;
	private JTextField telefonoRepartidor;
	private JComboBox<Poblacion> poblacionRepartidor;
	private JTextField usernameRepartidor;
	private JPasswordField contrasenaRepartidor;
	
	private Component panelDatos;

	private Repartidor creada;
	private boolean modificado;
	
	public DialogoIntegrantes(JFrame ventana,String titulo,boolean modo){
		super(ventana,titulo,modo);

		this.setSize(350,400);
		this.setLocation(100,100);
		this.setContentPane(this.crearVentana());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(modo);
	}
	
	public DialogoIntegrantes(JFrame ventana,String titulo,boolean modo,Repartidor elegido){
		super(ventana,titulo,modo);

		this.creada=elegido;
		this.modificado=false;
		
		this.setSize(350,400);
		this.setLocation(100,100);
		this.setContentPane(this.crearVentana());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(modo);
	}
	
	private Container crearVentana() {
		JPanel panel=new JPanel(new BorderLayout());
		
		panel.add(this.panelEntradas());
		
		panel.add(this.panelBotones(),BorderLayout.SOUTH);
		
		return panel;
	}
	
	private Component panelEntradas() {
		JPanel panel=new JPanel(new BorderLayout());
		
		panel.add(this.panelDatosRepartidor());

		if(this.creada!=null) {
			this.setValues();
		}
		
		return panel;
	}

	private void setValues() {
		this.nombreRepartidor.setText(this.creada.getNombre());
		
		this.apellidoRepartidor.setText(this.creada.getApellido());
	
		this.dniRepartidor.setText(this.creada.getDni());
	
		this.direccionRepartidor.setText(this.creada.getDireccion());
	
		this.telefonoRepartidor.setText(this.creada.getTlf());
	
		this.poblacionRepartidor.setSelectedItem(this.creada.getZona_trabajo());
	
		this.usernameRepartidor.setText(this.creada.getUsername());

		this.contrasenaRepartidor.setText(this.creada.getPassword());
	}

	private Component panelDatosRepartidor() {
		JPanel panel=new JPanel(new GridLayout(8,2,10,10));
		
		panel.setBorder(this.setCustomBorder("Panel Repartidores"));
		
		JLabel label=new JLabel("Nombre: ");
		panel.add(label);
		
		nombreRepartidor=new JTextField();
		panel.add(nombreRepartidor);
		
		JLabel label1=new JLabel("Apellidos: ");
		panel.add(label1);
		
		apellidoRepartidor=new JTextField();
		panel.add(apellidoRepartidor);
		
		JLabel label2=new JLabel("DNI: ");
		panel.add(label2);
		
		dniRepartidor=new JTextField();
		panel.add(dniRepartidor);
		
		JLabel label3=new JLabel("Direccion: ");
		panel.add(label3);
		
		direccionRepartidor=new JTextField();
		panel.add(direccionRepartidor);
		
		JLabel label4=new JLabel("Telefono: ");
		panel.add(label4);
		
		telefonoRepartidor=new JTextField();
		panel.add(telefonoRepartidor);
		
		JLabel label5=new JLabel("Zona Trabajo: ");
		panel.add(label5);
		
		poblacionRepartidor=new JComboBox(Poblacion.values());
		panel.add(poblacionRepartidor);
		
		JLabel label6=new JLabel("Username: ");
		panel.add(label6);
		
		usernameRepartidor=new JTextField();
		panel.add(usernameRepartidor);
		
		JLabel label7=new JLabel("Contraseña: ");
		panel.add(label7);
		
		contrasenaRepartidor=new JPasswordField();
		panel.add(contrasenaRepartidor);
		
		return panel;
	}

	private Border setCustomBorder(String string) {
		TitledBorder titledBorder=BorderFactory.createTitledBorder(
		BorderFactory.createLineBorder(Color.BLACK), string);
		Border empty=BorderFactory.createEmptyBorder(10,10,10,10);
		
		CompoundBorder border = BorderFactory.createCompoundBorder(titledBorder, empty);
		
		return border;
	}
		
	private Component panelBotones() {
		JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
		
		JButton start=new JButton("Ok");
		start.addActionListener(this);
		start.setActionCommand("Ok");
		panel.add(start);
		
		JButton cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setActionCommand("Cancel");
		panel.add(cancel);

		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case"Ok":{		
				boolean esModificacion=false;
				int idRepartidor=0;
				
				if(creada!=null) {
					idRepartidor=this.creada.getId_repartidor();
					esModificacion=true;
				}
				
				Poblacion poblacionElegida=(Poblacion) this.poblacionRepartidor.getSelectedItem();
					
				this.creada=new Repartidor(idRepartidor,
						this.nombreRepartidor.getText(),
						this.apellidoRepartidor.getText(),
						this.dniRepartidor.getText(),
						this.direccionRepartidor.getText(),
						this.telefonoRepartidor.getText(),
						poblacionElegida.name(),
						this.usernameRepartidor.getText(),
						this.contrasenaRepartidor.getText(),
						false,
						poblacionElegida.getId());
			
				if(esModificacion) {
					this.modificado=true;
				}
					
				this.dispose();
				break;
			}
			case "Cancel":{
				this.dispose();
				break;
			}
		}
	}

	public Repartidor getCreada() {
		return creada;
	}

	public boolean isModificado() {
		return modificado;
	}

}
