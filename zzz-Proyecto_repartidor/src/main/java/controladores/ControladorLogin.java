package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import base_de_datos.UsersData;
import interfaces.Login;
import interfaces.Register;
import interfaces.VentanaInicialRepartidor;
import interfaces.VentanaInitJefe;
import modelo.Usuario;

public class ControladorLogin implements ActionListener {

	private Login vista;
	
	public ControladorLogin(Login vista) {
		// TODO Auto-generated constructor stub
		this.setVista(vista);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command= e.getActionCommand();
	 	 
	 	 switch (command) {
			case "login": {
				UsersData demo=new UsersData();
				
				boolean login=demo.loginCertificate(this.getVista().getUsername().getText(),this.getVista().getPassfield().getText());
				
				if(login==true) {
					
					boolean admin=demo.adminCertificate(this.getVista().getUsername().getText());	
					
					if(admin==true) {
						this.getVista().dispose();
						VentanaInitJefe ven=new VentanaInitJefe(demo.getGROUPNUM());
					}
					if(admin==false){
						this.getVista().dispose();
						VentanaInicialRepartidor ven=new VentanaInicialRepartidor();
					}
					
				}
				else{
					//promt con mensaje de error
					
					String message = "\"Error in the credentials\"\n"
					        + "The password or the username are not correct\n"
					        + "Please try again";
					    JOptionPane.showMessageDialog(this.vista, message, "Dialog",
					        JOptionPane.ERROR_MESSAGE);
					
					//borrar textos
					this.getVista().getUsername().setText("");
					this.getVista().getPassfield().setText("");
					
				}
				  
				break;
			}
			case "ToRegister": {	
					
					Register re=new Register();
					
					break;
				}
			

			
				default:
						break;
		 	}
		
	  
	} 
		

	public Login getVista() {
		return vista;
	}

	public void setVista(Login vista) {
		this.vista = vista;
	}
	
	

}
