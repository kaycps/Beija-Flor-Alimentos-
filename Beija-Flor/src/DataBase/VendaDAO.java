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
			
			String sql = "insert into vendas" + 
			"(data,valor,quantidade,id_login,id_cliente,id_endereco,id_produto)" + "values(?,?,?,?,?,?,?)";	
			 
		
			try {		
				
				//prepara o statement para inserção 			
				PreparedStatement	stmt = connection.prepareStatement(sql);		
				
				
				//seta os valores
				stmt.setString(1, venda.getDataVenda());
				stmt.setDouble(2, venda.getValorUnitario());
				stmt.setInt(3, (int) venda.getQuantidade());
				stmt.setInt(4, venda.getId_login());
				stmt.setInt(5, venda.getId_cliente());
				stmt.setInt(6, venda.getId_EnderecoCliente());
				stmt.setInt(7, venda.getId_produto());
				
				stmt.execute();
				
				
				//executa				
				stmt.close();			
				JOptionPane.showMessageDialog(null, "Venda Cadatrada com sucesso!");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			
		}
		public double credito() {
			
			double total = 0;
			String sql = "SELECT (SUM(valor) * SUM(quantidade)) as Resultado FROM vendas;";
			try {
				PreparedStatement	stmt = connection.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery(sql);
				rs.next();
				total = rs.getDouble("Resultado");
				rs.close();
				stmt.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return total;
		}
	
		
		
}
