package e_ventana_mover;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

public class ControladorMover extends AbstractAction implements ActionListener{

	private VentanaMover ventana;
	private String texto;
	private ModeloMover modeloLlamadas;

	public ControladorMover(VentanaMover pal, ModeloMover modeloLlamada) {
		this.ventana=pal;
		this.modeloLlamadas=modeloLlamada;
	}
		
	public ControladorMover(String string, ImageIcon imageIcon, String string2, int vkC, VentanaMover ventanaMover, ModeloMover modeloLlamada) {
		super(string,imageIcon);
		this.texto = string;
		this.putValue( Action.SHORT_DESCRIPTION ,string2);
		this.putValue(Action.MNEMONIC_KEY, vkC);
		
		this.modeloLlamadas=modeloLlamada;
		this.ventana=ventanaMover;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comand=e.getActionCommand();
		String instruccion="";
		int numero=0;
		
		if(comand!=null) {
			String comandoEntero[]=comand.split(":");
			
			instruccion=comandoEntero[0];
			numero=Integer.parseInt(comandoEntero[1])-1;
		}
		else {
			instruccion=this.texto;
		}

		switch(instruccion) {
			case "enter":{		
				this.modeloLlamadas.introducir(numero);
				break;
			}
			case "salir":{
				this.modeloLlamadas.salir(numero);
				break;
			}
			case "Volver a Administrador":{
				this.modeloLlamadas.volverAdmin();
				break;
			}
		}
	}

}
