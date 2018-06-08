package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/BeijaFlor?useTimezone=true&serverTimezone=UTC&useSSL=false",	"root",	"160494");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
