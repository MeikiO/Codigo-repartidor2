package factories;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import base_de_datos.PuntosData;
import base_de_datos.UsersData;
import interfaces.VRecorrido;
import interfaces.VentanaIntegrantes;
import mapas.SwingWaypoint;
import modelo.GestorGrupos;
import modelo.Grupo;
import modelo.Usuario;


	

public class FactoryMovimientos {

	private static GestorGrupos gestor;


	
	public FactoryMovimientos(GestorGrupos gestor2) {
		// TODO Auto-generated constructor stub
		this.gestor=gestor2;
	}

	public static SelectorUsuarios getUsuarios(){
		return new SelectorUsuarios();
	}
	
	public static SelectorPuntos getPuntos(){
		return new SelectorPuntos();
	}

	
	public static class SelectorUsuarios<T> extends FactoryMovimientos implements MoverElementos {

		
		public SelectorUsuarios() {
			super(gestor);
			// TODO Auto-generated constructor stub
		}

		@Override
		public List<T> cogerLista0() {
			// TODO Auto-generated method stub
			return (List<T>) this.getGestor().getListaGrupo().get(0).getListaUsuario();
		}

		@Override
		public List<T> cogerListaGrupo(int idGrupo) {
			// TODO Auto-generated method stub
			return (List<T>) this.getGestor().getListaGrupo().get(idGrupo).getListaUsuario();
		}

		@Override
		public GestorGrupos getGestor() {
			// TODO Auto-generated method stub
			return gestor;
		}

		@Override
		public void guardarEnDatabase(Grupo g) {
			// TODO Auto-generated method stub
			UsersData database=new UsersData();
			
			for(Usuario elemento:g.getListaUsuario()) {
				database.actualizarGrupoUsuario(elemento);
			}
			
		}

		@Override
		public void volver() {
			// TODO Auto-generated method stub
			VentanaIntegrantes ventana=new VentanaIntegrantes(gestor);
			
		}
		
	}
	
	

	public static class SelectorPuntos<T> extends FactoryMovimientos implements MoverElementos  {

		
		public SelectorPuntos() {
			super(gestor);
			// TODO Auto-generated constructor stub
		}

		@Override
		public List<T> cogerLista0() {
			// TODO Auto-generated method stub
			return this.pasarSetALista(this.getGestor().getListaGrupo().get(0).getListaRecorrido().get(0).getWaypoints());
		}

		@Override
		public List<T> cogerListaGrupo(int idGrupo) {
			// TODO Auto-generated method stub
			return this.pasarSetALista(this.getGestor().getListaGrupo().get(idGrupo).getListaRecorrido().get(0).getWaypoints());
		}

		@Override
		public GestorGrupos getGestor() {
			// TODO Auto-generated method stub
			return gestor;
		}
		
		public List<T> pasarSetALista(Set<SwingWaypoint> set){
		    Set<SwingWaypoint> a = set;
		    List<T> arr= (List<T>) a.stream().collect(Collectors.toList());

	        return arr;
			
		}

		@Override
		public void guardarEnDatabase(Grupo g) {
			// TODO Auto-generated method stub
			PuntosData database=new PuntosData();
			
			for(SwingWaypoint elemento:g.getListaRecorrido().get(0).getListaWaypoints()) {
				database.actualizarPunto(elemento);
			}
		}

		@Override
		public void volver() {
			// TODO Auto-generated method stub
			VRecorrido pantalla=new VRecorrido(gestor);
		}
		
	}
	

}
