package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.cj.result.Row;

import Classes.cliente;
import Classes.endereco;
import DataBase.ClienteDAO;
import DataBase.EnderecoDAO;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Button;

public class ConsultarAgenda extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarAgenda frame = new ConsultarAgenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultarAgenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnVoltar.setBounds(245, 334, 89, 23);
		contentPane.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 154, 367, 85);
		contentPane.add(scrollPane);	
		
		//chamada classe Dao
		ClienteDAO cDao = new ClienteDAO();		
		
		List<cliente> clientes = cDao.BuscarContato();
		
		//Criação da Table
		String coluna[]= {"Id","Nome","Telefone","Cnpj","Endereco_id"};
		DefaultTableModel tableModel = new DefaultTableModel(coluna,0);
		JTable table = new JTable(tableModel);
		
		//Transformando arrayList em Object
		for(int i = 0; i<clientes.size();i++) {
			
			int id = clientes.get(i).getId();
			String nome = clientes.get(i).getNome();
			String telefone = clientes.get(i).getTelefone();			
			String cnpj = clientes.get(i).getCnpj();
			int id_endereco = clientes.get(i).getId_endereco();
			
			Object data[]= {id,nome,telefone,cnpj,id_endereco};			
			tableModel.addRow(data);
		}	
		
		
		
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Agenda de Contatos");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(245, 11, 143, 14);
		contentPane.add(lblNewLabel);
		
		Button button = new Button("Editar\r\n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				
				List clienteList = (List) tableModel.getDataVector().elementAt(table.getSelectedRow());				
				
				cliente cliente = new cliente();
				
				
				cliente.setId((int) clienteList.get(0));
				cliente.setNome((String)clienteList.get(1));
				cliente.setTelefone((String)clienteList.get(2));				
				cliente.setCnpj((String)clienteList.get(3));
				cliente.setId_endereco((int)clienteList.get(4));
				
				
				
				//enviando os dados para edição
				UpdateCliente uc =new UpdateCliente();
				uc.editarCliente(cliente);
				uc.setVisible(true);
				dispose();
				
				
			}
		});		
		
		button.setBounds(461, 174, 70, 22);
		contentPane.add(button);
		
		Button button_1 = new Button("Excluir\r\n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				List clienteList = (List) tableModel.getDataVector().elementAt(table.getSelectedRow());				
				
				cliente cliente = new cliente();				
				
				cliente.setId((int) clienteList.get(0));
				cliente.setNome((String)clienteList.get(1));
				cliente.setTelefone((String)clienteList.get(2));				
				
				
				//enviando os dados para edição
				ClienteDAO cd =new ClienteDAO();
				cd.DeletarCliente(cliente);
				
				dispose();
				ConsultarAgenda consultarAgenda = new ConsultarAgenda();
				consultarAgenda.setVisible(true);
			}
		});
		button_1.setBounds(461, 215, 70, 22);
		contentPane.add(button_1);		
		
		
	}
}
