package DataBase;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import Classes.cliente;
import Classes.endereco;

public class ClienteDAO {
	
	EnderecoDAO eDao = new EnderecoDAO();
	private Connection connection; 
	
	public ClienteDAO() {
		
		this.connection = new ConnectionFactory().getConnection();		
	}
	
	public void AdicionarContato(cliente cliente)  {
		
		String sql = "insert into cliente" + 
		"(nome,telefone,cnpj,tipo,id_endereco)" + "values(?,?,?,?,?)";	
		 
	
		try {		
			
			//prepara o statement para inserção 			
			PreparedStatement	stmt = connection.prepareStatement(sql);		
			
			
			//seta os valores
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getCnpj());
			stmt.setString(4, cliente.getTipo());
			stmt.setInt(5, eDao.TotalEnderecos());
			stmt.execute();
			
			
			//executa				
			stmt.close();			
			JOptionPane.showMessageDialog(null, "Cadatrado com sucesso!");
			
			
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
				cliente.setId(rs.getInt("idcliente"));
				cliente.setId_endereco(rs.getInt("id_endereco"));
				cliente.setCnpj(rs.getString("cnpj"));
				
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
		
		String sqlString = "update cliente set nome=?, telefone=?, cnpj=? where idcliente=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlString);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getCnpj());
			stmt.setInt(4, cliente.getId());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso!");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void DeletarCliente (cliente cliente) {
		
		try {
			PreparedStatement stmt  = connection.prepareStatement("delete from cliente where idcliente=?");
			stmt.setInt(1, cliente.getId());
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Clinte deletado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int buscarIdEndereço(int id) throws SQLException{
		
		int id_endereco=0;
		String sqlString  = "select * from cliente where idcliente=? ";
		
		PreparedStatement	stmt = connection.prepareStatement(sqlString);
		stmt.setInt(1,id);
		
		ResultSet rs = stmt.executeQuery();			
		rs.next();
		id_endereco=rs.getInt("id_endereco");
		rs.close();
		stmt.close();	
		
		return id_endereco;
	}
}
