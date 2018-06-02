package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JDesktopPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inicio");
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmAgendaDeContatos = new JMenuItem("Agenda de Contatos");
		menuBar.add(mntmAgendaDeContatos);
		
		JMenu mnNewMenu = new JMenu("Compras");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmListaDeCompras = new JMenuItem("Lista de Compras");
		mnNewMenu.add(mntmListaDeCompras);
		
		JMenuItem mntmRealizarCompra = new JMenuItem("Realizar Compra");
		mnNewMenu.add(mntmRealizarCompra);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmListaDeVendas = new JMenuItem("Lista de Vendas");
		mnVendas.add(mntmListaDeVendas);
		
		JMenuItem mntmRealizarVenda = new JMenuItem("Realizar Venda");
		mnVendas.add(mntmRealizarVenda);
		frame.getContentPane().setLayout(null);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
