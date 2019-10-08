package matching;

import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import ctrl.Controler;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class recorder {

	JFrame frame;
	private JTable table;
	public Controler controler;
	private JTable table_1;
	private String[] Level = {"同花","顺子","同点","对子","杂牌"};
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public recorder(Controler controler) {
		this.controler=controler;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u5BF9\u5C40\u8BB0\u5F55");
		frame.setBounds(100, 100, 701, 465);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		Vector data = new Vector();
		Vector header = new Vector();
		header.add("牌型");
		header.add("类型");
		header.add("点数");
		header.add("胜负");
		for(int i=0;i<controler.length;i++) {
			Vector row = new Vector();
			row.add(controler.records[i].paixing);
			row.add(Level[controler.records[i].level-1]);
			row.add(controler.records[i].point+6);
			if(controler.records[i].win==1)
				row.add("胜");
			else if(controler.records[i].win==2) {
				row.add("负");
			}else 
				row.add("平");
			data.add(row);
		}
		table = new JTable(data,header);
		JScrollPane jp = new JScrollPane(table);
		springLayout.putConstraint(SpringLayout.NORTH, jp, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, jp, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, jp, 297, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, table, 21, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table, 52, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table, 395, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table, 443, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(jp);
		
		Vector header2 = new Vector();
		header2.add("类型");
		header2.add("出现次数");
		header2.add("出现概率");
		header2.add("胜场");
		header2.add("获胜率");
		Vector data2= new Vector();
		for(int i=0;i<5;i++) {
			Vector row = new Vector();
			row.add(Level[i]);
			row.add(controler.appearTimes(i+1));
			row.add(controler.appearTimes(i+1)/controler.length);
			row.add(controler.winTimes(i+1));
			if(controler.appearTimes(i+1)==0) {
				row.add(0);
			}else
				row.add((controler.winTimes(i+1)+0.5-0.5)/controler.appearTimes(i+1));
			data2.add(row);
		}
		table_1 = new JTable(data2,header2);
		JScrollPane scrollPane = new JScrollPane(table_1);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 0, SpringLayout.NORTH, jp);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 95, SpringLayout.EAST, jp);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 0, SpringLayout.SOUTH, jp);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, -39, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(scrollPane);
	}
}
