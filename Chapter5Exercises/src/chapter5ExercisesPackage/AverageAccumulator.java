package chapter5ExercisesPackage;

import java.util.Scanner;

public class AverageAccumulator {
	
	double inputVal;
	double avg;
	int numbs;
	double total;
	boolean done;
	
	Scanner input = new Scanner(System.in);
	
	public AverageAccumulator(){
		
	}
	
	public void getNumbers(){
		while (inputVal != 0){
			inputVal = input.nextDouble();
			total = inputVal + total;
		}
	}
}
