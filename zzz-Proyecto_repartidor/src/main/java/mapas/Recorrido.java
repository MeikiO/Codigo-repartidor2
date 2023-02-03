package mapas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import org.jxmapviewer.viewer.GeoPosition;
import org.jxmapviewer.viewer.WaypointPainter;

import base_de_datos.PuntosData;




public class Recorrido {

	
	public Set<SwingWaypoint> listaWaypoints;
	private PuntosData database;
	public int idRecorrido;
	public int idGrupo;
	
	public Recorrido(int idRecorrido) {
		this.listaWaypoints = new HashSet<SwingWaypoint>();
		
		this.idRecorrido=idRecorrido;
		this.idGrupo=idRecorrido;
		
		
		//de database
		this.database=new PuntosData();
		
		this.setWaypoints(this.getDatabase().cargarPuntos(this.getIdGrupo())); 
		
	}
	
	public Recorrido() {
		// TODO Auto-generated constructor stub
		
		listaWaypoints = new HashSet<SwingWaypoint>();
	}
	


	public Painter<? super JXMapViewer> cargarREcorrido(Set<SwingWaypoint> listaWaypoints2) {
		// TODO Auto-generated method stub
		
    
        WaypointPainter<SwingWaypoint> swingWaypointPainter = new SwingWaypointOverlayPainter();   
        swingWaypointPainter.setWaypoints(listaWaypoints2);
     
        
        return swingWaypointPainter;
		
	}



	public void seMapInitialPosition(JXMapViewer mapViewer) {
		// TODO Auto-generated method stub
		   // Set the focus of the map viewer (which location shows)
        mapViewer.setZoom(10);
        mapViewer.setAddressLocation(this.getListaWaypoints().iterator().next().getPosition());
	}

	


	public Set<SwingWaypoint> getWaypoints() {
		return listaWaypoints;
	}

	public void setWaypoints(Set<SwingWaypoint> waypoints) {
		this.listaWaypoints = waypoints;
	}

	public Set<SwingWaypoint> getListaWaypoints() {
		return listaWaypoints;
	}

	public void setListaWaypoints(Set<SwingWaypoint> listaWaypoints) {
		this.listaWaypoints = listaWaypoints;
	}

	public PuntosData getDatabase() {
		return database;
	}

	public void setDatabase(PuntosData database) {
		this.database = database;
	}

	public int getIdRecorrido() {
		return idRecorrido;
	}

	public void setIdRecorrido(int idRecorrido) {
		this.idRecorrido = idRecorrido;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}


	
	
	
	
}
