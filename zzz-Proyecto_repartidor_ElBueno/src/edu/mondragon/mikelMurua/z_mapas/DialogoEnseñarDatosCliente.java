package z_mapas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import z_base_de_datos_dao.ConsultasClientes;
import z_base_de_datos_dao.ConsultasRegistros;
import z_modelo_equipo_repartidores.Cliente;
import z_tablas.TablaSemana;

public class DialogoEnseñarDatosCliente extends JDialog implements WindowListener, ItemListener {

	private JTextArea notas;
	
	private Cliente clienteElegido;

	private JCheckBox completado;
	
	private String notaInicial;

	public DialogoEnseñarDatosCliente(Cliente cliente){
		this.addWindowListener(this);
		
		this.setTitle("Cliente: "+cliente.toString());
		
		this.clienteElegido=cliente;
		
		this.notaInicial=this.clienteElegido.getNotas();
		
		this.setSize(400,500);
		this.setLocation(100,100);
		this.setContentPane(this.crearVentana());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);	
	}

	private Container crearVentana() {
		JPanel panel=new JPanel(new BorderLayout());
	
		panel.add(this.panelDatosClientes(),BorderLayout.CENTER);
	
		return panel;
	}

	private void constraintsConfiguration(GridBagConstraints c) {
		int top = 0,left = 0, bottom = 10, right = 0;
		Insets i = new Insets(top, left, bottom, right);
				
		c.insets=i;
		c.weightx = 0.5; 
		c.weighty=2;
		c.fill = GridBagConstraints.HORIZONTAL;
	}

	private Component panelDatosClientes() {
		JPanel panel=new JPanel(new GridBagLayout()); 
		panel.setBorder(this.setCustomBorder(""));
		
		GridBagConstraints c = new GridBagConstraints();  
		this.constraintsConfiguration(c);
	
		
		completado=new JCheckBox("Completado");
		this.completado.addItemListener(this);
		c.gridx = 1;  
		c.gridy = 0; 
		
		if(!this.clienteElegido.getRepartidorResponsable().isAdmin()) {	
			panel.add(completado, c); 
		} 
		
		JLabel label=new JLabel("Nombre Cliente: ");
		c.gridx = 0;  
		c.gridy = 1;  
		panel.add(label, c);  
		  
		JLabel nombreCliente = new JLabel(this.clienteElegido.getNombre_cliente());
		c.gridx = 1;  
		c.gridy = 1;  
		panel.add(nombreCliente, c);  
			
		JLabel label1=new JLabel("Poblacion: ");
		c.gridx = 0;  
		c.gridy = 2;  
		panel.add(label1, c);  
		
		JLabel poblacionCliente = new JLabel(this.clienteElegido.getPoblacion().name()); 
		c.gridx = 1;  
		c.gridy = 2;  
		panel.add(poblacionCliente, c); 
			
		JLabel label2=new JLabel("Direccion: ");
		c.gridx = 0;  
		c.gridy = 3;  
		panel.add(label2, c);  
		
		JLabel direccionCliente = new JLabel(this.clienteElegido.getDireccion());
		c.gridx = 1;  
		c.gridy = 3;  
		panel.add(direccionCliente, c); 
					
		JLabel label3=new JLabel("Llave: ");
		c.gridx = 0;  
		c.gridy = 4;  
		panel.add(label3, c);  
		
		JLabel llaveCliente = new JLabel(this.clienteElegido.getLlaves());
		c.gridx = 1;  
		c.gridy = 4;  
		panel.add(llaveCliente, c); 
		
		JLabel label4=new JLabel("Como dejarlo: ");
		c.gridx = 0;  
		c.gridy = 5;  
		panel.add(label4, c);  
		
		JLabel comoDejarACliente = new JLabel(this.clienteElegido.getComo_dejarlo()); 
		c.gridx = 1;  
		c.gridy = 5;  
		panel.add(comoDejarACliente, c); 
			
		JLabel label5=new JLabel("Periodico/Revista: ");
		c.gridx = 0;  
		c.gridy = 6;  
		panel.add(label5, c);  
		
		JLabel listaProductos = new JLabel(this.clienteElegido.leerListaProductos());
		c.gridx = 1;  
		c.gridy = 6;  
		panel.add(listaProductos, c); 
				
		JLabel label6=new JLabel("Dias reparto: ");  
		c.gridx = 0;  
		c.gridy = 7;  
		panel.add(label6, c); 
		
		TablaSemana tablaDias = new TablaSemana();
		tablaDias.setSelectedValuesSemana(this.clienteElegido.getDias());
		c.gridwidth = 2;  
		c.gridx = 0;  
		c.gridy = 8;  
		panel.add(tablaDias.getPanel(), c);  
			  
		JLabel label7=new JLabel("Notas: ");  
		c.gridx = 0;  
		c.gridy = 9;  
		panel.add(label7, c); 
		
		this.notas = new  JTextArea (this.clienteElegido.getNotas());
		c.gridwidth = 2;  
		c.gridheight=2;
		c.gridx = 0;  
		c.gridy = 10;  
		panel.add(this.notas, c);  
	
		return panel;
	}

	private Border setCustomBorder(String string) {
		TitledBorder titledBorder=BorderFactory.createTitledBorder(
		BorderFactory.createLineBorder(Color.BLACK), string);
		Border empty=BorderFactory.createEmptyBorder(10,10,10,10);
		
		CompoundBorder border = BorderFactory.createCompoundBorder(titledBorder, empty);
		
		return border;
	}
		
	@Override
	public void windowClosing(WindowEvent e) {
		this.clienteElegido.setNotas(this.notas.getText());

		if(this.completado.isSelected()) {
			ConsultasRegistros repartidor=new ConsultasRegistros();
			repartidor.registrarRepartoRealizado(clienteElegido);
			
			StringBuilder cadena=new StringBuilder(this.clienteElegido.getDiasCompletados());
			cadena.append(this.clienteElegido.getSeparador());
			cadena.append(this.clienteElegido.getDiaActual().abreviacion);
			this.clienteElegido.setDiasCompletados(cadena.toString());
			
			ConsultasClientes cliente=new ConsultasClientes();
			cliente.actualizar(this.clienteElegido);
			
			this.clienteElegido.getButton().setBackground(Color.green);
			
		}
		if(!this.notaInicial.equals(this.clienteElegido.getNotas())) {
			ConsultasClientes cliente=new ConsultasClientes();
			cliente.actualizarNotas(this.clienteElegido);
		}
		
		this.dispose();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}


	@Override
	public void windowClosed(WindowEvent e) {
	}


	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}
		
}
