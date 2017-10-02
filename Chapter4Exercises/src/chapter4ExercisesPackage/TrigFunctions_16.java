package chapter4ExercisesPackage;

import java.util.Scanner;

public class TrigFunctions_16 {
	
	Scanner input = new Scanner(System.in);
	
	double angle;
	
	public TrigFunctions_16(){
		
	}
	public void getAngle(){
		System.out.print("Please input an angle in radians: ");
		angle = input.nextDouble();
	}
	public void calcFuncts(){
		System.out.println("Sin x:" + Math.sin(angle));
		System.out.println("Cos x:" + Math.cos(angle));
		System.out.println("Tan x:" + Math.tan(angle));	
	}
}
