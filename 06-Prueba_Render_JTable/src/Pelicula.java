import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pelicula extends JPanel{

	String nombre,director, nacionalidad,genero, imagen;
	int a�o;
	public Pelicula(String imagen, String nombre, int a�o, String director, String nacionalidad, String genero) {
		super(new GridLayout(1,2));
		this.imagen="caratulas/"+imagen;
		this.nombre = nombre;
		this.director = director;
		this.nacionalidad = nacionalidad;
		this.genero = genero;
		this.a�o = a�o;
		this.add(new ImagePanel(this.imagen));
		this.add(crearPanelDatos());
		this.setPreferredSize(new Dimension(300,200));
	}
	private Component crearPanelDatos() {
		JPanel panel =new JPanel(new GridLayout(5,1));
		JLabel lbTitulo=new JLabel(nombre);
		JLabel lbA�o=new JLabel(""+a�o);
		JLabel lbDirector=new JLabel(director);
		JLabel lbNacionalidad=new JLabel(nacionalidad);
		JLabel lbGenero=new JLabel(genero);
		panel.add(lbTitulo);
		panel.add(lbA�o);
		panel.add(lbDirector);
		panel.add(lbNacionalidad);
		panel.add(lbGenero);
		return panel;
	}
	
}
