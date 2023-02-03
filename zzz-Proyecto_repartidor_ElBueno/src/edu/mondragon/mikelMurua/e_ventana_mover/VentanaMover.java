package e_ventana_mover;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;

import b_ventanas_admin.VentanaAdmin;
import z_base_de_datos_dao.ConsultasClientes;
import z_base_de_datos_dao.ConsultasRepartidor;
import z_base_de_datos_dao.ObjetoDao;
import z_enumeraciones.Poblacion;
import z_look_and_field.MyLookAndFeel;
import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.Equipo;
import z_modelo_equipo_repartidores.Miembro;
import z_modelo_equipo_repartidores.Repartidor;

public class VentanaMover extends JFrame implements PropertyChangeListener{

	private ControladorMover controlador;
	
	private ModeloMover modeloLlamada;
	private List<ModeloMover> listaModelosGrupos;
	private List<JList> listaJListsGrupos;
	
	private JList listaIzquierda;
	private DefaultListModel modeloIzquierdo;
	private List<Equipo> listaElementos;

	private boolean isRepartidor;

	private ControladorMover salir;
	
	private static String botonDerecho="resources/images/2rightarrow.png";
	private static String botonIzquierdo="resources/images/2leftarrow.png";
	
	
	public VentanaMover(List<Equipo> list,boolean condicion) {
		String elementoAMover="";
		
		if(condicion) {
			elementoAMover="Repartidores";
		}
		else {
			elementoAMover="Clientes";
		}
		
		this.setTitle("Definicion de grupos "+elementoAMover);
		
		MyLookAndFeel look=new MyLookAndFeel(this);
		
		this.isRepartidor=condicion;
		
		this.listaElementos=list;
		
		this.listaJListsGrupos=new ArrayList<>();
		
		this.listaModelosGrupos=new ArrayList<>();
		
		this.inicializar();
		
		this.modeloLlamada=new ModeloMover();
		this.modeloLlamada.addPropertyChangeListener(this);
		this.controlador=new ControladorMover(this,modeloLlamada);
		
		this.setBounds(200, 200, 1100, 625);
		
		this.crearAcciones();
		this.setJMenuBar(this.crearBarraMenu());
		
		this.setContentPane(this.crearVentana());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearAcciones() {
		salir= new ControladorMover ("Volver a Administrador", new ImageIcon("resources/icons/exit.png"),"Volver a Administrador", KeyEvent.VK_C,this,this.modeloLlamada);
	}
	
	private JMenuBar crearBarraMenu() {
		JMenuBar barra=new JMenuBar();
		
		barra.add(Box.createHorizontalGlue());
		
		barra.add(this.crearMenuSalir());
		
		return barra;
	}

	private JMenu crearMenuSalir() {
		JMenu menuSalir=new JMenu("Volver a v.Administracion");
		menuSalir.add(this.salir);
		return menuSalir;
	}
	
	private Component panelToolbar() {
		JPanel panelToolbar=new JPanel(new GridLayout(1,1,20,50));
		panelToolbar.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JToolBar toolbar=new JToolBar();

		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(salir);
		
		panelToolbar.add(toolbar);
		
		return panelToolbar;
	}
	
	private void inicializar() {	
		for(Poblacion actual:Poblacion.values()) {
			List<Miembro> lista=new ArrayList<>();
			
			Equipo dePega=new Equipo();
			dePega.setPoblacionActual(actual);
			
			if(this.listaElementos.contains(dePega)) {
				int posicion=this.listaElementos.indexOf(dePega);
				
				if(this.isRepartidor) {
					for(Repartidor elemento:this.listaElementos.get(posicion).getListaRepartidores()) {
						lista.add(elemento);
					}
				}
				else {
					for(Cliente elemento:this.listaElementos.get(posicion).getListaClientes()) {
						lista.add(elemento);
					}
				}
			}
	
			ModeloMover nuevo=new ModeloMover(actual,lista);
			
			this.listaModelosGrupos.add(nuevo);
		}
	}
	
	private Container crearVentana() {
		JPanel panelPrincipal=new JPanel(new BorderLayout());
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		panelPrincipal.add(this.panelToolbar(),BorderLayout.NORTH);
		
		JSplitPane panel=new JSplitPane();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10)); 
			
		panel.setDividerLocation(300);
		
		panel.setLeftComponent(this.panelIzquierdo());
		
		panel.setRightComponent(this.panelGrupos());
		
		panelPrincipal.add(panel);
		
