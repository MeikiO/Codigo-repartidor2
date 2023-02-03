import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Vista extends JFrame {
	List<JList> listaPaneles;
	MiAccion accAdelante, accAtras;
	JLabel labelPagina;
	ControladorPeliculas controlador;
	PanelPelicula panel;
	RendererPelicula renderer;
	int actual=0, tamaño;
	public int getActual() {
		return actual;
	}
	public void setActual(int actual) {
		this.actual = actual;
	}
	public int getTamaño() {
		return tamaño;
	}
	public Vista() {
		super("Peliculas");
		this.crearAcciones();
		
		this.renderer=new RendererPelicula();
		listaPaneles= new ArrayList<>();
		this.controlador=new ControladorPeliculas("files/peliculas.txt",this);
		this.tamaño=this.controlador.getLista().size()/5;
		this.setLocation(500, 300); 
		this.setSize(400,600);
		this.setContentPane(crearPanelVentana());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);	
	}
	private void crearAcciones() {
		accAdelante=new MiAccion("Adelante",new ImageIcon("icons/1rightarrow.png"),"Adelante",this);
		accAtras=new MiAccion("Atras",new ImageIcon("icons/1leftarrow.png"),"Atras",this);
	}
	private Container crearPanelVentana() {
		JPanel panel=new JPanel(new BorderLayout(10,10));
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel.add(crearPanelToolbar(),BorderLayout.NORTH);
		panel.add(crearPanelLista(),BorderLayout.CENTER);
		return panel;
	}
	private JToolBar crearPanelToolbar() {
		JToolBar toolBar=new JToolBar();
		labelPagina=new JLabel();
		toolBar.setBorder(BorderFactory.createRaisedBevelBorder());
		toolBar.addSeparator();
		toolBar.add(accAtras);
		toolBar.addSeparator(new Dimension(125,10));
		toolBar.add(labelPagina);
		toolBar.addSeparator(new Dimension(125,10));
		toolBar.add(accAdelante);
		return toolBar;
	}
	private Component crearPanelLista() {
		int j=0, salir=0,kont=0;
		panel=new PanelPelicula();
		
		for(int i=0;i<controlador.getLista().size()/5+1;i++) {
			
			JList<Pelicula> listaPeliculas =new JList<>();
			Modelo modelo=new Modelo();
			listaPeliculas.setModel(modelo);
			listaPeliculas.setCellRenderer(renderer);
			
			while(j<5&&salir==0) {
				if(kont>=controlador.getLista().size()) {
					salir=1;
				}else {
					modelo.addElement(controlador.getLista().get(kont));
					listaPeliculas.add(controlador.getLista().get(kont));
					
				}
				j++;
				
				kont++;
			}
			if(salir==1) {
				salir=0;
			}
			panel.setTamaño(j);
			labelPagina.setText(this.getActual()*this.panel.getTamaño()+"-"+((this.getActual()*this.panel.getTamaño())+this.panel.getTamaño()-1));
			j=0;
			
			listaPaneles.add(listaPeliculas);
		}
		panel.setViewportView(listaPaneles.get(0));
		
		return panel;
	}
	public static void main(String[] args) {

		Vista programa =new Vista();
	}

}
