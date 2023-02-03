package z_tablas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

import z_enumeraciones.DiasSemana;

public class TablaSemana  {

	DefaultTableModel dm ;
	public JPanel panel;
	
	private final static int width=50;
	
	private final static String lunes=DiasSemana.Lunes.getAbreviacion();
	private final static String martes=DiasSemana.Martes.getAbreviacion();
	private final static String miercoles=DiasSemana.Miercoles.getAbreviacion();
	private final static String jueves=DiasSemana.Jueves.getAbreviacion();
	private final static String viernes=DiasSemana.Viernes.getAbreviacion();
	private final static String sabado=DiasSemana.Sabado.getAbreviacion();
	private final static String domingo=DiasSemana.Domingo.getAbreviacion();
	
	private final static String separador=":";
	
	public TablaSemana() {  
	    UIDefaults ui = UIManager.getLookAndFeel().getDefaults();
	    UIManager.put("RadioButton.focus", ui.getColor("control"));
	    
	    dm = new DefaultTableModel();
	    this.getDm().setDataVector(new Object[][] { 
	    	{new JRadioButton(lunes), new JRadioButton(martes), new JRadioButton(miercoles),
	        	new JRadioButton(jueves), new JRadioButton(viernes), new JRadioButton(sabado),
	        	new JRadioButton(domingo)} }, 
	    	new Object[] {
	        lunes, martes,miercoles,jueves,viernes,sabado,domingo });
	
	    JTable table = new JTable(dm) {
	      public void tableChanged(TableModelEvent e) {
	        super.tableChanged(e);
	        repaint();
	      }
	    };
	    
	    this.setCustomRenderer(lunes,table);
	    this.setCustomRenderer(martes,table);
	    this.setCustomRenderer(miercoles,table);
	    this.setCustomRenderer(jueves,table);
	    this.setCustomRenderer(viernes,table);
	    this.setCustomRenderer(sabado,table);
	    this.setCustomRenderer(domingo,table);
	        
	    this.panel=new JPanel();
	    panel.add(table);
   }
	
	private void setCustomRenderer(String string, JTable table) {
		table.getColumn(string).setCellRenderer(new RadioButtonRenderer());
		table.getColumn(string).setCellEditor(new RadioButtonEditor(new JCheckBox()));
		table.getColumn(string).setPreferredWidth(width);
	}

	public void setSelectedValuesSemana(String string) {	
		this.deselectAll();
		
		String[] dias=string.split(this.separador);
		
		 for(int i=0;i<dias.length;i++) {
			 this.selectInDays(dias[i]);
		 }	  
	}
	
	private void deselectAll() {
		for(int i=0;i<7;i++) {
			((JRadioButton) this.getDm().getValueAt(0, i)).setSelected(false);
		}
	}

	public void selectInDays(String string) {	
		DiasSemana diaSeleccionado=DiasSemana.getDiaDeAbreviacion(string);
		
		switch(diaSeleccionado) {
			case Lunes:{
				((JRadioButton) this.getDm().getValueAt(0, 0)).setSelected(true);
				break;
			}
			case Martes:{
				((JRadioButton) this.getDm().getValueAt(0, 1)).setSelected(true);
				break;
			}
			case Miercoles:{
				((JRadioButton) this.getDm().getValueAt(0, 2)).setSelected(true);
				break;
			}
			case Jueves:{
				((JRadioButton) this.getDm().getValueAt(0, 3)).setSelected(true);
				break;
			}
			case Viernes:{
				((JRadioButton) this.getDm().getValueAt(0, 4)).setSelected(true);
				break;
			}
			case Sabado:{
				((JRadioButton) this.getDm().getValueAt(0, 5)).setSelected(true);
				break;
			}	
			case Domingo:{
				((JRadioButton) this.getDm().getValueAt(0, 6)).setSelected(true);	
				break;
			}
		}
	}
	
	public String getSelectedValuesText() {			
		StringBuilder cadena=new StringBuilder("");
		for(int i=0;i<7;i++) {
			JRadioButton botonActual=((JRadioButton) this.getDm().getValueAt(0, i));
			if(botonActual.isSelected()) {
				cadena.append(botonActual.getText());
				cadena.append(this.separador);
			}
		}
		
		if(!cadena.isEmpty()) {
			cadena.replace(cadena.length()-1,cadena.length(), "");
		}
		
		return cadena.toString();
	}
	
	public DefaultTableModel getDm() {
		return dm;
	}
	
	public void setDm(DefaultTableModel dm) {
		this.dm = dm;
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public static void main(String[] args) {
		JFrame frame=new JFrame();
	
	    TablaSemana panel = new TablaSemana();
	
	    frame.add(panel.getPanel());
	    frame. setSize(200, 140);
	    frame.setVisible(true);
	    
	    frame.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	        System.exit(0);
	      }
	    });
	}
}
