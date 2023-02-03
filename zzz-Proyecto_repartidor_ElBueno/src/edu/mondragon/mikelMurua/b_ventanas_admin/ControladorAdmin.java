package b_ventanas_admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

import z_modelo_equipo_repartidores.Equipo;

public class ControladorAdmin extends AbstractAction implements ActionListener {

	private VentanaAdmin ventana;
	private ModeloAdmin modelo;
	private String texto;

	public ControladorAdmin (String texto, Icon imagen, String descrip, Integer nemonic,VentanaAdmin ventana,ModeloAdmin modelo){
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

		Equipo elegido=(Equipo) this.ventana.getListaEquipos().getSelectedValue();
		
		switch(comand) {
			case "Integrantes":{
				this.modelo.cambiarVentanaIntegrantes();
				break;
			}
			case "Recorrido":{
				this.modelo.cambiarVentanaRecorrido();

				break;
			}
			case "Log-Out":{
				this.modelo.volverALogin();
				break;
			}
			default:
				break;
		}	
	}
	
}
