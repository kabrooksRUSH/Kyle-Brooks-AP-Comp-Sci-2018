package main;

import java.util.Scanner;

public class Player {
	
	Scanner input = new Scanner(System.in);
	
	String name;
	int diceNum;
	
	public Player(){
		
	}
	
	public void setName(){
		System.out.print("Please enter your name: ");
		name = input.nextLine();
	}
	
	public String getName(){
		return name;
	}
	
	public void setDiceChoice(){
		System.out.println("Would you like a (2) sided die (4) sided die (6) sided die or (12) sided die");
		diceNum = input.nextInt();
	}
	
	public int getDiceChoice(){
		return diceNum;
	}
}
