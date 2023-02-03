package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Busquedas.Busquedas;
import base_de_datos.PuntosData;
import factories.FactoryMovimientos;
import interfaces.VRecorrido;
import interfaces.VentanaInitJefe;
import interfaces.VentanaMover;
import mapas.SwingWaypoint;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.Usuario;





public class ControlerVRecorrido implements ActionListener, WindowListener, ListSelectionListener {

	private GestorGrupos gestor;
	private VRecorrido vista;
	private PuntosData database;

	public ControlerVRecorrido(VRecorrido vRecorrido, GestorGrupos gestor) {
		// TODO Auto-generated constructor stub
		
		this.vista=vRecorrido;
		this.gestor=gestor;
 		this.database=new PuntosData();
	}

	

	@Override
	public void valueChanged(ListSelectionEvent listSelectionEvent) {
		// TODO Auto-generated method stub
		
				
				System.out.println("lista Grupo");
				
				Grupo grupoSeleccionado=this.vista.grupos.getSelectedValue();
				
				this.vista.modeloWaipoint.removeAllElements();
				
				for(SwingWaypoint elemento:grupoSeleccionado.listaRecorrido.get(0).getWaypoints()){
					
					this.vista.modeloWaipoint.addElement(elemento);	
					
				}
				
				if(grupoSeleccionado!=null) {
					this.gestor.selectedGroup=grupoSeleccionado;
				}
				
				
				this.vista.waipoints.repaint();
				
				
			
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command= e.getActionCommand();
 		boolean register=false;
 		
	 	 switch (command) {
				case "anadir": {	
		
			
					break;
				}
				case "quitar": {	
			
				//queda remover el punto del JList y de la database
					
				
					//retirar del gestor
					this.gestor.getListaGrupo().get(gestor.selectedGroup.idGrupo)
					.getListaRecorrido().get(0).listaWaypoints.remove(this.gestor.selectedWaypoint);
					
					
					//retirar JList
					this.vista.modeloWaipoint.removeElement(this.gestor.selectedWaypoint);
					this.vista.waipoints.repaint();
					
					
					//retirar database
					this.database.borrarPunto(this.gestor.selectedWaypoint);
					
						break;
				}
				case "modificar": {	
			
					
					break;
				}
				case "mover": {	
					
					this.vista.dispose();
										
					VentanaMover vgrupo=new VentanaMover(new FactoryMovimientos(this.gestor).getPuntos());
					
		
					break;
				}
				case"logo":{
					this.vista.dispose();
					VentanaInitJefe ventana=new VentanaInitJefe(this.vista.getGestor().getNUMGRUPOS());
				}
			
				default:
						break;
		 	}
 			
	}

	
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}



}
