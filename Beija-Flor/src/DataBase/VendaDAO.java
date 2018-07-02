package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Classes.materiaPrima;
import Classes.venda;



public class VendaDAO {		
		
		private Connection connection; 
		
		public VendaDAO() {
			
			this.connection = new ConnectionFactory().getConnection();		
		}
		
		public void AdicionarVenda(venda venda)  {
			
			String sql = "insert into venda" + 
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
		
		public void AlterarCliente(materiaPrima materiaPrima) {
			
			String sqlString = "update materiaprima set nome=?, telefone=?, cnpj=?, where id=?";
			
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
		
		public void DeletarCliente (materiaPrima materiaPrima) {
			
			try {
				PreparedStatement stmt  = connection.prepareStatement("delete from materiaprima where id_materiaprima=?");
				stmt.setInt(1, materiaPrima.getId());
				stmt.execute();
				stmt.close();
				
				JOptionPane.showMessageDialog(null, "Materia prima deletada com sucesso!");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

}
