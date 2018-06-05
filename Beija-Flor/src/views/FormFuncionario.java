package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.WebServiceCep;

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
import java.awt.event.ActionEvent;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;



public class FormFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField tfRua;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField tfCep;
	private JTextField textField_8;
	private JTextField tfCidade;
	private JTextField tfbairro;

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
		
		JComboBox cb_DataNascimento = new JComboBox();
		cb_DataNascimento.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cb_DataNascimento.setSelectedIndex(0);
		cb_DataNascimento.setBounds(284, 81, 46, 20);
		contentPane.add(cb_DataNascimento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox.setBounds(340, 81, 46, 20);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("/");
		label.setBounds(334, 83, 21, 17);
		contentPane.add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960"}));
		comboBox_1.setBounds(396, 81, 55, 20);
		contentPane.add(comboBox_1);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(390, 84, 21, 14);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(40, 244, 61, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
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
		
		textField_1 = new JTextField();
		textField_1.setBounds(121, 81, 141, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 188, 100, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(121, 132, 100, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		tfRua = new JTextField();
		tfRua.setBounds(365, 244, 121, 20);
		contentPane.add(tfRua);
		tfRua.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(121, 244, 100, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSexo.setBounds(40, 107, 37, 14);
		contentPane.add(lblSexo);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox_5.setBounds(40, 132, 37, 20);
		contentPane.add(comboBox_5);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 13));
		lblCodigo.setBounds(40, 56, 46, 14);
		contentPane.add(lblCodigo);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(40, 81, 37, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Arial", Font.BOLD, 13));
		lblEstadoCivil.setBounds(284, 107, 96, 14);
		contentPane.add(lblEstadoCivil);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Solteiro", "Casado", "Divorciado", "Vi\u00FAvo"}));
		comboBox_6.setBounds(283, 132, 85, 20);
		contentPane.add(comboBox_6);
		
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
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_7.setSelectedIndex(0);
		comboBox_7.setBounds(284, 188, 46, 20);
		contentPane.add(comboBox_7);
		
		JLabel label_4 = new JLabel("/");
		label_4.setBounds(334, 190, 21, 17);
		contentPane.add(label_4);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_8.setBounds(340, 188, 46, 20);
		contentPane.add(comboBox_8);
		
		JLabel label_5 = new JLabel("/");
		label_5.setBounds(390, 191, 21, 14);
		contentPane.add(label_5);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		comboBox_9.setBounds(396, 188, 55, 20);
		contentPane.add(comboBox_9);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Limpeza", "Produ\u00E7\u00E3o", "Administra\u00E7\u00E3o", "Almoxarifado"}));
		comboBox_2.setBounds(40, 188, 85, 20);
		contentPane.add(comboBox_2);
		
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
		
		textField_8 = new JTextField();
		textField_8.setBounds(456, 300, 37, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
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
		
		tfbairro = new JTextField();
		tfbairro.setBounds(282, 300, 73, 20);
		contentPane.add(tfbairro);
		tfbairro.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.BOLD, 13));
		lblBairro.setBounds(284, 276, 46, 14);
		contentPane.add(lblBairro);
		
		JLabel lblNewLabel_2 = new JLabel("Foto\r\n");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(503, 57, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		
	}
	public void buscaCep() {
        //Faz a busca para o cep 58043-280
        WebServiceCep webServiceCep = WebServiceCep.searchCep(tfCep.getText());
        //A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

        //caso a busca ocorra bem, imprime os resultados.
        if (webServiceCep.wasSuccessful()) {
            tfRua.setText(webServiceCep.getLogradouroFull());
            tfCidade.setText(webServiceCep.getCidade());
            tfbairro.setText(webServiceCep.getBairro());
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
