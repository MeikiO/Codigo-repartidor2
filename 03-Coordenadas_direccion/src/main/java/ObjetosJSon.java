import java.util.List;

public class ObjetosJSon {
	List<RespuestaAPI> data;
	
	public ObjetosJSon(List<RespuestaAPI> data) {
		this.data=data;
	}

	public List<RespuestaAPI> getListaCoordenadas() {
		return data;
	}

	public void setListaCoordenadas(List<RespuestaAPI> listaCoordenadas) {
		this.data = listaCoordenadas;
	}
	
	
	
}
