package b_ventanas_admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import a_login_y_register.VentanaLogin;
import c_ventana_integrantes.VentanaIntegrantes;
import d_ventana_recorrido.VentanaRecorrido;
import z_enumeraciones.DiasSemana;
import z_look_and_field.MyLookAndFeel;
import z_mapas.GestorMapa;
import z_modelo_equipo_repartidores.Equipo;

public class VentanaAdmin extends JFrame implements ListSelectionListener, PropertyChangeListener   {

	private ModeloAdmin modelo;
	private JList listaEquipos;

	private ControladorAdmin salir;
	private ControladorAdmin integrantes;
	private ControladorAdmin recorrido;
	private ControladorAdmin chat;
	private GestorMapa mapa;
	private JSplitPane splitPanel;
	
	public VentanaAdmin() {
		super("Ventana Admin");
		MyLookAndFeel look=new MyLookAndFeel(this);
		
		this.modelo=new ModeloAdmin();
		this.modelo.addPropertyChangeListener(this);

		this.setBounds(200, 200, 1100, 625);
		
		this.crearAcciones();
		
		this.setJMenuBar(this.crearBarraMenu());
		
		this.setContentPane(this.crearVentana());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearAcciones() {
		integrantes = new ControladorAdmin ("Integrantes", new ImageIcon("resources/icons/integrantesEquipo.png"), "Integrantes", KeyEvent.VK_O,this,this.modelo);
		
		recorrido = new ControladorAdmin ("Recorrido", new ImageIcon("resources/icons/recorrido_icon.png"), "Recorrido", KeyEvent.VK_O,this,this.modelo);
		
		salir= new ControladorAdmin ("Log-Out", new ImageIcon("resources/icons/exit.png"),"Log-Out", KeyEvent.VK_C,this,this.modelo);		
	}
	
	private JMenuBar crearBarraMenu() {
		JMenuBar barra=new JMenuBar();
		
		barra.add(this.crearMenu1());
		
		barra.add(Box.createHorizontalGlue());
		
		barra.add(this.crearMenuSalir());
		
		return barra;
	}

	private JMenu crearMenu1() {
		JMenu menuEditar=new JMenu("Ventanas");

		menuEditar.add(this.integrantes);
		menuEditar.add(this.recorrido);
		menuEditar.add(this.chat );
		
		return menuEditar;
	}

	private JMenu crearMenuSalir() {
		JMenu menuSalir=new JMenu("Log-Out");
		menuSalir.add(this.salir);
		return menuSalir;
	}
	
	private Container crearVentana() {	
		JPanel panelPrincipal=new JPanel(new BorderLayout());
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		panelPrincipal.add(this.panelToolbar(),BorderLayout.NORTH);
		
		splitPanel=new JSplitPane();
		
		splitPanel.setRightComponent(this.panelDerecho());

		if(!this.modelo.getListaAEnsenar().isEmpty()) {
			splitPanel.setLeftComponent(this.setPanelIzquierdo(this.modelo.getElementAt(0)));
		}
		else {
			splitPanel.setLeftComponent(this.setPanelIzquierdo(new Equipo()));
		}
	
		panelPrincipal.add(splitPanel);
		
		return panelPrincipal;
	}

	private Component panelToolbar() {
		JPanel panelToolbar=new JPanel(new GridLayout(1,1,20,50));
		panelToolbar.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JToolBar toolbar=new JToolBar();
		toolbar.add(this.integrantes);
		toolbar.add(this.recorrido);
		
		toolbar.addSeparator();
		
		toolbar.add(Box.createHorizontalGlue());
		toolbar.add(salir);
		
		panelToolbar.add(toolbar);
		
		return panelToolbar;
	}

	private Component setPanelIzquierdo(Equipo equipo) {
		JPanel panel=new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		mapa=new GestorMapa(equipo.getListaClientes(),this.modelo.getAdmin(),DiasSemana.diaActual().abreviacion);
		
		if(!equipo.getListaClientes().isEmpty()) {
			panel.add(mapa.devolverMapa());
		}
		else {
			panel.add(mapa.visualizarNoHayDatos());
		}
		
		splitPanel.setDividerLocation(850);
	
		return panel;
	}
	
	private Component panelDerecho() {
		JPanel panel=new JPanel(new GridLayout(1,1));
		
		this.listaEquipos=new JList(this.modelo);
		this.listaEquipos.setListData(this.modelo.getListaAEnsenar().toArray());
		this.listaEquipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.listaEquipos.addListSelectionListener(this);
		panel.add(this.panelScrollBar(listaEquipos));
	
		this.repaint();
		
		return panel;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {	
		if ( e.getValueIsAdjusting()) return;
		if (e.getSource() == this.listaEquipos) {
			Equipo elegido=(Equipo) this.listaEquipos.getSelectedValue();	
			this.splitPanel.setLeftComponent(this.setPanelIzquierdo(elegido));
			this.repaint();
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
			case"CambioIntegrantes":{
				if(this.modelo.getListaAEnsenar().isEmpty() || this.modelo.checkListaRepartidores()) {
					JOptionPane.showMessageDialog(this, "No hay datos para enseñar\nRegistre algun usuario para avanzar");
				}
				else {
					VentanaIntegrantes integrantes=new VentanaIntegrantes(this.modelo.getListaAEnsenar());
					this.dispose();
				}
				
				break;
			}
			case"CambioRecorrido":{
				if(this.modelo.getListaAEnsenar().isEmpty() || this.modelo.checkListaClientes()) {
					JOptionPane.showMessageDialog(this, "No hay datos para enseñar\nRegistre algun usuario para avanzar");
				}
				else {
					VentanaRecorrido recorrido=new VentanaRecorrido(this.modelo.getListaAEnsenar());
					this.dispose();
				}
			
				break;
			}
			case"Volver":{
				VentanaLogin login=new VentanaLogin();
				this.dispose();
				break;
			}
		}
	}
	
	public JList getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(JList listaEquipos) {
		this.listaEquipos = listaEquipos;
	}
	
	public static void main(String[] args) {	
		VentanaAdmin programa=new VentanaAdmin();
	}

}
