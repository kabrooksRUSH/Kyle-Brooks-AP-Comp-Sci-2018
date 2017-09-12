package chapter3ExercisesPackage;

import java.util.Scanner;

public class Energy_4 {
	
	double e;
	double m;
	double b;
	double c = 300000000;
	
	public Energy_4() {
		System.out.print("Enter a mass in kilograms: ");
	}
	
	public void setWeight(){
		Scanner input = new Scanner(System.in);
		m = input.nextDouble();
	}
	
	public void calcEnergy(){
		e = m*Math.pow(c, 2);
		System.out.print("The energy produced in Joules is: " + e);
	}
	
	public void calcBulbs(){
		b = e/360000;
		System.out.print("\n" + "The number of 100-watt light bulbs powered by this in an hour is: " + b);
	}
}
