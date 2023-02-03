package controladores;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Busquedas.Busquedas;
import base_de_datos.UsersData;
import factories.FactoryMovimientos;
import interfaces.VentanaMover;
import interfaces.VentanaAnadir;
import interfaces.VentanaInitJefe;
import interfaces.VentanaIntegrantes;
import modelo.GestorGrupos;
import modelo.Usuario;

public class ControlerPantallaIntegrantes implements ListSelectionListener, ActionListener {
	

	public GestorGrupos gestor;
	public VentanaIntegrantes vista;
	public UsersData data;
	public VentanaAnadir venanadir;
	private String texto;


	public ControlerPantallaIntegrantes(VentanaIntegrantes ventanaIntegrantes, GestorGrupos gestor) {
		// TODO Auto-generated constructor stub
		
   	 	this.vista=ventanaIntegrantes;
		this.gestor=gestor;
		data=new UsersData();
		
	
	}	
	
	public void valueChanged(ListSelectionEvent listSelectionEvent) {
	 
		try {
			Usuario usuarioSeleccionado=this.getVista().getList().getSelectedValue();
	            
            this.getVista().getSplitPane().setRightComponent(this.getVista().panelDerecho(usuarioSeleccionado));
           
            if(usuarioSeleccionado!=null) {
                this.getGestor().setSelectedUser(usuarioSeleccionado);
            }
       }
		catch(NullPointerException e)	{
			e.printStackTrace();
		}
	           
	        
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String command= e.getActionCommand();
		
	 	 switch (command) {
				case "logo": {	
					this.getVista().dispose();
					VentanaInitJefe ven=new VentanaInitJefe(this.getGestor().getNUMGRUPOS());

						//probar que va bien y despues haz añadir/quitar y modificar 
						//email deja para cuando se haya hecho todo
						//search va despues del 1.punto
					
					break;
				}
				case "email": {	
			
					
						break;
				}
				case "search": {	
				
					
					break;
				}
	
				case "sumar": {	
					//ventana para meter informacion (usa register?)
					venanadir=new VentanaAnadir(this.getVista().getControler(),"register");		
					break;
				}
				case "register": {	
				
					//Añadir a la lista
					
					//Añadir ese elemento a la base de datos	
					
					if(this.getVenanadir().allFieldsFilled()) {
							Usuario user=new Usuario();
							user=this.getVenanadir().devolverUsuarioEntero();
						
							this.anadirElementosListas(user);
				
							//añadir en la base de datos		
							this.getData().registrarNuevoUsuarioEnDatabase(user);
									
					}
					

					System.out.print("se ha registrado");
				
					break;
				}
				case "exit": {	
					
					//Añadir a la lista
					
					//Añadir ese elemento a la base de datos	
					
					this.getVenanadir().dispose();
					
					System.out.print("se ha salido");
				
					break;
				}
				
				
				case "quitar": {	
					//quitar de la lista
					
					try {
					
						//quitar de modelo.
						
						this.getVista().getModelo().removeElement(this.getGestor().getSelectedUser());
						this.getVista().getList().repaint();
						
						
						//this.quitarDeLista(aBorrar,posicionLista);
						this.getGestor().getListaGrupo().get(this.getGestor().getSelectedGroup().getIdGrupo())
						.getListaUsuario().remove(this.getGestor().getSelectedUser());
						
						
						//quitar de la base de datos
						this.getData().borrarUsuario(this.getGestor().getSelectedUser());
						
						
					}
					catch(java.lang.NullPointerException ex) {
						ex.printStackTrace();
					}
					catch(java.lang.IndexOutOfBoundsException ex) {
						ex.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					//eliminar ese elemento concreto de la base de datos
									
					break;
				}
				case "modificar": {	
					
					venanadir=new VentanaAnadir(this.getVista().getControler(),"alterar");
					venanadir.fillAlJTextfields(this.getGestor().getSelectedUser());
					
					
					break;
				}
				case "alterar": {	
			
					if(this.getVenanadir().allFieldsFilled()) {
						
						int posicionLista=new Busquedas().buscarPosicionUsuarioPorIdentificativo(
								this.getGestor().getSelectedGroup().getListaUsuario()
								,this.getGestor().getSelectedUser().getUsername());
						
						
						Usuario user=new Usuario();
						user=this.getVenanadir().devolverUsuarioEntero();
						
						this.getVenanadir().dispose();
						
						this.getGestor().setSelectedUser(user);
						
						this.getGestor().getListaGrupo().get(this.getGestor().getSelectedGroup().getIdGrupo())
						.getListaUsuario().get(posicionLista).actualizar(user);
						
						
						//juntarlo todo en una funcion re refrescar pantalla en la clase ventana integrantes
						this.getVista().getModelo().removeAllElements();
						
						for(Usuario elemento : this.getGestor().getSelectedGroup().getListaUsuario()) {
							this.getVista().getModelo().addElement(elemento);
						}
				
				        this.getVista().getSplitPane().setRightComponent(this.getVista().panelDerecho(user));
				           
						//añadir en la base de datos
						this.getData().actualizarUsuario(user);	
				}
					
					
					System.out.print("se ha alterado");
					
					break;
				}
				
				case "grupos": {	
					
					//necesitamos una nueva ventana para hacerlo, para hacerlo
					//usa el ejercicio de gestion de alumnos de txema para hacerlo de
					//forma similar
					
					this.getVista().dispose();
					VentanaMover vgrupo=new VentanaMover(new FactoryMovimientos(this.getGestor()).getUsuarios());
					
					
					break;
				}
				
			
				default:
						break;
		 	}
 		
	 	 
	 	 
 	  
	}




	private void quitarDeLista(Usuario aBorrar, int posicionLista) {
		// TODO Auto-generated method stub
		
		//eliminar de nuestra lista
		this.getGestor().getListaGrupo().get(this.getGestor().getSelectedGroup().getIdGrupo())
		.getListaUsuario().remove(posicionLista);
		
		
		//quitar del jlist
		
		this.getVista().getModelo().removeElementAt(posicionLista);
		
	}

	private void anadirElementosListas(Usuario user) {
		// TODO Auto-generated method stub
		
		
		this.getVenanadir().dispose();
		
		//añadir a nuestra lista
		this.getGestor().getListaGrupo().get(this.getGestor().getSelectedGroup().getIdGrupo())
		.getListaUsuario().add(user);
		
		// añadir en el jlist
		this.getVista().getModelo().addElement(user);
		
	}

	public GestorGrupos getGestor() {
		return gestor;
	}

	public void setGestor(GestorGrupos gestor) {
		this.gestor = gestor;
	}

	public VentanaIntegrantes getVista() {
		return vista;
	}

	public void setVista(VentanaIntegrantes vista) {
		this.vista = vista;
	}

	public UsersData getData() {
		return data;
	}

	public void setData(UsersData data) {
		this.data = data;
	}

	public VentanaAnadir getVenanadir() {
		return venanadir;
	}

	public void setVenanadir(VentanaAnadir venanadir) {
		this.venanadir = venanadir;
	}

	
	
}

