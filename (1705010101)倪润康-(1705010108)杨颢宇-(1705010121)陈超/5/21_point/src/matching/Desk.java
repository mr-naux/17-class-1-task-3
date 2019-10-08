package matching;

import java.awt.EventQueue;

import javax.swing.JFrame;

import ctrl.Controler;

public class Desk {
	JFrame frame;
	public static Controler controler= new Controler();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start_menu window = new start_menu(controler);
					window.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
