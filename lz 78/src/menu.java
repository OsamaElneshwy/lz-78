import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class menu {

	private JFrame frmMenu;

	/**	
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu window = new menu();
					window.frmMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenu = new JFrame();
		frmMenu.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmMenu.setTitle("menu");
		frmMenu.setBounds(100, 100, 450, 300);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 10));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnCompression = new JButton("Compression");
		btnCompression.setBackground(SystemColor.activeCaption);
		btnCompression.setFont(new Font("Arial", Font.BOLD, 20));
		btnCompression.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				comp w=new comp();
				w.open();
				
			}
		});
		
		JButton btnDecompression = new JButton("Decompression");
		btnDecompression.setBackground(SystemColor.activeCaption);
		btnDecompression.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decomp w=new decomp();
				w.open();
			}
		});
		btnDecompression.setFont(new Font("Arial", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(frmMenu.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(118)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDecompression, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(btnCompression, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
					.addGap(122))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(btnCompression, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(btnDecompression, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addContainerGap())
		);
		frmMenu.getContentPane().setLayout(groupLayout);
	}

	
}
