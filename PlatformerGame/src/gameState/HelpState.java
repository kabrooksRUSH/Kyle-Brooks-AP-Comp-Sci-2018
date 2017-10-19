package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tileMap.Background;

public class HelpState extends GameState{
	
	Background help;
	
	Color infoColor = Color.GRAY;
	Font infoFont = new Font("Arial", Font.PLAIN, 12);
	
	public HelpState(GameStateManager gsm){
		this.gsm = gsm;
		
		try {
			help = new Background("/Backgrounds/help.gif", 1);
			help.setVector(0, 0);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void init() {
		
	}

	public void update() {
		help.update();
	}

	public void draw(Graphics2D g) {
		help.draw(g);
		
		g.setColor(Color.GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 14));
		
		g.drawString("Press Enter to exit", 100, 235);
		
		g.setFont(infoFont);
		g.drawString("10/19/2017", 70, 94);
		g.drawString("1", 85, 109);
	}

	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			gsm.setState(0);
		}
	}

	public void keyReleased(int k) {
		
	}

}
