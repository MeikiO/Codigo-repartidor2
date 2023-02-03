package c_ventana_integrantes;

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
import z_modelo_equipo_repartidores.Equipo;
import z_modelo_equipo_repartidores.Repartidor;
import z_tablas.TablaRegistros;

public class VentanaIntegrantes extends JFrame implements ListSelectionListener, PropertyChangeListener   {

	private ModeloIntegrantes modelo;
	private JList listaElementos;
	private JList listaClaves;
	private DefaultListModel<Repartidor> modeloElementos;
	
	private ControladorIntegrantes salir;
	private ControladorIntegrantes anadir;
	private ControladorIntegrantes quitar;
	private ControladorIntegrantes modificar;
	private ControladorIntegrantes mover;
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelDni;
	private JLabel labelDireccion;
	private JLabel labelTelefono;
	private JLabel labelZona;
	private JLabel labelUser;
	private JLabel labelPassword;
	private TablaRegistros tablaRegistro;
	
	private static String imagenPrueba="resources/images/userIcon.png";
	
	public VentanaIntegrantes(List<Equipo> lista) {
		super("Ventana Integrantes");
		MyLookAndFeel look=new MyLookAndFeel(this);
		
		this.modelo=new ModeloIntegrantes(lista);
		this.modelo.addPropertyChangeListener(this);

		this.setBounds(200, 200, 900, 650);
		
		this.crearAcciones();
		
		this.setJMenuBar(this.crearBarraMenu());
		
		this.setContentPane(this.crearVentana());

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearAcciones() {
		anadir = new ControladorIntegrantes ("Anadir", new ImageIcon("resources/icons/edit_add.png"), "Anadir", KeyEvent.VK_O,this,this.modelo);
		
		quitar = new ControladorIntegrantes ("Quitar", new ImageIcon("resources/icons/edit_remove.png"), "Quitar", KeyEvent.VK_O,this,this.modelo);
		
		modificar=new ControladorIntegrantes ("Modificar",new ImageIcon("resources/icons/edit.png"), "Modificar", KeyEvent.VK_O,this,this.modelo);
		
		mover=new ControladorIntegrantes ("Mover",new ImageIcon("resources/icons/enumList.png"), "Mover", KeyEvent.VK_O,this,this.modelo);
				
		salir= new ControladorIntegrantes ("Volver", new ImageIcon("resources/icons/exit.png"),"Volver", KeyEvent.VK_C,this,this.modelo);
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

		modeloElementos=new DefaultListModel<Repartidor>();
		
		for(Equipo actual:this.modelo.getListaEquipo()) {
			if(!actual.getListaRepartidores().isEmpty()) {
				modeloElementos.addAll(actual.getListaRepartidores());
			}
		}
	
		this.listaElementos=new JList(modeloElementos);
		this.listaElementos.addListSelectionListener(this);
		this.listaElementos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel.add(this.panelScrollBar(listaElementos),BorderLayout.WEST);
	
		panel.add(panelContenido());
		
		this.setValueToDisplay((Repartidor) modeloElementos.get(0));
		
		return panel;
	}
	
	private void setValueToDisplay(Repartidor repartidor) {
		labelNombre.setText(repartidor.getNombre());
	
		labelApellido.setText(repartidor.getApellido());
	
		labelDni.setText(repartidor.getDni());
	
		labelDireccion.setText(repartidor.getDireccion());
	
		labelTelefono.setText(repartidor.getTlf());
	
		labelZona.setText(repartidor.getZona_trabajo().name());
	
		labelUser.setText(repartidor.getUsername());

		labelPassword.setText(repartidor.getPassword());

		tablaRegistro.getTable().setModel(tablaRegistro.setNewValuesInTable(repartidor.getListaReparto()));		
	}
	
	private void constraintsConfiguration(GridBagConstraints c) {
		int top = 5,left = 10, bottom = 5, right = 10;
		Insets i = new Insets(top, left, bottom, right);
				
		c.insets=i;
		c.weightx = 1; 
		c.weighty=2;
		c.fill = GridBagConstraints.HORIZONTAL;
	}
	
	private Component panelContenido() {

		JPanel panel=new JPanel(new GridBagLayout()); 
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		GridBagConstraints c = new GridBagConstraints();  
		this.constraintsConfiguration(c);
	
		JLabel labelImagen=new JLabel(new ImageIcon(this.imagenPrueba));
		labelImagen.setHorizontalAlignment(JLabel.CENTER);
		c.gridx = 1;  
		c.gridy = 0;  
		panel.add(labelImagen, c);  
		
		labelDni=this.createCustomLabel("DNI");
		c.gridx = 0;  
		c.gridy = 1;
		panel.add(labelDni, c);  

		labelNombre=this.createCustomLabel("Nombre");
		c.gridx = 1;  
		c.gridy = 1;  
		panel.add(labelNombre, c);  
		
		labelApellido=this.createCustomLabel("Apellido");
		c.gridx = 2;  
		c.gridy = 1; 
		panel.add(labelApellido, c);  
		
		labelDireccion=this.createCustomLabel("Direccion");
		c.gridx = 0;  
		c.gridy = 2;
		c.gridwidth=3;
		panel.add(labelDireccion, c);  
			
		labelTelefono=this.createCustomLabel("Telefono");
		c.gridx = 0;  
		c.gridy = 3;  
		c.gridwidth=1;
		panel.add(labelTelefono, c);  
		
		labelZona=this.createCustomLabel("Zona Trabajo");
		c.gridx = 1;  
		c.gridy = 3;  
		panel.add(labelZona, c);  
		
		labelUser=this.createCustomLabel("Username");
		c.gridx = 0;  
		c.gridy = 4;  
		panel.add(labelUser, c);
		
		labelPassword=this.createCustomLabel("Password");
		c.gridx = 1;  
		c.gridy = 4;  
		panel.add(labelPassword, c);
		
		JLabel labelRepartosRealizados=new JLabel("Repartos Realizados:");
		c.gridx = 0;  
		c.gridy = 5;  
		panel.add(labelRepartosRealizados, c);
		
		JPanel panelTabla=new JPanel(new BorderLayout());
		
		Repartidor inicializar=(Repartidor) modeloElementos.get(0);
		tablaRegistro=new TablaRegistros(inicializar.getListaReparto());
		panelTabla.add(tablaRegistro.devolverComponente());
		c.gridx = 0;  
		c.gridy = 6;
		c.gridwidth=3;
		panel.add(panelTabla, c);
		
		return panel;
	}

	private JLabel createCustomLabel(String string) {
		JLabel nuevo=new JLabel("");
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
				this.listaElementos.setListData(elegido.getListaRepartidores().toArray());
			}
			
			return;
		}
		if (e.getSource() == this.listaElementos) {
			Repartidor elegido=(Repartidor) this.listaElementos.getSelectedValue();
			
			if(elegido!=null) {
				this.setValueToDisplay(elegido);
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
			case"noSeHaSeleccionadoRepartidor":{
				JOptionPane.showMessageDialog(this, "No se ha elegido repartidor\n Pruebe otra vez");		
				break;
			}
			case"usuarioExistente":{
				JOptionPane.showMessageDialog(this,"El nombre de usuario ya existe \n Ponga otro que no este en uso.");
				break;
			}
			case"irAVentanaMover":{
				VentanaMover ventanaMover=new VentanaMover(this.modelo.getListaEquipo(),true);
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
					this.listaElementos.setListData(seleccionado.getListaRepartidores().toArray());
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
