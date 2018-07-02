package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classes.materiaPrima;
import DataBase.MateriaPrimaDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarMateriaPrima extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarMateriaPrima frame = new ConsultarMateriaPrima();
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
	public ConsultarMateriaPrima() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 278, 600, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaMateriaPrima = new JLabel("Consulta Materia Prima");
		lblConsultaMateriaPrima.setForeground(new Color(0, 139, 139));
		lblConsultaMateriaPrima.setFont(new Font("Arial", Font.BOLD, 15));
		lblConsultaMateriaPrima.setBounds(208, 11, 170, 14);
		contentPane.add(lblConsultaMateriaPrima);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnEditar.setBounds(450, 178, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(450, 212, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnVoltar.setBounds(229, 316, 89, 23);
		contentPane.add(btnVoltar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 154, 361, 81);
		contentPane.add(scrollPane);
		
		MateriaPrimaDAO mDao = new MateriaPrimaDAO();
		
		List<materiaPrima> materiaPrimas = mDao.buscarMateriaPrimas();
		
		//Criação da Table
		String coluna[]= {"Id","Nome","Quantidade","Descrição","Origem"};
		DefaultTableModel tableModel = new DefaultTableModel(coluna,0);
		JTable table = new JTable(tableModel);
				//Transformando arrayList em Object
				for(int i = 0; i<materiaPrimas.size();i++) {
					
					int id = materiaPrimas.get(i).getId();
					String nome = materiaPrimas.get(i).getNome();
					int Quantidade = materiaPrimas.get(i).getQuantidade();			
					String Descrição = materiaPrimas.get(i).getDescricao();
					String Origem = materiaPrimas.get(i).getOrigem();
					
					Object data[]= {id,nome,Quantidade,Descrição,Origem};			
					tableModel.addRow(data);
				}
		scrollPane.setViewportView(table);		
				
	}
}
