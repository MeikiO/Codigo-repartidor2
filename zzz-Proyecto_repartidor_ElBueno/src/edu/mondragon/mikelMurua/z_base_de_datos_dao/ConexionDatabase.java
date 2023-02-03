package z_base_de_datos_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDatabase {

	public Connection myConn;
	public Statement myStat;
	
	final String DATABASESTRING="jdbc:mysql://localhost:3306/aplicacion_reparto?serverTimezone=UTC";
		
	public void connect() {
		try {
			myConn=DriverManager.getConnection(this.DATABASESTRING,"root","root");
			myStat=myConn.createStatement();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void disconnect() {
        try {
            if (myStat != null) {
            	myStat.clearWarnings();
                myStat.close();
            }

            if (myConn != null) {
            	myConn.clearWarnings();
            	myConn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error disconnecting");
        }
	}

	public Connection getMyConn() {
		return myConn;
	}

	public Statement getMyStat() {
		return myStat;
	}
	
}
