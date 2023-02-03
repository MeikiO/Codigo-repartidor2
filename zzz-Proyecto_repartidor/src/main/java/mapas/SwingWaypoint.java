package mapas;

import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

import enumeraciones.Poblacion;
import enumeraciones.TipoReparto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * A waypoint that is represented by a button on the map.
 *
 * @author Daniel Stahr
 */
public class SwingWaypoint extends DefaultWaypoint {
    private final JButton button;
    private final String nombre;
    private String direccion;
    private String nombre_cliente;
    private String llaves;
    private String como_dejarlo;
    
    private String notas;
    
    private String dias;
    
    
    private Poblacion poblacion;
    private TipoReparto tipo;
    
    
	private Integer id_recorrido;
	

    public SwingWaypoint(Integer id_recorrido,String name,String direction,String nombre_cliente,
    		String llaves,String como_dejarlo,String notes,String dias,String poblacion,String tipo,
    		GeoPosition coord) {
       
    	super(coord);
        this.nombre = name;
        this.direccion=direction;
        
        this.nombre_cliente=nombre_cliente;
        this.llaves=llaves;
        this.como_dejarlo=como_dejarlo;
        this.notas=notes;
        this.dias=dias;
        
        //GeoPosition geo=new GeoPosition(id_recorrido, id_recorrido, id_recorrido, id_recorrido, id_recorrido, id_recorrido);
        
        //asignacion de de los enum
        
        for(TipoReparto dept:TipoReparto.values()){//el tipo de aqui es solo un string
           // System.out.println("Enum constant-> "+dept+" with ordinal value-> "+dept.ordinal());
            
            if(tipo.equals(dept.getNombre())) {
            	this.tipo=dept; //this tipo es el tiporeparto
            }
            
        }
        
        for(Poblacion po:Poblacion.values()) {
        	if(poblacion.equals(po.getNombre())) {
        		this.poblacion=po;
        	}
        }
        
        
        this.id_recorrido=id_recorrido;
        
        
     
        
       this.button = new JButton(name.substring(0, 1));
        this.getButton().setSize(24, 24);
        this.getButton().setPreferredSize(new Dimension(24, 24));
        
       this.getButton().addMouseListener(new SwingWaypointMouseListener(this));
        
        if(this.getTipo().getColor()!= null) {
        	this.getButton().setBackground(this.getTipo().getColor());
        }
        
        
        if(this.getTipo()==null) {
        	this.tipo=TipoReparto.Ninguno;
        }
        
        if(this.getPoblacion()==null) {
        	this.poblacion=Poblacion.Ninguno;

        }
        
        
        
        this.getButton().setVisible(true);
    }


    

	JButton getButton() {
        return button;
    }
    
	public String getLabel() {
		return nombre;
	}


	
	public String getNotes() {
		return notas;
	}

	public void setNotes(String notes) {
		this.notas = notes;
	}

	public String getDirection() {
		return direccion;
	}

	public void setDirection(String direction) {
		this.direccion = direction;
	}

	public String getName() {
		return nombre;
	}

	public Integer getId_recorrido() {
		return id_recorrido;
	}

	public void setId_recorrido(Integer id_recorrido) {
		this.id_recorrido = id_recorrido;
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

	public String getNombre() {
		return nombre;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	public Poblacion getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Poblacion poblacion) {
		this.poblacion = poblacion;
	}

	public TipoReparto getTipo() {
		return tipo;
	}

	public void setTipo(TipoReparto tipo) {
		this.tipo = tipo;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNombre();
	}

	
	

}
