package z_tablas;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import z_modelo_equipo_repartidores.RegistroReparto;

public class TablaRegistros extends JFrame
{
	private JTable table;
	private JTableHeader head;

	public TablaRegistros(List<RegistroReparto> lista)
    {
        String[] columns = new String[] {
            "id_cliente", "iduser", "idEquipo", "fecha-hora"
        };
       
        Object[][] data=null;
        
        if(lista.isEmpty()) {
        	data = new Object[][] {{"", "","",""},}; 
        }
        else {
             data =this.crearArray(lista, columns.length);
        }
      	
        table = new JTable(this.getModel(data, columns));
        head = table.getTableHeader();
    }
	
	public DefaultTableModel setNewValuesInTable (List<RegistroReparto> lista){
        String[] columns = new String[] {
            "id_cliente", "iduser", "idEquipo", "fecha-hora"
        };
        
        Object[][] data=null;
        
        if(lista.isEmpty()) {
        	data = new Object[][] {{"", "","",""},};
        }
        else {
             data =this.crearArray(lista, columns.length);
        }
      
        return this.getModel(data, columns);
	}
	
	public JPanel devolverComponente() {
		 JPanel c = new JPanel(new BorderLayout());
	      c.add(this.head, BorderLayout.NORTH);
	      c.add(this.table,BorderLayout.CENTER);
       
	      return c;
	}
   

	public String [][] crearArray(List<RegistroReparto>lista,int numColumnas) {
		String [][] datos = new String [lista.size()][numColumnas];
		int i = 0;
		for (RegistroReparto registro:lista ){
			datos[i] = registro.toArray(numColumnas);
			i++;
		}
		return datos;
	}

  private DefaultTableModel getModel(Object[][] data,String[] columns){

    	int columnCount = columns.length;
        Vector<String> columnNames = new Vector<>();

        for (int column = 0; column < columnCount; column++) {
            columnNames.add(columns[column]);
        }
        
        DefaultTableModel dataModel = new DefaultTableModel(columnNames, 0);

        for (int i=0;i<data.length;i++) {
            Vector<String> vector = new Vector<>();
          
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
            	vector.add((String) data[i][columnIndex]);
            }
            dataModel.addRow(vector);
        }

        return dataModel;
    }
	  
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTableHeader getHead() {
		return head;
	}

	public void setHead(JTableHeader head) {
		this.head = head;
	}
	
	public static void main(String[] args){	
		TablaRegistros programa=new TablaRegistros(new ArrayList<>());

	    programa.add(programa.devolverComponente());
         
        programa.setTitle("Table Example");
        programa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        programa.setVisible(true);
    }
	
}