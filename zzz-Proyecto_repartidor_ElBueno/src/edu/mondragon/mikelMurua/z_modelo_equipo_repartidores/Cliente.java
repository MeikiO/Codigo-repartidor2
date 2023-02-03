package z_modelo_equipo_repartidores;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

import z_enumeraciones.DiasSemana;
import z_enumeraciones.Poblacion;
import z_enumeraciones.TipoReparto;
import z_mapas.ClienteMouseListener;

public class Cliente extends DefaultWaypoint implements Miembro{
	
	private int id_cliente;
	private int idEquipo;
    private JButton button;
    private String direccion;
    private String nombre_cliente;
    private String llaves;
    private String como_dejarlo;
    private String notas;
    private String dias;
    private Poblacion poblacion;
    private List<TipoReparto> lista_productos;
    private static final String separador=":";
    
    private Repartidor repartidorResponsable;
    private String diasCompletados;
    private DiasSemana diaActual;
    
	public Cliente(int id_cliente,int idEquipo,String nombre_cliente,String direccion,String llaves,
    		String como_dejarlo,String notas,String dias,String poblacion,List list,
    		GeoPosition coord,String diasCompletados) {     
    	super(coord);
    	
    	this.id_cliente=id_cliente;
    	
    	this.idEquipo=idEquipo;
        this.notas=notas;
        
    	this.nombre_cliente=nombre_cliente; 
        this.direccion=direccion;
        this.llaves=llaves;
        this.como_dejarlo=como_dejarlo;
        this.dias=dias;
        
        this.poblacion=Poblacion.valueOf(poblacion);
        
        lista_productos=new ArrayList<>();
        if(!list.isEmpty()) {
        	this.lista_productos=list;
        }
        else {
        	lista_productos.add(TipoReparto.Berria);
        }
        
        this.diasCompletados=diasCompletados;
        
        this.inicializarBoton(lista_productos.size());
    }

    public Cliente(String nombre_cliente,String direccion,String llaves,
    		String como_dejarlo,String dias,String poblacion,List list,
    		GeoPosition coord) {
       
    	super(coord);
    	
        this.notas="";
        
    	this.nombre_cliente=nombre_cliente; 
        this.direccion=direccion;
        this.llaves=llaves;
        this.como_dejarlo=como_dejarlo;
        this.dias=dias;
        
        this.poblacion=Poblacion.valueOf(poblacion);
        this.idEquipo=this.poblacion.getId();
        
        lista_productos=new ArrayList<>();
        if(!list.isEmpty()) {
        	this.lista_productos=list;
        }
        else {
        	lista_productos.add(TipoReparto.Berria);
        }
        
        this.diasCompletados="";
        
        this.inicializarBoton(lista_productos.size());
    }

	private void inicializarBoton(int numproductos) {
		 this.button = new JButton(""+numproductos);
	        this.getButton().setSize(40, 40);
	        this.getButton().setPreferredSize(new Dimension(40,40));
	        
	       this.getButton().addMouseListener(new ClienteMouseListener(this));
	        
	        if(!this.lista_productos.isEmpty()) {
	        	
	        	this.getButton().setBackground(this.getListaProductos().get(0).getColor());
	       
	        	this.getButton().setVisible(true);
	        }
	        else {
	        	this.getButton().setVisible(false);
	        }
	}

	public Integer getId_recorrido() {
		return idEquipo;
	}

	public void setId_recorrido(Integer id_recorrido) {
		this.idEquipo = id_recorrido;
	}

	public JButton getButton() {
		return button;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getLlaves() {
		return llaves;
	}
	
	public void setLlaves(String llaves) {
		this.llaves = llaves;
	}

	public String getComo_dejarlo() {
		return como_dejarlo;
	}

	public void setComo_dejarlo(String como_dejarlo) {
		this.como_dejarlo = como_dejarlo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public List<TipoReparto> getListaProductos() {
		return lista_productos;
	}

	public void setListaProductos(List<TipoReparto> listaProductos) {
		this.lista_productos = listaProductos;
	}

	public String leerListaProductos() {
		StringBuilder cadena=new StringBuilder("");
		for(TipoReparto actual:this.lista_productos) {
			cadena.append(actual.name());
			cadena.append(this.separador);
		}
	
		if(!cadena.isEmpty()) {
			cadena.replace(cadena.length()-1,cadena.length(), "");
		}
		
		return cadena.toString();
	}
	
	@Override
	public String toString() {
		return this.nombre_cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	

	public Repartidor getRepartidorResponsable() {
		return repartidorResponsable;
	}

	public void setRepartidorResponsable(Repartidor repartidorResponsable) {
		this.repartidorResponsable = repartidorResponsable;
	}

	public List<TipoReparto> getLista_productos() {
		return lista_productos;
	}

	public void setLista_productos(List<TipoReparto> lista_productos) {
		this.lista_productos = lista_productos;
	}

	@Override
	public int getIdEquipo() {
		return this.idEquipo;
	}

	@Override
	public void setIdEquipo(int id) {
		this.idEquipo=id;
	}
	
	@Override
	public Poblacion getPoblacion() {
		return poblacion;
	}

	@Override
	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_cliente;
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
		Cliente other = (Cliente) obj;
		if (id_cliente != other.id_cliente)
			return false;
		return true;
	}

	@Override
	public int getIdParticular() {
		return this.id_cliente;
	}

	public String getDiasCompletados() {
		return diasCompletados;
	}

	public void setDiasCompletados(String diasCompletados) {
		this.diasCompletados = diasCompletados;
	}


	public DiasSemana getDiaActual() {
		return diaActual;
	}


	public void setDiaActual(DiasSemana diaActual) {
		this.diaActual = diaActual;
	}


	public static String getSeparador() {
		return separador;
	}

}
