package Classes;

import java.sql.SQLException;

import DataBase.EnderecoDAO;

public class teste {
	
	public static void main(String[] args) {
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		try {
			System.out.println(""+enderecoDAO.TotalEnderecos());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
