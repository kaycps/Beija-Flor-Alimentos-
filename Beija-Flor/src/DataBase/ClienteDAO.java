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
			
			//prepara o statement para inser��o 
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
				cliente.setId(rs.getInt("id"));
				
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
	
	public void AlterarCliente(cliente cliente) {
		
		String sqlString = "update cliente set nome=?, telefone=? where id=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlString);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setInt(3, cliente.getId());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso!");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void DeletarCliente (cliente cliente) {
		
		try {
			PreparedStatement stmt  = connection.prepareStatement("delete from cliente where id=?");
			stmt.setInt(1, cliente.getId());
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Clinte deletado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
