package mapas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import componentes_interfaz.TablaSemana;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class VisualizacionPunto extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public TablaSemana tabla;
	JPanel contenido;
	public boolean condition;
	public Sample4 sample;
	
	
	public VisualizacionPunto(SwingWaypoint punto,Boolean condition) {
		
		this.condition=condition;
	
		setLayout(new BorderLayout(0, 0));
		
		contenido = new JPanel();
		this.getContenido().setLayout(new GridLayout(8, 1, 20, 5));
		
		this.getContenido().add(this.panelParametro("nombre: ",punto.getNombre()), BorderLayout.CENTER);
		this.getContenido().add(this.panelParametro("Poblacion: ",punto.getPoblacion().getNombre()), BorderLayout.CENTER);
		this.getContenido().add(this.panelParametro("Direccion ",punto.getDireccion()), BorderLayout.CENTER);
		this.getContenido().add(this.panelParametro("Nombre cliente: ",punto.getNombre_cliente()), BorderLayout.CENTER);
		this.getContenido().add(this.panelParametro("Llaves: ",punto.getLlaves()), BorderLayout.CENTER);
		this.getContenido().add(this.panelParametro("Como dejarlo: ",punto.getComo_dejarlo()), BorderLayout.CENTER);

		this.getContenido().add(this.panelNotas(punto.getNotas()), BorderLayout.CENTER);
		
	
		tabla=new TablaSemana();
		this.getTabla().setSelectedValuesSemana(punto.getDias());
		
		JPanel panelTabla=new JPanel();
		panelTabla.add(this.getTabla().getPanel());
		panelTabla.setBorder(new TitledBorder(null, "Dias semana", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		this.getContenido().add(panelTabla, BorderLayout.CENTER);
		
		
		/* para poner el mapa correspondiente
		Set<SwingWaypoint> lista=new HashSet<SwingWaypoint>();
		lista.add(punto);

		sample=new Sample4();
		this.getContenido().add(sample.devolverMapa(lista));
	*/
		
		this.add(this.getContenido(), BorderLayout.CENTER);
			

	}



	private Component panelParametro(String string, String string2) {
		// TODO Auto-generated method stub

		JPanel panel = new JPanel();
		panel.setBounds(10,10, 200, 20);
		
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		JLabel lblNewLabel = new JLabel(string);
		panel.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(this.isCondition());
		
		textPane.setText(string2);
		
		panel.add(textPane);
		
		return panel;
	}
	
	
	private Component panelNotas(String notas) {
		// TODO Auto-generated method stub
		JPanel panelNotas = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelNotas.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panelNotas.setBorder(new TitledBorder(null, "Notas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText(notas);
		textPane_1.setEditable(this.isCondition());
		
		panelNotas.add(textPane_1);
		
		return panelNotas;
	}



	public TablaSemana getTabla() {
		return tabla;
	}



	public void setTabla(TablaSemana tabla) {
		this.tabla = tabla;
	}



	public JPanel getContenido() {
		return contenido;
	}



	public void setContenido(JPanel contenido) {
		this.contenido = contenido;
	}



	public boolean isCondition() {
		return condition;
	}



	public void setCondition(boolean condition) {
		this.condition = condition;
	}



	public Sample4 getSample() {
		return sample;
	}



	public void setSample(Sample4 sample) {
		this.sample = sample;
	}

}
