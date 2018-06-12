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
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormProdutoManufaturado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProdutoManufaturado frame = new FormProdutoManufaturado();
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
	public FormProdutoManufaturado() {
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

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(37, 82, 46, 14);
		contentPane.add(lblTipo);

		JLabel lblNome = new JLabel("Destino\r\n");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNome.setBounds(152, 82, 63, 14);
		contentPane.add(lblNome);

		JLabel lblOrigem = new JLabel("Valor");
		lblOrigem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrigem.setBounds(152, 162, 46, 14);
		contentPane.add(lblOrigem);

		JLabel lblQuantidade = new JLabel("Quantidade\r\n");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantidade.setBounds(37, 159, 74, 14);
		contentPane.add(lblQuantidade);

		JLabel lblDescrio = new JLabel("Data de Fabrica\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescrio.setBounds(286, 82, 124, 14);
		contentPane.add(lblDescrio);

		textField = new JTextField();
		textField.setBounds(152, 104, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(152, 184, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(37, 184, 46, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar\r\n");
		btnNewButton.setBounds(174, 286, 96, 23);
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(318, 286, 92, 23);
		contentPane.add(btnCancelar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(37, 104, 40, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(286, 107, 124, 20);
		contentPane.add(dateChooser);
		
		JLabel lblDataDeValidade = new JLabel("Data de Validade");
		lblDataDeValidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeValidade.setBounds(286, 163, 124, 14);
		contentPane.add(lblDataDeValidade);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(286, 184, 124, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblMateriaprima = new JLabel("Materia-Prima");
		lblMateriaprima.setForeground(new Color(0, 139, 139));
		lblMateriaprima.setBounds(250, 36, 96, 14);
		contentPane.add(lblMateriaprima);
	}
}
