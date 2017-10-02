package helloGraphics;

import java.util.Scanner;

public class Qmcat {
	
	Scanner input = new Scanner(System.in);
	int Choice;
	
	double heatEnergy;
	double mass;
	double specHeat;
	double deltaTemp;
	
	String answer;
	
	public Qmcat(){
		
	}
	public void setEquation(int Choice){
		switch (Choice){
		case 1: System.out.print("You are solving for heat energy" + "\n"); 
				System.out.print("Please enter specific heat: ");
				specHeat = input.nextDouble();
				System.out.print("Please enter mass: ");
				mass = input.nextDouble();
				System.out.print("Please enter the change in temperature: ");
				deltaTemp = input.nextDouble();
				
				answer = (mass*specHeat*deltaTemp) + " Joules";
				break;
				
		case 2: System.out.print("You are solving for specific heat" + "\n");
				System.out.print("Please enter heat energy: ");
				heatEnergy = input.nextDouble();
				System.out.print("Please enter mass: ");
				mass = input.nextDouble();
				System.out.print("Please enter the change in temperature: ");
				deltaTemp = input.nextDouble();
		
				answer = "The specific heat is " + (heatEnergy/(mass*deltaTemp));
				break;
				
		case 3: System.out.print("You are solving for mass" + "\n");
				System.out.print("Please enter heat energy: ");
				heatEnergy = input.nextDouble();
				System.out.print("Please enter specific heat: ");
				specHeat = input.nextDouble();
				System.out.print("Please enter the change in temperature: ");
				deltaTemp = input.nextDouble();
				
				answer = (heatEnergy/(specHeat*deltaTemp)) + " grams";
				break;
				
		case 4: System.out.print("You are solving for change in temperature" + "\n");
				System.out.print("Please enter heat energy: ");
				heatEnergy = input.nextDouble();
				System.out.print("Please enter mass: ");
				mass = input.nextDouble();
				System.out.print("Please enter specific heat: ");
				specHeat = input.nextDouble();
				
				answer = (heatEnergy/(mass*specHeat)) + " Degrees of change";
				break;
		}
		System.out.print("The answer to your problem is " + answer);
		System.out.println("\n");
		answer = null;
	}
}
