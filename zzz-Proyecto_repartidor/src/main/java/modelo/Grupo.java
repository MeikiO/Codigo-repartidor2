package modelo;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import base_de_datos.UsersData;
import interfaces.VentanaMover;
import mapas.Recorrido;

public class Grupo extends DefaultListModel{

	public List<Recorrido> listaRecorrido;
	public List<Usuario> listaUsuario;
	public int idGrupo;
	public String identificativo;
	public UsersData usersD;
	public DefaultListModel modelo;
	public JList lista;
	
	
	public Grupo(int idGrupo) {
		// TODO Auto-generated constructor stub
		this.idGrupo=idGrupo;
		
		listaUsuario=new ArrayList<>();

		modelo=new ModeloUsuario(this.getIdGrupo());
		lista=new JList<>(this.getModelo());
		this.getLista().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		
		this.iniializarRecorrido();
		
		
		this.inicializarListaUsuarios();
		
		
	}
	
	public Grupo(int idGrupo,String identificativo) {
		// TODO Auto-generated constructor stub
		this.idGrupo=idGrupo;

		this.identificativo=identificativo;
		
		listaUsuario=new ArrayList<>();
		
		modelo=new ModeloUsuario(this.getIdGrupo());
		lista=new JList<>(this.getModelo());
		this.getLista().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		

		this.iniializarRecorrido();
		
		this.inicializarListaUsuarios();
		
	}

	private void iniializarRecorrido() {
		
		Recorrido recorrido=new Recorrido(this.getIdGrupo());
		
		this.listaRecorrido=new ArrayList<>();
		
		this.getListaRecorrido().add(recorrido);
		
	}
	
	private void inicializarListaUsuarios() {
		// TODO Auto-generated method stub
		
		//cargar todos los usuarios de un grupo concreto (teniendo en cuenta el id_grupo) los que tengan el mismo id_grupo que este grupo
		
		this.listaUsuario=new ArrayList<>();
		
		this.usersD=new UsersData();
		
		this.getUsersD().cargarUsuariosDelGrupo(this.getListaUsuario(),this.getIdGrupo());
		
		
	}
	
	
	

	
	public <T> Component crearPanelGrupo(VentanaMover<T> ventanaMover, List<T> listaElementosIzquierda) {
		// TODO Auto-generated method stub
		JPanel panel=new JPanel();
		
		panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder
				(BorderFactory.createLoweredBevelBorder(),"Grupo "+this.getIdGrupo()),
				BorderFactory.createEmptyBorder(1,1,1,1)));
		panel.add(crearBotonesGrupo(ventanaMover), BorderLayout.WEST);
		panel.add(crearListaGrupo(listaElementosIzquierda), BorderLayout.CENTER);
		
		
		return panel;
	}
	
	

	private Component crearBotonesGrupo(VentanaMover ventanGrupos) {
		JPanel panel= new JPanel(new GridLayout(2,1,1,1));
		
		JButton flechaIzq = new JButton(new ImageIcon(".\\resources\\images\\1leftarrow.png"));
		flechaIzq.setActionCommand("izda "+this.getIdGrupo());
		flechaIzq.addActionListener(ventanGrupos.getControler());
		
		JButton flechaDer = new JButton(new ImageIcon(".\\resources\\images\\1rightarrow.png"));
		flechaDer.setActionCommand("dcha "+this.getIdGrupo());
		flechaDer.addActionListener(ventanGrupos.getControler());
		
		panel.add(flechaDer);
		panel.add(flechaIzq);
			
		return panel;
	}

	private <T> Component crearListaGrupo(List<T> listaElementosIzquierda) {
		// TODO Auto-generated method stub
		this.lista=this.cargarLista(listaElementosIzquierda);
		
		JScrollPane panel= new JScrollPane();
		panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		panel.setViewportView(this.getLista());

		
		return panel;
	}
	private <T> JList cargarLista(List<T> listaElementosIzquierda) {
		// TODO Auto-generated method stub
		this.modelo=new DefaultListModel();
		
		JList lista=new JList<>(this.getModelo());
		lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		
		for(T elemento: listaElementosIzquierda) {
			this.getModelo().addElement(elemento);
		}
		
		lista.setModel(this.getModelo());
		
		return lista;
	}


	
	

	public List<Recorrido> getListaRecorrido() {
		return listaRecorrido;
	}

	public void setListaRecorrido(List<Recorrido> listaRecorrido) {
		this.listaRecorrido = listaRecorrido;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}



	public String getIdentificativo() {
		return identificativo;
	}



	public void setIdentificativo(String identificativo) {
		this.identificativo = identificativo;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public UsersData getUsersD() {
		return usersD;
	}

	public void setUsersD(UsersData usersD) {
		this.usersD = usersD;
	}

	public DefaultListModel getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel modelo) {
		this.modelo = modelo;
	}

	public JList getLista() {
		return lista;
	}

	public void setLista(JList lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.identificativo;
	}


	
	
	
	
	
}
