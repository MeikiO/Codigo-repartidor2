package interfaces;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControlerPantallaIntegrantes;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.ModeloUsuario;
import modelo.Usuario;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.Component;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.JToolBar;

public class VentanaIntegrantes extends JFrame {


	private static final long serialVersionUID = -3405264460197027202L;
	public JPanel contentPane;
	public JTextField textField;
	
	public JSplitPane splitPane;
	
	
	public JPanel izquierda;
	public JList<Usuario> list;
	public JScrollPane scrollPane;	
	
	public JPanel panelVisualizacion;
	public JPanel derecha;
	
	public ControlerPantallaIntegrantes controler;

	public Grupo selected;
	public GestorGrupos gestor;
	
	public ModeloUsuario modelo;
	
	ControlerPantallaIntegrantes sumar;
	private ControlerPantallaIntegrantes quitar;
	private ControlerPantallaIntegrantes logo;
	private ControlerPantallaIntegrantes mover;
	private ControlerPantallaIntegrantes modificar;
	
	/**
	 * Create the frame.
	 * @param gestor2 
	 * @param grupo 
	 */
	public VentanaIntegrantes(GestorGrupos gestor2) {
		
		this.gestor=gestor2;
		
		this.controler=new ControlerPantallaIntegrantes(this,this.getGestor());
		
		this.modelo=new ModeloUsuario(this.getGestor().getSelectedGroup().getIdGrupo());
		
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		splitPane = new JSplitPane();
		contentPane.add(this.getSplitPane(), BorderLayout.CENTER);
		
		
		this.getSplitPane().setLeftComponent(panelIzquierdo(this.getGestor().getSelectedGroup().getListaUsuario()));
		
	   
		this.getSplitPane().setRightComponent(this.panelDerecho(this.getGestor().getSelectedGroup().getListaUsuario().get(0)));
		
		
		this.setVisible(true);
	}



	public Component panelIzquierdo(List<Usuario> listaExterna) {
		// TODO Auto-generated method stub
		izquierda = new JPanel();
		
		this.getIzquierda().setLayout(new BorderLayout(0, 0));
				
		this.getIzquierda().add(this.parte_superiorD(), BorderLayout.NORTH);
		
		this.getIzquierda().add(this.listShow(listaExterna), BorderLayout.CENTER);
		
		
		return this.getIzquierda();
	}


	public Component parte_superiorD() {
		// TODO Auto-generated method stub
		
		JPanel parte_superiorI = new JPanel();
		

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		parte_superiorI.add(horizontalStrut_1);
		
		textField = new JTextField();
		parte_superiorI.add(this.getTextField());
		this.getTextField().setColumns(10);
		
		JButton search = new JButton("search");
		search.addActionListener(this.getControler());
		search.setActionCommand("search");
		parte_superiorI.add(search);
		
		
		return parte_superiorI ;
	}



	public Component listShow(List<Usuario> listaExterna) {
		// TODO Auto-generated method stub
		
		
		for(Usuario elemento : listaExterna) {
			
			if(!elemento.isAdmin()) {
				this.getModelo().addElement(elemento);
			}
			
		}
		
		list = new JList(this.getModelo());
		this.getList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
	    this.getList().addListSelectionListener(this.getControler());
	    
	    
	
		scrollPane = new JScrollPane();
		this.getScrollPane().setViewportView(this.getList());
		
		
		scrollPane.setColumnHeaderView(this.toolBarPart());
		
		
		return this.getScrollPane();
	}

	
	private Component toolBarPart() {
		// TODO Auto-generated method stub
		
		JToolBar toolBar = new JToolBar();
		Icon icon = new ImageIcon(".\\resources\\icons\\edit_add.png");    
		
		JButton sumar=new JButton(icon);
		sumar.addActionListener(this.getControler());
		sumar.setActionCommand("sumar");
		
		icon = new ImageIcon(".\\resources\\icons\\edit_remove.png");    
		
		JButton quitar=new JButton(icon);
		quitar.addActionListener(this.getControler());
		quitar.setActionCommand("quitar");
		
		icon = new ImageIcon(".\\resources\\icons\\edit.png"); 
		
		JButton modificar=new JButton(icon);
		modificar.addActionListener(this.getControler());
		modificar.setActionCommand("modificar");
		
		icon = new ImageIcon(".\\resources\\icons\\enumList.png"); 
		JButton grupos=new JButton(icon);
		grupos.addActionListener(this.getControler());
		grupos.setActionCommand("grupos");
		
		icon = new ImageIcon(".\\resources\\icons\\exit.png"); 
		JButton logo = new JButton(icon);
		logo.addActionListener(this.getControler());
		logo.setActionCommand("logo");


		toolBar.add(sumar);
		toolBar.add(quitar);
		toolBar.add(modificar);
		toolBar.add(grupos);
		toolBar.add(Box.createHorizontalGlue());
		toolBar.add(logo);
		
		return toolBar;
	}
	


	public Component panelDerecho(Usuario user) {
		// TODO Auto-generated method stub
		
		derecha = new JPanel();
		this.getDerecha().setLayout(new BorderLayout(0, 0));
		
	
		this.getDerecha().add(this.panelSuperiorDerecho(), BorderLayout.NORTH);
	
		panelVisualizacion = new JPanel();
	
		if(user!=null) {
			panelVisualizacion=(JPanel) user.crearPanelDatos();
			this.getDerecha().add(this.getPanelVisualizacion(), BorderLayout.CENTER);
		}
		return this.getDerecha();
	}

	
	

	public Component panelSuperiorDerecho() {
		// TODO Auto-generated method stub
		JPanel parte_superiorD = new JPanel();
		parte_superiorD.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		Component horizontalStrut = Box.createHorizontalStrut(170);
		parte_superiorD.add(horizontalStrut);
		
		JButton email = new JButton("email");
		email.addActionListener(this.getControler());
		email.setActionCommand("email");
		parte_superiorD.add(email);
		return parte_superiorD;
	}





	public JPanel getPanelVisualizacion() {
		return panelVisualizacion;
	}



	public void setPanelVisualizacion(JPanel panelVisualizacion) {
		this.panelVisualizacion = panelVisualizacion;
	}



	public JTextField getTextField() {
		return textField;
	}



	public void setTextField(JTextField textField) {
		this.textField = textField;
	}



	public JSplitPane getSplitPane() {
		return splitPane;
	}



	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}



	public JPanel getIzquierda() {
		return izquierda;
	}



	public void setIzquierda(JPanel izquierda) {
		this.izquierda = izquierda;
	}



	public JList<Usuario> getList() {
		return list;
	}



	public void setList(JList<Usuario> list) {
		this.list = list;
	}



	public JScrollPane getScrollPane() {
		return scrollPane;
	}



	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}



	public JPanel getDerecha() {
		return derecha;
	}



	public void setDerecha(JPanel derecha) {
		this.derecha = derecha;
	}



	public ControlerPantallaIntegrantes getControler() {
		return controler;
	}



	public void setControler(ControlerPantallaIntegrantes controler) {
		this.controler = controler;
	}



	public Grupo getSelected() {
		return selected;
	}



	public void setSelected(Grupo selected) {
		this.selected = selected;
	}



	public GestorGrupos getGestor() {
		return gestor;
	}



	public void setGestor(GestorGrupos gestor) {
		this.gestor = gestor;
	}



	public ModeloUsuario getModelo() {
		return modelo;
	}



	public void setModelo(ModeloUsuario modelo) {
		this.modelo = modelo;
	}


	







}
