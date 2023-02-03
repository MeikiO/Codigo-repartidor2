import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Grupo extends JPanel implements ActionListener,Serializable {
	JButton flechaIzq, flechaDer;
	Modelo modelo;
	GruposPBL vista;
	JList<Alumno> lista;
	List<Alumno> listaAlumnos;
	JScrollPane panel;
	
public Grupo(int i, GruposPBL vista) {
	this.listaAlumnos=new ArrayList<>();
	this.vista=vista;
	this.modelo=new Modelo();
	this.lista=new JList<>(this.modelo);
	this.lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
			(BorderFactory.createLoweredBevelBorder(),"Grupo "+i),
			BorderFactory.createEmptyBorder(1,1,1,1)));
	this.add(crearBotonesGrupo(), BorderLayout.WEST);
	this.add(crearListaGrupo(), BorderLayout.CENTER);
	
	
}


private Component crearBotonesGrupo() {
	JPanel panel= new JPanel(new GridLayout(2,1,1,1));
	
	flechaIzq = new JButton(new ImageIcon("icons/2leftarrow.png"));
	flechaIzq.setActionCommand("izda");
	flechaIzq.addActionListener(this);
	
	flechaDer = new JButton(new ImageIcon("icons/2rightarrow.png"));
	flechaDer.setActionCommand("dcha");
	flechaDer.addActionListener(this);
	
	panel.add(flechaDer);
	panel.add(flechaIzq);
		
	return panel;
}


private Component crearListaGrupo() {
	panel= new JScrollPane();
	panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	panel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
	panel.setViewportView(lista);

	
	return panel;
}


@Override
public void actionPerformed(ActionEvent evt) {
	
	switch(evt.getActionCommand()) {
	case "izda":{
		List<Alumno> alumnos=this.lista.getSelectedValuesList();
		for(Alumno a:alumnos) {
			this.vista.listAlumnos.add(a);
			this.vista.getModelo().addElement(a);
			this.vista.listaAlumnos.repaint();
			
			this.modelo.removeElement(a);
			this.listaAlumnos.remove(a);
			this.lista.repaint();
		}
		
		
		
	}break;
	
	case "dcha":{
		List<Alumno> alumnos=new ArrayList<>();
		alumnos=this.vista.getListaAlumnos().getSelectedValuesList();
		for(Alumno a:alumnos) {
		this.modelo.addElement(a);
		this.listaAlumnos.add(a);
		this.lista.repaint();
		
		this.vista.getModelo().removeElement(a);
		this.vista.listAlumnos.remove(a);
		this.vista.listaAlumnos.repaint();
		
		}
	}break;
	}
	
}


public JList<Alumno> getLista() {
	return lista;
}


public void setLista(JList<Alumno> lista) {
	this.lista = lista;
}


public void setVista(GruposPBL vista) {
	this.vista = vista;
}


public List<Alumno> getListaAlumnos() {
	return listaAlumnos;
}


public void setListaAlumnos(List<Alumno> listaAlumnos) {
	this.listaAlumnos = listaAlumnos;
}
}
