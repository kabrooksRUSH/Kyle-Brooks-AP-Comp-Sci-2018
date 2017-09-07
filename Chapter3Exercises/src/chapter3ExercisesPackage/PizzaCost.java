package chapter3ExercisesPackage;

import java.util.Scanner;

public class PizzaCost {
	
	double cost;
	double diameter;
	
	public PizzaCost(){
		System.out.print("Enter diameter of pizza in inches: ");
	}
	public void calcCost(){
		cost = 1.75 +( .05 * Math.pow(diameter, 2));
		System.out.print("The cost of making your pizza will be: $" + cost );
	}
	public void setDiameter(){
		Scanner input = new Scanner(System.in);
		diameter = input.nextDouble();
	}
	
}
