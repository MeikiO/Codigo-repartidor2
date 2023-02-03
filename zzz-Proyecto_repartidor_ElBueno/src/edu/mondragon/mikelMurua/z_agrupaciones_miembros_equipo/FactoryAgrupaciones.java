package z_agrupaciones_miembros_equipo;

import z_modelo_equipo_repartidores.Miembro;

public class FactoryAgrupaciones {

	public static Selector getSelectorIdEquipo(){
		return new SelectorIdEquipo();
	}
	
	public static class SelectorIdEquipo implements Selector<Miembro>{
	
		@Override
		public Integer getElemento(Miembro elemento) {
			return elemento.getIdEquipo();
		}
		
	}
	
}
