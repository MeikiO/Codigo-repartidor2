package d_ventana_recorrido;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import z_base_de_datos_dao.ConsultasClientes;
import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.Equipo;
import z_modelo_equipo_repartidores.Repartidor;

public class ModeloRecorrido extends AbstractListModel<Equipo>{

	public PropertyChangeSupport conector;
	private List<Equipo> listaEquipo;
	private ConsultasClientes databaseCliente;
	
	public ModeloRecorrido(List<Equipo> lista) {
		super();
		this.conector=new PropertyChangeSupport(this);
		databaseCliente =new ConsultasClientes();
		this.listaEquipo=new ArrayList<>();
		this.inicializarLista(lista);
	}

	private void inicializarLista(List<Equipo> lista) {
		for(Equipo actual:lista) {
			if(!actual.getListaClientes().isEmpty()) {
				this.listaEquipo.add(actual);
			}
		}
	}

	public Equipo buscarEquipoAlQuePertenece(Cliente cliente) {
		Equipo equipoBuscado=null;
		
		for(int i=0;i<this.getSize();i++) {
			Equipo equipo=this.getElementAt(i);

			if(equipo.getIdEquipo()==cliente.getIdEquipo()) {
				
				equipoBuscado=this.getElementAt(i);
			}
		}
		return equipoBuscado;
	}
	
	public void anadirCliente(DialogoRecorrido dialogo) {
		if(dialogo.getCreada()!=null) {
			boolean entradaFalsa=databaseCliente.registrarEnDatabase(dialogo.getCreada());						
			
			if(entradaFalsa) {
				this.conector.firePropertyChange("direccionExistente",-1,this);
			}
			else {
				this.anadirClienteALista(dialogo.getCreada());
			}
		}
	}
	
	public void quitarCliente(Cliente elegido) {
		if(elegido==null) {
			this.conector.firePropertyChange("noSeHaSeleccionadoCliente",-1,this);
		}
		else {
			databaseCliente.borrarElemento(elegido);	
			this.quitarElementoALista(elegido);
		}
		
		if(this.getListaEquipo().isEmpty()) {
			this.volverAnterior();
		}
	}
	
	public void modificarCliente(Cliente elegido, VentanaRecorrido ventana) {
		if(elegido==null) {
			this.conector.firePropertyChange("noSeHaSeleccionadoCliente",-1,this);
		}
		else {
			DialogoRecorrido dialogo=new DialogoRecorrido(ventana, "Modificar Repartidor", true,elegido);
			
			if(dialogo.isModificado()) {
				this.quitarElementoALista(elegido);
				this.anadirClienteALista(dialogo.getCreada());

				databaseCliente.actualizar(dialogo.getCreada());	
			}
		}
	}
	
	public void irVentanaMover() {
		this.conector.firePropertyChange("irAVentanaMover", -1, this);
	}
	
	public void volverAnterior() {
		this.conector.firePropertyChange("Volver", -1, this);
	}
	
	public void anadirClienteALista(Cliente cliente) {
		boolean crearNuevoEquipo=true;
		
		Equipo equipo=this.buscarEquipoAlQuePertenece(cliente);
			
		if(equipo!=null) {
			equipo.getListaClientes().add(cliente);
		}
		else {
			List<Cliente> listaCliente=new ArrayList<>();
			List<Repartidor>repartidores=new ArrayList<>();
			
			listaCliente.add(cliente);
			
			Equipo nuevo=new Equipo(this.getSize()+1,cliente.getPoblacion(),listaCliente,repartidores);
			
			this.listaEquipo.add(nuevo);
			
			this.fireContentsChanged(this.listaEquipo, 0, getSize());
		}
		
		this.conector.firePropertyChange("refrescar", -1, cliente);	
	}

	public void quitarElementoALista(Cliente elegido) {
		Equipo equipo=this.buscarEquipoAlQuePertenece(elegido);

		equipo.getListaClientes().remove(elegido);
		
		if(equipo.getListaClientes().isEmpty() ) {
			this.listaEquipo.remove(equipo);
		}

		this.conector.firePropertyChange("refrescar", -1, this);
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

	@Override
	public int getSize() {
		return this.listaEquipo.size();
	}

	@Override
	public Equipo getElementAt(int index) {
		return this.listaEquipo.get(index);
	}

	public List<Equipo> getListaEquipo() {
		return listaEquipo;
	}

	public void setListaEquipo(List<Equipo> listaEquipo) {
		this.listaEquipo = listaEquipo;
	}
	
}
