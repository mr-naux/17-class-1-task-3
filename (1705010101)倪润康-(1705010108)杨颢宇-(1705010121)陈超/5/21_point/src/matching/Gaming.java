package matching;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.io.File;

import ctrl.Controler;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ctrl.*;
import game_obj.*;
public class Gaming {
	File f = new File(this.getClass().getResource("..").getPath()).getParentFile();
	JFrame frame;
	Controler controler;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Gaming(Controler controler) {
		this.controler=controler;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u6E38\u620F\u754C\u9762");
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		frame.setBounds(100, 100, 680, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel top3 = new JLabel("");
		
		top3.setIcon(new ImageIcon("cards\\"+"blue.png"));
		frame.getContentPane().add(top3);
		
		JLabel player1 = new JLabel("\u73A9\u5BB6top");
		springLayout.putConstraint(SpringLayout.WEST, player1, 271, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, player1, -266, SpringLayout.EAST, frame.getContentPane());
		player1.setFont(new Font("宋体", Font.BOLD, 16));
		player1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(player1);
		
		JLabel top1 = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, top3, 0, SpringLayout.SOUTH, top1);
		springLayout.putConstraint(SpringLayout.NORTH, top1, 62, SpringLayout.NORTH, frame.getContentPane());
		top1.setIcon(new ImageIcon("cards\\"+"blue.png"));
		frame.getContentPane().add(top1);
		
		JLabel top2 = new JLabel("");
		springLayout.putConstraint(SpringLayout.SOUTH, player1, -11, SpringLayout.NORTH, top2);
		springLayout.putConstraint(SpringLayout.SOUTH, top2, 0, SpringLayout.SOUTH, top1);
		top2.setIcon(new ImageIcon("cards\\"+"blue.png"));
		frame.getContentPane().add(top2);
		
		JLabel bottom1 = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, top1, 0, SpringLayout.WEST, bottom1);
		bottom1.setIcon(new ImageIcon("cards\\"+"red.png"));
		frame.getContentPane().add(bottom1);
		
		JLabel bottom2 = new JLabel("");
		springLayout.putConstraint(SpringLayout.EAST, top2, 0, SpringLayout.EAST, bottom2);
		springLayout.putConstraint(SpringLayout.EAST, bottom1, -92, SpringLayout.WEST, bottom2);
		springLayout.putConstraint(SpringLayout.SOUTH, bottom2, -52, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, bottom1, 0, SpringLayout.SOUTH, bottom2);
		bottom2.setIcon(new ImageIcon("cards\\"+"red.png"));
		frame.getContentPane().add(bottom2);
		
		JLabel bottom3 = new JLabel("");
		springLayout.putConstraint(SpringLayout.WEST, bottom3, 455, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, top3, 0, SpringLayout.EAST, bottom3);
		springLayout.putConstraint(SpringLayout.EAST, bottom2, -82, SpringLayout.WEST, bottom3);
		springLayout.putConstraint(SpringLayout.SOUTH, bottom3, -52, SpringLayout.SOUTH, frame.getContentPane());
		bottom3.setIcon(new ImageIcon(f+"\\red.png"));
		frame.getContentPane().add(bottom3);
		
		JLabel lblbottom = new JLabel("\u73A9\u5BB6bottom");
		lblbottom.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.SOUTH, lblbottom, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblbottom, -286, SpringLayout.EAST, frame.getContentPane());
		lblbottom.setFont(new Font("宋体", Font.BOLD, 16));
		frame.getContentPane().add(lblbottom);
		
		JButton btnNewButton_2 = new JButton("\u53D1\u724C");
		btnNewButton_2.setSelectedIcon(null);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 236, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 10, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("\u5B9A\u80DC\u8D1F");
		btnNewButton.setEnabled(false);
		
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnNewButton_2);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u9ED1\u65B9");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 31, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -107, SpringLayout.NORTH, btnNewButton_2);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7EA2\u65B9");
		lblNewLabel_1.setForeground(Color.RED);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -97, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		frame.setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5BF9\u5C40\u8BB0\u5F55");
		mntmNewMenuItem.setEnabled(false);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recorder re = new recorder(controler);
				re.frame.setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 11));
		mntmNewMenuItem.setBackground(Color.LIGHT_GRAY);
		menuBar.add(mntmNewMenuItem);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controler.shuffling();
				controler.recording();
				System.out.print("cards\\"+controler.h1.hander[0].id+".png");
				top1.setIcon(new ImageIcon("cards\\"+controler.h1.hander[0].id+".png"));
				top2.setIcon(new ImageIcon("cards\\"+controler.h1.hander[1].id+".png"));
				top3.setIcon(new ImageIcon("cards\\"+controler.h1.hander[2].id+".png"));
				bottom1.setIcon(new ImageIcon("cards\\"+controler.h2.hander[0].id+".png"));
				bottom2.setIcon(new ImageIcon("cards\\"+controler.h2.hander[1].id+".png"));
				bottom3.setIcon(new ImageIcon("cards\\"+controler.h2.hander[2].id+".png"));
				
				/*System.out.println("status="+controler.judgement());
				System.out.println("h1.level="+controler.h1.level);
				System.out.println("h1.point="+controler.h1.point);
				System.out.println("h2.level="+controler.h2.level);
				System.out.println("h2.point="+controler.h2.point);
				*/
				btnNewButton.setEnabled(true);
				mntmNewMenuItem.setEnabled(true);
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(controler.judgement()==1) {
					lblNewLabel.setText("黑方胜");
					lblNewLabel_1.setText("红方败");
				}else if(controler.judgement()==2) {
					lblNewLabel.setText("黑方败");
					lblNewLabel_1.setText("红方胜");
				}else {
					lblNewLabel.setText("平局");
					lblNewLabel_1.setText("平局");
				}
				controler.recording();
			}
		});
	}
}
