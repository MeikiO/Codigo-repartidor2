package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import base_de_datos.UsersData;
import controladores.ControlerPantallaJefe;
import mapas.Recorrido;
import mapas.Sample4;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.ModeloGrupo;

import javax.swing.JSplitPane;
import java.awt.List;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.DefaultListModel;

public class VentanaInitJefe extends JFrame {


	public Sample4 sample;
	public ControlerPantallaJefe controler;
	public GestorGrupos gestor;
	
	public JPanel contentPane;
	public JTextField barraBusqueda;
	
	public JList<Grupo> listaNombres;/*declaramos La Lista*/
	public ModeloGrupo modelo;/*declaramos el Modelo*/
	
	private JScrollPane scrollLista;
	public JSplitPane splitPane;
	
	public JPanel izquierda;

	public VentanaInitJefe(Integer gROUPNUM) {
	
	
		
		gestor=new GestorGrupos(gROUPNUM);
		
		modelo=new ModeloGrupo();
		
		controler=new ControlerPantallaJefe(this,this.getGestor());
		

		for(Grupo elemento : this.getGestor().getListaGrupo()) {
			
				if(elemento.getIdGrupo()!=0) {
					this.getModelo().addElement(elemento);
				}
		}
		
		
		
	
	
		sample=new Sample4(this.getGestor().getSelectedGroup().getListaRecorrido().get(0));

		
		
		
		
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		splitPane = new JSplitPane();
		contentPane.add(this.getSplitPane(), BorderLayout.CENTER);
		
		
		this.getSplitPane().setLeftComponent(parteIzquierda());
		
			
		this.getSplitPane().setRightComponent(this.parteDerecha());
		
		
		this.getSplitPane().setDividerLocation(450);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		

	}


	private Component parteDerecha() {
		// TODO Auto-generated method stub
		
			
		//instanciamos la lista
		listaNombres = new JList(this.getModelo());
		this.getListaNombres().setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
	    this.getListaNombres().addListSelectionListener(this.getControler());

		
		
		//instanciamos el Scroll que tendra la lista
	    scrollLista = new JScrollPane();
		this.getScrollLista().setBounds(20, 120,220, 80);
	    this.getScrollLista().setViewportView(this.getListaNombres());
		
		return scrollLista;
	}

	

	public Component parteIzquierda() {
		// TODO Auto-generated method stub
		
		izquierda = new JPanel();
		
	
		this.getIzquierda().setLayout(new BorderLayout(0, 0));
		
		
		this.getIzquierda().add(parteSuperior(), BorderLayout.NORTH);
		
	
		this.getIzquierda().add(this.getSample().devolverMapa(this.getSample().getRecorrido().getListaWaypoints()), BorderLayout.CENTER);
		
		//Sample3 ventana=new Sample3(this);
		
				
		this.getIzquierda().add(parteDeAbajo(), BorderLayout.SOUTH);
		
		return izquierda;
	}




	public Component parteSuperior() {
		// TODO Auto-generated method stub
		
		JPanel parteSuperior = new JPanel();
		parteSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ImageIcon icon = new ImageIcon(".\\resources\\icons\\exit.png"); 
		
		JButton logo = new JButton(icon);
		//logo.setIcon(new ImageIcon(".\\resources\\images\\Drop (4).png"));
		logo.addActionListener(this.getControler());
		logo.setActionCommand("logo");
		parteSuperior.add(logo);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		parteSuperior.add(horizontalStrut);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		parteSuperior.add(horizontalStrut_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		parteSuperior.add(horizontalStrut_1);
		
		barraBusqueda = new JTextField();
		parteSuperior.add(this.getBarraBusqueda());
		this.getBarraBusqueda().setColumns(10);
		
		JButton busqueda = new JButton("busqueda");
		busqueda.addActionListener(this.getControler());
		busqueda.setActionCommand("busqueda");
		parteSuperior.add(busqueda);
		
		JButton chat = new JButton("chat");
		chat.addActionListener(this.getControler());
		chat.setActionCommand("chat");
		parteSuperior.add(chat);
		
		return parteSuperior;
	}

	
	public Component parteDeAbajo() {
		// TODO Auto-generated method stub
		JPanel abajo = new JPanel();
		
		
		JButton integrantes = new JButton("Integrantes");
		integrantes.addActionListener(this.getControler());
		integrantes.setActionCommand("integrantes");
		abajo.add(integrantes);
		
		JButton recorrido = new JButton("Recorrido");
		recorrido.addActionListener(this.getControler());
		recorrido.setActionCommand("recorrido");
		abajo.add(recorrido);
	
		return abajo;
	}


	public JTextField getBarraBusqueda() {
		return barraBusqueda;
	}


	public void setBarraBusqueda(JTextField barraBusqueda) {
		this.barraBusqueda = barraBusqueda;
	}


	public ControlerPantallaJefe getControler() {
		return controler;
	}


	public void setControler(ControlerPantallaJefe controler) {
		this.controler = controler;
	}


	public GestorGrupos getGestor() {
		return gestor;
	}


	public void setGestor(GestorGrupos gestor) {
		this.gestor = gestor;
	}


	public JPanel getIzquierda() {
		return izquierda;
	}


	public void setIzquierda(JPanel izquierda) {
		this.izquierda = izquierda;
	}


	public Sample4 getSample() {
		return sample;
	}


	public void setSample(Sample4 sample) {
		this.sample = sample;
	}


	public JList<Grupo> getListaNombres() {
		return listaNombres;
	}


	public void setListaNombres(JList<Grupo> listaNombres) {
		this.listaNombres = listaNombres;
	}


	public ModeloGrupo getModelo() {
		return modelo;
	}


	public void setModelo(ModeloGrupo modelo) {
		this.modelo = modelo;
	}


	public JSplitPane getSplitPane() {
		return splitPane;
	}


	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}


	public JScrollPane getScrollLista() {
		return scrollLista;
	}


	public void setScrollLista(JScrollPane scrollLista) {
		this.scrollLista = scrollLista;
	}


	


}



	
