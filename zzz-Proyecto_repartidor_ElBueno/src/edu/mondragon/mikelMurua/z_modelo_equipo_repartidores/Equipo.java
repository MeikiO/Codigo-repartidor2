package z_modelo_equipo_repartidores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import z_enumeraciones.Poblacion;


public class Equipo {

	public int idEquipo;
	public Poblacion poblacionActual;
	public Set<Cliente> listaClientes;
	public List<Repartidor> listaRepartidores;
	
	public Equipo() {
		this.listaClientes = new HashSet<>();
		this.listaRepartidores = new ArrayList<>();	
	}
	
	public Equipo(int idEquipo,Poblacion poblacionActual, List<Cliente> clientesEquipo, List<Repartidor> listaRepartidores) {
		this.idEquipo = idEquipo;
		this.poblacionActual=poblacionActual;
		this.listaClientes = new HashSet<>(clientesEquipo);
		this.listaRepartidores = listaRepartidores;	
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}


	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}


	public Set<Cliente> getListaClientes() {
		return listaClientes;
	}


	public void setListaClientes(Set<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}


	public List<Repartidor> getListaRepartidores() {
		return listaRepartidores;
	}


	public void setListaRepartidores(List<Repartidor> listaRepartidores) {
		this.listaRepartidores = listaRepartidores;
	}

	
	public Poblacion getPoblacionActual() {
		return poblacionActual;
	}

	public void setPoblacionActual(Poblacion poblacionActual) {
		this.poblacionActual = poblacionActual;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((poblacionActual == null) ? 0 : poblacionActual.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (poblacionActual != other.poblacionActual)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipo: " + idEquipo+"  Poblacion: "+this.poblacionActual.name();
	}
		
}
