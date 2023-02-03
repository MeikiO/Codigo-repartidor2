package interfaces;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controladores.ControlerVRecorrido;
import mapas.Sample4;
import mapas.SwingWaypoint;
import mapas.VisualizacionPunto;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.ModeloGrupo;
import modelo.ModeloUsuario;
import modelo.ModeloWaipoint;
import modelo.Usuario;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ListModel;

public class VRecorrido extends JFrame implements ListSelectionListener {

	private JPanel contentPane;
	

	public GestorGrupos gestor;
	
	public ControlerVRecorrido controlador;
	
	public JList<Grupo> grupos;
	public ModeloGrupo modeloGrupo;
	
	public JList<SwingWaypoint> waipoints;
	public ModeloWaipoint modeloWaipoint;
	
	public JScrollPane visualizacion;
	
	public JSplitPane splitPane;

	public SwingWaypoint puntoElegido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GestorGrupos gestor=new GestorGrupos(2);
					VRecorrido frame = new VRecorrido(gestor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VRecorrido(GestorGrupos gestor) {
		
		//puntoElegido=gestor.listaGrupo.get(1).listaRecorrido.get(0).listaWaypoints.iterator().next();
		
		
		this.gestor=gestor;
		
		controlador=new ControlerVRecorrido(this, gestor);
		
		this.modeloGrupo=new ModeloGrupo();
		this.modeloWaipoint=new ModeloWaipoint();
		
		this.addWindowListener(this.getControlador());
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setVisible(true);
		
		
		splitPane = new JSplitPane();
		contentPane.add(this.getSplitPane(), BorderLayout.CENTER);
		
		splitPane.setLeftComponent(this.parteIzquierda());
		
		splitPane.setRightComponent(
				this.parteDerecha(this.getGestor().getSelectedWaypoint()));
		
		this.splitPane.setDividerLocation(300);
		
		
		
		
	}

	
	
	public Component parteDerecha(SwingWaypoint lista) {
		// TODO Auto-generated method stub
		
		visualizacion = new JScrollPane();
		
		try {
			VisualizacionPunto punto=new VisualizacionPunto(lista,false);
			this.getVisualizacion().setAutoscrolls(true);
			this.getVisualizacion().setViewportView(punto);
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}

		this.visualizacion.setColumnHeaderView(this.toolBarPart());
		

		return this.getVisualizacion();
	}

	private Component toolBarPart() {
		// TODO Auto-generated method stub
		
		JToolBar toolBar = new JToolBar();
		Icon icon = new ImageIcon(".\\resources\\icons\\edit_add.png");    
		
		JButton sumar=new JButton(icon);
		sumar.addActionListener(this.getControlador());
		sumar.setActionCommand("sumar");
		
		icon = new ImageIcon(".\\resources\\icons\\edit_remove.png");    
		
		JButton quitar=new JButton(icon);
		quitar.addActionListener(this.getControlador());
		quitar.setActionCommand("quitar");
		
		icon = new ImageIcon(".\\resources\\icons\\edit.png"); 
		
		JButton modificar=new JButton(icon);
		modificar.addActionListener(this.getControlador());
		modificar.setActionCommand("modificar");
		
		icon = new ImageIcon(".\\resources\\icons\\enumList.png"); 
		JButton grupos=new JButton(icon);
		grupos.addActionListener(this.getControlador());
		grupos.setActionCommand("grupos");
		
		icon = new ImageIcon(".\\resources\\icons\\exit.png"); 
		JButton logo = new JButton(icon);
		logo.addActionListener(this.getControlador());
		logo.setActionCommand("logo");


		toolBar.add(sumar);
		toolBar.add(quitar);
		toolBar.add(modificar);
		toolBar.add(grupos);
		toolBar.add(Box.createHorizontalGlue());
		toolBar.add(logo);
		
		return toolBar;
	}

	
	
	private Component parteIzquierda() {
		// TODO Auto-generated method stub
		JPanel izquierda = new JPanel();
		
		izquierda.setLayout(new BorderLayout(0, 0));
		
		
		izquierda.add(this.listaIzquierda(), BorderLayout.CENTER);
		
		//izquierda.add(this.botonesIzquierda(), BorderLayout.SOUTH);
		
		
		return izquierda;
		
	}

	
	
	private Component listaIzquierda() {
		// TODO Auto-generated method stub
		JSplitPane listas = new JSplitPane();
		
		JScrollPane gruposScroll=new JScrollPane();
	
		this.grupos = new JList(modeloGrupo);
		this.getGrupos().setBorder(new CompoundBorder(new TitledBorder("Grupos"),new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null)));
		this.getGrupos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
	    this.getGrupos().addListSelectionListener(this.getControlador());
	    
	    
	    for(Grupo elemento:this.getGestor().getListaGrupo()) {
	    	this.getModeloGrupo().addElement(elemento);
	    }

	    gruposScroll.setViewportView(this.grupos);
	    
		listas.setLeftComponent(gruposScroll);
		
		
	
		this.waipoints = new JList(this.getModeloWaipoint());
		this.getWaipoints().setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		this.getWaipoints().setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		this.getWaipoints().addListSelectionListener(this);
		
		
		for(SwingWaypoint elemento: this.getGestor().getListaGrupo().get(1).getListaRecorrido().get(0).getWaypoints()) {
			this.getModeloWaipoint().addElement(elemento);
		}
		
		
		JScrollPane waypointScroll=new JScrollPane();
		waypointScroll.setViewportView(this.getWaipoints());
		
		listas.setRightComponent(waypointScroll);
		
		
		listas.setDividerLocation(120);
		
		return listas;
	}
	
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		//este es para las acciones del waipoint
			
