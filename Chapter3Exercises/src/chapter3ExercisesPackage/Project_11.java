package chapter3ExercisesPackage;

import java.util.Scanner;

public class Project_11 {
	
	double designT;
	double codingT;
	double debugT;
	double testT;
	
	double totalT;
	
	public Project_11(){
		
	}
	
	public void getDesignTime(){
		System.out.print("Design  time: ");
		Scanner inputD = new Scanner(System.in);
		designT = inputD.nextInt();
	}
	public void getCodingTime(){
		System.out.print("Coding  time: ");
		Scanner inputC = new Scanner(System.in);
		codingT = inputC.nextInt();
	}
	public void getDebuggingTime(){
		System.out.print("Debugging  time: ");
		Scanner inputDe = new Scanner(System.in);
		debugT = inputDe.nextInt();
	}
	public void getTestingTime(){
		System.out.print("Testing  time: ");
		Scanner inputT = new Scanner(System.in);
		testT = inputT.nextInt();
	}
	public void getTimes(){
		getDesignTime();
		getCodingTime();
		getDebuggingTime();
		getTestingTime();
	}
	public void calcPercent(){
		totalT = designT + codingT + debugT + testT;
		
		System.out.println("\n" + "Task               % Time");
		System.out.println("Designing:           " + (designT/totalT)*100 + " %");
		System.out.println("Coding:              " + (codingT/totalT)*100 + " %");
		System.out.println("Debugging:           " + (debugT/totalT)*100 + " %");
		System.out.println("Testing:             " + (testT/totalT)*100 + " %");
	}
}
