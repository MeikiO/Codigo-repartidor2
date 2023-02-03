package f_ventana_repartidor_una_vez_logeado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import a_login_y_register.VentanaLogin;
import z_enumeraciones.DiasSemana;
import z_look_and_field.MyLookAndFeel;
import z_mapas.GestorMapa;
import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.Repartidor;

public class VentanaRepartidor extends JFrame implements ListSelectionListener, PropertyChangeListener, ItemListener   {

	private ModeloRepartidor modelo;
	
	private ControladorRepartidor salir;

	private GestorMapa mapa;
	private JSplitPane splitPanel;
	
	private Repartidor usuarioRepatidor;
	private JList listaClientesRecorrido;
	private JComboBox diasSemana;
	
	public static DiasSemana diaActual=DiasSemana.diaActual();

	public VentanaRepartidor(Repartidor cond) {
		
		super("Ventana Repartidor: "+cond.toString());
		MyLookAndFeel look=new MyLookAndFeel(this);
		
		this.usuarioRepatidor=cond;
		
		this.modelo=new ModeloRepartidor(cond);
		this.modelo.addPropertyChangeListener(this);

		this.setBounds(200, 200, 1100, 625);
		
		this.crearAcciones();
		
		this.setJMenuBar(this.crearBarraMenu());
		
		this.setContentPane(this.crearVentana());
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearAcciones() {	
		salir= new ControladorRepartidor ("Log-Out", new ImageIcon("resources/icons/exit.png"),"Log-Out", KeyEvent.VK_C,this,this.modelo);
	}
	
	private JMenuBar crearBarraMenu() {
		JMenuBar barra=new JMenuBar();

		barra.add(Box.createHorizontalGlue());
		
		barra.add(this.crearMenuSalir());
		
		return barra;
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
	
		splitPanel.setRightComponent(this.panelDerecho(diaActual.name()));
		
		splitPanel.setLeftComponent(this.setPanelIzquierdo(this.modelo.getMapDias().get(diaActual.name()),diaActual.abreviacion));
		
		panelPrincipal.add(splitPanel);
		
		return panelPrincipal;
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

	private Component setPanelIzquierdo(Set<Cliente> elementosAEnsenar,String diaSemana) {
		JPanel panel=new JPanel(new BorderLayout());
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		mapa=new GestorMapa(elementosAEnsenar,this.usuarioRepatidor,diaSemana);
		
		if(!elementosAEnsenar.isEmpty()) {
			panel.add(mapa.devolverMapa());
		}
		else {
			panel.add(mapa.visualizarNoHayDatos());
		}

		splitPanel.setDividerLocation(850);
	
		return panel;
	}
	
	private Component panelDerecho(String diaActual) {
		JPanel panel=new JPanel(new BorderLayout(10,10));
		
		diasSemana=new JComboBox<>(this.modelo.getMapDias().keySet().toArray());
		diasSemana.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Dia de la semana:"));
		diasSemana.setSelectedItem(diaActual);
			
		diasSemana.addItemListener(this);
		panel.add(diasSemana,BorderLayout.NORTH);

		listaClientesRecorrido=new JList<>();
		listaClientesRecorrido.setListData(this.modelo.getMapDias().get(diaActual).toArray());
		listaClientesRecorrido.addListSelectionListener(this);
		listaClientesRecorrido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaClientesRecorrido.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"Clientes Recorrido:"));
		panel.add(this.panelScrollBar(listaClientesRecorrido),BorderLayout.CENTER);

		return panel;
	}
		
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==this.diasSemana) {
			DiasSemana dia=DiasSemana.getDiaNombreEntero(this.diasSemana.getSelectedItem().toString());
					
			splitPanel.setLeftComponent(this.setPanelIzquierdo(this.modelo.getMapDias().get(dia.name()),dia.getAbreviacion()));
			
			listaClientesRecorrido.setListData(this.modelo.getMapDias().get(dia.name()).toArray());
		}
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if ( e.getValueIsAdjusting()) return;
		
		if (e.getSource() == this.listaClientesRecorrido) {		
			Cliente elegido=(Cliente) this.listaClientesRecorrido.getSelectedValue();
			
			this.mapa.setPositionCliente(elegido);
			
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
			case"Volver":{
				this.dispose();
				VentanaLogin login=new VentanaLogin();
				break;
			}
		}
	}
	
}
