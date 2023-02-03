package mapas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import componentes_interfaz.TablaSemana;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Vpunto2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private SwingWaypoint punto;
	private SwingWaypointMouseListener controler;
	private JTextPane textPane_1;
	
	
	public Vpunto2(SwingWaypoint point, SwingWaypointMouseListener controler) {
		// TODO Auto-generated constructor stub

	this.punto=point;
	this.controler=controler;
	
	this.dibujarVentana();
	
	}

	
	public void dibujarVentana() {
		this.getContentPanel().setLayout(new BorderLayout(0, 0));
		VisualizacionPunto visual=new VisualizacionPunto(punto, false);
				
		setBounds(40, 100, 550, 500);
		getContentPane().setLayout(new BorderLayout());
		this.getContentPanel().setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER); //no tocar el getter no funciona
		{
			JScrollPane scrollPane = new JScrollPane();
			this.getContentPanel().add(scrollPane, BorderLayout.CENTER);
		}
		{
			JPanel panel = new JPanel();
			this.getContentPanel().add(panel, BorderLayout.CENTER);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
			{
				JLabel label3 = new JLabel("Notas");
				label3.setVerticalAlignment(SwingConstants.TOP);
				label3.setHorizontalAlignment(SwingConstants.LEFT);
				label3.setAlignmentY(0.0f);
				panel.add(label3);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(30);
				panel.add(horizontalStrut);
			}
			{
				JTextPane textPane_1 = new JTextPane();
				textPane_1.setText((String) null);
				panel.add(textPane_1);
			}
		}
		{
			JPanel Centro = new JPanel();
			this.getContentPanel().add(Centro, BorderLayout.CENTER);
			Centro.setLayout(new GridLayout(0, 1, 5, 5));
			{
				JPanel panel = new JPanel();
				Centro.add(panel);
				panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
				{
					JLabel label1 = new JLabel("name");
					label1.setHorizontalAlignment(SwingConstants.LEFT);
					panel.add(label1);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					panel.add(horizontalStrut);
				}
				{
					JTextPane textPane_1 = new JTextPane();
					textPane_1.setText(this.getPunto().getName());
					textPane_1.setEditable(false);
					panel.add(textPane_1);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setHgap(20);
				flowLayout.setAlignment(FlowLayout.LEFT);
				Centro.add(panel);
				{
					JLabel label2 = new JLabel("Direction");
					panel.add(label2);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					panel.add(horizontalStrut);
				}
				{
					JTextPane textPane_1 = new JTextPane();
					textPane_1.setText(this.getPunto().getDirection());
					textPane_1.setEditable(false);
					panel.add(textPane_1);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setHgap(20);
				flowLayout.setAlignment(FlowLayout.LEFT);
				Centro.add(panel);
				{
					JLabel nombre_cliente = new JLabel("Nombre cliente");
					panel.add(nombre_cliente);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					panel.add(horizontalStrut);
				}
				{
					JTextPane direccion = new JTextPane();
					direccion.setEditable(false);
					direccion.setText(this.getPunto().getNombre_cliente());
					
					panel.add(direccion);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setHgap(20);
				Centro.add(panel);
				{
					JLabel llaves = new JLabel("llaves");
					panel.add(llaves);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					panel.add(horizontalStrut);
				}
				{
					JTextPane direccion = new JTextPane();
					direccion.setText(this.getPunto().getLlaves());
					direccion.setEditable(false);
					panel.add(direccion);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setHgap(20);
				flowLayout.setAlignment(FlowLayout.LEFT);
				Centro.add(panel);
				{
					JLabel como_dejarlo = new JLabel("Como dejarlo");
					panel.add(como_dejarlo);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					panel.add(horizontalStrut);
				}
				{
					JTextPane direccion = new JTextPane();
					direccion.setText(this.getPunto().getComo_dejarlo());
					direccion.setEditable(false);
					panel.add(direccion);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setHgap(20);
				Centro.add(panel);
				{
					JLabel poblacion = new JLabel("Poblacion");
					panel.add(poblacion);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					panel.add(horizontalStrut);
				}
				{
					JTextPane direccion = new JTextPane();
					
					if(this.getPunto().getPoblacion()!=null) {
						direccion.setText(this.getPunto().getPoblacion().getNombre());
					}
					
					direccion.setEditable(false);
					panel.add(direccion);
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				flowLayout.setHgap(20);
				Centro.add(panel);
				{
					JLabel tipo = new JLabel("Tipo");
					panel.add(tipo);
				}
				{
					Component horizontalStrut = Box.createHorizontalStrut(30);
					panel.add(horizontalStrut);
				}
				{
					JTextPane direccion = new JTextPane();
					
					if(this.getPunto().getTipo()!=null) {
						direccion.setText(this.getPunto().getTipo().getNombre());
					}
					
					direccion.setEditable(false);
					panel.add(direccion);
				}
			}
			{
				JPanel tabla = new JPanel();
				Centro.add(tabla);
				tabla.setLayout(new BorderLayout(20, 0));
				
				TablaSemana tablas=new TablaSemana();
				tabla.add(tablas.getPanel());
				tablas.setSelectedValuesSemana(this.getPunto().getDias());
				
				
			}
			{
				JPanel arriba = new JPanel();
				Centro.add(arriba);
				arriba.setLayout(new BorderLayout(20, 0));
				{
					JLabel label3 = new JLabel("Notas");
					label3.setVerticalAlignment(SwingConstants.TOP);
					label3.setHorizontalAlignment(SwingConstants.LEFT);
					label3.setAlignmentY(0.0f);
					arriba.add(label3, BorderLayout.NORTH);
				}
				{
					textPane_1 = new JTextPane();
					textPane_1.setText(this.getPunto().getNotes());
					arriba.add(textPane_1, BorderLayout.CENTER);
				}
			}
		}
		{
			JPanel arriba = new JPanel();
			this.getContentPanel().add(arriba, BorderLayout.NORTH);
			arriba.setLayout(new GridLayout(0, 3, 0, 0));
			{
				JButton btnNewButton = new JButton("<-");
				btnNewButton.setBackground(Color.LIGHT_GRAY);
				btnNewButton.addActionListener(controler);
				btnNewButton.setActionCommand("eliminarCuadro");
				arriba.add(btnNewButton);
			}
			{
				Box horizontalBox = Box.createHorizontalBox();
				arriba.add(horizontalBox);
			}
			{
				JLabel volver = new JLabel("Tarea#");
				arriba.add(volver);
			}
		}
		

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}


	public JTextPane getTextPane_1() {
		return textPane_1;
	}


	public void setTextPane_1(JTextPane textPane_1) {
		this.textPane_1 = textPane_1;
	}


	public SwingWaypoint getPunto() {
		return punto;
	}


	public void setPunto(SwingWaypoint punto) {
		this.punto = punto;
	}


	public SwingWaypointMouseListener getControler() {
		return controler;
	}


	public void setControler(SwingWaypointMouseListener controler) {
		this.controler = controler;
	}


	public JPanel getContentPanel() {
		return contentPanel;
	}


}
