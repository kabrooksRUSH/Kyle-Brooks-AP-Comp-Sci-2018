package helloGraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.*;
import javax.swing.JComponent;


public class Drawing extends JComponent {
	
	float axisX;
	float axisY;
	float axisW;
	float axisL;
	
	
	public void paint(Graphics g){
		Graphics2D graph2 = (Graphics2D)g;
		graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Shape ellipse = new Ellipse2D.Float(axisX, axisY, 100, 300);
			
		graph2.setPaint(Color.BLUE);
		
		cartPlane(g, 700, 300, 100, 100);
		cartPlane(g, 750, 350, 150, 150);
		cartPlane(g, 800, 400, 200, 200);
		cartPlane(g, 850, 450, 250, 250);
		cartPlane(g, 900, 500, 300, 300);
		cartPlane(g, 1500, 200, 50, 300);
		cartPlane(g, 500, 500, 1000, 1000);
	}
		
	public void cartPlane(Graphics g, int xCoord, int yCoord, int height, int width){
		axisX = xCoord;
		axisY = yCoord;
		axisW = width;
		axisL = height;
		
		Graphics2D cartPlane = (Graphics2D)g;
		cartPlane.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		Shape yAxis = new Line2D.Float(0 + axisX, (float) (axisY - (height*.5)), 0 + axisX, (float) (axisY + (height*.5)));
		Shape xAxis = new Line2D.Float((float) (axisX - (width*.5)), 0 + axisY, (float) (axisX + (width*.5)), 0 + axisY);
		
		cartPlane.draw(xAxis);
		cartPlane.draw(yAxis);
	}
}

