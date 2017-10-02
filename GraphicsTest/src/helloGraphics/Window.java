package helloGraphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


public class Window extends JFrame implements ActionListener {
	
	JPanel mainPanel = new JPanel();
	
	int Choice;
	String answer;
	
	double specHeat;
	double mass;
	double deltaTemp;
	double heatEnergy;
	
	Scanner input = new Scanner(System.in);
	
	Qmcat n1 = new Qmcat();

	
	JButton b1 = new JButton("Heat Energy");
	JButton b2 = new JButton("Change In Temperature");
	JButton b3 = new JButton("Mass");
	JButton b4 = new JButton("Specific Heat");
//	JButton b5 = new JButton("Page 2");
	
	public Window(String name){
		openMainPage();
		this.setTitle(name);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.add(new Drawing(), BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}
	
	public void openMainPage(){			
		b1.setActionCommand("heatenerg");
		b1.addActionListener(this);
		
		b2.setActionCommand("tempchange");
		b2.addActionListener(this);
		
		b3.setActionCommand("mass");
		b3.addActionListener(this);
		
		b4.setActionCommand("specheat");
		b4.addActionListener(this);
		
		/*b5.setActionCommand("panel2");
		b5.addActionListener(this);*/
		
		mainPanel.setBackground(Color.YELLOW);
		
		mainPanel.add(b1);
		mainPanel.add(b2);
		mainPanel.add(b3);
		mainPanel.add(b4);
//		mainPanel.add(b5);
		
		mainPanel.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
		
		this.setContentPane(mainPanel);
	}
	/*public void closeMainPage(){
		mainPanel.remove(b1);
		mainPanel.remove(b2);
		mainPanel.remove(b3);
		mainPanel.remove(b4);
	}*/
	
	public void actionPerformed(ActionEvent event1){
		String eventName = event1.getActionCommand();
		
		if (eventName == "heatenerg"){
			n1.setEquation(1);
		}
		else if (eventName == "specheat"){
			n1.setEquation(2);
		}
		else if (eventName == "mass"){
			n1.setEquation(3);
		}
		else if (eventName == "specheat"){
			n1.setEquation(4);
		}
		/*else if (eventName == "panel2"){
			this.closeMainPage();
		}*/
	}
}