package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class FormProduto extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduto frame = new FormProduto();
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
	public FormProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setForeground(new Color(0, 139, 139));
		lblCadastroDeProdutos.setFont(new Font("Arial", Font.BOLD, 15));
		lblCadastroDeProdutos.setBounds(213, 11, 177, 14);
		contentPane.add(lblCadastroDeProdutos);

		JLabel lblNome = new JLabel("Nome\r\n");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(37, 82, 46, 14);
		contentPane.add(lblNome);

		JLabel lblOrigem = new JLabel("Origem\r\n");
		lblOrigem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrigem.setBounds(160, 82, 46, 14);
		contentPane.add(lblOrigem);

		JLabel lblQuantidade = new JLabel("Quantidade\r\n");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantidade.setBounds(37, 135, 74, 14);
		contentPane.add(lblQuantidade);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o\r\n");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescrio.setBounds(286, 82, 63, 14);
		contentPane.add(lblDescrio);

		textField = new JTextField();
		textField.setBounds(37, 104, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(160, 104, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(37, 160, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar\r\n");
		btnNewButton.setBounds(168, 282, 100, 23);
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(316, 282, 100, 23);
		contentPane.add(btnCancelar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(286, 99, 256, 105);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
