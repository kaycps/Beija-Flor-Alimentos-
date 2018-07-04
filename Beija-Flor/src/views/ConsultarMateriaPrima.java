package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classes.cliente;
import Classes.materiaPrima;
import Classes.produtoManufaturado;
import DataBase.ManufaturadoDao;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 465, 81);
		contentPane.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 196, 465, 81);
		contentPane.add(scrollPane_1);

		MateriaPrimaDAO mDao = new MateriaPrimaDAO();
		ManufaturadoDao manufaturadoDao = new ManufaturadoDao();

		List<materiaPrima> materiaPrimas = mDao.buscarMateriaPrimas();
		List<produtoManufaturado> manufaturados = manufaturadoDao.buscarManufaturados();

		// Criação da Table materia prima
		String coluna[] = { "Id", "Nome", "Quantidade", "Descrição", "Origem" };
		DefaultTableModel tableModel = new DefaultTableModel(coluna, 0);
		JTable table = new JTable(tableModel);
		// Transformando arrayList em Object
		for (int i = 0; i < materiaPrimas.size(); i++) {

			int id = materiaPrimas.get(i).getId();
			String nome = materiaPrimas.get(i).getNome();
			int Quantidade = materiaPrimas.get(i).getQuantidade();
			String Descrição = materiaPrimas.get(i).getDescricao();
			String Origem = materiaPrimas.get(i).getOrigem();

			Object data[] = { id, nome, Quantidade, Descrição, Origem };
			tableModel.addRow(data);
		}
		////

		// Criação da Table manufaturado
		String colunaManu[] = { "Id", "Tipo", "Quantidade", "valor", "DataFabricação", "Validade" };
		DefaultTableModel tableModelManu = new DefaultTableModel(colunaManu, 0);
		JTable tableManu = new JTable(tableModelManu);
		// Transformando arrayList em Object
		for (int i = 0; i < manufaturados.size(); i++) {

			int id = manufaturados.get(i).getId();
			String validade = manufaturados.get(i).getValidade();
			int Quantidade = manufaturados.get(i).getQuantidade();
			int tipo = manufaturados.get(i).getTipo();
			double valor = manufaturados.get(i).getValor();
			String dataFabricacao = manufaturados.get(i).getDataFabricacao();

			Object data[] = { id, tipo, Quantidade, valor, dataFabricacao, validade };
			tableModelManu.addRow(data);
		}
		////
		scrollPane.setViewportView(table);
		scrollPane_1.setViewportView(tableManu);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List materiaList = (List) tableModel.getDataVector().elementAt(table.getSelectedRow());

				materiaPrima materiaPrima = new materiaPrima();

				materiaPrima.setId((int) materiaList.get(0));
				materiaPrima.setNome((String) materiaList.get(1));
				materiaPrima.setQuantidade((int) materiaList.get(2));
				materiaPrima.setDescricao((String) materiaList.get(3));
				materiaPrima.setOrigem((String) materiaList.get(4));

				// enviando os dados para edição
				UpdateMateriaPrima uM = new UpdateMateriaPrima();
				uM.editarMateriaPrima(materiaPrima);
				uM.setVisible(true);
				dispose();
				

			}
		});
		btnEditar.setBounds(485, 81, 89, 23);
		contentPane.add(btnEditar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List materiaList = (List) tableModel.getDataVector().elementAt(table.getSelectedRow());

				materiaPrima materiaPrima = new materiaPrima();

				materiaPrima.setId((int) materiaList.get(0));
				materiaPrima.setNome((String) materiaList.get(1));
				materiaPrima.setQuantidade((int) materiaList.get(2));
				materiaPrima.setDescricao((String) materiaList.get(3));
				materiaPrima.setOrigem((String) materiaList.get(4));

				MateriaPrimaDAO mDao = new MateriaPrimaDAO();
				mDao.DeletarMateriaPrima(materiaPrima);

				dispose();
				ConsultarMateriaPrima cMateriaPrima = new ConsultarMateriaPrima();
				cMateriaPrima.setVisible(true);
			}
		});
		btnExcluir.setBounds(485, 115, 89, 23);
		contentPane.add(btnExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});
		btnVoltar.setBounds(229, 316, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblNewLabel = new JLabel("Materia Prima");
		lblNewLabel.setForeground(new Color(32, 178, 170));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 54, 111, 14);
		contentPane.add(lblNewLabel);

		JLabel lblProdutoManufaturado = new JLabel("Produto Manufaturado");
		lblProdutoManufaturado.setForeground(new Color(32, 178, 170));
		lblProdutoManufaturado.setFont(new Font("Arial", Font.BOLD, 13));
		lblProdutoManufaturado.setBounds(10, 171, 142, 14);
		contentPane.add(lblProdutoManufaturado);

		JButton button = new JButton("Editar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//"Id", "Tipo", "Quantidade", "valor", "DataFabricação", "Validade"
				List manufaturadoList = (List) tableModelManu.getDataVector().elementAt(tableManu.getSelectedRow());

				produtoManufaturado manufaturado = new produtoManufaturado();
				
				manufaturado.setId((int)manufaturadoList.get(0));
				manufaturado.setTipo((int)manufaturadoList.get(1));
				manufaturado.setQuantidade((int)manufaturadoList.get(2));
				manufaturado.setValor((double)manufaturadoList.get(3));
				manufaturado.setDataFabricacao((String)manufaturadoList.get(4));
				manufaturado.setValidade((String)manufaturadoList.get(5));				

				// enviando os dados para edição
				UpdateManufaturado uManufaturado = new UpdateManufaturado();
				uManufaturado.editarManufaturado(manufaturado);
				dispose();
				uManufaturado.setVisible(true);
				
			}
		});
		button.setBounds(485, 196, 89, 23);
		contentPane.add(button);

		JButton button_1 = new JButton("Excluir");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List manufaturadoList = (List) tableModelManu.getDataVector().elementAt(tableManu.getSelectedRow());

				produtoManufaturado manufaturado = new produtoManufaturado();
				
				manufaturado.setId((int) manufaturadoList.get(0));			

				ManufaturadoDao manufaturadoDao = new ManufaturadoDao();
				manufaturadoDao.DeletarManufaturado(manufaturado);

				dispose();
				ConsultarMateriaPrima cMateriaPrima = new ConsultarMateriaPrima();
				cMateriaPrima.setVisible(true);
			}
		});
		button_1.setBounds(485, 230, 89, 23);
		contentPane.add(button_1);

	}
}
