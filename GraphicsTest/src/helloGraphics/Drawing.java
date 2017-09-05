package helloGraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.*;
import javax.swing.JComponent;


	public class Drawing extends JComponent {
		public void paint(Graphics g){
			Graphics2D graph2 = (Graphics2D)g;
			graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
			Shape line = new Line2D.Float(100, 100, 100, 250);
			Shape ellipse = new Ellipse2D.Float(500, 100, 100, 300);
			
			graph2.setPaint(Color.BLUE);
						
			graph2.draw(ellipse);
			graph2.draw(line);
	}
		
}

