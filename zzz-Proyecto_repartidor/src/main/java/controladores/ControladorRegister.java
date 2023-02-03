package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import base_de_datos.UsersData;
import interfaces.Login;
import interfaces.Register;
import modelo.Usuario;

public class ControladorRegister  implements ActionListener {

	Register vista;
	
	public ControladorRegister(Register vista) {
		// TODO Auto-generated constructor stub
		this.setVista(vista);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

 		String command= e.getActionCommand();
 		boolean register=false;
 		
	 	 switch (command) {
				case "Register": {	
		
					System.out.print(getVista().toString());
				
				
					if(getVista().allFieldsFilled()) {
						UsersData driver =new UsersData();
				
						Usuario registrado=this.getVista().devolverUsuarioRegister();
						
						register=driver.registrarNuevoUsuarioEnDatabase(registrado);
					}
					
				
					if(register) { 
						
						
						 int input = JOptionPane.showConfirmDialog(null, 
					                "The register has been executed","", JOptionPane.DEFAULT_OPTION);
				
						 this.getVista().dispose();
						 
					
					}
					else {
						//prompt de fallo 
						
					    String message = "\"Error\"\n"
					            + "Complete all the fields\n "
					            + "or change the username\n"
					            + "please try with other";
					    
					        JOptionPane.showMessageDialog(this.getVista(), message, "Dialog",
					            JOptionPane.ERROR_MESSAGE);
						
						
						//borrar los datos introducidos
						
							this.getVista().getUsername().setText("");
							this.getVista().getContraseña().setText("");
						
						
					}
					
					break;
				}
				case "ToLogin": {	
			
						this.getVista().dispose();
					
						break;
				}
			
				default:
						break;
		 	}
 		
 	  
 	}




	public Register getVista() {
		return vista;
	}


	public void setVista(Register vista) {
		this.vista = vista;
	} 

	
	
	
}
