package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Classes.cliente;

public class ClienteDAO {
	
	private Connection connection; 
	
	public ClienteDAO() {
		
		this.connection = new ConnectionFactory().getConnection();		
	}
	
	public void Adicionar(cliente cliente)  {
		
		String sql = "insert into funcionario" + 
		"(nome,telefone)" + "values(?,?)";		
		
		 
		try {
			
			//prepara o statement para inserção 
			PreparedStatement	stmt = connection.prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			
			//executa
			stmt.execute();
			JOptionPane.showMessageDialog(null, "Cadatrado com sucesso!");
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
}
