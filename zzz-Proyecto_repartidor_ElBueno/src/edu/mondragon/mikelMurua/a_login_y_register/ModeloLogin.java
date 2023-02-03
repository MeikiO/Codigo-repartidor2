package a_login_y_register;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import z_base_de_datos_dao.ConsultasClientes;
import z_base_de_datos_dao.ConsultasRepartidor;
import z_modelo_equipo_repartidores.Repartidor;

public class ModeloLogin {

	public PropertyChangeSupport conector;
	
	public ModeloLogin() {	
		this.conector=new PropertyChangeSupport(this);
	}

	public void registrar(DialogoRegister dialogo) {
		boolean entradaFalsa=false;
		
		if(dialogo.getRepartidorRegistrado()!=null) {
			ConsultasRepartidor databaseRepartidor =new ConsultasRepartidor();
			entradaFalsa=databaseRepartidor.registrarEnDatabase(dialogo.getRepartidorRegistrado());						
			
			if(entradaFalsa) {
				this.conector.firePropertyChange("usuarioExistente", -1, this);
			}
		}
		
		if(dialogo.getClienteRegistrado()!=null) {
			ConsultasClientes databaseCliente=new ConsultasClientes();
			entradaFalsa=databaseCliente.registrarEnDatabase(dialogo.getClienteRegistrado());						
			
			if(entradaFalsa) {
				this.conector.firePropertyChange("direccionExistente", -1, this);
			}	
		}
	}
	
	
	public void comprobarContenido(String usuario, String contraseña) {
		ConsultasRepartidor database=new ConsultasRepartidor();
		
		Repartidor comprobacion=database.comprobarCertificados(usuario, contraseña);
	
		this.conector.firePropertyChange("comprobar", -1, comprobacion);
	}
	
	public void vaciarTexto() {
		this.conector.firePropertyChange("borrar", -1, 0);
	}
	
	public void acabarPrograma() {
		this.conector.firePropertyChange("acabar", -1, 0);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		conector.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		conector.removePropertyChangeListener(listener);	
	}

	public PropertyChangeSupport getConector() {
		return conector;
	}

		
}
