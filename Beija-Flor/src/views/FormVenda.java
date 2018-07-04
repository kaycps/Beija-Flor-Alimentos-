package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.Element;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;

import Classes.cliente;
import Classes.login;
import Classes.materiaPrima;
import Classes.produtoManufaturado;
import Classes.venda;
import DataBase.ClienteDAO;
import DataBase.EnderecoDAO;
import DataBase.ManufaturadoDao;
import DataBase.VendaDAO;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FormVenda extends JFrame {

	private JPanel contentPane;
	private JTextField tfQuantidade;
	private JTextField tfValorTotal;
	private JTable tableCliente;
	private JTable tableProduto;
	private JTextField tfValorUni;
	JComboBox cbDiaVenda = new JComboBox();
	JComboBox cbMesVenda = new JComboBox();
	JComboBox cbAnoVenda = new JComboBox();
	login login = new login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormVenda frame = new FormVenda();
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
	public FormVenda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				
				dispose();
			}
		});
		btnCancelar.setBounds(193, 330, 89, 23);
		contentPane.add(btnCancelar);
		
		
		
		ManufaturadoDao manufaturado = new ManufaturadoDao();
		ClienteDAO clienteDAO = new ClienteDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		List<produtoManufaturado> produtoList= manufaturado.buscarManufaturados();
		List<cliente> clientes = clienteDAO.BuscarContato();
		
		// Criação da Table manufaturado
		String colunaPro[] = { "Tipo", "Quantidade", "valor", "DataFabricação", "Validade" };
		DefaultTableModel tableModelP = new DefaultTableModel(colunaPro, 0);
		tableProduto = new JTable(tableModelP);
		// Transformando arrayList em Object
			for (int i = 0; i < produtoList.size(); i++) {

				int tipo = produtoList.get(i).getTipo();				
				int Quantidade = produtoList.get(i).getQuantidade();
				double valor = produtoList.get(i).getValor();				
				String dataFabricacao = produtoList.get(i).getDataFabricacao();
				String validade = produtoList.get(i).getValidade();
				Object data[] = {  tipo, Quantidade, valor, dataFabricacao, validade };
				tableModelP.addRow(data);
			}
		////
			
		// Criação da Table manufaturado
		String colunaCli[] = { "ID", "Nome", "Telefone", "Cnpj" };
		DefaultTableModel tableModelC = new DefaultTableModel(colunaCli, 0);
		tableCliente = new JTable(tableModelC);
		// Transformando arrayList em Object
			for (int i = 0; i < clientes.size(); i++) {

				int id = clientes.get(i).getId();				
				String nome = clientes.get(i).getNome();
				String telefone = clientes.get(i).getTelefone();
				String cnpj = clientes.get(i).getCnpj();
				
				Object data[] = {  id, nome, telefone,cnpj };
				tableModelC.addRow(data);
			}
			////	
		
			JButton btnCadastrar = new JButton("Cadastrar");
			btnCadastrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {					
					//"Tipo", "Quantidade", "valor", "DataFabricação", "Validade"
					//"ID", "Nome", "Telefone", "Cnpj"
					VendaDAO vendaDAO = new VendaDAO();
					
					
					String dataVenda =""+cbDiaVenda.getSelectedItem()+"-"+cbMesVenda.getSelectedItem()+"-"+cbAnoVenda.getSelectedItem();
					
					List produto = (List) tableModelP.getDataVector().elementAt(tableProduto.getSelectedRow());				
					List cliente = (List) tableModelC.getDataVector().elementAt(tableCliente.getSelectedRow());	
					
					venda venda = new venda();
					
					venda.setDataVenda(dataVenda);
					venda.setId_cliente((int)cliente.get(0));
					venda.setId_produto((int)produto.get(0));					
					try {
						venda.setId_EnderecoCliente(clienteDAO.buscarIdEndereço((int)cliente.get(0)));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					venda.setId_login(login.getId());
					venda.setQuantidade((int)produto.get(1));
					venda.setValorUnitario((double)produto.get(2));
					
					vendaDAO.AdicionarVenda(venda);
					
					dispose();
					
					
				}
			});		
		btnCadastrar.setBounds(324, 330, 97, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("Quantidade :\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(42, 258, 82, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Unitario :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(42, 294, 105, 14);
		contentPane.add(lblNewLabel_1);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(126, 256, 67, 20);
		contentPane.add(tfQuantidade);
		tfQuantidade.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Produto :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(42, 136, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDataDaVenda = new JLabel("Data da Venda :");
		lblDataDaVenda.setFont(new Font("Arial", Font.BOLD, 13));
		lblDataDaVenda.setBounds(42, 226, 105, 14);
		contentPane.add(lblDataDaVenda);
		
		JLabel lblValorTotal = new JLabel("Valor Total :");
		lblValorTotal.setFont(new Font("Arial", Font.BOLD, 13));
		lblValorTotal.setBounds(374, 294, 82, 14);
		contentPane.add(lblValorTotal);
		
		tfValorTotal = new JTextField();
		tfValorTotal.setEditable(false);
		tfValorTotal.setBounds(459, 288, 73, 20);
		contentPane.add(tfValorTotal);
		tfValorTotal.setColumns(10);
		
		JLabel lblCadastrarVenda = new JLabel("Cadastrar Venda");
		lblCadastrarVenda.setForeground(new Color(0, 139, 139));
		lblCadastrarVenda.setFont(new Font("Arial", Font.BOLD, 15));
		lblCadastrarVenda.setBounds(214, 11, 117, 14);
		contentPane.add(lblCadastrarVenda);
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(40, 72, 495, 53);
		contentPane.add(scrollPaneCliente);
		
		
		scrollPaneCliente.setViewportView(tableCliente);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 13));
		lblCliente.setBounds(40, 49, 46, 14);
		contentPane.add(lblCliente);
		
		JScrollPane scrollPaneProduto = new JScrollPane();
		scrollPaneProduto.setBounds(42, 160, 495, 53);
		contentPane.add(scrollPaneProduto);
		
		
		scrollPaneProduto.setViewportView(tableProduto);
		
		tfValorUni = new JTextField();
		tfValorUni.setBounds(140, 288, 67, 20);
		contentPane.add(tfValorUni);
		tfValorUni.setColumns(10);
		
		
		cbDiaVenda.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDiaVenda.setBounds(144, 226, 49, 20);
		contentPane.add(cbDiaVenda);
		
		JLabel label = new JLabel("/");
		label.setBounds(198, 229, 10, 14);
		contentPane.add(label);
		
		
		cbMesVenda.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbMesVenda.setBounds(206, 226, 46, 20);
		contentPane.add(cbMesVenda);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(258, 229, 10, 14);
		contentPane.add(label_1);
		
		
		cbAnoVenda.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cbAnoVenda.setBounds(267, 226, 53, 20);
		contentPane.add(cbAnoVenda);
		
		
		
		System.out.println(""+login.getId());
		
		
		
		
	}
}
