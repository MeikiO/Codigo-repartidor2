package z_mapas_coordenadas;
import java.util.List;

public class ObjetosJSon {
	List<RespuestaAPI> data;
	
	public ObjetosJSon(List<RespuestaAPI> data) {
		this.data=data;
	}

	public List<RespuestaAPI> getData() {
		return data;
	}

	public void setData(List<RespuestaAPI> data) {
		this.data = data;
	}

}
