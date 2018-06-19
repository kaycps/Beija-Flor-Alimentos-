package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classes.cliente;
import Classes.login;

public class LogimDAO {
	
private Connection connection; 
	
	public LogimDAO() {
		
		this.connection = new ConnectionFactory().getConnection();		
	}
	
public Boolean VerificarLogin(login login)  {
		
		boolean flag = false;
		String sql = "select * from login where usuario = ? and senha = ? ";		
		 
		try {		
			
			//prepara o statement para inserção 			
			PreparedStatement	stmt = connection.prepareStatement(sql);
			stmt.setString(1,login.getUsuario());
			stmt.setString(2, login.getSenha());
			
			ResultSet rs = stmt.executeQuery();	
			
			if(rs.next()) {
				
				if(rs.getString("usuario").equals(login.getUsuario())&&rs.getString("senha").equals(login.getSenha())) {
					
					rs.close();
					stmt.close();
					flag = true;
					
				}
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	
		
		
	}

}
