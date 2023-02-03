package f_ventana_repartidor_una_vez_logeado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

public class ControladorRepartidor extends AbstractAction implements ActionListener {

	private VentanaRepartidor ventana;
	private ModeloRepartidor modelo;
	private String texto;

	public ControladorRepartidor (String texto, Icon imagen, String descrip, Integer nemonic,VentanaRepartidor ventana,ModeloRepartidor modelo){
		super(texto,imagen);
		this.texto = texto;
		this.putValue( Action.SHORT_DESCRIPTION ,descrip);
		this.putValue(Action.MNEMONIC_KEY, nemonic);
		
		this.modelo=modelo;
		this.ventana=ventana;	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comand=comand=this.texto;

		switch(comand) {
			case "Log-Out":{
				this.modelo.volverALogin();
				break;
			}
		}
	}

}
