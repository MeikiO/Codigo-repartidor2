package z_base_de_datos_dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import z_modelo_equipo_repartidores.Cliente;
import z_modelo_equipo_repartidores.RegistroReparto;
import z_modelo_equipo_repartidores.Repartidor;

public class ConsultasRegistros {
	private ConexionDatabase conexionDatabase;

	public ConsultasRegistros() {
		this.conexionDatabase=new ConexionDatabase();
	}

	public void registrarRepartoRealizado(Cliente cliente) {
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		Repartidor existente=null;
		
		try {
	
			String sql="INSERT INTO `registros_reparto` (`id_cliente`,`iduser` ,`idEquipo`,`fecha-hora`)\r\n"
					+ "VALUES("+cliente.getId_cliente()+","
					+cliente.getRepartidorResponsable().getId_repartidor()+","
					+cliente.getRepartidorResponsable().getIdEquipo()+",CURRENT_TIME());";

			this.getConexionDatabase().getMyStat().executeUpdate(sql);
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		this.conexionDatabase.disconnect();
	}

	
	public List<RegistroReparto> cargarTodosLosElementos() {

		List<RegistroReparto> lista=new ArrayList<>();
		
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		try {
			
			String query="select * from `registros_reparto`";
			
		 	ResultSet myRe= ((java.sql.Statement) this.getConexionDatabase().getMyStat()).executeQuery(query);
		
			while (myRe.next()) {
				
				RegistroReparto nuevo=new RegistroReparto(
						myRe.getInt("id_cliente"),
						myRe.getInt("iduser"),
						myRe.getInt("idEquipo"),
						myRe.getString("fecha-hora")
						);	
				lista.add(nuevo);
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
		
		return lista;
	}
	
	public ConexionDatabase getConexionDatabase() {
		return conexionDatabase;
	}

	public void setConexionDatabase(ConexionDatabase conexionDatabase) {
		this.conexionDatabase = conexionDatabase;
	}
	
	
}
