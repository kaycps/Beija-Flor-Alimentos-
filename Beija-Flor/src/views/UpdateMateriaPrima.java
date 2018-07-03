package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.cliente;
import Classes.endereco;
import Classes.materiaPrima;
import DataBase.EnderecoDAO;
import DataBase.MateriaPrimaDAO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UpdateMateriaPrima extends JFrame {

	private JPanel contentPane;
	private JTextField tfQuantidade;
	private JTextField tfNome;
	private JTextField tfOrigem;
	private JTextField tfID;
	JTextArea taDescricao = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateMateriaPrima frame = new UpdateMateriaPrima();
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
	public UpdateMateriaPrima() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setColumns(10);
		tfQuantidade.setBounds(40, 160, 46, 20);
		contentPane.add(tfQuantidade);
		
		JLabel label = new JLabel("Quantidade\r\n");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(40, 135, 74, 14);
		contentPane.add(label);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(106, 104, 86, 20);
		contentPane.add(tfNome);
		
		JLabel label_1 = new JLabel("Nome\r\n");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(106, 82, 46, 14);
		contentPane.add(label_1);
		
		tfOrigem = new JTextField();
		tfOrigem.setColumns(10);
		tfOrigem.setBounds(216, 104, 86, 20);
		contentPane.add(tfOrigem);
		
		JLabel label_2 = new JLabel("Origem\r\n");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(216, 82, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Descri\u00E7\u00E3o\r\n");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(319, 82, 63, 14);
		contentPane.add(label_3);
		
		
		taDescricao.setBounds(320, 100, 254, 103);
		contentPane.add(taDescricao);
		
		JLabel label_4 = new JLabel("Materia-Prima");
		label_4.setForeground(new Color(32, 178, 170));
		label_4.setFont(new Font("Arial", Font.BOLD, 11));
		label_4.setBounds(256, 36, 86, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Cadastro de Produtos");
		label_5.setForeground(new Color(0, 139, 139));
		label_5.setFont(new Font("Arial", Font.BOLD, 15));
		label_5.setBounds(216, 11, 177, 14);
		contentPane.add(label_5);
		
		JButton btAtualizar = new JButton("Atualizar");
		btAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MateriaPrimaDAO mDao = new MateriaPrimaDAO();
				materiaPrima materiaPrima = new materiaPrima();
				
				materiaPrima.setId(Integer.valueOf(tfID.getText()));
				materiaPrima.setNome(tfNome.getText());
				materiaPrima.setDescricao(taDescricao.getText());
				materiaPrima.setOrigem(tfOrigem.getText());
				materiaPrima.setQuantidade(Integer.valueOf(tfQuantidade.getText()));
				
				mDao.AlterarMateriaPrima(materiaPrima);
				dispose();
				ConsultarMateriaPrima cMateriaPrima = new ConsultarMateriaPrima();
				cMateriaPrima.setVisible(true);
			}
		});
		btAtualizar.setBounds(319, 283, 100, 23);
		contentPane.add(btAtualizar);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btCancelar.setBounds(175, 283, 100, 23);
		contentPane.add(btCancelar);
		
		JLabel label_6 = new JLabel("Nome\r\n");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(40, 82, 46, 14);
		contentPane.add(label_6);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setColumns(10);
		tfID.setBounds(40, 104, 46, 20);
		contentPane.add(tfID);
	}
	
public void editarMateriaPrima(materiaPrima materiaPrima) {
					
		tfID.setText(Integer.toString(materiaPrima.getId()));
		tfNome.setText(materiaPrima.getNome());
		tfOrigem.setText(materiaPrima.getOrigem());
		tfQuantidade.setText(Integer.toString(materiaPrima.getQuantidade()));	
		taDescricao.setText(materiaPrima.getDescricao());	
		
	}
}
