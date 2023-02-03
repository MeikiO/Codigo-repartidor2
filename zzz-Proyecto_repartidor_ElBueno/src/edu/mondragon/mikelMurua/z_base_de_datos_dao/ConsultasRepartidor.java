package z_base_de_datos_dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import z_modelo_equipo_repartidores.Repartidor;



public class ConsultasRepartidor implements ObjetoDao<Repartidor> {

	private ConexionDatabase conexionDatabase;

	@Override
	public void demo() {
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		try {
			 
			String query="SELECT * FROM `aplicacion_reparto`.`repartidor`";
			 ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(query);
			
				while (myRe.next()) {
					System.out.print(
							myRe.getInt("iduser")+"\n"+
							myRe.getString("nombre")+"\n"+
							myRe.getString("apellido")+"\n"+
							myRe.getString("dni")+"\n"+
							myRe.getString("direccion")+"\n"+
							myRe.getString("tlf")+"\n"+
							myRe.getString("zona_trabajo")+"\n"+
							myRe.getString("username")+"\n"+
							myRe.getString("password")+"\n"+
							myRe.getBoolean("admin")+"\n"+
							myRe.getInt("idEquipo"));					
				}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}

	@Override
	public boolean registrarEnDatabase(Repartidor user) {
		boolean entradaFalsa=false;
		
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		try {
		
			String sql="INSERT INTO `Repartidor` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`idEquipo`)\r\n"
				+ "VALUES (\""+user.getNombre()+"\""
				+ ",\""+user.getApellido()+"\",\""+user.getDni()+"\""
				+ ",\""+user.getDireccion()+"\",\""+user.getTlf()+"\""
				+ ",\""+user.getZona_trabajo().name()+"\",\""+user.getUsername()+"\",\""+user.getPassword()+"\",false,"+user.getIdEquipo()+")";
		
			this.getConnect().getMyStat().executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
			entradaFalsa=true;
		}
		
		this.conexionDatabase.disconnect();
		
		return entradaFalsa;
	}
	
	
	@Override
	public List<Repartidor> cargarTodosLosElementos() {
		List<Repartidor> lista=new ArrayList<>();
		
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		try {
			
			String query="SELECT * FROM `aplicacion_reparto`.`repartidor`";
				
			ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(query);
			
			while (myRe.next()) {
				
				Repartidor nuevo=new Repartidor(
						myRe.getInt("iduser"),
						myRe.getString("nombre"),
						myRe.getString("apellido"),
						myRe.getString("dni"),
						myRe.getString("direccion"),
						myRe.getString("tlf"),
						myRe.getString("zona_trabajo"),
						myRe.getString("username"),
						myRe.getString("password"),
						myRe.getBoolean("admin"),
						myRe.getInt("idEquipo")
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
	
	@Override
	public void actualizar(Repartidor elegido) {
		
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		
		try {
	
			String sql="UPDATE `repartidor` \r\n"
					+ "	SET \r\n"
					+ "    `nombre`='"+elegido.getNombre()+"',\r\n"
					+ "    `apellido`='"+elegido.getApellido()+"',\r\n"
					+ "     `dni`='"+elegido.getDni()+"',\r\n"
					+ "     `direccion`='"+elegido.getDireccion()+"',\r\n"
					+ "     `tlf`='"+elegido.getTlf()+"',\r\n"
					+ "     `zona_trabajo`='"+elegido.getZona_trabajo().name()+"',\r\n"
					+ "     `username`='"+elegido.getUsername()+"',\r\n"
					+ "     `password`='"+elegido.getPassword()+"',\r\n"
					+ "     `idEquipo`="+elegido.getIdEquipo()+"\r\n"
					+ "WHERE `iduser` = "+elegido.getId_repartidor()+"";
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
			 
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}
	
	@Override
	public void actualizarLista(List<Repartidor> listaElementos) {
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		
		try {
	
			for(Repartidor elegido:listaElementos) {
				
				String sql="UPDATE `repartidor` \r\n"
						+ "	SET \r\n"
						+ "    `nombre`='"+elegido.getNombre()+"',\r\n"
						+ "    `apellido`='"+elegido.getApellido()+"',\r\n"
						+ "     `dni`='"+elegido.getDni()+"',\r\n"
						+ "     `direccion`='"+elegido.getDireccion()+"',\r\n"
						+ "     `tlf`='"+elegido.getTlf()+"',\r\n"
						+ "     `zona_trabajo`='"+elegido.getZona_trabajo().name()+"',\r\n"
						+ "     `username`='"+elegido.getUsername()+"',\r\n"
						+ "     `password`='"+elegido.getPassword()+"',\r\n"
						+ "     `idEquipo`="+elegido.getIdEquipo()+"\r\n"
						+ "WHERE `iduser` = "+elegido.getId_repartidor()+"";
				
				int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
			} 
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}
	
	
	@Override
	public void borrarElemento(Repartidor elegido) {
	
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		
		try {
			
			String sql="DELETE FROM  `repartidor` where `iduser`="+elegido.getId_repartidor()+"";
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}
	
	public Repartidor comprobarCertificados(String username, String password) {
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		Repartidor existente=null;
		
		try {
			String query="SELECT * FROM `aplicacion_reparto`.`repartidor`\r\n"
					+ "WHERE `username`=\""+username+"\" and `password`=\""+password+"\";";
			ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(query);
			
			if (myRe.next()) {
				existente=new Repartidor(
						myRe.getInt("iduser"),
						myRe.getString("nombre"),
						myRe.getString("apellido"),
						myRe.getString("dni"),
						myRe.getString("direccion"),
						myRe.getString("tlf"),
						myRe.getString("zona_trabajo"),
						myRe.getString("username"),
						myRe.getString("password"),
						myRe.getBoolean("admin"),
						myRe.getInt("idEquipo")
						);	
			} 
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		this.conexionDatabase.disconnect();
		
		return existente;
	}
	
	public ConexionDatabase getConnect() {
		return conexionDatabase;
	}

	public void setConnect(ConexionDatabase connect) {
		this.conexionDatabase = connect;
	}

}

