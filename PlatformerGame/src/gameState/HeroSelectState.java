package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tileMap.Background;

public class HeroSelectState extends GameState{
	
	Background roster;
	
	public HeroSelectState(GameStateManager gsm){
		this.gsm = gsm;
		
		try {
			roster = new Background("/Backgrounds/HeroRoster.png", 1);
			roster.setVector(0, 0);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		roster.update();
	}

	@Override
	public void draw(Graphics2D g) {
		roster.draw(g);
		
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.PLAIN, 14));
		
		g.drawString("Press e to exit", 100, 235);
	}

	@Override
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_E){
			gsm.setState(0);
		}
	}

	@Override
	public void keyReleased(int k) {
		
	}

}
