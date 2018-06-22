package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Generated;
import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

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
	
	public int TotalEnderecos () throws SQLException {
		
		String sql = "select count(*) from endereco";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		rs.next();
		int i = rs.getInt(1);
		return i;
	}
	
	

}
