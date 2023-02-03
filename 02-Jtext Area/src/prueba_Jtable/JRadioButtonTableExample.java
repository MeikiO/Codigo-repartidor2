package prueba_Jtable;

// Example from http://www.crionics.com/products/opensource/faq/swing_ex/SwingExamples.html
/**
 * @version 1.0 12/03/98
 */

//


//ejemplo tomado de ;   http://www.java2s.com/Code/Java/Swing-Components/RadioButtonTableExample.htm

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
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
	    if(this.diasIntroducidos>0) {
	    	this.cadena.append("-");
	    	this.cadena.append(table.getColumnName(column));
	    }
	    if(this.diasIntroducidos==0) {
	    	this.cadena.append(table.getColumnName(column));
	    	this.diasIntroducidos=1;
	    }
	    
	    //despues cuando se guarden los elegidos se guardara
	    //el string del stringBuilder
	    
	    System.out.print("\n The selected value is: "+table.getColumnName(column) );
	    System.out.print("\n cadena is: "+cadena.toString() );
	    
	    
   }
    
 

        
    return (Component) value;
  }

  public Object getCellEditorValue() {
    button.removeItemListener(this);
    return button;
  }

  public void itemStateChanged(ItemEvent e) {
    super.fireEditingStopped();
  }
}




public class JRadioButtonTableExample  {

	  DefaultTableModel dm ;
	JPanel panel;
	
  public JRadioButtonTableExample() {
 
	panel=new JPanel();
	  
    UIDefaults ui = UIManager.getLookAndFeel().getDefaults();
    UIManager.put("RadioButton.focus", ui.getColor("control"));

    
    dm = new DefaultTableModel();
    dm.setDataVector(new Object[][] { 
    	{new JRadioButton(), new JRadioButton(), new JRadioButton(),
        	new JRadioButton(), new JRadioButton(), new JRadioButton(),
        	new JRadioButton()} }, 
    	new Object[] {
        "lu", "mar","mier","ju","vi","sa","do" });

    
    
    JTable table = new JTable(dm) {
      public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
        repaint();
      }
    };
    
    
    
    ButtonGroup group1 = new ButtonGroup();
    group1.add((JRadioButton) dm.getValueAt(0, 0));

    ButtonGroup group2 = new ButtonGroup();
    group2.add((JRadioButton) dm.getValueAt(0, 1));
  // ((JRadioButton) dm.getValueAt(0, 1)).setSelected(true);
    
    ButtonGroup group3 = new ButtonGroup();
    group3.add((JRadioButton) dm.getValueAt(0, 2));
    
    ButtonGroup group4 = new ButtonGroup();
    group4.add((JRadioButton) dm.getValueAt(0, 3));
    
    ButtonGroup group5 = new ButtonGroup();
    group5.add((JRadioButton) dm.getValueAt(0, 4));
    
    ButtonGroup group6 = new ButtonGroup();
    group6.add((JRadioButton) dm.getValueAt(0, 5));

    ButtonGroup group7 = new ButtonGroup();
    group7.add((JRadioButton) dm.getValueAt(0, 6));
   
    
    
    table.getColumn("lu").setCellRenderer(new RadioButtonRenderer());
    table.getColumn("lu").setCellEditor(new RadioButtonEditor(new JCheckBox()));
    
    table.getColumn("mar").setCellRenderer(new RadioButtonRenderer());
    table.getColumn("mar").setCellEditor(new RadioButtonEditor(new JCheckBox()));
    
    table.getColumn("mier").setCellRenderer(new RadioButtonRenderer());
    table.getColumn("mier").setCellEditor(new RadioButtonEditor(new JCheckBox()));
    
    table.getColumn("ju").setCellRenderer(new RadioButtonRenderer());
    table.getColumn("ju").setCellEditor(new RadioButtonEditor(new JCheckBox()));
    
    table.getColumn("vi").setCellRenderer(new RadioButtonRenderer());
    table.getColumn("vi").setCellEditor(new RadioButtonEditor(new JCheckBox()));
    
    table.getColumn("sa").setCellRenderer(new RadioButtonRenderer());
    table.getColumn("sa").setCellEditor(new RadioButtonEditor(new JCheckBox()));
    
    table.getColumn("do").setCellRenderer(new RadioButtonRenderer());
    table.getColumn("do").setCellEditor(new RadioButtonEditor(new JCheckBox()));
    
    
    //this.setSelectedValuesSemana("vi-ju-do-sa");
    
    JScrollPane scroll = new JScrollPane(table);
    panel.add(scroll);
  
    
    
  }

  
  
  
  
  
  
  
  private void setSelectedValuesSemana(String string) {
	// TODO Auto-generated method stub
	
	 String[] dias=string.split("-");
	 
	 
	 for(int i=0;i<dias.length;i++) {
		 this.selectInDays(dias[i]);
	 }
	  
	  
}





private void selectInDays(String string) {
	// TODO Auto-generated method stub
	switch (string) {
	case "lu": {
		((JRadioButton) dm.getValueAt(0, 0)).setSelected(true);
		break;
	}
	case "mar": {
		((JRadioButton) dm.getValueAt(0, 1)).setSelected(true);
		break;
	}
	case "mier": {
		((JRadioButton) dm.getValueAt(0, 2)).setSelected(true);
		break;
	}
	case "ju": {
		((JRadioButton) dm.getValueAt(0, 3)).setSelected(true);
		break;
	}
	case "vi": {
		((JRadioButton) dm.getValueAt(0, 4)).setSelected(true);
		break;
	}
	case "sa": {
		((JRadioButton) dm.getValueAt(0, 5)).setSelected(true);
		break;
	}
	case "do": {
		((JRadioButton) dm.getValueAt(0, 6)).setSelected(true);
		break;
	}
	
	default:
		throw new IllegalArgumentException("Unexpected value: " + string);
	}
}





public static void main(String[] args) {
	JFrame frame=new JFrame();

    JRadioButtonTableExample panel = new JRadioButtonTableExample();

    frame.add(panel.panel);
    frame. setSize(200, 140);
    frame.setVisible(true);
    
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
