package z_base_de_datos_dao;

import java.util.List;

public interface ObjetoDao<T> {
	public void demo();
	public boolean registrarEnDatabase(T objeto);
	public List<T> cargarTodosLosElementos();
	public void actualizar(T elegido);
	public void actualizarLista(List<T> listaElementos);
	public void borrarElemento(T elegido);
}
