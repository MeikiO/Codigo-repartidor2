package factories;

import java.util.List;

import modelo.GestorGrupos;
import modelo.Grupo;

public interface MoverElementos<T> {
	
	public GestorGrupos getGestor();	
	public List<T> cogerLista0();
	public List<T> cogerListaGrupo(int idGrupo);
	public void guardarEnDatabase(Grupo g);
	public void volver();

}
