package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.parser.Element;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.demo.DateChooserPanel;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class FormVenda extends JFrame {

	private JPanel contentPane;
	private JTextField tf_Destino;
	private JTextField tf_Quantidade;
	private JTextField tf_Valor;
	private JTextField tf_Produto;
	JCalendar calendar = new JCalendar();
	private JTextField textField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdicionarVenda = new JLabel("Adicionar Venda");
		lblAdicionarVenda.setForeground(new Color(0, 128, 128));
		lblAdicionarVenda.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAdicionarVenda.setBounds(217, 24, 115, 14);
		contentPane.add(lblAdicionarVenda);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(191, 307, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				String dade =""+ calendar.getYearChooser().getValue()+"/"+calendar.getMonthChooser().getMonth()+"/"+calendar.getDayChooser().getDay();
				System.out.println(""+dade);
				
				
			}
		});
		btnCadastrar.setBounds(319, 307, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblDestino = new JLabel("Destino :");
		lblDestino.setFont(new Font("Arial", Font.BOLD, 13));
		lblDestino.setBounds(42, 90, 67, 14);
		contentPane.add(lblDestino);
		
		tf_Destino = new JTextField();
		tf_Destino.setText("Destino");
		tf_Destino.setBounds(114, 88, 89, 20);
		contentPane.add(tf_Destino);
		tf_Destino.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantidade :\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(42, 159, 82, 14);
		contentPane.add(lblNewLabel);
		
		tf_Quantidade = new JTextField();
		tf_Quantidade.setBounds(134, 153, 46, 20);
		contentPane.add(tf_Quantidade);
		tf_Quantidade.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Unitario :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(42, 197, 105, 14);
		contentPane.add(lblNewLabel_1);
		
		tf_Valor = new JTextField();
		tf_Valor.setBounds(144, 195, 46, 20);
		contentPane.add(tf_Valor);
		tf_Valor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Produto :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(42, 124, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		tf_Produto = new JTextField();
		tf_Produto.setBounds(114, 122, 89, 20);
		contentPane.add(tf_Produto);
		tf_Produto.setColumns(10);
		
		JLabel lblDataDaVenda = new JLabel("Data da Venda :");
		lblDataDaVenda.setFont(new Font("Arial", Font.BOLD, 13));
		lblDataDaVenda.setBounds(341, 90, 105, 14);
		contentPane.add(lblDataDaVenda);
		
		
		calendar.setBounds(341, 118, 214, 122);
		contentPane.add(calendar);
		
		JLabel lblValorTotal = new JLabel("Valor Total :");
		lblValorTotal.setFont(new Font("Arial", Font.BOLD, 13));
		lblValorTotal.setBounds(42, 234, 82, 14);
		contentPane.add(lblValorTotal);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(134, 230, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		
		
		
		
	}
}
