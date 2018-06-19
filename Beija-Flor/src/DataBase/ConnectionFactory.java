package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		try {
			return DriverManager.getConnection("jdbc:mysql://bellaflor.c9yq7dy7npvp.us-east-2.rds.amazonaws.com:3306/bellaflor?user=bellaflor&password=160494159632");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
