package c_ventana_integrantes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;

import z_modelo_equipo_repartidores.Repartidor;

public class ControladorIntegrantes extends AbstractAction implements ActionListener {

	private VentanaIntegrantes ventana;
	private ModeloIntegrantes modelo;
	private String texto;
	
	public ControladorIntegrantes (String texto, Icon imagen, String descrip, Integer nemonic, VentanaIntegrantes ventana, ModeloIntegrantes modelo){
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
		Repartidor elegido=(Repartidor) this.ventana.getListaElementos().getSelectedValue();
		
		switch(comand) {
			case "Anadir":{
				DialogoIntegrantes dialogo=new DialogoIntegrantes(this.ventana, "Crear nuevo Repartidor", true);
				this.modelo.anadirRepartidor(dialogo);
				break;
			}
			case "Quitar":{
				this.modelo.quitarRepartidor(elegido);
				break;
			}
			case "Modificar":{
				this.modelo.modificarRepartidor(elegido,this.ventana);			
				break;
			}
			case "Mover":{
				this.modelo.irVentanaMover();
				break;
			}
			case "Volver":{	
				this.modelo.volverAtras();
				break;
			}
		}
	}
	
}
