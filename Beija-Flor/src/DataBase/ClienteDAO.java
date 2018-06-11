package DataBase;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import Classes.cliente;

public class ClienteDAO {
	
	private Connection connection; 
	
	public ClienteDAO() {
		
		this.connection = new ConnectionFactory().getConnection();		
	}
	
	public void AdicionarContato(cliente cliente)  {
		
		String sql = "insert into cliente" + 
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
	
	public  java.util.List<cliente> BuscarContato() {
		try {
			
			java.util.List<cliente> clientes = new ArrayList<cliente>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente");
		    ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				cliente cliente = new cliente();
				cliente.setNome(rs.getString("nome"));
				cliente.setTelefone(rs.getString("telefone"));
				
				clientes.add(cliente);
			}		    
			rs.close();
			stmt.close();
			System.out.println("dados retornados!");
			return clientes;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
		
		
	}
}
