package base_de_datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class UsersData {
	
	
	DatabaseConnection connect;
	
	private List<Usuario> listaUsuarios;
	
	public Integer USERNUM=0;
	
	public Integer GROUPNUM=0;

	final String USERQUERY="SELECT * FROM `aplicacionr`.`usuario`";
	
	final String COUNTQUERY="select count(`iduser`) from `aplicacionr`.`usuario`";
	
	final String COUNTGROUPSNUMBER="SELECT count(distinct `id_grupo`) FROM `aplicacionr`.`usuario` where id_grupo!=0";
	
	
	final String USERDELETEQUERY="DELETE FROM `aplicacionr`.`usuario` WHERE `username`=\"";
	
	public UsersData() {
		// TODO Auto-generated constructor stub
	
		this.connect=new DatabaseConnection();
		
		this.contarUsuarios();
		
		this.contarGrupos();
		 
	
	}
	


	public void demo() {
		try {
		 
		 ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(USERQUERY);
		
		while (myRe.next()) {
			
			System.out.print(
			myRe.getString("nombre")+" \n "
			+myRe.getString("apellido")+" \n "
			+myRe.getString("dni")+" \n "
			+myRe.getString("direccion")+" \n "
			+myRe.getString("tlf")+" \n "
			+myRe.getString("zona_trabajo")+" \n "
			+myRe.getString("username")+" \n "
			+myRe.getString("password")+" \n "
			+myRe.getString("admin")+" \n\n  "
			+myRe.getString("id_grupo"));	
		}
		 
		
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	

	public List<Usuario> cargarUsuarios() {
		
		this.listaUsuarios=new ArrayList<>();
		
		try {
		 
		 ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(USERQUERY);
		
		while (myRe.next()) {
			
			Usuario nuevo=this.cargarUsuario(myRe);
			
			this.listaUsuarios.add(nuevo);
			
		}
		 
		
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		return listaUsuarios;
	}
	
	private Usuario cargarUsuario(ResultSet myRe) throws SQLException {
		// TODO Auto-generated method stub
		boolean admin=true;
		
		if(myRe.getString("admin").equals("1")) {
			admin=true;
		}
		if(myRe.getString("admin").equals("0")) {
			admin=false;
		}
		
		Usuario nuevo=new Usuario(
				myRe.getString("nombre"),
				myRe.getString("apellido"),
				myRe.getString("dni"),
				myRe.getString("direccion"),
				myRe.getString("tlf"),
				myRe.getString("zona_trabajo"),
				myRe.getString("username"),
				myRe.getString("password"),
				admin,
				myRe.getInt("id_grupo"));
		
		return nuevo;
	}
	
	
	
	public void cargarUsuariosDelGrupo(List<Usuario> listaUsuario, int idGrupo) {
		// TODO Auto-generated method stub
		
		this.listaUsuarios=new ArrayList<>();
		
		try {
		 
		 ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(USERQUERY);
		
			while (myRe.next()) {
				
				if(myRe.getInt("id_grupo")==idGrupo) {
					
					Usuario nuevo=this.cargarUsuario(myRe);
					listaUsuario.add(nuevo);
				}
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}
	

	
	public boolean loginCertificate(String username, String password) {
		
		boolean login=false;
		
		try {
		 
		ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(USERQUERY);
		
		while (myRe.next()) {
	
			
			if(myRe.getString("username").equals(username)) {
				
				if(myRe.getString("password").equals(password)) {
					
					login=true;
					
				}
				
			}
			
			
		}
		 
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		return login;
	}

	
	public boolean adminCertificate(String username) {
		
		boolean admin=false;
		
		try {
		 
			 ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(USERQUERY);
				
				while (myRe.next()) {
					
					if(myRe.getString("username").equals(username)) {
						if(myRe.getString("admin").equals("1")) {
							admin=true;
						}
						if(myRe.getString("admin").equals("0")) {
							admin=false;
						}	
					}
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		return admin;
		
		
	}
	
	
	
	
	
	// para escribir :   https://www.youtube.com/watch?v=Q4T7jg0Lv4E 
	
	
	public boolean registrarNuevoUsuarioEnDatabase(Usuario user) {
		
		boolean insert=false;
		
		
		//falta comprobar 
		//si el usuario introducido esta en la database
		
		
		try {
		
			String sql="INSERT INTO `usuario` (`nombre`,`apellido`, `dni`,`direccion`,`tlf`,`zona_trabajo`,`username`,`password`,`admin`,`id_grupo`)\r\n"
				+ "VALUES (\""+user.getNombre()+"\""
				+ ",\""+user.getApellido()+"\",\""+user.getDni()+"\""
				+ ",\""+user.getDireccion()+"\",\""+user.getTlf()+"\""
				+ ",\""+user.getZona_trabajo()+"\",\""+user.getUsername()+"\",\""+user.getPassword()+"\",false,"+user.getId_grupo()+")";
		
			//todos los usuarios registrados por la aplicacion
			//no podran ser admin, solo usuarios normales
				
			this.getConnect().getMyStat().executeUpdate(sql);
			
			System.out.print("Insert Complete");
			
			insert=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Insert failed, user is already in use"); //si el usuario esta repetido 
		}
		
		return insert;
	}
	

	public void borrarUsuario(Usuario aBorrar) throws SQLException {
		// TODO Auto-generated method stub

		try {
			
			StringBuilder command=new StringBuilder();
			
			command.append(USERDELETEQUERY);
			
			command.append(aBorrar.getUsername());
			
			command.append("\"");
			
			//comando que funciona : DELETE FROM `aplicacionr`.`usuario` WHERE `username`="user2";
			//nota: no le pongas el caracter (;) sino te dara error
			
			System.out.println(command.toString());
			
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(command.toString());
			 
			/*nota: la funcion executeQuery() -> sirve para hacer consultas y meter datos
			 				.executeUpdate() -> sirve para la manipulacion de datos (update,Delete....)
			  
			*/
			
			if(myRe==1) {
				System.out.println("Se ha borrado bien");
			}
			else {
				System.out.println("No Se ha borrado");
			}
			
			
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
		
	}
	
	
	
	
	
	

	
	public void actualizarUsuario(Usuario user) {
		// TODO Auto-generated method stub
	try {
			
	
		
			String sql="UPDATE `usuario`\r\n"
					+ "SET nombre = '"+user.getNombre()+"', apellido= '"+user.getApellido()+"',dni='"+user.getDni()+"',direccion='"+user.getDireccion()+"',zona_trabajo='"+user.getZona_trabajo()+"'\r\n"
					+ "WHERE username = '"+user.getUsername()+"'";
			
			
			
			
			//comando que funciona : DELETE FROM `aplicacionr`.`usuario` WHERE `username`="user2";
			//nota: no le pongas el caracter (;) sino te dara error
			
			System.out.println(sql);
			
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
			 
			/*nota: la funcion executeQuery() -> sirve para hacer consultas y meter datos
			 				.executeUpdate() -> sirve para la manipulacion de datos (update,Delete....)
			  
			*/
			
			if(myRe==1) {
				System.out.println("Se ha borrado bien");
			}
			else {
				System.out.println("No Se ha borrado");
			}
			
			
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
	}
	
	
	
	
	public void actualizarGrupoUsuario(Usuario user) {
		// TODO Auto-generated method stub
	try {
			
	
		
			String sql="UPDATE `usuario`\r\n"
					+ "SET id_grupo="+user.getId_grupo()+" \r\n"
					+ "WHERE username = '"+user.getUsername()+"'";
			
			
			
			//comando que funciona : DELETE FROM `aplicacionr`.`usuario` WHERE `username`="user2";
			//nota: no le pongas el caracter (;) sino te dara error
			
			System.out.println(sql);
			
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
			 
			/*nota: la funcion executeQuery() -> sirve para hacer consultas y meter datos
			 				.executeUpdate() -> sirve para la manipulacion de datos (update,Delete....)
			  
			*/
			
			if(myRe==1) {
				System.out.println("Se ha borrado bien");
			}
			else {
				System.out.println("No Se ha borrado");
			}
			
			
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
	}
	
	
	
	public void contarUsuarios() {
		try {
		 
			ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(COUNTQUERY);
			
			while (myRe.next()) {
				this.setUSERNUM(myRe.getInt("count(`iduser`)"));
			}
		 
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		
	}
	
	private void contarGrupos() {
		// TODO Auto-generated method stub
		
		try {
			 
			ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(COUNTGROUPSNUMBER);
			
			while (myRe.next()) {
				this.setGROUPNUM(myRe.getInt("count(distinct `id_grupo`)") );
			}
			
			//el grupo 0 no se contara nunca
			
			
	
			
		
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}

	


	public Integer getUSERNUM() {
		return USERNUM;
	}



	public void setUSERNUM(Integer uSERNUM) {
		USERNUM = uSERNUM;
	}



	public Integer getGROUPNUM() {
		return GROUPNUM;
	}



	public void setGROUPNUM(Integer gROUPNUM) {
		GROUPNUM = gROUPNUM;
	}



	public DatabaseConnection getConnect() {
		return connect;
	}



	public void setConnect(DatabaseConnection connect) {
		this.connect = connect;
	}



	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}



	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}



	public String getUSERQUERY() {
		return USERQUERY;
	}



	public String getCOUNTQUERY() {
		return COUNTQUERY;
	}



	public String getCOUNTGROUPSNUMBER() {
		return COUNTGROUPSNUMBER;
	}



	public String getUSERDELETEQUERY() {
		return USERDELETEQUERY;
	}










	
	
	
}
