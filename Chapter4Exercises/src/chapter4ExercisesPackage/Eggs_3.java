package chapter4ExercisesPackage;

import java.util.Scanner;

public class Eggs_3 {
	double numEggs;
	double cost;
	Scanner input = new Scanner(System.in);
	
	Eggs_3(){
		
	}
	public void getEggs(){
		System.out.print("Enter the number of eggs to purchase: ");
		numEggs = input.nextDouble();
	}
	public void calcCost(){
		if (numEggs <= 48){
			cost = numEggs*(.5/12);
		}
		else if (numEggs <= 72 && numEggs >= 49){
			cost = numEggs*(.45/12);
		}
		else if (numEggs <= 132 && numEggs >= 73){
			cost = numEggs*(.4/12);
		} 
		else if (numEggs > 133){
			cost = numEggs*(.35/12);
		}
		
		System.out.print("That will cost you $" + cost);
	}
}
