package modelo;

import javax.swing.DefaultListModel;

public class ModeloUsuario extends DefaultListModel<Usuario> {

	private int id;

	public ModeloUsuario(int i) {
		super();
		this.setId(i);
	}

	public ModeloUsuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}

