package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;

import Classes.funcionario;
import Classes.materiaPrima;
import DataBase.MateriaPrimaDAO;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Menu extends JFrame {

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
					Menu frame = new Menu();
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
	public Menu() {
		FormFuncionario funcionario = new FormFuncionario();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(200, 144, 584, 417);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/logo.png")));
		lblNewLabel_1.setBounds(180, 140, 185, 137);
		panel.add(lblNewLabel_1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 0, 201, 561);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JDayChooser dayChooser = new JDayChooser();
		dayChooser.setBounds(10, 417, 175, 133);
		panel_1.add(dayChooser);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Adicionar venda");
		mntmNewMenuItem.setBounds(0, 30, 201, 19);
		panel_1.add(mntmNewMenuItem);
		mntmNewMenuItem.setIcon(new ImageIcon(Menu.class.getResource("/icons8-mais-16.png")));
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consultar Venda");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Menu.class.getResource("/icons8-pesquisar-16.png")));
		mntmNewMenuItem_1.setBounds(0, 48, 201, 22);
		panel_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Adicionar Dispesa");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Menu.class.getResource("/icons8-su\u00ED\u00E7a-16.png")));
		mntmNewMenuItem_2.setBounds(0, 67, 201, 22);
		panel_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Consultar Despesa");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Menu.class.getResource("/icons8-pesquisar-16.png")));
		mntmNewMenuItem_3.setBounds(0, 86, 201, 22);
		panel_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Funcion\u00E1rios");
		mntmNewMenuItem_4.setFont(new Font("Arial", Font.BOLD, 13));
		mntmNewMenuItem_4.setIcon(new ImageIcon(Menu.class.getResource("/icons8-empres\u00E1ria-16.png")));
		mntmNewMenuItem_4.setBounds(0, 119, 201, 22);
		panel_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Cadastrar Funcion\u00E1rio");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(funcionario.isVisible()==true) {
					
				}else {
					funcionario.setVisible(true);
				}
				
				
;			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon(Menu.class.getResource("/icons8-mais-16.png")));
		mntmNewMenuItem_5.setBounds(0, 138, 201, 22);
		panel_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Consultar Funcion\u00E1rio");
		mntmNewMenuItem_6.setIcon(new ImageIcon(Menu.class.getResource("/icons8-pesquisar-16.png")));
		mntmNewMenuItem_6.setBounds(0, 157, 201, 22);
		panel_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Finan\u00E7as");
		mntmNewMenuItem_7.setIcon(new ImageIcon(Menu.class.getResource("/icons8-fluxo-de-caixa-16.png")));
		mntmNewMenuItem_7.setFont(new Font("Arial", Font.BOLD, 13));
		mntmNewMenuItem_7.setBounds(0, 11, 201, 22);
		panel_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Agenda");
		mntmNewMenuItem_8.setIcon(new ImageIcon(Menu.class.getResource("/icons8-contatos-16.png")));
		mntmNewMenuItem_8.setFont(new Font("Arial", Font.BOLD, 13));
		mntmNewMenuItem_8.setBounds(0, 190, 201, 22);
		panel_1.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Adicionar Contato");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormCliente cliente = new FormCliente();
				cliente.setVisible(true);
				
			}
		});
		mntmNewMenuItem_9.setIcon(new ImageIcon(Menu.class.getResource("/icons8-mais-16.png")));
		mntmNewMenuItem_9.setBounds(0, 209, 201, 22);
		panel_1.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Consultar Contato");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarAgenda cAgenda = new ConsultarAgenda();
				cAgenda.setVisible(true);
			}
		});
		mntmNewMenuItem_10.setIcon(new ImageIcon(Menu.class.getResource("/icons8-pesquisar-16.png")));
		mntmNewMenuItem_10.setBounds(0, 226, 201, 22);
		panel_1.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Estoque");
		mntmNewMenuItem_11.setIcon(new ImageIcon(Menu.class.getResource("/icons8-caixa-vazia-16.png")));
		mntmNewMenuItem_11.setFont(new Font("Arial", Font.BOLD, 13));
		mntmNewMenuItem_11.setBounds(0, 259, 201, 22);
		panel_1.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Cadastrar Item");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UIManager.put("OptionPane.cancelButtonText", "Cancelar");
				UIManager.put("OptionPane.noButtonText", "Materia-Prima");
				UIManager.put("OptionPane.yesButtonText", "Manufaturado");			
				
				
				int i = JOptionPane.showConfirmDialog(null, "Escolha uma Opção:", "Tipo",1);
				
				if(i==JOptionPane.YES_OPTION) {
					FormProdutoManufaturado pm = new FormProdutoManufaturado();
					pm.setVisible(true);
				}else if(i==JOptionPane.NO_OPTION) {
					
					FormProduto produto = new FormProduto();
					produto.setVisible(true);
				}
				
			}
		});
		mntmNewMenuItem_12.setIcon(new ImageIcon(Menu.class.getResource("/icons8-mais-16.png")));
		mntmNewMenuItem_12.setBounds(0, 277, 201, 22);
		panel_1.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Consultar Estoque\r\n");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				ConsultarMateriaPrima cMateriaPrima = new ConsultarMateriaPrima();
				cMateriaPrima.setVisible(true);
				
				
			}
		});
		mntmNewMenuItem_13.setIcon(new ImageIcon(Menu.class.getResource("/icons8-pesquisar-16.png")));
		mntmNewMenuItem_13.setBounds(0, 297, 201, 22);
		panel_1.add(mntmNewMenuItem_13);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			FormVenda venda = new FormVenda();
			public void actionPerformed(ActionEvent arg0) {
				
				venda.setVisible(true);
			}
		});
		
		
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(246, 104, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(439, 104, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);	
		
			
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(654, 104, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/icons8-solicitar-dinheiro-48.png")));
		lblNewLabel.setBounds(260, 48, 48, 59);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Menu.class.getResource("/icons8-iniciar-transfer\u00EAncia-de-dinheiro-48.png")));
		label.setBounds(457, 34, 54, 72);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Menu.class.getResource("/icons8-performance-de-vendas-40.png")));
		label_1.setBounds(676, 41, 48, 59);
		contentPane.add(label_1);
		
		JLabel lblCredito = new JLabel("Credito");
		lblCredito.setFont(new Font("Arial", Font.BOLD, 13));
		lblCredito.setBounds(260, 34, 46, 14);
		contentPane.add(lblCredito);
		
		JLabel lblDebito = new JLabel("Debito");
		lblDebito.setFont(new Font("Arial", Font.BOLD, 13));
		lblDebito.setBounds(457, 34, 46, 14);
		contentPane.add(lblDebito);
		
		JLabel lblSaldo = new JLabel("Saldo\r\n");
		lblSaldo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSaldo.setBounds(678, 34, 46, 14);
		contentPane.add(lblSaldo);
	}
}
