package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import interfaces.Login;
import interfaces.VRecorrido;
import interfaces.VentanaMover;
import interfaces.VentanaInitJefe;
import interfaces.VentanaIntegrantes;
import mapas.Sample4;
import modelo.GestorGrupos;
import modelo.Grupo;


public class ControlerPantallaJefe implements ListSelectionListener, ActionListener {
	

	public GestorGrupos gestor;
	public VentanaInitJefe vista;


	
	public ControlerPantallaJefe(VentanaInitJefe ventanaInitJefe, GestorGrupos gestorG) {
		// TODO Auto-generated constructor stub
	
		this.vista=ventanaInitJefe;
		this.gestor=gestorG;
		
		
	}

	
	
     public void valueChanged(ListSelectionEvent listSelectionEvent) {
	   
         
	            Grupo grupoSeleccionado=this.vista.listaNombres.getSelectedValue();
	        	
	            this.vista.sample=new Sample4(grupoSeleccionado.getListaRecorrido().get(0));
	        	       	
	              	
	        	//se pone lo que se quiere poner ( se actualiza solo no hace falta quitar nada)
	        	this.vista.splitPane.setLeftComponent(this.vista.parteIzquierda());
	        	
	    
	         	
	        	this.gestor.selectedGroup=grupoSeleccionado;
	        	
	        	
	        
	      }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String command= e.getActionCommand();
 		boolean register=false;
 		
	 	 switch (command) {
				case "logo": {	
		
					this.vista.dispose();
					Login re=new Login();
					
					break;
				}
				case "busqueda": {	
			
					
						break;
				}
				case "integrantes": {	
					this.vista.dispose();
					VentanaIntegrantes re=new VentanaIntegrantes(this.gestor);
					
					
					break;
				}
				case "recorrido": {	
					
			
					this.vista.dispose();
					VRecorrido re=new VRecorrido(this.gestor);
					
					break;
				}
			
				default:
						break;
		 	}
 		
 	  
	}

	public GestorGrupos getGestor() {
		return gestor;
	}

	public void setGestor(GestorGrupos gestor) {
		this.gestor = gestor;
	}

	public VentanaInitJefe getVentana() {
		return vista;
	}

	public void setVentana(VentanaInitJefe ventana) {
		this.vista = ventana;
	}
	    

	
	
	
}

