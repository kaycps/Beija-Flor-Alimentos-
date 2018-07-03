package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Classes.endereco;
import Classes.materiaPrima;


public class MateriaPrimaDAO {
	
	private Connection connection; 
	
	public MateriaPrimaDAO() {
		
		this.connection = new ConnectionFactory().getConnection();		
	}
	
	public void AdicionarMateriaPrima(materiaPrima materiaPrima)  {
		
		String sql = "insert into materiaprima" + 
		"(nome,quantidade,descricao,origem)" + "values(?,?,?,?)";	
		 
	
		try {		
			
			//prepara o statement para inserção 			
			PreparedStatement	stmt = connection.prepareStatement(sql);		
			
			
			//seta os valores
			stmt.setString(1, materiaPrima.getNome());
			stmt.setInt(2, materiaPrima.getQuantidade());
			stmt.setString(3, materiaPrima.getDescricao());
			stmt.setString(4, materiaPrima.getOrigem());			
			stmt.execute();
			
			
			//executa				
			stmt.close();			
			JOptionPane.showMessageDialog(null, "Materia Prima cadatrada com sucesso!");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}
	
	public  java.util.List<materiaPrima> buscarMateriaPrimas() {
		try {
			
			java.util.List<materiaPrima> materiaPrimas = new ArrayList<materiaPrima>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from materiaprima");
		    ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				materiaPrima materiaPrima = new materiaPrima();
				materiaPrima.setNome(rs.getString("nome"));
				materiaPrima.setDescricao(rs.getString("descricao"));
				materiaPrima.setOrigem(rs.getString("origem"));
				materiaPrima.setQuantidade(rs.getInt("quantidade"));
				materiaPrima.setId(rs.getInt("id_materiaprima"));
				
				
				materiaPrimas.add(materiaPrima);
			}		    
			rs.close();
			stmt.close();
			System.out.println("dados materia prima retornados!");
			return materiaPrimas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
	}
	
	public void AlterarMateriaPrima(materiaPrima materiaPrima) {
		
		String sqlString = "update materiaprima set nome=?, descricao=?, origem=?, quantidade=? where id_materiaprima=?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sqlString);
			stmt.setString(1, materiaPrima.getNome());
			stmt.setString(2, materiaPrima.getDescricao());
			stmt.setString(3, materiaPrima.getOrigem());
			stmt.setInt(4, materiaPrima.getQuantidade());
			stmt.setInt(5, materiaPrima.getId());
			stmt.execute();
			stmt.close();
			JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso!");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void DeletarMateriaPrima (materiaPrima materiaPrima) {
		
		try {
			PreparedStatement stmt  = connection.prepareStatement("delete from materiaprima where id_materiaprima=?");
			stmt.setInt(1, materiaPrima.getId());
			stmt.execute();
			stmt.close();
			
			JOptionPane.showMessageDialog(null, "Materia Prima deletada com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<materiaPrima> BuscarMateriaPrimaId(int id) {
			
			List<materiaPrima> materiaPrimas = new ArrayList<materiaPrima>();
			
			
			String sql = "SELECT * FROM bellaflor.materiaprima where id_materiaprima="+id;
			
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);		
				
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					
					materiaPrima materiaPrima = new materiaPrima();
					materiaPrima.setDescricao(rs.getString("descricao"));
					materiaPrima.setNome(rs.getString("nome"));
					materiaPrima.setOrigem(rs.getString("origem"));
					materiaPrima.setId(rs.getInt("id_materiaprima"));
					materiaPrima.setQuantidade(rs.getInt("quantidade"));
					
					materiaPrimas.add(materiaPrima);
				}
				rs.close();
				stmt.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(""+materiaPrimas);
			return materiaPrimas;
			
			
			
		}


}
