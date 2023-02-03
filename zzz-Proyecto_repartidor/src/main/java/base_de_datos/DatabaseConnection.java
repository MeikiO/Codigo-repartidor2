package base_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import modelo.Usuario;

public class DatabaseConnection {

	
	public Connection myConn;
	public Statement myStat;
	
	final String DATABASESTRING="jdbc:mysql://localhost:3306/aplicacionr?serverTimezone=UTC";
	

	
	
	public DatabaseConnection() {
	
		try {
			myConn=DriverManager.getConnection(this.DATABASESTRING,"root","root");
			myStat=myConn.createStatement();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	
	}




	public Connection getMyConn() {
		return myConn;
	}




	public void setMyConn(Connection myConn) {
		this.myConn = myConn;
	}




	public Statement getMyStat() {
		return myStat;
	}




	public void setMyStat(Statement myStat) {
		this.myStat = myStat;
	}




	public String getDATABASESTRING() {
		return DATABASESTRING;
	}
	
	
	
}
