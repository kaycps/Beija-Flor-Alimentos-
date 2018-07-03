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

import Classes.produtoManufaturado;
import DataBase.ManufaturadoDao;

import java.awt.event.ActionListener;
import java.time.Year;
import java.awt.event.ActionEvent;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class FormProdutoManufaturado extends JFrame {

	private JPanel contentPane;
	private JTextField tfValor;
	private JTextField tfQuantidade;
	JComboBox cbTipo = new JComboBox();
	JComboBox cbDiaF = new JComboBox();
	JComboBox cbMesF = new JComboBox();
	JComboBox cbAnoF = new JComboBox();
	JComboBox cbDiaV = new JComboBox();
	JComboBox cbMesV = new JComboBox();
	JComboBox cbAnoV = new JComboBox();
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JLabel lblTipo = new JLabel("Tipo :");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(37, 95, 46, 14);
		contentPane.add(lblTipo);

		JLabel lblOrigem = new JLabel("Valor :");
		lblOrigem.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrigem.setBounds(37, 152, 46, 14);
		contentPane.add(lblOrigem);

		JLabel lblQuantidade = new JLabel("Quantidade :\r\n");
		lblQuantidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuantidade.setBounds(37, 124, 86, 14);
		contentPane.add(lblQuantidade);

		JLabel lblDescrio = new JLabel("Data de Fabrica\u00E7\u00E3o :");
		lblDescrio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescrio.setBounds(37, 212, 133, 14);
		contentPane.add(lblDescrio);

		tfValor = new JTextField();
		tfValor.setBounds(84, 150, 86, 20);
		contentPane.add(tfValor);
		tfValor.setColumns(10);

		tfQuantidade = new JTextField();
		tfQuantidade.setBounds(127, 122, 53, 20);
		contentPane.add(tfQuantidade);
		tfQuantidade.setColumns(10);

		JButton btnNewButton = new JButton("Cadastrar\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				produtoManufaturado pManufaturado = new produtoManufaturado();
				
				//data fabricação
				String anoF = String.valueOf(cbAnoF.getSelectedItem());
				String diaF = String.valueOf(cbDiaF.getSelectedItem());
				String mesF = String.valueOf(cbMesF.getSelectedItem());
				String dataFabricação = ""+diaF+"-"+mesF+"-"+anoF;
				
				//data validade
				String anoV = String.valueOf(cbAnoV.getSelectedItem());
				String mesV = String.valueOf(cbMesV.getSelectedItem());
				String diaV = String.valueOf(cbDiaV.getSelectedItem());
				String dataValidade = ""+diaV+"-"+mesV+"-"+anoV;
				
				pManufaturado.setDataFabricacao(dataFabricação);
				pManufaturado.setValidade(dataValidade);				
				pManufaturado.setValor(Double.parseDouble(tfValor.getText()));
				pManufaturado.setTipo(Integer.valueOf((String) cbTipo.getSelectedItem()));
				pManufaturado.setQuantidade(Integer.valueOf(tfQuantidade.getText()));
				
				ManufaturadoDao mDao = new ManufaturadoDao();
				mDao.AdicionarManufaturado(pManufaturado);
				dispose();
				
			}
		});
		btnNewButton.setBounds(294, 283, 96, 23);
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnCancelar.setBounds(172, 283, 92, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblDataDeValidade = new JLabel("Data de Validade :\r\n");
		lblDataDeValidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeValidade.setBounds(37, 181, 124, 14);
		contentPane.add(lblDataDeValidade);
		
		JLabel lblMateriaprima = new JLabel("Manufaturado");
		lblMateriaprima.setForeground(new Color(0, 139, 139));
		lblMateriaprima.setBounds(250, 36, 96, 14);
		contentPane.add(lblMateriaprima);
		
		
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		cbTipo.setBounds(80, 93, 46, 20);
		contentPane.add(cbTipo);
		
		
		cbDiaF.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDiaF.setBounds(180, 206, 37, 20);
		contentPane.add(cbDiaF);
		
		
		cbMesF.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbMesF.setBounds(227, 206, 46, 20);
		contentPane.add(cbMesF);
		
		
		cbAnoF.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cbAnoF.setBounds(290, 206, 53, 20);
		contentPane.add(cbAnoF);
		
		
		cbDiaV.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cbDiaV.setBounds(163, 175, 37, 20);
		contentPane.add(cbDiaV);
		
		
		cbMesV.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		cbMesV.setBounds(213, 175, 46, 20);
		contentPane.add(cbMesV);
		
		
		cbAnoV.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
		cbAnoV.setBounds(274, 175, 53, 20);
		contentPane.add(cbAnoV);
		
		JLabel label = new JLabel("/");
		label.setBounds(205, 178, 10, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("/");
		label_1.setBounds(265, 178, 10, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("/");
		label_2.setBounds(220, 206, 10, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("/");
		label_3.setBounds(280, 206, 10, 14);
		contentPane.add(label_3);
	}
}
