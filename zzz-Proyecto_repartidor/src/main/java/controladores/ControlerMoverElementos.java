package controladores;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import base_de_datos.PuntosData;
import base_de_datos.UsersData;
import factories.MoverElementos;
import interfaces.VentanaMover;
import interfaces.VentanaIntegrantes;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.Usuario;

public class ControlerMoverElementos<T> implements ActionListener, WindowListener {

	private GestorGrupos gestor;
	private VentanaMover vista;

	public ControlerMoverElementos(VentanaMover ventanGrupos, GestorGrupos gestor) {
		// TODO Auto-generated constructor stub
	
		this.vista=ventanGrupos;
		this.gestor=gestor;
	}




@Override
public void actionPerformed(ActionEvent evt) {
	
	String command= evt.getActionCommand();
	
	String mensaje[]=command.split(" ");
	
	String direccion=mensaje[0];
	
	String numero=mensaje[1];
	
	Integer num=Integer.parseInt(numero);

	
	List<T> elementos;
	Grupo grupo;
	
	
	grupo=this.getGestor().getListaGrupo().get(num.intValue());
		
	

	switch(direccion) {
	case "izda":{
		

		elementos=grupo.getLista().getSelectedValuesList();
		
		
		
		for(T a: elementos) {

			grupo.getListaUsuario().remove(a);
			grupo.getModelo().removeElement(a);
			grupo.getLista().repaint();
			
			this.getVista().getModelo().addElement(a);
			this.getVista().getListaIzquierda().repaint();
		}
		

		
		
	}break;
	
	case "dcha":{

		elementos=this.getVista().getListaIzquierda().getSelectedValuesList();
		
		
		for(T a:elementos) {
			
			this.getVista().getModelo().removeElement(a);
			this.getVista().getListaIzquierda().repaint();
			
			
			grupo.getModelo().addElement(a);
			grupo.getLista().repaint();
			
			
		}
		
	}break;
	}
	
}





@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub

	
	//guardar todas las listas
	
	//actualizar los grupo de cada usuario
	
	System.out.println(e.getSource());
	
	UsersData database=new UsersData();
	PuntosData databasep=new PuntosData();
	
	
	for(Grupo g:this.getVista().getElementosd().getGestor().getListaGrupo()) {
		
		this.getVista().getElementosd().guardarEnDatabase(g);
	}
	
	
	this.getVista().dispose();
	this.getVista().getElementosd().volver();
	
	
}



@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	

	
}


@Override
public void windowOpened(WindowEvent e) {
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




public GestorGrupos getGestor() {
	return gestor;
}




public void setGestor(GestorGrupos gestor) {
	this.gestor = gestor;
}




public VentanaMover getVista() {
	return vista;
}




public void setVista(VentanaMover vista) {
	this.vista = vista;
}





	
	
	
}
