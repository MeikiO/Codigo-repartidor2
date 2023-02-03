package modelo;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Usuario extends DefaultListModel{

	
	private boolean admin;
	private String password;
	private String username;
	private String zona_trabajo;
	private String tlf;
	private String direccion;
	private String dni;
	private String apellido;
	private String nombre;
	private int id_grupo;

	public Usuario(String nombre,String apellido, String dni,String direccion
			,String tlf,String zona_trabajo,String username,String password,boolean admin,int id_grupo) {
		// TODO Auto-generated constructor stub
		super();
		
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
		this.direccion=direccion;
		this.tlf=tlf;
		this.zona_trabajo=zona_trabajo;
		this.username=username;
		this.password=password;
		this.admin=admin;
		this.id_grupo=id_grupo;
	
	}
	
	

	public Usuario() {
		// TODO Auto-generated constructor stub
	}



	public JPanel crearPanelDatos() {
		
		JPanel panel =new JPanel(new GridLayout(5,2));
		
		JLabel n=new JLabel("Nombre: ");
		JLabel lnombre=new JLabel(this.getNombre()+" "+this.getApellido());
		
		JLabel d=new JLabel("Dni: ");
		JLabel ldni=new JLabel(this.getDni());
		
		JLabel di=new JLabel("Direccion: ");
		JLabel ldireccion=new JLabel(this.getDireccion());
		
		JLabel t=new JLabel("Telefono: ");
		JLabel ltlf=new JLabel(this.getTlf());
		
		JLabel tr=new JLabel("Zona trabajo: ");
		JLabel lzonaTrabajo=new JLabel(this.getZona_trabajo());
		
		panel.add(n);
		panel.add(lnombre);
		
		panel.add(d);
		panel.add(ldni);
		
		panel.add(di);
		panel.add(ldireccion);
		
		panel.add(t);
		panel.add(ltlf);
		
		panel.add(tr);
		panel.add(lzonaTrabajo);
	
		return panel;
	}
	

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getZona_trabajo() {
		return zona_trabajo;
	}

	public void setZona_trabajo(String zona_trabajo) {
		this.zona_trabajo = zona_trabajo;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ""+this.getNombre()+" "+this.getApellido();
	}



	public void actualizar(Usuario user) {
		// TODO Auto-generated method stub
		
		this.setApellido(user.getApellido());
		this.setDireccion(user.getDireccion());
		this.setDni(user.getDni());
		this.setNombre(user.getNombre());
		this.setTlf(user.getTlf());
		this.setZona_trabajo(user.getZona_trabajo());
	}

	




	
	
	
	
}
