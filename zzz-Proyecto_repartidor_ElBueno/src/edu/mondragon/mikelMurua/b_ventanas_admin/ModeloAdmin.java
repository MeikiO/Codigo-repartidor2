package b_ventanas_admin;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractListModel;

import z_agrupaciones_miembros_equipo.Agrupador;
import z_agrupaciones_miembros_equipo.FactoryAgrupaciones;
import z_base_de_datos_dao.ConsultasClientes;
import z_base_de_datos_dao.ConsultasRepartidor;
import z_enumeraciones.Poblacion;
import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.Equipo;
import z_modelo_equipo_repartidores.Repartidor;

public class ModeloAdmin extends AbstractListModel<Equipo>{

	public PropertyChangeSupport conector;
	private List<Equipo> listaAEnsenar;
	private Repartidor admin;
	
	public ModeloAdmin() {
		super();
		this.conector=new PropertyChangeSupport(this);
		this.listaAEnsenar=new ArrayList<>();
		this.inicializarEquipos();
	}

	private void inicializarEquipos() {
		Agrupador agrupador=new Agrupador();
		
		ConsultasClientes clientes=new ConsultasClientes();
		List<Cliente> listaClientes=clientes.cargarTodosLosElementos();
		
		ConsultasRepartidor repartidores=new ConsultasRepartidor();
		List<Repartidor>listaRepartidores=repartidores.cargarTodosLosElementos();
		
		Map<Integer,List<Cliente>>mapClientes=agrupador.agrupar(FactoryAgrupaciones.getSelectorIdEquipo(), listaClientes);
		Map<Integer,List<Repartidor>>mapRepartidores=agrupador.agrupar(FactoryAgrupaciones.getSelectorIdEquipo(), listaRepartidores);
		
		this.admin=mapRepartidores.get(0).get(0);
	
		for(int i=1;i<=Poblacion.numeroPoblaciones();i++) {
			List<Cliente> clientesEquipo=new ArrayList<>();
			List<Repartidor> repartidoresEquipo=new ArrayList<>();
			Poblacion poblacionEquipoActual=null;
			
			if(mapClientes.get(i)!=null || mapRepartidores.get(i)!=null) {
				if(mapRepartidores.get(i)!=null) {
					repartidoresEquipo=mapRepartidores.get(i);
					poblacionEquipoActual=mapRepartidores.get(i).get(0).getZona_trabajo();
				}
		
				if(mapClientes.get(i)!=null) {
					clientesEquipo=mapClientes.get(i);
					poblacionEquipoActual=mapClientes.get(i).get(0).getPoblacion();
				}

				Equipo nuevo=new Equipo(i,poblacionEquipoActual,clientesEquipo, repartidoresEquipo);
				this.listaAEnsenar.add(nuevo);
			}
		}
	}

	public boolean checkListaClientes() {
		boolean cond=true;
		
		for(Equipo actual:this.listaAEnsenar) {
			if(!actual.getListaClientes().isEmpty()) {
				cond=false;
			}
		}
		
		return cond;
	}
	
	public boolean checkListaRepartidores() {
		boolean cond=true;
		
		for(Equipo actual:this.listaAEnsenar) {
			if(!actual.getListaRepartidores().isEmpty()) {
				cond=false;
			}
		}
		
		return cond;
	}
	
	public void cambiarVentanaIntegrantes() {
		this.conector.firePropertyChange("CambioIntegrantes", -1, this);
	}
	
	public void cambiarVentanaRecorrido() {
		this.conector.firePropertyChange("CambioRecorrido", -1, this);
	}
	
	@Override
	public int getSize() {
		return this.listaAEnsenar.size()-1;
	}

	@Override
	public Equipo getElementAt(int index) {	
		return this.listaAEnsenar.get(index);
	}
		
	public void anadirALista(Equipo Equipo) {
		this.listaAEnsenar.add(Equipo);
		this.fireContentsChanged(this.listaAEnsenar, 0, this.getSize());
	}
	
	public void quitarDeLista(Equipo Equipo) {
		this.listaAEnsenar.remove(Equipo);
		this.fireContentsChanged(this.listaAEnsenar, 0, this.getSize());
	}
	
	public void setListaAEnsenar(List<Equipo> listaAEnsenar) {
		this.listaAEnsenar = listaAEnsenar;
		this.fireContentsChanged(this.listaAEnsenar, 0, getSize());
	}
	
	public void volverALogin() {
		this.conector.firePropertyChange("Volver", -1, this);
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

	public List<Equipo> getListaAEnsenar() {
		return listaAEnsenar;
	}

	public Repartidor getAdmin() {
		return admin;
	}

	public void setAdmin(Repartidor admin) {
		this.admin = admin;
	}
	
}
