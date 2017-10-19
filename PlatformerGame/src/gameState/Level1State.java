package gameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tileMap.Background;

public class Level1State extends GameState{
	
	Background bg;
	
	public Level1State(GameStateManager gsm){
		this.gsm = gsm;
		
		try {
			bg = new Background("/Backgrounds/grassbg1.gif", 1);
			bg.setVector(-.2, 0);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void init(){
		
	}
	
	public void update(){
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		bg.draw(g);
	}
	
	public void keyPressed(int k){
		
	}
	
	public void keyReleased(int k){
		
	}
}
