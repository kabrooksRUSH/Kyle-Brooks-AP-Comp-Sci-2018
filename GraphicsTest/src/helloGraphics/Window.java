package helloGraphics;

import javax.swing.JFrame;
import java.awt.BorderLayout;


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
		
	}
}