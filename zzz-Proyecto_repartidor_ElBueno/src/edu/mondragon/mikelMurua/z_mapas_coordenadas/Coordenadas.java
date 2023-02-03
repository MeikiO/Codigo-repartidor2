package z_mapas_coordenadas;

import org.jxmapviewer.viewer.GeoPosition;

public class Coordenadas {
	private double coordenadasLatitud;
	private double coordenadasLongitud;
	
	private GeoPosition posicion;
	
	public Coordenadas(double latitud, double longitud) {
		this.coordenadasLatitud=latitud;
		this.coordenadasLongitud=longitud;

		this.posicion=new GeoPosition(latitud, longitud);	
	}

	public double getCoordenadasLatitud() {
		return coordenadasLatitud;
	}

	public void setCoordenadasLatitud(double coordenadasLatitud) {
		this.coordenadasLatitud = coordenadasLatitud;
	}

	public double getCoordenadasLongitud() {
		return coordenadasLongitud;
	}

	public void setCoordenadasLongitud(double coordenadasLongitud) {
		this.coordenadasLongitud = coordenadasLongitud;
	}

	public GeoPosition getPosicion() {
		return posicion;
	}

	public void setPosicion(GeoPosition posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Coordenadas [coordenadasLatitud=" + coordenadasLatitud + ", coordenadasLongitud=" + coordenadasLongitud
				+ "]";
	}

}
