package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout.Group;

import controladores.ControlerPantallaJefe;
import mapas.SwingWaypoint;

public class GestorGrupos {

	
	public int NUMGRUPOS;
	
	public List<Grupo> listaGrupo;
	
	public Grupo selectedGroup;
	
	public Usuario selectedUser;


	public SwingWaypoint selectedWaypoint;

	
	
	public GestorGrupos(Integer gROUPNUM) {
		// TODO Auto-generated constructor stub
		
		
		this.NUMGRUPOS = gROUPNUM;
		
		this.listaGrupo=new ArrayList<>();
		
		this.inicializarGrupos();
		
		if(this.listaGrupo.isEmpty()) {
			this.selectedGroup=new Grupo(0);
		}
		else {
			this.selectedGroup=this.listaGrupo.get(1); //inicializamos para que coga el primero de default
		}
		
		
		this.selectedUser=new Usuario();
		
		if(!this.listaGrupo.get(1).getListaRecorrido().get(0).getWaypoints().isEmpty()) {
			this.selectedWaypoint=this.listaGrupo.get(1).getListaRecorrido().get(0).getWaypoints().iterator().next();
			
		}
	}
	
	
	public void inicializarGrupos() {	
		for(int i=0;i<=this.getNUMGRUPOS();i++) {
		    Grupo grupo=new Grupo(i,i+". ero");	
		    this.getListaGrupo().add(grupo);
		}	
	}


	

	public int getNUMGRUPOS() {
		return NUMGRUPOS;
	}


	public void setNUMGRUPOS(int nUMGRUPOS) {
		NUMGRUPOS = nUMGRUPOS;
	}


	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}


	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
	}


	public Grupo getSelectedGroup() {
		return selectedGroup;
	}


	public void setSelectedGroup(Grupo selectedGroup) {
		this.selectedGroup = selectedGroup;
	}


	public Usuario getSelectedUser() {
		return selectedUser;
	}


	public void setSelectedUser(Usuario selectedUser) {
		this.selectedUser = selectedUser;
	}


	public SwingWaypoint getSelectedWaypoint() {
		return selectedWaypoint;
	}


	public void setSelectedWaypoint(SwingWaypoint selectedWaypoint) {
		this.selectedWaypoint = selectedWaypoint;
	}









	
	
}
