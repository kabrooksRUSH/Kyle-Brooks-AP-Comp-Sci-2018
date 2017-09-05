package helloWorldPackage;

import javax.swing.JFrame;
import java.awt.BorderLayout;


public class Window extends JFrame {
	public Window(String name,int x, int y){
		this.setSize(x,y);
		this.setTitle(name);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new Drawing(), BorderLayout.CENTER);
		this.setVisible(true);
	}
}