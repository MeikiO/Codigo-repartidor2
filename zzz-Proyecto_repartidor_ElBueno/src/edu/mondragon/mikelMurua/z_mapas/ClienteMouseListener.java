package z_mapas;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import z_modelo_equipo_repartidores.Cliente;


public class ClienteMouseListener implements MouseListener {

	private Cliente point;

	public ClienteMouseListener(Cliente point) {
		this.point=point;
		
	}
	
    @Override
    public void mouseClicked(MouseEvent e) {
        
    	DialogoEnseñarDatosCliente dialogo=new DialogoEnseñarDatosCliente(point);
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


	public Cliente getPoint() {
		return point;
	}

	public void setPoint(Cliente point) {
		this.point = point;
	}

	
	
}
