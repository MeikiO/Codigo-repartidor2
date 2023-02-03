package mapas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import base_de_datos.PuntosData;


public class SwingWaypointMouseListener implements MouseListener, ActionListener {

	private SwingWaypoint point;
	Vpunto2 dialog;

	public SwingWaypointMouseListener(SwingWaypoint point) {
		// TODO Auto-generated constructor stub
		this.point=point;
		
	}
	
    @Override
    public void mouseClicked(MouseEvent e) {
    	
        //JOptionPane.showMessageDialog(this.point.getButton(), "You clicked on " + this.point.getName());
       
		dialog = new Vpunto2(this.getPoint(),this);
        
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	
    	System.out.print("presed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	System.out.print("released");
    	
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    	System.out.print("entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
    	System.out.print("exited");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command= e.getActionCommand();

	 	 switch (command) {

				case "eliminarCuadro": {	
						
						if(!this.getPoint().getNotes().equals(this.getDialog().getTextPane_1().getText())) {
							
							this.getPoint().setNotes(this.getDialog().getTextPane_1().getText());
							
							PuntosData database=new PuntosData();
							database.actualizarNotas(this.getPoint());
							
						}
						
						this.getDialog().dispose();
						
					
						break;
				}
	
			
				default:
						break;
		 	}
 		
 	  
	}

	public SwingWaypoint getPoint() {
		return point;
	}

	public void setPoint(SwingWaypoint point) {
		this.point = point;
	}

	public Vpunto2 getDialog() {
		return dialog;
	}

	public void setDialog(Vpunto2 dialog) {
		this.dialog = dialog;
	}
	
	
}
