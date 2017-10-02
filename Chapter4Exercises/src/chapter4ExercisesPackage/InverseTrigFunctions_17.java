package chapter4ExercisesPackage;

import java.util.Scanner;

public class InverseTrigFunctions_17 {
	
	double angle;
	
	Scanner input = new Scanner(System.in);
	
	public InverseTrigFunctions_17(){
		
	}
	public void getAngle(){
		System.out.print("Please input an angle in radians: ");
		angle = input.nextDouble();
	}
	public void calcFuncts(){
		System.out.println("Arcsin x:" + Math.asin(angle));
		System.out.println("Arccos x:" + Math.acos(angle));
		System.out.println("Arctan x:" + Math.atan(angle));	
	}
}
