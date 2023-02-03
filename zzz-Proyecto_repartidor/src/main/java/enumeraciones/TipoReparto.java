package enumeraciones;

import java.awt.Color;

public enum TipoReparto {

	Ninguno("",Color.white),
	Berria("berria",Color.BLUE),
	Argia("argia",Color.RED);
	
	
	private Color color;
	private String nombre;

	private TipoReparto(String nombre,Color color) {
		// TODO Auto-generated constructor stub
	
		this.nombre=nombre;
		this.color=color;
	}

	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
