package d_ventana_recorrido;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import z_enumeraciones.Poblacion;
import z_enumeraciones.TipoReparto;
import z_mapas_coordenadas.ConvertirDireccionACoordenadas;
import z_mapas_coordenadas.Coordenadas;
import z_modelo_equipo_repartidores.Cliente;
import z_tablas.TablaSemana;

public class DialogoRecorrido extends JDialog implements  ActionListener {

	private JComboBox<Poblacion> poblacionCliente;
	private JTextField direccionCliente;
	private JTextField llaveCliente;
	private JTextField comoDejarACliente;
	private JList listaProductos;
	private TablaSemana tablaDias;
	
	private Component panelDatos;

	private Cliente creada;
	private boolean modificado;
	private JTextField nombreCliente;
		
	public DialogoRecorrido(JFrame ventana,String titulo,boolean modo){
		super(ventana,titulo,modo);

		this.setSize(400,400);
		this.setLocation(100,100);
		this.setContentPane(this.crearVentana());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(modo);
	}
	
	public DialogoRecorrido(JFrame ventana,String titulo,boolean modo,Cliente elegido){
		super(ventana,titulo,modo);

		this.creada=elegido;
		this.modificado=false;
		
		this.setSize(400,400);
		this.setLocation(100,100);
		this.setContentPane(this.crearVentana());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(modo);
	}
	
	private Container crearVentana() {
		JPanel panel=new JPanel(new BorderLayout());
		
		panel.add(this.panelDatosClientes());
		
		if(creada!=null) {
			this.setValues();
		}
		
		panel.add(this.panelBotones(),BorderLayout.SOUTH);
		
		return panel;
	}

	private void setValues() {
		this.nombreCliente.setText(this.creada.getNombre_cliente());
		
		this.poblacionCliente.setSelectedItem(this.creada.getPoblacion());
		
		this.direccionCliente.setText(this.creada.getDireccion());
		
		this.llaveCliente.setText(this.creada.getLlaves());
		
		this.comoDejarACliente.setText(this.creada.getComo_dejarlo());
		
		for(TipoReparto actual: creada.getLista_productos()) {
			this.listaProductos.setSelectedValue(actual, false);
		}
		
		this.tablaDias.setSelectedValuesSemana(creada.getDias());
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
		panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		GridBagConstraints c = new GridBagConstraints();  
		this.constraintsConfiguration(c);

		JLabel label=new JLabel("Nombre Cliente: ");
		c.gridx = 0;  
		c.gridy = 0;  
		panel.add(label, c);  
		  
		nombreCliente=new JTextField();
		c.gridx = 1;  
		c.gridy = 0;  
		panel.add(nombreCliente, c);  
			
		JLabel label1=new JLabel("Poblacion: ");
		c.gridx = 0;  
		c.gridy = 1;  
		panel.add(label1, c);  
		
		poblacionCliente=new JComboBox(Poblacion.values()); 
		poblacionCliente.setSelectedIndex(0);
		c.gridx = 1;  
		c.gridy = 1;  
		panel.add(poblacionCliente, c); 
			
		JLabel label2=new JLabel("Direccion: ");
		c.gridx = 0;  
		c.gridy = 2;  
		panel.add(label2, c);  
		
		direccionCliente=new JTextField();
		c.gridx = 1;  
		c.gridy = 2;  
		panel.add(direccionCliente, c); 
					
		JLabel label3=new JLabel("Llave: ");
		c.gridx = 0;  
		c.gridy = 3;  
		panel.add(label3, c);  
		
		llaveCliente=new JTextField();
		c.gridx = 1;  
		c.gridy = 3;  
		panel.add(llaveCliente, c); 
		
		JLabel label4=new JLabel("Como dejarlo: ");
		c.gridx = 0;  
		c.gridy = 4;  
		panel.add(label4, c);  
		
		comoDejarACliente=new JTextField(); 
		c.gridx = 1;  
		c.gridy = 4;  
		panel.add(comoDejarACliente, c); 
			
		JLabel label5=new JLabel("Periodico/Revista: ");
		c.gridx = 0;  
		c.gridy = 5;  
		panel.add(label5, c);  
		
		this.listaProductos=new JList(TipoReparto.values());
		this.listaProductos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		c.gridx = 1;  
		c.gridy = 5;  
		panel.add(this.panelScrollBar(listaProductos), c); 
			
		JLabel label6=new JLabel("Dias reparto: ");  
		c.gridx = 0;  
		c.gridy = 6;  
		panel.add(label6, c); 
		
		tablaDias=new TablaSemana();
		c.gridwidth = 2;  
		c.gridx = 0;  
		c.gridy = 7;  
		panel.add(tablaDias.getPanel(), c);  
			   
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
		
	private Component panelBotones() {
		JPanel panel=new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
		
		JButton start=new JButton("Ok");
		start.addActionListener(this);
		start.setActionCommand("Ok");
		panel.add(start);
		
		JButton cancel=new JButton("Cancel");
		cancel.addActionListener(this);
		cancel.setActionCommand("Cancel");
		panel.add(cancel);

		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case"Ok":{
				boolean esModificacion=false;
				int idCliente=0;
				Poblacion poblacion=null;
				String diasCompletados="";
				if(creada!=null) {
					idCliente=this.creada.getId_cliente();
					diasCompletados=this.creada.getDiasCompletados();
					esModificacion=true;
				}
				
				Poblacion poblacionElegida=(Poblacion) this.poblacionCliente.getSelectedItem();
				
				List<TipoReparto> lista=this.listaProductos.getSelectedValuesList();
				
				for(TipoReparto actual:lista) {
					
					if(!actual.getDiaSemana().equals("")) {
						this.tablaDias.selectInDays(actual.getDiaSemana());
					}
					
				}
				
				ConvertirDireccionACoordenadas consulta=new ConvertirDireccionACoordenadas();
				Coordenadas puntoGPS=null;
				try {
					puntoGPS=consulta.realizarConsultaDeCoordenada(this.direccionCliente.getText(),
							Poblacion.valueOf(this.poblacionCliente.getSelectedObjects()[0].toString()).getCodigoPostal());
				} 
				catch (IOException e1) {
					e1.printStackTrace();
				} 
				catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				if(puntoGPS!=null) {
					this.creada=new Cliente(idCliente,
							poblacionElegida.getId(),
							this.nombreCliente.getText(),
							this.direccionCliente.getText(),
							this.llaveCliente.getText(),
							this.comoDejarACliente.getText(),
							"",
							this.tablaDias.getSelectedValuesText(),
							poblacionElegida.name(),
							this.listaProductos.getSelectedValuesList(),
							puntoGPS.getPosicion(),
							diasCompletados
							);
							
					if(esModificacion) {
						this.modificado=true;						
					}
					
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(this, "Direccion no valida \n Intentalo de nuevo");
				}
		    
				break;
			}
			case "Cancel":{
				this.dispose();
				break;
			}
		}
	}

	public Cliente getCreada() {
		return creada;
	}

	public boolean isModificado() {
		return modificado;
	}
	
}
