
public class CoordenadasToDMS {
	private double coordenadasLatitud;
	private double coordenadasLongitud;
	
	private DMS latitudDMS;
	private DMS longitudDMS;

	
	public CoordenadasToDMS(double latitud, double longitud) {
		this.coordenadasLatitud=latitud;
		this.coordenadasLongitud=longitud;
		
		this.latitudDMS=new DMS(latitud);
		this.longitudDMS=new DMS(longitud);
		
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


	public DMS getLatitudDMS() {
		return latitudDMS;
	}


	public void setLatitudDMS(DMS latitudDMS) {
		this.latitudDMS = latitudDMS;
	}


	public DMS getLongitudDMS() {
		return longitudDMS;
	}


	public void setLongitudDMS(DMS longitudDMS) {
		this.longitudDMS = longitudDMS;
	}


	
	
	
}
