import java.util.List;
import java.util.Map;



public class Presidentes {

	private String nombre;
	private String estado_natal;
	private String partido;
	private List<NestedObject> mandato;


	public Presidentes(String string, String string2, String string3, List<NestedObject> mandatos) {
		// TODO Auto-generated constructor stub
		this.nombre=string;
		this.estado_natal=string2;
		this.partido=string3;
		this.mandato=mandatos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado_natal() {
		return estado_natal;
	}
	public void setEstado_natal(String estado_natal) {
		this.estado_natal = estado_natal;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public List<NestedObject> getMandato() {
		return mandato;
	}
	public void setMandato(List<NestedObject> mandato) {
		this.mandato = mandato;
	}


	
	
}
