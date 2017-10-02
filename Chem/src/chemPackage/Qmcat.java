package chemPackage;

import java.util.Scanner;

public class Qmcat {
	
	Scanner input = new Scanner(System.in);
	int Choice;
	
	double specHeat;
	double mass;
	double deltaTemp;
	double heatEnergy;
	
	String answer;
	
	public Qmcat(){
		
	}
	public void getEquation(){
		System.out.print("Please enter (1)-q (2)-c (3)-m (4)-delta T : ");
		Choice = input.nextInt();
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
				
		case 2: System.out.print("You chose specific heat" + "\n");
				break;
				
		case 3: System.out.print("You chose mass" + "\n");
				break;
				
		case 4: System.out.print("You chose change in temperature" + "\n");
				break;
		}
		System.out.print("The answer to your problem is " + answer);
	}
}
