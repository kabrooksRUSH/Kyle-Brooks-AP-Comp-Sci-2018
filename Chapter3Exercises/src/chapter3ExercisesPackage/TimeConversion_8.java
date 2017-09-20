package chapter3ExercisesPackage;

import java.util.Scanner;

public class TimeConversion_8 {
	
	int timeMin;
	
	TimeConversion_8(){
		System.out.print("Enter the time in minutes: ");
	}
	
	public void setTime(){
		Scanner input = new Scanner(System.in);
		timeMin = input.nextInt();
	}
	
	public void calcTime(){
		System.out.print("The time is: " + timeMin/60 + ":" + timeMin%60);
	}
}
