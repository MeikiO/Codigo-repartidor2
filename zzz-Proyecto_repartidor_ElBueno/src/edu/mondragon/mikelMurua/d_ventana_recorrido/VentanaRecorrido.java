package d_ventana_recorrido;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import b_ventanas_admin.VentanaAdmin;
import e_ventana_mover.VentanaMover;
import z_look_and_field.MyLookAndFeel;
import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.Equipo;
import z_tablas.TablaSemana;

public class VentanaRecorrido extends JFrame implements ListSelectionListener, PropertyChangeListener   {

	private ModeloRecorrido modelo;
	private JList listaElementos;
	private JList listaClaves;
	private DefaultListModel<Cliente> modeloElementos;
	
	private ControladorRecorrido salir;
	private ControladorRecorrido anadir;
	private ControladorRecorrido quitar;
	private ControladorRecorrido modificar;
	private ControladorRecorrido mover;
	private JLabel nombreCliente;
	private JLabel poblacionCliente;
	private JLabel direccionCliente;
	private JLabel llaveCliente;
	private JLabel comoDejarACliente;
	private JLabel listaProductos;
	private TablaSemana tablaDias;
	
	private static String imagenPruebaCliente="resources/images/userIcon.png";

	public VentanaRecorrido(List<Equipo> lista) {
		super("Ventana Clientes");
		MyLookAndFeel look=new MyLookAndFeel(this);
				
		this.modelo=new ModeloRecorrido(lista);
		this.modelo.addPropertyChangeListener(this);

		this.setBounds(200, 200, 900, 700);
		
		this.crearAcciones();
		
		this.setJMenuBar(this.crearBarraMenu());
		
		this.setContentPane(this.crearVentana());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearAcciones() {
		anadir = new ControladorRecorrido ("Anadir", new ImageIcon("resources/icons/edit_add.png"), "Anadir", KeyEvent.VK_O,this,this.modelo);
		
		quitar = new ControladorRecorrido ("Quitar", new ImageIcon("resources/icons/edit_remove.png"), "Quitar", KeyEvent.VK_O,this,this.modelo);
		
		modificar=new ControladorRecorrido ("Modificar",new ImageIcon("resources/icons/edit.png"), "Modificar", KeyEvent.VK_O,this,this.modelo);
		
		mover=new ControladorRecorrido ("Mover",new ImageIcon("resources/icons/enumList.png"), "Mover", KeyEvent.VK_O,this,this.modelo);
				
		salir= new ControladorRecorrido ("Volver", new ImageIcon("resources/icons/exit.png"),"Volver", KeyEvent.VK_C,this,this.modelo);
	}
	
	private JMenuBar crearBarraMenu() {
		JMenuBar barra=new JMenuBar();
		
		barra.add(this.crearMenu1());
		
		barra.add(Box.createHorizontalGlue());
		
		barra.add(this.crearMenuSalir());
		
		return barra;
	}

	private JMenu crearMenu1() {
		JMenu menuEditar=new JMenu("Acciones");

		menuEditar.add(this.anadir);
		menuEditar.add(this.quitar);
		
		menuEditar.add(this.modificar);
		menuEditar.add(this.mover);
				
		return menuEditar;
	}

	private JMenu crearMenuSalir() {
		JMenu menuSalir=new JMenu("Volver");
		menuSalir.add(this.salir);
		return menuSalir;
	}
	
	private Container crearVentana() {	
		JPanel panelPrincipal=new JPanel(new BorderLayout());
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		panelPrincipal.add(this.panelToolbar(),BorderLayout.NORTH);
		
		JSplitPane splitPanel=new JSplitPane();
		
		splitPanel.setRightComponent(this.panelDerecho());
		splitPanel.setLeftComponent(this.setPanelIzquierdo());
		
		panelPrincipal.add(splitPanel);
		
		return panelPrincipal;
	}

	private Component panelToolbar() {
		JPanel panelToolbar=new JPanel(new GridLayout(1,1,20,50));
		panelToolbar.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JToolBar toolbar=new JToolBar();
		toolbar.add(this.anadir);
		toolbar.add(this.quitar);
		toolbar.add(this.modificar);
		toolbar.add(this.mover);

		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(salir);
		
		panelToolbar.add(toolbar);
		
		return panelToolbar;
	}

	private Component setPanelIzquierdo() {
		JPanel panel=new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.listaClaves=new JList(this.modelo);
		this.listaClaves.addListSelectionListener(this);
		this.listaClaves.setSelectedIndex(0);
		this.listaClaves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.panelScrollBar(listaClaves);
		panel.add(listaClaves);
		
		return panel;
	}
	
	private Component panelDerecho() {
		JPanel panel=new JPanel(new BorderLayout());

		modeloElementos=new DefaultListModel<Cliente>();
		
		for(Equipo actual:this.modelo.getListaEquipo()) {
			if(!actual.getListaClientes().isEmpty()) {
				modeloElementos.addAll(actual.getListaClientes());
			}
		}
	
		this.listaElementos=new JList(modeloElementos);
		this.listaElementos.addListSelectionListener(this);
		this.listaElementos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(this.panelScrollBar(listaElementos),BorderLayout.WEST);
	
		panel.add(panelContenido());
		
		this.setValueToDisplay((Cliente) modeloElementos.get(0));
		
		return panel;
	}
	
	private void setValueToDisplay(Cliente elegido) {
		this.nombreCliente.setText(elegido.getNombre_cliente());
		this.poblacionCliente.setText(elegido.getPoblacion().name());
		this.direccionCliente.setText(elegido.getDireccion());
		this.llaveCliente.setText(elegido.getLlaves());
		this.comoDejarACliente.setText(elegido.getComo_dejarlo());
		this.listaProductos.setText(elegido.leerListaProductos());

		this.tablaDias.setSelectedValuesSemana(elegido.getDias());
	}
	
	private void constraintsConfiguration(GridBagConstraints c) {
		int top = 10,left = 10, bottom = 10, right = 10;
		Insets i = new Insets(top, left, bottom, right);
				
		c.insets=i;
		c.weightx = 1; 
		c.weighty=2;
		c.fill = GridBagConstraints.HORIZONTAL;
	}
	
	private Component panelContenido() {
		JPanel panel=new JPanel(new GridBagLayout()); 
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		GridBagConstraints c = new GridBagConstraints();  
		this.constraintsConfiguration(c);

		JLabel labelImagen=new JLabel(new ImageIcon(this.imagenPruebaCliente));
		labelImagen.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 1;  
		c.gridy = 0;  
		panel.add(labelImagen, c);  
	
		nombreCliente=this.createCustomLabel("Nombre Cliente:");
		c.gridx = 0;  
		c.gridy = 2;  
		panel.add(nombreCliente, c);  
			
		poblacionCliente=this.createCustomLabel("Poblacion:");
		c.gridx = 0;  
		c.gridy = 3;  
		panel.add(poblacionCliente, c); 
			
		direccionCliente=this.createCustomLabel("Direccion: ");
		c.gridx = 0;  
		c.gridy = 4;
		c.gridwidth=3;
		panel.add(direccionCliente, c); 
					
		llaveCliente=this.createCustomLabel("Llave:");
		c.gridx = 0;  
		c.gridy = 5;  
		panel.add(llaveCliente, c); 
		 
		comoDejarACliente=this.createCustomLabel("Como dejarlo:");
		c.gridx = 0;  
		c.gridy = 6;  
		panel.add(comoDejarACliente, c); 
			
		this.listaProductos=this.createCustomLabel("Productos:");
		c.gridx = 0;  
		c.gridy = 7;
		c.gridwidth=1;
		panel.add(this.listaProductos, c); 
				
		JLabel label6=new JLabel("Dias reparto: ");  
		c.gridx = 0;  
		c.gridy = 8;  
		panel.add(label6, c); 
		
		tablaDias=new TablaSemana();
		c.gridwidth = 2;  
		c.gridx = 0;  
		c.gridy = 9;  
		panel.add(tablaDias.getPanel(), c);  
			  

		return panel;
	}

	private JLabel createCustomLabel(String string) {
		JLabel nuevo=new JLabel();
		Border titled1=BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),string);
		nuevo.setBorder(titled1);
		return nuevo;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if ( e.getValueIsAdjusting()) return;
		if (e.getSource() == this.listaClaves) {
			Equipo elegido=(Equipo) this.listaClaves.getSelectedValue();
			
			if(elegido!=null) {
				this.listaElementos.setListData(elegido.getListaClientes().toArray());
				this.repaint();
			}
			
			return;
		}
		if (e.getSource() == this.listaElementos) {
			
			Cliente elegido=(Cliente) this.listaElementos.getSelectedValue();
			
			if(elegido!=null) {
				this.setValueToDisplay(elegido);
				this.repaint();
			}
		}		
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
			case"noSeHaSeleccionadoCliente":{
				JOptionPane.showMessageDialog(this, "No se ha elegido Cliente\n Pruebe otra vez");		
				break;
			}
			case"direccionExistente":{
				JOptionPane.showMessageDialog(this,"La direccion que se a puesto ya existe \n Ponga otro que no este en uso.");
				break;
			}
			case"irAVentanaMover":{
				VentanaMover ventanaMover=new VentanaMover(this.modelo.getListaEquipo(),false);
				this.dispose();
				break;
			}
			case"Volver":{
				VentanaAdmin ventana=new VentanaAdmin();
				this.dispose();
				break;
			}
			case"refrescar":{	
				Equipo seleccionado=(Equipo) this.listaClaves.getSelectedValue();
				
				if(seleccionado!=null) {
					this.listaElementos.setListData(seleccionado.getListaClientes().toArray());
				}
				else {
					this.listaClaves.setSelectedIndex(0);
				}

				this.repaint();
				this.revalidate();
				break;
			}
		}
	}

	public JList getListaElementos() {
		return listaElementos;
	}

}
