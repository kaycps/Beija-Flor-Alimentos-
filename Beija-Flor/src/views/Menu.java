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
import java.awt.Font;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(200, 198, 584, 363);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(0, 0, 201, 561);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JDayChooser dayChooser = new JDayChooser();
		dayChooser.setBounds(10, 375, 175, 133);
		panel_1.add(dayChooser);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(246, 118, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(441, 118, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(655, 118, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/icons8-solicitar-dinheiro-48.png")));
		lblNewLabel.setBounds(260, 48, 48, 59);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\kaycp\\Downloads\\icons8-iniciar-transfer\u00EAncia-de-dinheiro-48.png"));
		label.setBounds(456, 34, 55, 66);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\kaycp\\Downloads\\icons8-performance-de-vendas-40.png"));
		label_1.setBounds(676, 34, 48, 66);
		contentPane.add(label_1);
		
		JLabel lblCredito = new JLabel("Credito");
		lblCredito.setFont(new Font("Arial", Font.BOLD, 13));
		lblCredito.setBounds(262, 23, 46, 14);
		contentPane.add(lblCredito);
		
		JLabel lblDebito = new JLabel("Debito");
		lblDebito.setFont(new Font("Arial", Font.BOLD, 13));
		lblDebito.setBounds(465, 23, 46, 14);
		contentPane.add(lblDebito);
		
		JLabel lblSaldo = new JLabel("Saldo\r\n");
		lblSaldo.setFont(new Font("Arial", Font.BOLD, 13));
		lblSaldo.setBounds(678, 23, 46, 14);
		contentPane.add(lblSaldo);
	}
}
