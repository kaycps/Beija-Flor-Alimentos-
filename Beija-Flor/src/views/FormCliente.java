package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.WebServiceCep;
import Classes.cliente;
import Classes.endereco;
import DataBase.ClienteDAO;
import DataBase.EnderecoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
	private JComboBox cbTipo; 

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
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 13));
		lblNome.setBounds(167, 97, 48, 14);
		contentPane.add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefone.setBounds(323, 97, 73, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblCnpj = new JLabel("CNPJ");
		lblCnpj.setFont(new Font("Arial", Font.BOLD, 13));
		lblCnpj.setBounds(430, 97, 48, 14);
		contentPane.add(lblCnpj);
		
		tfNome = new JTextField();
		tfNome.setBounds(167, 114, 131, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(323, 114, 86, 20);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		tfCNPJ = new JTextField();
		tfCNPJ.setBounds(430, 114, 86, 20);
		contentPane.add(tfCNPJ);
		tfCNPJ.setColumns(10);
		
		JLabel label = new JLabel("CEP");
		label.setFont(new Font("Arial", Font.BOLD, 13));
		label.setBounds(24, 172, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Rua");
		label_1.setFont(new Font("Arial", Font.BOLD, 13));
		label_1.setBounds(226, 172, 46, 14);
		contentPane.add(label_1);
		
		tfCEPAgenda = new JTextField();
		tfCEPAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaCep();
			}
		});
		tfCEPAgenda.setColumns(10);
		tfCEPAgenda.setBounds(24, 189, 71, 20);
		contentPane.add(tfCEPAgenda);
		
		tfRuaAgenda = new JTextField();
		tfRuaAgenda.setColumns(10);
		tfRuaAgenda.setBounds(227, 189, 121, 20);
		contentPane.add(tfRuaAgenda);
		
		JLabel label_3 = new JLabel("Cidade");
		label_3.setFont(new Font("Arial", Font.BOLD, 13));
		label_3.setBounds(372, 172, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Numero");
		label_4.setFont(new Font("Arial", Font.BOLD, 13));
		label_4.setBounds(478, 172, 71, 14);
		contentPane.add(label_4);
		
		tfNumeroAgenda = new JTextField();
		tfNumeroAgenda.setColumns(10);
		tfNumeroAgenda.setBounds(479, 189, 37, 20);
		contentPane.add(tfNumeroAgenda);
		
		tfCidadeAgenda = new JTextField();
		tfCidadeAgenda.setColumns(10);
		tfCidadeAgenda.setBounds(370, 189, 86, 20);
		contentPane.add(tfCidadeAgenda);
		
		tfBairroAgenda = new JTextField();
		tfBairroAgenda.setColumns(10);
		tfBairroAgenda.setBounds(131, 189, 73, 20);
		contentPane.add(tfBairroAgenda);
		
		JLabel lblBairro = new JLabel("Bairro\r\n");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 13));
		lblBairro.setBounds(131, 172, 46, 14);
		contentPane.add(lblBairro);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		button.setBounds(190, 299, 96, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Cadastrar");
		button_1.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				cliente cliente = new cliente();
				endereco endereco = new endereco();
				
				//SetCliente
				cliente.setNome(tfNome.getText());
				cliente.setTelefone(tfTelefone.getText());
				cliente.setCnpj(tfCNPJ.getText());
				cliente.setTipo((String)cbTipo.getSelectedItem());
				//setEndereco
				endereco.setBairro(tfBairroAgenda.getText());
				endereco.setCidade(tfCidadeAgenda.getText());
				endereco.setCep(tfCEPAgenda.getText());
				endereco.setRua(tfRuaAgenda.getText());
				endereco.setNumero(tfNumeroAgenda.getText());
				//setEndereço_Cliente
				cliente.setEndereco(endereco);
				
				EnderecoDAO eDao = new EnderecoDAO();
				ClienteDAO dao = new ClienteDAO();
				
				eDao.AdicionarEndereco(endereco);
				dao.AdicionarContato(cliente);	
				
				
				dispose();
			}
		});
		button_1.setBounds(315, 299, 96, 23);
		contentPane.add(button_1);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipo.setBounds(24, 97, 46, 14);
		contentPane.add(lblTipo);
		
		cbTipo = new JComboBox();
		cbTipo.setFont(new Font("Arial", Font.PLAIN, 13));
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Fornecedor", "Cliente"}));
		cbTipo.setBounds(24, 113, 97, 20);
		contentPane.add(cbTipo);
		
		
		
	}
	public void buscaCep() {
        //Faz a busca para o cep
        WebServiceCep webServiceCep = WebServiceCep.searchCep(tfCEPAgenda.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.
        
        if (webServiceCep.wasSuccessful()) {
            tfRuaAgenda.setText(webServiceCep.getLogradouroFull());
            tfCidadeAgenda.setText(webServiceCep.getCidade());
            tfBairroAgenda.setText(webServiceCep.getBairro());
            //e1.setSelectedItem(webServiceCep.getUf());

        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());

            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
        }
    }
	
	public void editarCliente(cliente cliente) {
		
		tfNome.setText(cliente.getNome());
		tfTelefone.setText(cliente.getTelefone());		
		
	}
}