		try {
			System.out.println("lista Waypoints");
			
			SwingWaypoint elegido=this.getWaipoints().getSelectedValue();
			
			this.getSplitPane().setRightComponent(this.parteDerecha(elegido));	
			this.getSplitPane().setDividerLocation(300);
			
			if(elegido!=null) {
				this.getGestor().setSelectedWaypoint(elegido);
			}
		}
		catch(NullPointerException exc) {
			exc.printStackTrace();
		}
	
	}
	
	
	

	private Component botonesIzquierda() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		
		JButton anadir = new JButton("Anadir");
		anadir.addActionListener(this.getControlador());
		anadir.setActionCommand("anadir");
		panel.add(anadir);
		
		JButton quitar = new JButton("Quitar");
		quitar.addActionListener(this.getControlador());
		quitar.setActionCommand("quitar");
		panel.add(quitar);
		
		JButton modificar = new JButton("Modificar");
		modificar.addActionListener(this.getControlador());
		modificar.setActionCommand("modificar");
		panel.add(modificar);
		
		JButton mover = new JButton("Mover");
		mover.addActionListener(this.getControlador());
		mover.setActionCommand("mover");
		panel.add(mover);
		
		return panel;
	}

	public GestorGrupos getGestor() {
		return gestor;
	}

	public void setGestor(GestorGrupos gestor) {
		this.gestor = gestor;
	}

	public ControlerVRecorrido getControlador() {
		return controlador;
	}

	public void setControlador(ControlerVRecorrido controlador) {
		this.controlador = controlador;
	}

	public JList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(JList<Grupo> grupos) {
		this.grupos = grupos;
	}

	public ModeloGrupo getModeloGrupo() {
		return modeloGrupo;
	}

	public void setModeloGrupo(ModeloGrupo modeloGrupo) {
		this.modeloGrupo = modeloGrupo;
	}

	public JList<SwingWaypoint> getWaipoints() {
		return waipoints;
	}

	public void setWaipoints(JList<SwingWaypoint> waipoints) {
		this.waipoints = waipoints;
	}

	public ModeloWaipoint getModeloWaipoint() {
		return modeloWaipoint;
	}

	public void setModeloWaipoint(ModeloWaipoint modeloWaipoint) {
		this.modeloWaipoint = modeloWaipoint;
	}

	public JScrollPane getVisualizacion() {
		return visualizacion;
	}

	public void setVisualizacion(JScrollPane visualizacion) {
		this.visualizacion = visualizacion;
	}

	public JSplitPane getSplitPane() {
		return splitPane;
	}

	public void setSplitPane(JSplitPane splitPane) {
		this.splitPane = splitPane;
	}

	public SwingWaypoint getPuntoElegido() {
		return puntoElegido;
	}

	public void setPuntoElegido(SwingWaypoint puntoElegido) {
		this.puntoElegido = puntoElegido;
	}





}
