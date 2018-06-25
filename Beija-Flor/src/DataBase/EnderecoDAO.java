package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;
import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

import Classes.cliente;
import Classes.endereco;



public class EnderecoDAO {
	
private Connection connection; 
	
	public EnderecoDAO() {
		
		this.connection = new ConnectionFactory().getConnection();		
	}
	
	public void AdicionarEndereco(endereco endereco)  {
		
		String sql = "insert into endereco" + 
		"(num,rua,bairro,cidade,cep)" + "values(?,?,?,?,?)";		
		
		 
		try {
			
			//prepara o statement para inserção 
			PreparedStatement	stmt = connection.prepareStatement(sql);
			
			//seta os valores
			
			stmt.setString(1, endereco.getNumero());
			stmt.setString(2, endereco.getRua());
			stmt.setString(3, endereco.getBairro());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getCep());			
			
			//executa
			stmt.execute();
			
			
			
			//JOptionPane.showMessageDialog(null, "Endereço Cadatrado com sucesso!");
			System.out.println("Endereço Cadatrado com sucesso!");
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
public void AlterarEndereco(endereco endereco) {
		
		String sqlString = "update endereco set rua=?, num=?, bairro=?, cidade=?, cep=? where id_endereco=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlString);
			stmt.setString(1, endereco.getRua());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getBairro());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getCep());					
			stmt.setInt(6, endereco.getId());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Endereço Atualizado com sucesso!");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<endereco> BuscarEnderecoId(int id) {
		
		List<endereco> enderecos = new ArrayList<endereco>();
		
		
		String sql = "SELECT * FROM bellaflor.endereco where id_endereco="+id;
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);		
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				endereco endereco = new  endereco();
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setCep(rs.getString("cep"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getString("num"));
				enderecos.add(endereco);
			}
			rs.close();
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(""+enderecos);
		return enderecos;
		
		
		
	}
	public void DeletarEndereco (endereco endereco) {
		
		try {
			PreparedStatement stmt  = connection.prepareStatement("delete from endereco where id_endereco=?");
			stmt.setInt(1, endereco.getId());
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Endereço deletado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public  List<endereco> buscarEnderecos() {
		try {
			
			java.util.List<endereco> enderecos = new ArrayList<endereco>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from endereco");
		    ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				endereco endereco = new endereco();
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCep(rs.getString("cep"));
				endereco.setRua(rs.getString("rua"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setId(rs.getInt("id_endereco"));
				endereco.setNumero(rs.getString("num"));
				
				enderecos.add(endereco);
			}		    
			rs.close();
			stmt.close();
			System.out.println("dados retornados!");
			return enderecos;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
	
	public int TotalEnderecos () throws SQLException {
		
		String sql = "select count(*) from endereco";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		rs.next();
		int i = rs.getInt(1);
		return i;
	}
	
	

}
