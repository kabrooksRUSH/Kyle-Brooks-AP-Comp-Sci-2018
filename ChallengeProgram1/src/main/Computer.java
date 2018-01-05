package main;

import java.util.Random;

public class Computer {
	
	Player player1 = new Player();
	Random rand = new Random();
	
	int vowelCount;
	int targetNum;
	int roll;
	int total;
	int rollNum;
	int choice;
	
	public Computer(){
		
	}
	
	public void scrubVowels(){
		player1.setName();
		String s = player1.getName().toLowerCase();
		
		for (int i = 0; i < s.length(); i++) {
		    switch(s.charAt(i)) {
		        case 'a':
		        case 'e':
		        case 'i':
		        case 'o':
		        case 'u':vowelCount++;
		            break;
		        default:
		    }
		}
		targetNum = vowelCount * 6;	
		
		System.out.println("Your target number is: " + targetNum + "\n");
	}
	
	public void rollDice(){
		while(total < targetNum){
			
			player1.setDiceChoice();
			choice = player1.getDiceChoice();
			
			switch(choice){
			case 2: roll = rand.nextInt(1) + 1;
					total += roll;
					choice = 0;
					rollNum ++;
					break;
					
			case 4: roll = rand.nextInt(3) + 1;
					total += roll;
					choice = 0;
					rollNum ++;
					break;
					
			case 6: roll = rand.nextInt(5) + 1;
					total += roll;
					choice = 0;
					rollNum ++;
					break;
					
			case 12: roll = rand.nextInt(11) + 1;
				 	 total += roll;
				 	 choice = 0;
				 	 rollNum ++;
				 	 break;
				 	 
			default:System.out.print("You entered an incorrect die number");
			}
			System.out.print("Your total is currently: " + total + "\n");
		}
		
		System.out.print("\n" + "It took you " + rollNum + " rolls.");
		
	}
}
