package base_de_datos;

import java.awt.Color;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jxmapviewer.viewer.GeoPosition;

import mapas.SwingWaypoint;
import modelo.Usuario;

public class PuntosData {


	DatabaseConnection connect;
	
	
	final String POINTQUERY="select * from geoposicion";
	
	
	
	
	public PuntosData() {
		// TODO Auto-generated constructor stub
	
		this.connect=new DatabaseConnection();
		

	}
	
	//haz la prueba de la nueva database de los puntos aqui...
	
	public void demo() {
		try {
		 
		 ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(POINTQUERY);
		
		while (myRe.next()) {
			
			

			System.out.print(myRe.getInt("idRecorrido")+" \n "
			+myRe.getString("nombre")+" \n\n "
			
			+myRe.getString("latDegrees")+" \n "
			+myRe.getString("latMinutes")+" \n "
			+myRe.getString("latSeconds")+" \n "
			+myRe.getString("lonDegrees")+" \n "
			+myRe.getString("lonMinutes")+" \n "
			+myRe.getString("lonSeconds")+" \n\n "
			
			+myRe.getString("direccion")+" \n "
			+myRe.getString("nombre_cliente")+" \n "
			+myRe.getString("llaves")+" \n "
			+myRe.getString("como_dejarlo")+" \n "
			+myRe.getString("notas")+" \n "
			+myRe.getString("dias_semana")+" \n "
			+myRe.getString("poblacion")+" \n "
			+myRe.getString("tipo")+" \n ");	

		
		}
		 
		
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	
	
	public Set<SwingWaypoint> cargarPuntos(int idGrupo){
		Set<SwingWaypoint> waypoints = new HashSet<SwingWaypoint>();
		
		try {
			 
			 ResultSet myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeQuery(POINTQUERY);
			
			while (myRe.next()) {
					
				if(idGrupo== myRe.getInt("idRecorrido")) {
					
					 //positions of the map= estos son las posiciones logicas/numericas sin nada mas
					 GeoPosition nuevo = new GeoPosition(myRe.getInt("latDegrees"),
							 myRe.getInt("latMinutes"),
							 myRe.getInt("latSeconds"),
							 myRe.getInt("lonDegrees"),
							 myRe.getInt("lonMinutes"),
							 myRe.getInt("lonSeconds"));
					
					 
					 //waypoints = puntos en el mapa que se pueden ver/interactuar
					 
					// Create waypoints from the geo-positions and introduce in the set of waypoints

					 
					waypoints.add(new SwingWaypoint(myRe.getInt("idRecorrido"),myRe.getString("nombre")
							,myRe.getString("direccion"),myRe.getString("nombre_cliente"),
							myRe.getString("llaves"),myRe.getString("como_dejarlo"),
							myRe.getString("notas"),myRe.getString("dias_semana"),
							myRe.getString("poblacion"),myRe.getString("tipo"),
				    		nuevo)); 
											
				}
			}
			 
			
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
		
		
		
		
		
		return waypoints;
	}

	public void actualizarNotas(SwingWaypoint point) {
		// TODO Auto-generated method stub
		try {
			
			
			
			String sql="UPDATE `geoposicion` SET notas = '"+point.getNotes()+"' WHERE idposition ="+point.getId_recorrido().intValue();

			
			//comando que funciona : DELETE FROM `aplicacionr`.`usuario` WHERE `username`="user2";
			//nota: no le pongas el caracter (;) sino te dara error
			
			System.out.println(sql);
			
			
			int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
			 
			/*nota: la funcion executeQuery() -> sirve para hacer consultas y meter datos
			 				.executeUpdate() -> sirve para la manipulacion de datos (update,Delete....)
			  
			*/
			
			if(myRe==1) {
				System.out.println("Se ha actualizado bien");
			}
			else {
				
				System.out.println("No ha actualizado");
			}
			
			
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
	}
	
	public void borrarPunto(SwingWaypoint point) {
		// TODO Auto-generated method stub
		try {
			
			
			String sql="DELETE FROM `aplicacionr`.`geoposicion` WHERE `nombre`=\""+point.getNombre()+"\"";

			
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
				
				System.out.println("No ha borrado");
			}
			
			
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
	}

	public void actualizarPunto(SwingWaypoint elemento) {
		// TODO Auto-generated method stub
		
		try {
			
		String sql="update `geoposicion` set "
				+ "`idRecorrido`="+elemento.getId_recorrido()
				+" where `nombre`=\""+elemento+"\"";
		
		
		//comando que funciona : DELETE FROM `aplicacionr`.`usuario` WHERE `username`="user2";
		//nota: no le pongas el caracter (;) sino te dara error
		
		System.out.println(sql);
		
		
		int myRe= ((java.sql.Statement) this.getConnect().getMyStat()).executeUpdate(sql);
		 
		/*nota: la funcion executeQuery() -> sirve para hacer consultas y meter datos
		 				.executeUpdate() -> sirve para la manipulacion de datos (update,Delete....)
		  
		*/
		
		if(myRe==1) {
			System.out.println("Se ha modificado bien");
		}
		else {
			System.out.println("No Se ha modificado");
		}
		
		
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}

	public DatabaseConnection getConnect() {
		return connect;
	}

	public void setConnect(DatabaseConnection connect) {
		this.connect = connect;
	}

	public String getPOINTQUERY() {
		return POINTQUERY;
	}
	
	
	
	
	
	
}
