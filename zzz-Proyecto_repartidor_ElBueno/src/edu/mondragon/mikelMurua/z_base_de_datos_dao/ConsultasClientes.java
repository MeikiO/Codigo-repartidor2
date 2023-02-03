package z_base_de_datos_dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jxmapviewer.viewer.GeoPosition;

import z_enumeraciones.TipoReparto;
import z_modelo_equipo_repartidores.Cliente;

public class ConsultasClientes implements ObjetoDao<Cliente> {

	ConexionDatabase conexionDatabase;
		
	public ConsultasClientes() {
		this.conexionDatabase=new ConexionDatabase();
	}
	
	@Override
	public void demo() {
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		try {
			
		String query="select * from `cliente`";
			
		 ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(query);
		
			while (myRe.next()) {
				System.out.print(
						myRe.getString("idEquipo")+" \n "
						+myRe.getFloat("latitud")+" \n "
						+myRe.getFloat("longitud")+" \n "
						+myRe.getString("direccion")+" \n "
						+myRe.getString("nombre_cliente")+" \n "
						+myRe.getString("llaves")+" \n "
						+myRe.getString("como_dejarlo")+" \n "
						+myRe.getString("notas")+" \n "
						+myRe.getString("dias")+" \n"
						+myRe.getString("poblacion")+" \n"
						+myRe.getString("lista_productos")+" \n"
						+myRe.getString("dias_completados")+" \n"
					);	
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}
	
	@Override
	public boolean registrarEnDatabase(Cliente objeto) {
		boolean entradaFalsa=false;
		
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		try {
			
			String sql="INSERT INTO `cliente` (	`idEquipo`,`latitud` ,`longitud` ,\r\n"
					+ "    `direccion`,`nombre_cliente`,`llaves`,`como_dejarlo`,\r\n"
					+ "    `notas`,`dias` ,`poblacion`,`lista_productos`,`dias_completados`)\n"
					+ "VALUES ("+objeto.getIdEquipo()+","+objeto.getPosition().getLatitude()+","+objeto.getPosition().getLongitude()+", \""
					+objeto.getDireccion()+"\", \""+objeto.getNombre_cliente()+"\", \""+objeto.getLlaves()+"\",\r\n"
					+ "\""+objeto.getComo_dejarlo()+"\",\""+objeto.getNotas()+"\",\""+objeto.getDias()+"\",\""
					+objeto.getPoblacion()+"\",\""+objeto.leerListaProductos()+"\",\""+objeto.getDiasCompletados()+"\")";
		
			this.getConnect().getMyStat().executeUpdate(sql);
						
		} catch (SQLException e) {
			e.printStackTrace();
			entradaFalsa=true;
		}
		
		this.conexionDatabase.disconnect();
		
		return entradaFalsa;
	}

	
	@Override
	public List<Cliente> cargarTodosLosElementos() {
		
		List<Cliente> lista=new ArrayList<>();
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		
		try {
			
			String query="select * from `cliente`";
				
			ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(query);
			
			while (myRe.next()) {
				GeoPosition posicion=new GeoPosition(myRe.getFloat("latitud"),
				myRe.getFloat("longitud"));
				    
				List<TipoReparto> listaProductos=TipoReparto.cogerCadena(myRe.getString("lista_productos"));
					
				Cliente nuevo=new Cliente(
						myRe.getInt("id_cliente"),
						myRe.getInt("idEquipo"),
						myRe.getString("nombre_cliente"),
						myRe.getString("direccion"),
						myRe.getString("llaves"),
						myRe.getString("como_dejarlo"),
						myRe.getString("notas"),
						myRe.getString("dias"),
						myRe.getString("poblacion"),
						listaProductos,
						posicion,
						myRe.getString("dias_completados")
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
	public void actualizar(Cliente elegido) {
		
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		
		try {
			
			String productos=elegido.leerListaProductos();
		
			String sql="UPDATE `cliente` SET \r\n"
					+ "`idEquipo`="+elegido.getIdEquipo()+",\r\n"
					+ "`latitud` ="+elegido.getPosition().getLatitude()+",\r\n"
					+ "`longitud` ="+elegido.getPosition().getLongitude()+",\r\n"
					+ "    `direccion`='"+elegido.getDireccion()+"',\r\n"
					+ "    `nombre_cliente`='"+elegido.getNombre_cliente()+"',\r\n"
					+ "    `llaves`='"+elegido.getLlaves()+"',\r\n"
					+ "    `como_dejarlo`='"+elegido.getComo_dejarlo()+"',\r\n"
					+ "    `notas`='"+elegido.getNotas()+"',\r\n"
					+ "    `dias`='"+elegido.getDias()+"',\r\n"
					+ "    `poblacion`='"+elegido.getPoblacion().name()+"',\r\n"
					+ "    `lista_productos`='"+productos+"',\r\n"
					+ "    `dias_completados`='"+elegido.getDiasCompletados()+"'\r\n"
					+ "    WHERE `id_cliente` ="+elegido.getId_cliente();
			
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
				
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}
	
	public void actualizarNotas(Cliente elegido) {
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		
		try {
			
			String productos=elegido.leerListaProductos();
			
			String sql="UPDATE `cliente` SET \r\n"
					+ "    `notas`=' "+elegido.getNotas()+" '"
					+ "    WHERE `id_cliente` ="+elegido.getId_cliente();
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}
	

	@Override
	public void actualizarLista(List<Cliente> listaElementos) {
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		
		try {
	
			for(Cliente elegido:listaElementos) {
				
				String productos=elegido.leerListaProductos();
				
				String sql="UPDATE `cliente` SET \r\n"
						+ "`idEquipo`="+elegido.getIdEquipo()+",\r\n"
						+ "`latitud` ="+elegido.getPosition().getLatitude()+",\r\n"
						+ "`longitud` ="+elegido.getPosition().getLongitude()+",\r\n"
						+ "    `direccion`='"+elegido.getDireccion()+"',\r\n"
						+ "    `nombre_cliente`='"+elegido.getNombre_cliente()+"',\r\n"
						+ "    `llaves`='"+elegido.getLlaves()+"',\r\n"
						+ "    `como_dejarlo`='"+elegido.getComo_dejarlo()+"',\r\n"
						+ "    `notas`='"+elegido.getNotas()+"',\r\n"
						+ "    `dias`='"+elegido.getDias()+"',\r\n"
						+ "    `poblacion`='"+elegido.getPoblacion().name()+"',\r\n"
						+ "    `lista_productos`='"+productos+"',\r\n"
						+ "    `dias_completados`='"+elegido.getDiasCompletados()+"'\r\n"
						+ "    WHERE `id_cliente`="+elegido.getId_cliente();
				
				int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
			} 
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}
	
	@Override
	public void borrarElemento(Cliente elegido) {
		this.conexionDatabase=new ConexionDatabase();
		this.conexionDatabase.connect();
		
		try {
			
			String sql="DELETE FROM  `aplicacion_reparto`.`cliente` WHERE `id_cliente`="+elegido.getId_cliente()+"";
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		this.conexionDatabase.disconnect();
	}
	
	public ConexionDatabase getConnect() {
		return conexionDatabase;
	}

	public void setConnect(ConexionDatabase connect) {
		this.conexionDatabase = connect;
	}

}
	