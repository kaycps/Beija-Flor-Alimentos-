package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Classes.cliente;
import Classes.funcionario;

public class FuncionarioDAO {
	
	EnderecoDAO eDao = new EnderecoDAO();
	private Connection connection; 
	
	public FuncionarioDAO() {
		
		this.connection = new ConnectionFactory().getConnection();		
	}
	
	public void AdicionarFuncionario(funcionario funcionario)  {
		
		String sql = "insert into funcionario" + 
		"(nome,dataNasc,telefone,carteiraTrab,cpf,setor,salario,sexo,id_endereco,dataContrato)" + "values(?,?,?,?,?,?,?,?,?,?)";	
		 
	
		try {		
			
			//prepara o statement para inserção 			
			PreparedStatement	stmt = connection.prepareStatement(sql);		
			
			
			//seta os valores
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getDataNascimento());
			stmt.setString(3, funcionario.getTelefone());
			stmt.setString(4, funcionario.getCarteiraTrabalho());
			stmt.setString(5, funcionario.getCpf());
			stmt.setString(6, funcionario.getSetor());
			stmt.setDouble(7, funcionario.getSalario());
			stmt.setString(8, funcionario.getSexo());
			stmt.setInt(9, funcionario.getEndereco().getId());
			stmt.setString(10, funcionario.getDataContratacao());
			
			stmt.execute();
			
			
			//executa				
			stmt.close();			
			JOptionPane.showMessageDialog(null, "Cadatrado com sucesso!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

}
