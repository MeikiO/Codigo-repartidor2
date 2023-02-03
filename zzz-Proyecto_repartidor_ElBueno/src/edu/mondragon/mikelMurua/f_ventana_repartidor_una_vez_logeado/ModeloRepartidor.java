package f_ventana_repartidor_una_vez_logeado;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import z_agrupaciones_miembros_equipo.Agrupador;
import z_agrupaciones_miembros_equipo.FactoryAgrupaciones;
import z_base_de_datos_dao.ConsultasClientes;
import z_enumeraciones.DiasSemana;
import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.Repartidor;



public class ModeloRepartidor {
	public PropertyChangeSupport conector;
	private List<Cliente> elementosEquipo;
	private Set<Cliente> listaEntera;
	private Repartidor logeado;
	private Map<String,Set<Cliente>> mapDias;
	
	public ModeloRepartidor(Repartidor cond) {
		this.conector=new PropertyChangeSupport(this);
		this.logeado=cond;
		this.listaEntera=new HashSet<>();
		this.inicializarEquipos();
		
		this.mapDias=new LinkedHashMap();
		this.separarPorDias();
		
	}

	private void separarPorDias() {
		try {			
			for (Cliente actual: this.listaEntera){
				for(DiasSemana diaActual:DiasSemana.values()) {
					if(actual.getDias().contains(diaActual.getAbreviacion())) {
						String clavePrimaria = diaActual.name();
						Set<Cliente> listaEquipos = this.mapDias.get(clavePrimaria);
						if (listaEquipos == null) {
							listaEquipos = new HashSet();
						}
						
						listaEquipos.add(actual);
						
						this.mapDias.put(clavePrimaria, listaEquipos);
					}
				}
			}
		}
		catch(java.lang.NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	private void inicializarEquipos() {
		ConsultasClientes clientes=new ConsultasClientes();
		List<Cliente> listaClientes=clientes.cargarTodosLosElementos();
		
		Agrupador agrupacion=new Agrupador();
		Map<Integer,List<Cliente>>mapClientes=agrupacion.agrupar(FactoryAgrupaciones.getSelectorIdEquipo(), listaClientes);

		if(mapClientes.containsKey(this.logeado.getIdEquipo())) {
			this.elementosEquipo=mapClientes.get(this.logeado.getIdEquipo());
			
			for(Cliente actual: this.elementosEquipo) {
				this.listaEntera.add(actual);
			}
		}
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

	public Repartidor getLogeado() {
		return logeado;
	}

	public Set<Cliente> getListaEntera() {
		return listaEntera;
	}

	public List<Cliente> getElementosEquipo() {
		return elementosEquipo;
	}

	public Map<String, Set<Cliente>> getMapDias() {
		return mapDias;
	}
	
}
