package e_ventana_mover;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

import javax.swing.AbstractListModel;

import z_enumeraciones.Poblacion;
import z_modelo_equipo_repartidores.Miembro;

public class ModeloMover extends AbstractListModel<Miembro> {

	private int id;
	private List<Miembro> listaElementos;
	private Poblacion poblacion;
	
	public PropertyChangeSupport conector;

	public ModeloMover(Poblacion actual, List<Miembro> lista) {
		super();
		this.conector=new PropertyChangeSupport(this);
		this.setPoblacion(actual);
		this.id=actual.getId();
		listaElementos=lista;
	}
	
	public ModeloMover() {
		this.conector=new PropertyChangeSupport(this);
	}

	public void introducir(int numero) {
		this.conector.firePropertyChange("enter", -1, numero);
	}
	
	public void salir(int numero) {
		this.conector.firePropertyChange("salir", -1, numero);
	}
	
	public void volverAdmin() {
		this.conector.firePropertyChange("Volver a Administrador", -1, this);
	}
	
	public void anadir(Miembro elemento) {
		elemento.setPoblacion(poblacion);
		elemento.setIdEquipo(poblacion.getId());
		this.listaElementos.add(elemento);
		
		this.fireContentsChanged(this.listaElementos, -1, this.listaElementos.size());
	}
	
	public void quitar(Miembro elemento) {
		int posicion=this.listaElementos.indexOf(elemento);
		this.listaElementos.remove(posicion);
		
		this.fireContentsChanged(this.listaElementos, -1, this.listaElementos.size());
	}

	@Override
	public int getSize() {
		return this.listaElementos.size();
	}

	@Override
	public Miembro getElementAt(int index) {
		return listaElementos.get(index);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Miembro> getListaElementos() {
		return listaElementos;
	}

	public void setListaElementos(List<Miembro> listaElementos) {
		this.listaElementos = listaElementos;
	}

	public Poblacion getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
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
