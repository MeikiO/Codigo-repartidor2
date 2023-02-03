import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pelicula extends JPanel{

	String nombre,director, nacionalidad,genero, imagen;
	int año;
	public Pelicula(String imagen, String nombre, int año, String director, String nacionalidad, String genero) {
		super(new GridLayout(1,2));
		this.imagen="caratulas/"+imagen;
		this.nombre = nombre;
		this.director = director;
		this.nacionalidad = nacionalidad;
		this.genero = genero;
		this.año = año;
		this.add(new ImagePanel(this.imagen));
		this.add(crearPanelDatos());
		this.setPreferredSize(new Dimension(300,200));
	}
	private Component crearPanelDatos() {
		JPanel panel =new JPanel(new GridLayout(5,1));
		JLabel lbTitulo=new JLabel(nombre);
		JLabel lbAño=new JLabel(""+año);
		JLabel lbDirector=new JLabel(director);
		JLabel lbNacionalidad=new JLabel(nacionalidad);
		JLabel lbGenero=new JLabel(genero);
		panel.add(lbTitulo);
		panel.add(lbAño);
		panel.add(lbDirector);
		panel.add(lbNacionalidad);
		panel.add(lbGenero);
		return panel;
	}
	
}
