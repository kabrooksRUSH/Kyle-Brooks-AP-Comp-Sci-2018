package chapter3ExercisesPackage;

import java.util.Scanner;

public class CollegeCalculator_3 {
	
	double booksC;
	double housingC;
	double schoolingC;
	double mealPlanC;
	
	double scholarships;
	
	double totalCost;
	
	public CollegeCalculator_3(){
		System.out.print("Hello! Welcome to the college cost calculator!");
	}
	
	public void calcCost(){
		totalCost = booksC + housingC + schoolingC + mealPlanC - scholarships;
		System.out.print("\n" + "You will be paying $" + totalCost);
	}
	public void setBookC(){
		System.out.print("\n" + "\n" + "Please enter the cost of your books: ");
		Scanner bookIn = new Scanner(System.in);
		booksC = bookIn.nextDouble();
	}
	public void setLodgingC(){
		System.out.print("Please enter the cost of your lodging: ");
		Scanner housingIn = new Scanner(System.in);
		housingC = housingIn.nextDouble();
	}
	public void setTuitionC(){
		System.out.print("Please enter the cost of your tuition: ");
		Scanner schoolingIn = new Scanner(System.in);
		schoolingC = schoolingIn.nextDouble();
	}
	public void setMealC(){
		System.out.print( "Please enter the cost of your meal plan: ");
		Scanner mealPlanIn = new Scanner(System.in);
		mealPlanC = mealPlanIn.nextDouble();
	}
	public void setScholarship(){
		System.out.print("Please enter the amout of scholarship money you have recieved: ");
		Scanner scholarshipsIn = new Scanner(System.in);
		scholarships = scholarshipsIn.nextDouble();
	}
	public void setCollegeCosts(){
		setBookC();
		setLodgingC();
		setTuitionC();
		setMealC();
		setScholarship();
	}
	
}
