package gameState;

import java.awt.*;
import java.awt.event.KeyEvent;

import tileMap.Background;

public class MenuState extends GameState{
	
	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Heroes",
			"Help",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm){
		this.gsm = gsm;
		
		try {
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-.4, .05);
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font("Century Gothic", Font.PLAIN, 28);
			font = new Font("Arial", Font.PLAIN, 12);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void init(){
		bg.setPosition(0, 0);
	}
	
	public void update(){
		bg.update();
		
	}
	
	public void draw(Graphics2D g){
		bg.draw(g);
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("Hello World", 80, 70);	
		
		g.setFont(font);
		for (int i = 0; i < options.length; i++){
			if(i == currentChoice){
				g.setColor(Color.RED);
			}
			else{
				g.setColor(Color.BLACK);
			}
			
			g.drawString(options[i], 145, 140 + i * 15);
		}
	}
	
	private void select(){
		if(currentChoice == 0){
			gsm.setState(1);
		}
		if (currentChoice == 1){
			gsm.setState(3);
		}
		if (currentChoice == 2){
			gsm.setState(2);
		}
		if (currentChoice == 3){
			System.exit(0);
		}
	}
	
	public void keyPressed(int k){
		if(k == KeyEvent.VK_ENTER){
			select();
			System.out.print(currentChoice);
		}
		
		if(k == KeyEvent.VK_UP){
			currentChoice--;
			if(currentChoice == -1){
				currentChoice = options.length - 1;
			}
		}
		
		if(k == KeyEvent.VK_DOWN){
			currentChoice++;
			if(currentChoice == options.length){
				currentChoice = 0;
			}
		}
	}
	
	public void keyReleased(int k){
		
	}
}
