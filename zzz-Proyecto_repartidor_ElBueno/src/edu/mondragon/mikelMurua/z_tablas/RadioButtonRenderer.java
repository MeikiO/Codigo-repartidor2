package z_tablas;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


class RadioButtonRenderer implements TableCellRenderer {
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (value == null)
      return null;
 
    return (Component) value;
  }
  
}


class RadioButtonEditor extends DefaultCellEditor implements ItemListener {
  private JRadioButton button;

  private static StringBuilder cadena;

  private static int diasIntroducidos;
  
  public RadioButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    this.cadena=new StringBuilder("");
    this.diasIntroducidos=0;
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
	boolean isSelected, int row, int column) {
	    if (value == null)
	      return null;
	    
	   button = (JRadioButton) value;
	   button.addItemListener(this);
	     
	   if(!button.isSelected()) {
		    if(this.getDiasIntroducidos()>0) {
		    	this.getCadena().append("-");
		    	this.getCadena().append(table.getColumnName(column));
		    }
		    if(this.getDiasIntroducidos()==0) {
		    	this.getCadena().append(table.getColumnName(column));
		    	this.setDiasIntroducidos(1);
		    }
    
		    System.out.print("\n The selected value is: "+table.getColumnName(column) );
		    System.out.print("\n cadena is: "+getCadena().toString() );  	    
	   }
    
     
	   return (Component) value;
  	}

  
  
	public JRadioButton getButton() {
		return button;
	}
	
	public void setButton(JRadioButton button) {
		this.button = button;
	}
	
	public static StringBuilder getCadena() {
		return cadena;
	}
	
	public static void setCadena(StringBuilder cadena) {
		RadioButtonEditor.cadena = cadena;
	}
	
	public static int getDiasIntroducidos() {
		return diasIntroducidos;
	}
	
	public static void setDiasIntroducidos(int diasIntroducidos) {
		RadioButtonEditor.diasIntroducidos = diasIntroducidos;
	}
	
	public Object getCellEditorValue() {
	    button.removeItemListener(this);
	    return button;
	}
	
	public void itemStateChanged(ItemEvent e) {
	    super.fireEditingStopped();
	}

}


