import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JFrame;

public class MiAccion extends AbstractAction {

	String texto;
	Vista vista;
	public MiAccion(String texto, Icon imagen,String descrip,JFrame ventana) {
		super(texto,imagen);
		this.texto=texto;
		this.putValue(Action.SHORT_DESCRIPTION, descrip);
		this.vista=(Vista) ventana;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {

		switch(texto) {
		case "Adelante":{
			vista.setActual(vista.getActual()+1);
			vista.panel.setViewportView(vista.listaPaneles.get(vista.getActual()));
			
			
		}break;
		
		case "Atras":{
			vista.setActual(vista.getActual()-1);
			vista.panel.setViewportView(vista.listaPaneles.get(vista.getActual()));
			
		}break;
		
		
		}
		vista.labelPagina.setText(vista.getActual()*vista.panel.getTamaño()+"-"+((vista.getActual()*vista.panel.getTamaño())+vista.panel.getTamaño()-1));
		if(vista.getActual()==vista.getTamaño()) {
			vista.accAdelante.setEnabled(false);
		}else {
			vista.accAdelante.setEnabled(true);
		}
		if(vista.getActual()==0) {
			vista.accAtras.setEnabled(false);
		}else {
			vista.accAtras.setEnabled(true);
		}
		
	}

}
