package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.produtoManufaturado;
import DataBase.ManufaturadoDao;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class UpdateManufaturado extends JFrame {

	private JPanel contentPane;
	private JTextField tfQuantidade;
	private JTextField tfValor;
	private JTextField tfId;
	JComboBox cbDiaV = new JComboBox();
	JComboBox cbMesV = new JComboBox();
	JComboBox cbAnoV = new JComboBox();
	JComboBox cbAnoF = new JComboBox();
	JComboBox cbMesF = new JComboBox();
	JComboBox cbDiaF = new JComboBox();
	JComboBox cbTipo = new JComboBox();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateManufaturado frame = new UpdateManufaturado();
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
	public UpdateManufaturado() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Cadastro de Produtos");
		label.setForeground(new Color(0, 139, 139));
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBounds(213, 11, 177, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Manufaturado");
		label_1.setForeground(new Color(0, 139, 139));
		label_1.setBounds(250, 36, 96, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Tipo :");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(37, 110, 46, 14);
		contentPane.add(label_2);
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		
		
		cbTipo.setBounds(80, 108, 46, 20);
		contentPane.add(cbTipo);
		
		JLabel label_3 = new JLabel("Quantidade :\r\n");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(37, 139, 86, 14);
		contentPane.add(label_3);
		
		tfQuantidade = new JTextField();
		tfQuantidade.setColumns(10);
		tfQuantidade.setBounds(127, 137, 53, 20);
		contentPane.add(tfQuantidade);
		
		JLabel label_4 = new JLabel("Valor :");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(37, 167, 46, 14);
		contentPane.add(label_4);
		
		tfValor = new JTextField();
		tfValor.setColumns(10);
		tfValor.setBounds(84, 165, 86, 20);
		contentPane.add(tfValor);
		
		JLabel label_5 = new JLabel("Data de Validade :\r\n");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(37, 196, 124, 14);
		contentPane.add(label_5);
		cbDiaV.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		
		cbDiaV.setBounds(163, 190, 37, 20);
		contentPane.add(cbDiaV);
		cbMesV.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		
		cbMesV.setBounds(213, 190, 37, 20);
		contentPane.add(cbMesV);
		cbAnoV.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		
		
		cbAnoV.setBounds(263, 190, 53, 20);
		contentPane.add(cbAnoV);
		cbAnoF.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		
		
		cbAnoF.setBounds(280, 221, 53, 20);
		contentPane.add(cbAnoF);
		cbMesF.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		
		
		cbMesF.setBounds(230, 221, 37, 20);
		contentPane.add(cbMesF);
		cbDiaF.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		
		
		cbDiaF.setBounds(180, 221, 37, 20);
		contentPane.add(cbDiaF);
		
		JLabel label_6 = new JLabel("Data de Fabrica\u00E7\u00E3o :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(37, 227, 133, 14);
		contentPane.add(label_6);
		
		JButton button = new JButton("Cancelar");
		button.setBounds(173, 298, 92, 23);
		contentPane.add(button);
		
		JButton btnAtualizar = new JButton("Atualizar\r\n");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManufaturadoDao mDao = new ManufaturadoDao();
				produtoManufaturado manufaturado = new produtoManufaturado();
				
				manufaturado.setId(Integer.valueOf(tfId.getText()));
				manufaturado.setTipo(Integer.valueOf((String) cbTipo.getSelectedItem()));
				manufaturado.setQuantidade(Integer.valueOf(tfQuantidade.getText()));
				manufaturado.setValor(Double.parseDouble(tfValor.getText()));
				
				String validade = ""+cbDiaV+"-"+cbMesV+"-"+cbAnoV;
				String fabricacao = ""+cbDiaF+"-"+cbMesF+"-"+cbAnoF;
				
				manufaturado.setDataFabricacao(fabricacao);
				manufaturado.setValidade(validade);
				
				mDao.AlterarManufaturado(manufaturado);
			}
		});
		btnAtualizar.setBounds(294, 298, 96, 23);
		contentPane.add(btnAtualizar);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(37, 85, 28, 14);
		contentPane.add(lblId);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setBounds(63, 83, 28, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("/");
		lblNewLabel.setBounds(205, 192, 10, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label_7 = new JLabel("/");
		label_7.setBounds(257, 193, 10, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("/");
		label_8.setBounds(223, 224, 10, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("/");
		label_9.setBounds(273, 224, 10, 14);
		contentPane.add(label_9);
		
		JLabel lblNewLabel_1 = new JLabel("dd/MM/AAAA");
		lblNewLabel_1.setBounds(344, 196, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_10 = new JLabel("dd/MM/AAAA");
		label_10.setBounds(343, 224, 64, 14);
		contentPane.add(label_10);
	}
	
	public void editarManufaturado(produtoManufaturado manufaturado) {
		
		tfId.setText(String.valueOf(manufaturado.getId()));
		tfQuantidade.setText((String.valueOf(manufaturado.getQuantidade())));
		tfValor.setText((String.valueOf(manufaturado.getValor())));
		
		if(manufaturado.getTipo()==1) {
			cbTipo.setSelectedIndex(0);
		}else if(manufaturado.getTipo()==2) {
			cbTipo.setSelectedIndex(1);
		}else if(manufaturado.getTipo()==3) {
			cbTipo.setSelectedIndex(2);
		}
		
		String validade [] = manufaturado.getDataFabricacao().split("-");
		String fabricacao [] = manufaturado.getValidade().split("-");
		
		cbDiaF.setSelectedItem(validade[0]);
		cbMesF.setSelectedItem(validade[1]);
		cbAnoF.setSelectedItem(validade[2]);
		
		cbDiaV.setSelectedItem(fabricacao[0]);
		cbMesV.setSelectedItem(fabricacao[1]);
		cbAnoV.setSelectedItem(fabricacao[2]);
		
		
		
		
		
	}

}
