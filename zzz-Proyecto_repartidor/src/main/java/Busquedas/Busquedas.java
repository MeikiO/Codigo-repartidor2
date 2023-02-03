package Busquedas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mapas.SwingWaypoint;
import modelo.GestorGrupos;
import modelo.Usuario;

public class Busquedas {

	
	public Busquedas() {
		// TODO Auto-generated constructor stub
	}
	
	public int buscarPosicionUsuarioPorIdentificativo(List<Usuario> list , String identificativo) {
		int cuenta=0,posicion=0;
		
		for(Usuario elemento : list) {
			if(elemento.getUsername().equals(identificativo)) {
				posicion=cuenta;
			}
			
			cuenta++;
		}
			
			
		return posicion;
	}

	public int buscarPosicionPuntoPorNombre(SwingWaypoint puntoElegido, GestorGrupos gestor) {
		// TODO Auto-generated method stub
		int cuenta=0,posicion=0;
		Set<SwingWaypoint> lista=new HashSet<>();
		
		lista=gestor.getListaGrupo().get(puntoElegido.getId_recorrido()).getListaRecorrido().get(0).getWaypoints();
		
		for(SwingWaypoint elemento :lista) {
			
			if(elemento.equals(puntoElegido)) {
				posicion=cuenta;
			}
			
			cuenta++;
			
		}
		
		return posicion;
	}




}
