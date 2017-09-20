package chapter3ExercisesPackage;

import java.util.Scanner;

public class Sleep_9 {
	
	int yearB;
	int monthB;
	int dayB;

	int yearC;
	int monthC;
	int dayC;
	
	int yearA;
	int monthA;
	int dayA;
	
	double dayT;
	
	double sleepConvert = .33;
	
	public Sleep_9(){
		System.out.println("Please enter your date of birth");
	}
	
	public void getBYear(){
		System.out.print("Year: ");
		Scanner inputBY = new Scanner(System.in);
		yearB = inputBY.nextInt();
	}
	public void getBMonth(){
		System.out.print("Month: ");
		Scanner inputBM = new Scanner(System.in);
		monthB = inputBM.nextInt();

	}
	public void getBDay(){
		System.out.print("Day: ");
		Scanner inputBD = new Scanner(System.in);
		dayB = inputBD.nextInt();
	}
	
	public void getCurYear(){
		System.out.print("Year: ");
		Scanner inputCY = new Scanner(System.in);
		yearC = inputCY.nextInt();
	}
	public void getCurMonth(){
		System.out.print("Month: ");
		Scanner inputCM = new Scanner(System.in);
		monthC = inputCM.nextInt();

	}
	public void getCurDay(){
		System.out.print("Day: ");
		Scanner inputCD = new Scanner(System.in);
		dayC = inputCD.nextInt();
	}
	
	public void getBirthDate(){
		getBYear();
		getBMonth();
		getBDay();
		System.out.println("Please enter today's date");
	}
	
	public void getTodayDate(){
		getCurYear();
		getCurMonth();
		getCurDay();
	}
	
	public void calcSleep(){
		yearA = yearC - yearB;
		monthA = monthC - monthB;
		dayA = dayC - dayB;
		
		dayT = ((yearA*365)+(monthA*30)+dayA);
		
		System.out.print("You have been alive for "  + dayT + " days");
		System.out.print("\n" + "You have slept for " + ((dayT*24)*sleepConvert) + " hours");
	}
}