		return panelPrincipal;
	}
	
	private Component panelIzquierdo() {
		JPanel panelDerecho=new JPanel(new GridLayout(1,1));
		panelDerecho.setBorder(
				BorderFactory.createTitledBorder("Elementos para asignar"));
		
		this.modeloIzquierdo=new DefaultListModel();
		
		listaIzquierda=new JList(this.modeloIzquierdo);
		listaIzquierda.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		panelDerecho.add(this.panelScrollBar(listaIzquierda));
		return panelDerecho;
	}
	
	private Component panelGrupos() {	
		JScrollPane panelPrincipal=new JScrollPane();
		
		int numEquipos=(Poblacion.values().length/2)+1;
		
		JPanel panel=new JPanel(new GridLayout(numEquipos,2,20,20));

		for(ModeloMover actual:this.listaModelosGrupos) {				
			JList listaDerecha=new JList(actual);
			listaDerecha.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			actual.addPropertyChangeListener(this);
			this.listaJListsGrupos.add(listaDerecha);
			
			panel.add(this.panelGrupo(actual.getPoblacion(),listaDerecha));
		}
		
		panelPrincipal.setViewportView(panel);

		return panelPrincipal;
	}
	
	private Component panelGrupo(Poblacion poblacion,JList lista) {
		JPanel panel=new JPanel(new BorderLayout());
		panel.setBorder(
				BorderFactory.createTitledBorder("Equipo"+poblacion.getId()+"--Poblacion: "+poblacion.name()));
		
		JPanel panelBotones=new JPanel(new GridLayout(2,1,20,20));
		
		JButton enter=new JButton(new ImageIcon(this.botonDerecho));
		enter.addActionListener(controlador);
		enter.setActionCommand("enter:"+poblacion.getId());
		panelBotones.add(enter);
		
		JButton salir=new JButton(new ImageIcon(this.botonIzquierdo));
		salir.addActionListener(controlador);
		salir.setActionCommand("salir:"+poblacion.getId());
		panelBotones.add(salir);
		
		panel.add(panelBotones,BorderLayout.WEST);
		
		panel.add(this.panelScrollBar(lista));
		
		return panel;
	}

	private Component panelScrollBar(JList jlista) {
		JScrollPane panel=new JScrollPane();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		jlista.setLayoutOrientation(JList.VERTICAL);
		panel.add(jlista);
		
		panel.setViewportView(jlista);
			
		return panel;
	}
	
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		switch(evt.getPropertyName()) {
			case "enter":{		
				if(!this.getListaIzquierda().isSelectionEmpty()) {
					List<Miembro> elegidos=this.getListaIzquierda().getSelectedValuesList();
					int numero=(int) evt.getNewValue();
					for(Miembro elemento:elegidos) {
						this.getListaModelosGrupos().get(numero).anadir(elemento);
						this.getModeloIzquierdo().removeElement(elemento);
					}
				}
			
				break;
			}
			case "salir":{
				int numero=(int) evt.getNewValue();
				if(!this.getListaJListsGrupos().get(numero).isSelectionEmpty()) {
					List<Miembro> cosas =this.getListaJListsGrupos().get(numero).getSelectedValuesList();
					
					for(Miembro elemento:cosas) {
						this.getListaModelosGrupos().get(numero).quitar(elemento);
						this.getModeloIzquierdo().addElement(elemento);
					}
				}
				
				break;
			}
			case "Volver a Administrador":{
				if(!this.getModeloIzquierdo().isEmpty()) {
			         JOptionPane.showMessageDialog(this,
			        		 "La lista de elementos no puede tener ningun elemento\n"
						    + "distribuya los elementos restantes en los equipos.");     
			    }
				else {
					ObjetoDao database=null;
					
					if(this.isRepartidor()) {
						database=new ConsultasRepartidor();
					}
					else {
						database=new ConsultasClientes();
					}
					
					for(ModeloMover actual:this.getListaModelosGrupos()) {
						if(!actual.getListaElementos().isEmpty()) {
							database.actualizarLista(actual.getListaElementos());
						}
					}
					
					VentanaAdmin ventanaAdmin=new VentanaAdmin();	
					this.dispose();
				}
					
				break;
			}
		}
	}
	
	public List<ModeloMover> getListaModelosGrupos() {
		return listaModelosGrupos;
	}

	public void setListaModelosGrupos(List<ModeloMover> listaModelosGrupos) {
		this.listaModelosGrupos = listaModelosGrupos;
	}

	public List<JList> getListaJListsGrupos() {
		return listaJListsGrupos;
	}

	public void setListaJListsGrupos(List<JList> listaJListsGrupos) {
		this.listaJListsGrupos = listaJListsGrupos;
	}

	public JList getListaIzquierda() {
		return listaIzquierda;
	}

	public void setListaIzquierda(JList listaIzquierda) {
		this.listaIzquierda = listaIzquierda;
	}

	public DefaultListModel getModeloIzquierdo() {
		return modeloIzquierdo;
	}

	public void setModeloIzquierdo(DefaultListModel modeloIzquierdo) {
		this.modeloIzquierdo = modeloIzquierdo;
	}
	
	public boolean isRepartidor() {
		return isRepartidor;
	}

	public void setRepartidor(boolean isRepartidor) {
		this.isRepartidor = isRepartidor;
	}

	public List<Equipo> getListaElementos() {
		return listaElementos;
	}

	public void setListaElementos(List<Equipo> listaElementos) {
		this.listaElementos = listaElementos;
	}
	
}
