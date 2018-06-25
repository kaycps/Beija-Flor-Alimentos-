package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.WebServiceCep;
import Classes.endereco;
import Classes.funcionario;
import DataBase.EnderecoDAO;
import DataBase.FuncionarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.TextField;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.JDateChooser;



public class FormFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Salario;
	private JTextField tf_nome;
	private JTextField tf_CarteiraTrabalho;
	private JTextField tf_Telefone;
	private JTextField tfRua;
	private JTextField tf_Cpf;
	private JTextField tf_Id;
	private JTextField tfCep;
	private JTextField tf_Numero;
	private JTextField tfCidade;
	private JTextField tfBairro;
	JDateChooser data_Nasc = new JDateChooser();
	JDateChooser data_Contrat = new JDateChooser();
	JComboBox cb_Sexo = new JComboBox();
	JComboBox cb_Setor = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormFuncionario frame = new FormFuncionario();
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
	public FormFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome do Funcionario");
		lblNome.setFont(new Font("Arial", Font.BOLD, 13));
		lblNome.setBounds(121, 56, 153, 14);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("CPF\r\n\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(121, 219, 37, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTelefone = new JLabel("Telefone\r\n");
		lblTelefone.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefone.setBounds(121, 107, 71, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblDataDeContratao = new JLabel("Data de Contrata\u00E7\u00E3o");
		lblDataDeContratao.setFont(new Font("Arial", Font.BOLD, 13));
		lblDataDeContratao.setBounds(284, 163, 147, 14);
		contentPane.add(lblDataDeContratao);
		
		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 13));
		lblDataNascimento.setBounds(284, 56, 121, 14);
		contentPane.add(lblDataNascimento);
		
		JLabel lblCarteiraDeTrabalho = new JLabel("Carteira de Trabalho");
		lblCarteiraDeTrabalho.setFont(new Font("Arial", Font.BOLD, 13));
		lblCarteiraDeTrabalho.setBounds(131, 163, 147, 14);
		contentPane.add(lblCarteiraDeTrabalho);
		
		JLabel lblSetor = new JLabel("Setor");
		lblSetor.setFont(new Font("Arial", Font.BOLD, 13));
		lblSetor.setBounds(40, 163, 46, 14);
		contentPane.add(lblSetor);
		
		JLabel lblSalario = new JLabel("Salario");
		lblSalario.setFont(new Font("Arial", Font.BOLD, 13));
		lblSalario.setBounds(40, 219, 66, 14);
		contentPane.add(lblSalario);
		
		tf_Salario = new JTextField();
		tf_Salario.setBounds(40, 244, 61, 20);
		contentPane.add(tf_Salario);
		tf_Salario.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				funcionario funcionario = new funcionario();
				endereco endereco = new endereco();
				
				FuncionarioDAO fDao = new FuncionarioDAO();
				EnderecoDAO eDao = new EnderecoDAO();
				
				
				//setFuncionario
				funcionario.setNome(tf_nome.getText());
				funcionario.setCarteiraTrabalho(tf_CarteiraTrabalho.getText());
				funcionario.setCpf(tf_Cpf.getText());
				funcionario.setDataNascimento(data_Nasc.getDateFormatString());
				//funcionario.setDataContratacao(data_Contrat.getJCalendar());
				funcionario.setSalario(Double.parseDouble(tf_Salario.getText()));
				funcionario.setTelefone(tf_Telefone.getText());
				funcionario.setSetor((String)cb_Setor.getSelectedItem());
				funcionario.setSexo((String)cb_Sexo.getSelectedItem());
				
				System.out.println(""+funcionario.getDataContratacao());
				//setEndereço
				endereco.setCep(tfCep.getText());
				endereco.setCidade(tfCidade.getText());
				endereco.setBairro(tfBairro.getText());
				endereco.setRua(tfRua.getText());
				endereco.setNumero(tf_Numero.getText());
				/*try {
					endereco.setId(eDao.TotalEnderecos()+1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				/*funcionario.setEndereco(endereco);
				
				eDao.AdicionarEndereco(endereco);
				fDao.AdicionarFuncionario(funcionario);;*/
				
			}
		});
		btnCadastrar.setBounds(153, 299, 96, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(40, 299, 85, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblCadastroDeFuncionario = new JLabel("Cadastro de Funcionario");
		lblCadastroDeFuncionario.setForeground(new Color(0, 139, 139));
		lblCadastroDeFuncionario.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCadastroDeFuncionario.setBounds(203, 11, 190, 14);
		contentPane.add(lblCadastroDeFuncionario);
		
		tf_nome = new JTextField();
		tf_nome.setBounds(121, 81, 141, 20);
		contentPane.add(tf_nome);
		tf_nome.setColumns(10);
		
		tf_CarteiraTrabalho = new JTextField();
		tf_CarteiraTrabalho.setBounds(131, 188, 100, 20);
		contentPane.add(tf_CarteiraTrabalho);
		tf_CarteiraTrabalho.setColumns(10);
		
		tf_Telefone = new JTextField();
		tf_Telefone.setBounds(121, 132, 100, 20);
		contentPane.add(tf_Telefone);
		tf_Telefone.setColumns(10);
		
		tfRua = new JTextField();
		tfRua.setBounds(365, 244, 121, 20);
		contentPane.add(tfRua);
		tfRua.setColumns(10);
		
		tf_Cpf = new JTextField();
		tf_Cpf.setBounds(121, 244, 100, 20);
		contentPane.add(tf_Cpf);
		tf_Cpf.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSexo.setBounds(40, 107, 37, 14);
		contentPane.add(lblSexo);
		
		
		cb_Sexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cb_Sexo.setBounds(40, 132, 37, 20);
		contentPane.add(cb_Sexo);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 13));
		lblCodigo.setBounds(40, 56, 46, 14);
		contentPane.add(lblCodigo);
		
		tf_Id = new JTextField();
		tf_Id.setEditable(false);
		tf_Id.setBounds(40, 81, 37, 20);
		contentPane.add(tf_Id);
		tf_Id.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Arial", Font.BOLD, 13));
		lblEstadoCivil.setBounds(284, 107, 96, 14);
		contentPane.add(lblEstadoCivil);
		
		JComboBox cb_EstadoCivil = new JComboBox();
		cb_EstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Solteiro", "Casado", "Divorciado", "Vi\u00FAvo"}));
		cb_EstadoCivil.setBounds(283, 132, 85, 20);
		contentPane.add(cb_EstadoCivil);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kaycp\\Downloads\\icons8-funcion\u00E1rio-homem-80.png"));
		lblNewLabel_1.setBounds(481, 81, 80, 97);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Adicionar \r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnNewButton.setBounds(481, 187, 80, 23);
		contentPane.add(btnNewButton);
		
		
		cb_Setor.setModel(new DefaultComboBoxModel(new String[] {"Limpeza", "Produ\u00E7\u00E3o", "Administra\u00E7\u00E3o", "Almoxarifado"}));
		cb_Setor.setBounds(40, 188, 85, 20);
		contentPane.add(cb_Setor);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.BOLD, 13));
		lblCep.setBounds(284, 219, 46, 14);
		contentPane.add(lblCep);
		
		tfCep = new JTextField();
		tfCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaCep();
			}
		});
		tfCep.setBounds(284, 244, 71, 20);
		contentPane.add(tfCep);
		tfCep.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Arial", Font.BOLD, 13));
		lblRua.setBounds(365, 219, 46, 14);
		contentPane.add(lblRua);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Arial", Font.BOLD, 13));
		lblNumero.setBounds(456, 275, 71, 14);
		contentPane.add(lblNumero);
		
		tf_Numero = new JTextField();
		tf_Numero.setBounds(456, 300, 37, 20);
		contentPane.add(tf_Numero);
		tf_Numero.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial", Font.BOLD, 13));
		lblCidade.setBounds(365, 275, 46, 14);
		contentPane.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(365, 300, 86, 20);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(284, 276, 46, 14);
		contentPane.add(label_2);
		
		tfBairro = new JTextField();
		tfBairro.setBounds(282, 300, 73, 20);
		contentPane.add(tfBairro);
		tfBairro.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 13));
		lblBairro.setBounds(284, 276, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblNewLabel_2 = new JLabel("Foto\r\n");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(503, 57, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		
		data_Contrat.setBounds(281, 188, 109, 20);
		contentPane.add(data_Contrat);
		
		
		data_Nasc.setBounds(284, 81, 109, 20);
		contentPane.add(data_Nasc);
		
		
		
	}
	public void buscaCep() {
        //Faz a busca para o cep 58043-280
        WebServiceCep webServiceCep = WebServiceCep.searchCep(tfCep.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        //caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
            tfRua.setText(webServiceCep.getLogradouroFull());
            tfCidade.setText(webServiceCep.getCidade());
            tfBairro.setText(webServiceCep.getBairro());
            //e1.setSelectedItem(webServiceCep.getUf());
            System.out.println("Cep: " + webServiceCep.getCep());
            System.out.println("Logradouro: " + webServiceCep.getLogradouroFull());
            System.out.println("Bairro: " + webServiceCep.getBairro());
            System.out.println("Cidade: "
                    + webServiceCep.getCidade() + "/" + webServiceCep.getUf());

            //caso haja problemas imprime as exce??es.
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());

            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
        }
    }
}
