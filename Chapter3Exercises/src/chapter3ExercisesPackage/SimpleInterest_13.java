package chapter3ExercisesPackage;

import java.util.Scanner;

public class SimpleInterest_13 {
	
	double principal;
	double years;
	double amount;
	double rate;
	double endVal;
	
	public SimpleInterest_13(){
		
	}
	
	public void findEquation(){
		
	}
	
	public void getPrincipal(){
		System.out.print("Enter the principal: ");
		Scanner inputP = new Scanner(System.in);
		principal = inputP.nextInt();
	}
	
	public void getYears(){
		System.out.print("Enter number of years: ");
		Scanner inputY = new Scanner(System.in);
		years = inputY.nextInt();
	}
	
	public void getInterestRate(){
		System.out.print("Enter interest rate: ");
		Scanner inputR = new Scanner(System.in);
		rate = inputR.nextDouble();
	}
	
	public void getAmount(){
		System.out.print("Enter end amount: ");
		Scanner inputA = new Scanner(System.in);
		amount = inputA.nextDouble();
	}
	
	public void getValsA(){
		getPrincipal();
		getYears();
		getInterestRate();
	}
	
	public void getValsP(){
		getAmount();
		getYears();
		getInterestRate();
	}
	
	public void calcEndValA(){
		endVal = principal * (1 + years * rate);
		System.out.print("The value after end of term is: $" + endVal + "\n" + "\n");
	}
	
	public void calcEndValP(){
		principal = amount / (1 + years * rate);
		System.out.print("The principal you need is: $" + principal);
	}
}
