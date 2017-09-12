package chapter3ExercisesPackage;

import java.util.Scanner;

public class ObjectHeight_1 {
	double height;
	double time;
	
	
	public ObjectHeight_1(){	
		System.out.print("Input a time less than 4.5 seconds: " );
	}
	
	public void calcHeight(){
		height = 100-4.9*Math.pow(time, 2);
		System.out.print("Height of object: " + height);
	}
	public void setTime(){
		Scanner input = new Scanner(System.in);
		time = input.nextDouble();
	}
}