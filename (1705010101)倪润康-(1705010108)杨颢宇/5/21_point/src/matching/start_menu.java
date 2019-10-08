package matching;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;

import ctrl.Controler;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class start_menu {

	JFrame frame1;
	Controler controler;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public start_menu(Controler controler) {
		this.controler=controler;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setTitle("\u5F00\u59CB\u83DC\u5355");
		frame1.setBounds(100, 100, 637, 522);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame1.getContentPane().setLayout(springLayout);
		
		JButton btnNewButton = new JButton("\u5F00\u59CB\u5BF9\u5C40");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 312, SpringLayout.NORTH, frame1.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 268, SpringLayout.WEST, frame1.getContentPane());
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame1.hide();
				Gaming g = new Gaming(controler);
				g.frame.setVisible(true);
			}
		});
		frame1.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u6251\u514B\u6E38\u620F");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 152, SpringLayout.NORTH, frame1.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 270, SpringLayout.WEST, frame1.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -99, SpringLayout.NORTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, -283, SpringLayout.EAST, frame1.getContentPane());
		frame1.getContentPane().add(lblNewLabel);
	}
}
