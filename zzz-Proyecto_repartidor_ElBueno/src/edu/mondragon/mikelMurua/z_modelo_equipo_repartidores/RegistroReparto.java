package z_modelo_equipo_repartidores;

public class RegistroReparto {

	private int id_cliente;
	private int iduser;
	private int idEquipo;
	private String fechaHora;
	
	public RegistroReparto(int id_cliente, int iduser, int idEquipo, String momento_de_completacion) {
		this.id_cliente = id_cliente;
		this.iduser = iduser;
		this.idEquipo = idEquipo;
		this.fechaHora = momento_de_completacion;
	}
	
	public String [] toArray(int numColumnas) {
		String [] datos = new String [numColumnas];
		datos[0] = ""+this.id_cliente;
		datos[1] = ""+this.iduser;
		datos[2] = ""+this.idEquipo;
		datos[3] = this.fechaHora;
	
		return datos;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}
	
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public int getIduser() {
		return iduser;
	}
	
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	
	public int getIdEquipo() {
		return idEquipo;
	}
	
	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	public String getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	
}
