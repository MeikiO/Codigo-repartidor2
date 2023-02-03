package c_ventana_integrantes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import z_base_de_datos_dao.ConsultasRegistros;
import z_base_de_datos_dao.ConsultasRepartidor;
import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.Equipo;
import z_modelo_equipo_repartidores.RegistroReparto;
import z_modelo_equipo_repartidores.Repartidor;



public class ModeloIntegrantes extends AbstractListModel<Equipo>{

	public PropertyChangeSupport conector;
	private List<Equipo> listaEquipo;
	private ConsultasRepartidor databaseRepartidor;
	
	public ModeloIntegrantes(List<Equipo> lista) {
		super();
		this.conector=new PropertyChangeSupport(this);
		databaseRepartidor=new ConsultasRepartidor();
		this.listaEquipo=new ArrayList<>();
		this.inicializarLista(lista);
		this.cargarDatosRegistros();	
	}
	
	private void inicializarLista(List<Equipo> lista) {
		for(Equipo actual:lista) {
			if(!actual.getListaRepartidores().isEmpty()) {
				this.listaEquipo.add(actual);
			}
		}
	}

	private void cargarDatosRegistros() {
		ConsultasRegistros database=new ConsultasRegistros();
		List<RegistroReparto> listaRegistros=database.cargarTodosLosElementos();
		
		for(RegistroReparto registroActual:listaRegistros) {	
			for(Equipo equipoActual:this.listaEquipo) {
				for(Repartidor repartidorActual:equipoActual.getListaRepartidores()) {
					if(repartidorActual.getId_repartidor()==registroActual.getIduser()&&
						repartidorActual.getIdEquipo()==registroActual.getIdEquipo()) {
						repartidorActual.getListaReparto().add(registroActual);
					}
				}				
			}
		}
	}

	public Equipo buscarEquipoAlQuePertenece(Repartidor poblacion) {
		Equipo equipoBuscado=null;
		
		for(int i=0;i<this.getSize();i++) {
			Equipo equipo=this.getElementAt(i);

			if(equipo.getIdEquipo()==poblacion.getIdEquipo()) {
				equipoBuscado=this.getElementAt(i);
			}
		}
		
		return equipoBuscado;
	}

	public void anadirRepartidor(DialogoIntegrantes dialogo) {
		if(dialogo.getCreada()!=null) {
			boolean entradaFalsa=databaseRepartidor.registrarEnDatabase(dialogo.getCreada());						
			
			if(entradaFalsa) {
				this.conector.firePropertyChange("usuarioExistente", -1, this);
			}
			else {
				this.anadirRepartidorALista(dialogo.getCreada());
			}
		}
	}
	
	public void quitarRepartidor(Repartidor elegido) {
		if(elegido==null) {
			this.conector.firePropertyChange("noSeHaSeleccionadoRepartidor", -1, this);
		}
		else {
			databaseRepartidor.borrarElemento(elegido);	
			this.quitarElementoDeLista(elegido);
		}
		
		if(this.getListaEquipo().isEmpty()) {
			this.volverAtras();
		}
	}
	
	public void modificarRepartidor(Repartidor elegido, VentanaIntegrantes ventana) {
		if(elegido==null) {
			this.conector.firePropertyChange("noSeHaSeleccionadoRepartidor", -1, this);
		}
		else {
			DialogoIntegrantes dialogo=new DialogoIntegrantes(ventana, "Modificar Repartidor", true,elegido);
			
			if(dialogo.isModificado()) {
				this.quitarElementoDeLista(elegido);	
				this.anadirRepartidorALista(dialogo.getCreada());

				databaseRepartidor.actualizar(dialogo.getCreada());	
			}
		}
	}
	
	public void irVentanaMover() {
		this.conector.firePropertyChange("irAVentanaMover", -1, this);
	}
	
	public void volverAtras() {
		this.conector.firePropertyChange("Volver", -1, this);
	}
	
	public void anadirRepartidorALista(Repartidor repartidor) {
		boolean crearNuevoEquipo=true;
		
		Equipo equipo=this.buscarEquipoAlQuePertenece(repartidor);
			
		if(equipo!=null) {
			equipo.getListaRepartidores().add(repartidor);
		}
		else {
			List<Repartidor> listaRepartidor=new ArrayList<>();
			List<Cliente>listaClientes=new ArrayList<>();
			
			listaRepartidor.add(repartidor);
			
			Equipo nuevo=new Equipo(repartidor.getZona_trabajo().getId(),repartidor.getZona_trabajo(),listaClientes,listaRepartidor);
			
			this.listaEquipo.add(nuevo);
			
			this.fireContentsChanged(this.listaEquipo, 0, getSize());
		}
		
		this.conector.firePropertyChange("refrescar", -1, repartidor);
		
	}
	
	public void quitarElementoDeLista(Repartidor elegido) {	
		Equipo equipo=this.buscarEquipoAlQuePertenece(elegido);

		equipo.getListaRepartidores().remove(elegido);
		
		if(equipo.getListaRepartidores().isEmpty() ) {
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
