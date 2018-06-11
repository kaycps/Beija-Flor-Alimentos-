package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.WebServiceCep;
import Classes.cliente;
import DataBase.ClienteDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfTelefone;
	private JTextField tfCNPJ;
	private JTextField tfCEPAgenda;
	private JTextField tfRuaAgenda;
	private JTextField tfNumeroAgenda;
	private JTextField tfCidadeAgenda;
	private JTextField tfBairroAgenda;
	private JTextField tfProdutoFornecido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JRadioButton rbFornecedor = new JRadioButton("Fornecedor\r\n");
	JRadioButton rbCliente = new JRadioButton("Cliente");
	
	public FormCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAgenda.setForeground(new Color(0, 128, 128));
		lblAgenda.setBounds(273, 11, 73, 14);
		contentPane.add(lblAgenda);
		
		
		rbCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfProdutoFornecido.setEditable(false);
				rbFornecedor.setSelected(false);;
				
			}
		});
		rbCliente.setFont(new Font("Arial", Font.BOLD, 13));
		rbCliente.setBounds(129, 54, 109, 23);
		contentPane.add(rbCliente);
		
		
		rbFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				tfProdutoFornecido.setEditable(true);
				rbCliente.setSelected(false);
			}
		});
		rbFornecedor.setFont(new Font("Arial", Font.BOLD, 13));
		rbFornecedor.setBounds(383, 54, 109, 23);
		contentPane.add(rbFornecedor);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 13));
		lblNome.setBounds(22, 96, 48, 14);
		contentPane.add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefone.setBounds(203, 96, 73, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 13));
		lblCnpj.setBounds(328, 96, 48, 14);
		contentPane.add(lblCnpj);
		
		tfNome = new JTextField();
		tfNome.setBounds(22, 113, 138, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(203, 113, 86, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		tfCNPJ = new JTextField();
		tfCNPJ.setBounds(328, 113, 107, 20);
		contentPane.add(tfCNPJ);
		tfCNPJ.setColumns(10);
		
		JLabel label = new JLabel("CEP");
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setBounds(24, 226, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Rua");
		label_1.setFont(new Font("Arial", Font.BOLD, 13));
		label_1.setBounds(226, 226, 46, 14);
		contentPane.add(label_1);
		
		tfCEPAgenda = new JTextField();
		tfCEPAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaCep();
			}
		});
		tfCEPAgenda.setColumns(10);
		tfCEPAgenda.setBounds(24, 243, 71, 20);
		contentPane.add(tfCEPAgenda);
		
		tfRuaAgenda = new JTextField();
		tfRuaAgenda.setColumns(10);
		tfRuaAgenda.setBounds(227, 243, 121, 20);
		contentPane.add(tfRuaAgenda);
		
		JLabel label_3 = new JLabel("Cidade");
		label_3.setFont(new Font("Arial", Font.BOLD, 13));
		label_3.setBounds(372, 226, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Numero");
		label_4.setFont(new Font("Arial", Font.BOLD, 13));
		label_4.setBounds(478, 226, 71, 14);
		contentPane.add(label_4);
		
		tfNumeroAgenda = new JTextField();
		tfNumeroAgenda.setColumns(10);
		tfNumeroAgenda.setBounds(479, 243, 37, 20);
		contentPane.add(tfNumeroAgenda);
		
		tfCidadeAgenda = new JTextField();
		tfCidadeAgenda.setColumns(10);
		tfCidadeAgenda.setBounds(370, 243, 86, 20);
		contentPane.add(tfCidadeAgenda);
		
		tfBairroAgenda = new JTextField();
		tfBairroAgenda.setColumns(10);
		tfBairroAgenda.setBounds(131, 243, 73, 20);
		contentPane.add(tfBairroAgenda);
		
		JLabel lblBairro = new JLabel("Bairro\r\n");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 13));
		lblBairro.setBounds(131, 226, 46, 14);
		contentPane.add(lblBairro);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		button.setBounds(203, 315, 96, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cadastrar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cliente cliente = new cliente();
				
				cliente.setNome(tfNome.getText());
				cliente.setTelefone(tfTelefone.getText());
				
				ClienteDAO dao = new ClienteDAO();
				
				dao.AdicionarContato(cliente);		
				
				
				dispose();
			}
		});
		button_1.setBounds(328, 315, 96, 23);
		contentPane.add(button_1);
		
		JLabel lblProdutoFornecido = new JLabel("Produto Fornecido");
		lblProdutoFornecido.setFont(new Font("Arial", Font.BOLD, 13));
		lblProdutoFornecido.setBounds(22, 144, 138, 14);
		contentPane.add(lblProdutoFornecido);
		
		tfProdutoFornecido = new JTextField();		
		tfProdutoFornecido.setEditable(false);
		tfProdutoFornecido.setColumns(10);
		tfProdutoFornecido.setBounds(22, 158, 138, 20);
		contentPane.add(tfProdutoFornecido);
		
		
		
	}
	public void buscaCep() {
        //Faz a busca para o cep 58043-280
        WebServiceCep webServiceCep = WebServiceCep.searchCep(tfCEPAgenda.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        //caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
            tfRuaAgenda.setText(webServiceCep.getLogradouroFull());
            tfCidadeAgenda.setText(webServiceCep.getCidade());
            tfBairroAgenda.setText(webServiceCep.getBairro());
            //e1.setSelectedItem(webServiceCep.getUf());
//            System.out.println("Cep: " + webServiceCep.getCep());
//            System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
//            System.out.println("Bairro: " + webServiceCep.getBairro());
//            System.out.println("Cidade: "
//                    + webServiceCep.getCidade() + "/" + webServiceCep.getUf());

            //caso haja problemas imprime as exce??es.
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());

            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
        }
    }
}
