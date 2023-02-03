package d_ventana_recorrido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

import z_modelo_equipo_repartidores.Cliente;

public class ControladorRecorrido extends AbstractAction implements ActionListener {

	private VentanaRecorrido ventana;
	private ModeloRecorrido modelo;
	private String texto;

	public ControladorRecorrido (String texto, Icon imagen, String descrip, Integer nemonic, VentanaRecorrido ventana, ModeloRecorrido modelo){
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
		Cliente elegido= (Cliente) this.ventana.getListaElementos().getSelectedValue();
			
		switch(comand) {
			case "Anadir":{
				DialogoRecorrido dialogo=new DialogoRecorrido(this.ventana, "Crear nuevo Cliente", true);
				this.modelo.anadirCliente(dialogo);
				break;
			}
			case "Quitar":{
				this.modelo.quitarCliente(elegido);
				break;
			}
			case "Modificar":{
				this.modelo.modificarCliente(elegido,this.ventana);	
				break;
			}
			case "Mover":{
				this.modelo.irVentanaMover();
				break;
			}
			case "Volver":{	
				this.modelo.volverAnterior();
				break;
			}
		}
	}
	
}
