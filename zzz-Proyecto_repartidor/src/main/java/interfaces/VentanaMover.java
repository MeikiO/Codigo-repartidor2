package interfaces;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Element;

import base_de_datos.UsersData;
import controladores.ControlerMoverElementos;
import factories.FactoryMovimientos;
import factories.FactoryMovimientos.SelectorUsuarios;
import factories.MoverElementos;
import mapas.Recorrido;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.ModeloUsuario;
import modelo.Usuario;

public class VentanaMover<T>  extends JFrame{
	
	public JButton flechaIzq, flechaDer;
	
	public DefaultListModel modelo;

	public JList<MoverElementos> listaIzquierda;
	
	public JPanel panel;

	public ControlerMoverElementos controler;
	public MoverElementos elementosd;

	
public VentanaMover( MoverElementos elementos) {
		// TODO Auto-generated constructor stub

	this.elementosd=elementos;
	
	this.controler=new ControlerMoverElementos(this,this.getElementosd().getGestor());
	this.addWindowListener(this.getControler());
	
	this.setLocation(200,200);
	this.add(crearPanelCentral());
	this.pack();
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
	


private Container crearPanelCentral() {
	JSplitPane panel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,
	crearPanelIzquierda(),crearPanelDerecha());
	panel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
	panel.setDividerLocation(150);
	return panel;
}



public Component crearPanelIzquierda() {
	JScrollPane panelSeleccion = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	panelSeleccion.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
			(BorderFactory.createLoweredBevelBorder(),"Lista "),
			BorderFactory.createEmptyBorder(2,2,2,2)));
																						
	panelSeleccion.setOpaque(true);
	
	this.modelo=new DefaultListModel();
	
	for( Object elemento: this.getElementosd().cogerLista0()) {
			this.getModelo().addElement(elemento);
	}
	
	
	this.listaIzquierda=new JList(this.getModelo());
	
	panelSeleccion.setViewportView(this.getListaIzquierda());


	return panelSeleccion;
}


public Component crearPanelDerecha() {
	int x,y;
	x=this.getElementosd().getGestor().getNUMGRUPOS()/2;
	
	JPanel panel  = new JPanel(new GridLayout(x,x,5,5));
	panel.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
	
	for(Grupo g: this.getElementosd().getGestor().getListaGrupo()) {
		if(g.getIdGrupo()!=0) {
			panel.add(g.crearPanelGrupo(this,this.getElementosd().cogerListaGrupo(g.getIdGrupo())));
		}
	}
	return panel;
}



public JButton getFlechaIzq() {
	return flechaIzq;
}



public void setFlechaIzq(JButton flechaIzq) {
	this.flechaIzq = flechaIzq;
}



public JButton getFlechaDer() {
	return flechaDer;
}



public void setFlechaDer(JButton flechaDer) {
	this.flechaDer = flechaDer;
}



public DefaultListModel getModelo() {
	return modelo;
}



public void setModelo(DefaultListModel modelo) {
	this.modelo = modelo;
}



public JList<MoverElementos> getListaIzquierda() {
	return listaIzquierda;
}



public void setListaIzquierda(JList<MoverElementos> listaIzquierda) {
	this.listaIzquierda = listaIzquierda;
}



public JPanel getPanel() {
	return panel;
}



public void setPanel(JPanel panel) {
	this.panel = panel;
}



public ControlerMoverElementos getControler() {
	return controler;
}



public void setControler(ControlerMoverElementos controler) {
	this.controler = controler;
}



public MoverElementos getElementosd() {
	return elementosd;
}



public void setElementosd(MoverElementos elementosd) {
	this.elementosd = elementosd;
}



}
