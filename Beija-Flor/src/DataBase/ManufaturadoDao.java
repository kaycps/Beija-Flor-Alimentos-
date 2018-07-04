package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Classes.materiaPrima;
import Classes.produtoManufaturado;

public class ManufaturadoDao {
	
	private Connection connection; 
		
	public ManufaturadoDao() {
			
		this.connection = new ConnectionFactory().getConnection();		
	}
		
	
	public void AdicionarManufaturado(produtoManufaturado manufaturado)  {
			
			String sql = "insert into manufaturado" + 
			"(datavalidade,quantidade,valor,datafabricacao,tipo)" + "values(?,?,?,?,?)";	
			 
		
			try {		
				
				//prepara o statement para inserção 			
				PreparedStatement	stmt = connection.prepareStatement(sql);		
				
				//seta os valores
				stmt.setString(1, manufaturado.getValidade());
				stmt.setInt(2, manufaturado.getQuantidade());
				stmt.setDouble(3, manufaturado.getValor());
				stmt.setString(4, manufaturado.getDataFabricacao());
				stmt.setInt(5, manufaturado.getTipo());
				stmt.execute();
				
				
				//executa				
				stmt.close();			
				JOptionPane.showMessageDialog(null, "Produto manufaturado cadatrado com sucesso!");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			
		}
		
		public  java.util.List<produtoManufaturado> buscarManufaturados() {
			try {
				
				java.util.List<produtoManufaturado> manufaturados = new ArrayList<produtoManufaturado>();
				PreparedStatement stmt = this.connection.prepareStatement("select * from manufaturado");
			    ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					
					produtoManufaturado manufaturado = new produtoManufaturado();
					
					manufaturado.setDataFabricacao(rs.getString("datafabricacao"));
					manufaturado.setValidade(rs.getString("datavalidade"));
					manufaturado.setQuantidade(rs.getInt("quantidade"));
					manufaturado.setValor(rs.getDouble("valor"));
					manufaturado.setTipo(rs.getInt("tipo"));
					manufaturado.setId(rs.getInt("id_manufaturado"));
					
					manufaturados.add(manufaturado);					
				}		    
				rs.close();
				stmt.close();
				System.out.println("dados manufaturado retornados!");
				return manufaturados;
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}		
			
		}
		
		public void AlterarManufaturado(produtoManufaturado manufaturado) {
			
			String sqlString = "update manufaturado set datavalidade=?, quantidade=?, valor=?, datafabricacao=?, tipo=? where id_manufaturado=?";
			
			try {
				PreparedStatement stmt = connection.prepareStatement(sqlString);
				stmt.setString(1, manufaturado.getValidade());
				stmt.setInt(2, manufaturado.getQuantidade());
				stmt.setDouble(3, manufaturado.getValor());
				stmt.setString(4, manufaturado.getDataFabricacao());
				stmt.setInt(5, manufaturado.getTipo());
				stmt.setInt(6, manufaturado.getId());				
				stmt.execute();
				stmt.close();
				JOptionPane.showMessageDialog(null, "Dados Atualizados com sucesso!");
				
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		public void DeletarManufaturado (produtoManufaturado manufaturado) {
			
			try {
				PreparedStatement stmt  = connection.prepareStatement("delete from manufaturado where id_manufaturado=?");
				stmt.setInt(1, manufaturado.getId());
				stmt.execute();
				stmt.close();
				
				JOptionPane.showMessageDialog(null, "Produto Manufaturado  deletado com sucesso!");
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
