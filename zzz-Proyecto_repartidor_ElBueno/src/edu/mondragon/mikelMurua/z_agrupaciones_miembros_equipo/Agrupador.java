package z_agrupaciones_miembros_equipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agrupador {

	public Agrupador() {
	}

	public <T> Map<Integer, List<T>> agrupar(Selector selectorPrincipal,List<T> listaAgrupar) {
		
		Map<Integer,List<T>>mapAgrupaciones = new TreeMap<>();
		
		try {
			
			for (T actual: listaAgrupar){
				Integer clavePrimaria = selectorPrincipal.getElemento(actual);
				List<T> listaEquipos = mapAgrupaciones.get(clavePrimaria);
				if (listaEquipos == null) {
					listaEquipos = new ArrayList<>();
				}
				
				listaEquipos.add(actual);
				
				mapAgrupaciones.put(clavePrimaria, listaEquipos);
			}
		}
		catch(java.lang.NullPointerException e) {
			e.printStackTrace();
		}
		
		return mapAgrupaciones;
	}
	
}
