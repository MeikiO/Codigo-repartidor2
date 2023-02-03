package enumeraciones;

public enum Poblacion {

	Ninguno("","",""),
	Arrasate("Arrasate","Guipuzkoa","20500"),
	Vitoria("Vitoria","Araba","01001");
	
	
	
	private String codigoPostal;
	private String region;
	private String nombre;

	
	private Poblacion() {
		// TODO Auto-generated constructor stub
	}
	
	Poblacion(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	
		this.nombre=string;
		this.region=string2;
		this.codigoPostal=string3;
	
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
