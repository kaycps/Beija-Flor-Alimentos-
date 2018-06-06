package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarAgenda extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

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
		
		JLabel lblContatos = new JLabel("Contatos");
		lblContatos.setForeground(new Color(0, 128, 128));
		lblContatos.setFont(new Font("Arial", Font.BOLD, 15));
		lblContatos.setBounds(267, 11, 64, 14);
		contentPane.add(lblContatos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 310, 392, -131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(224, 255, 255));
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Tipo", "Nome", "Telefone", "Endere\u00E7o", "CNPJ", "Produto Fornecido"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setFont(new Font("Arial", Font.BOLD, 13));
		lblNome.setBounds(51, 91, 46, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(104, 91, 123, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(267, 88, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(431, 174, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(431, 209, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnVoltar.setBounds(267, 336, 89, 23);
		contentPane.add(btnVoltar);
	}
}
