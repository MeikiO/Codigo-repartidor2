package a_login_y_register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;


public class ControladorLogin extends AbstractAction implements ActionListener {

	private VentanaLogin ventana;
	private ModeloLogin modelo;
	private String texto;

	public ControladorLogin (String texto, Icon imagen, String descrip, Integer nemonic,VentanaLogin ventana,ModeloLogin modelo){
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
			case "Ok":{
				this.modelo.comprobarContenido(this.ventana.getUsuario().getText(),this.ventana.getPassword().getText());
				break;
			}
			case "Register":{
				this.modelo.vaciarTexto();
				DialogoRegister dialogo=new DialogoRegister(this.ventana, "Ventana de Registro", true, this);
				
				this.modelo.registrar(dialogo);
				
				break;
			}
			case "Salir":{
				this.modelo.acabarPrograma();
				break;
			}
			default:
				break;
		}
	}
	
}
