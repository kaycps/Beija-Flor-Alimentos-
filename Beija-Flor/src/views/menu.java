package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class menu extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setBounds(100, 100, 533, 351);
		getContentPane().setLayout(null);

	}

}
