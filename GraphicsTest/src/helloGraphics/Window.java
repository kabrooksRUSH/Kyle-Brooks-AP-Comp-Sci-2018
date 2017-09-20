package helloGraphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;


public class Window extends JFrame {
	public Window(String name){
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setTitle(name);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new Drawing(), BorderLayout.CENTER);
		this.setVisible(true);
		
		gui();
	}
	public void gui(){
		JPanel mainPanel = new JPanel();
		JLabel mainLabel = new JLabel();
		
		JButton b1 = new JButton("b1");
		JLabel l1 = new JLabel("l1");
		
		mainPanel.setBackground(Color.MAGENTA);
		
	/*	mainPanel.add(b1);
		mainPanel.add(l1);
		
		this.add(mainPanel);*/
	}
}