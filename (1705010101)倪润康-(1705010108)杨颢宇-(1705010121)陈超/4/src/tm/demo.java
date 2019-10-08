package tm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Panel;

public class demo extends JFrame {

	private String filename;
	public static int symbal = 0;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo frame = new demo();
					frame.setLocationRelativeTo(null); //窗口在屏幕中间显示
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
	public demo() {
		setFont(new Font("微软雅黑", Font.PLAIN, 16));
		setTitle("\u6559\u5E08\u5DE5\u8D44\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u2193\u5DF2\u9009\u62E9\u6587\u4EF6\u2193");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel.setBounds(355, 42, 132, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(68, 97, 501, 62);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\u6253\u5370\u65B0\u5DE5\u8D44\u6E05\u5355\r\n\uFF08\u9ED8\u8BA4\u4FDD\u5B58\u81F3\u9009\u62E9\u76EE\u5F55\uFF09");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cal cal = new Cal(filename);
				try {
					cal.calculate();
					if(symbal == 1) {
						JOptionPane.showMessageDialog(null, "更新成功！", "成功", JOptionPane.PLAIN_MESSAGE);
		        	}else {
		        		JOptionPane.showMessageDialog(null, "未知错误，更新失败！", "错误", JOptionPane.ERROR_MESSAGE);
		        	}
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 26));
		btnNewButton_1.setBounds(40, 192, 550, 113);
		btnNewButton_1.setEnabled(false);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u9009\u62E9\u6587\u4EF6");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc=new JFileChooser();  
		        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
		        jfc.showDialog(new JLabel(), "选择");  
		        File file=jfc.getSelectedFile();  
		        if(file.isDirectory()){  
		        	//System.out.println("文件夹:"+file.getAbsolutePath());  
		            JOptionPane.showMessageDialog(null, "请选择文本文件", "文件类型错误", JOptionPane.ERROR_MESSAGE);
		        }else if(file.isFile()){  
		            System.out.println("文件:"+file.getAbsolutePath());  
		            lblNewLabel_1.setText(file.getAbsolutePath());
		            btnNewButton_1.setEnabled(true);
		            filename = file.getAbsolutePath();
		        }  
		        //System.out.println(jfc.getSelectedFile().getName());
		        
			}
		});
		btnNewButton.setBounds(92, 38, 175, 46);
		contentPane.add(btnNewButton);
		
	}
}
