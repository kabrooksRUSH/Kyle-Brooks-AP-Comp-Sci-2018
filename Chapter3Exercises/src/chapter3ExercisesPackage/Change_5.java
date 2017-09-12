package chapter3ExercisesPackage;

import java.util.Scanner;

public class Change_5 {
	int quarter = 25;
	int qRemain;

	int dime = 10;
	int dRemain;
	
	int nickel = 5;
	int nRemain;
	
	int penny = 1;
	
	int change;
	
	public Change_5(){
		System.out.print("Enter change in cents: ");
	}
	
	public void setChange(){
		Scanner input = new Scanner(System.in);
		change = input.nextInt();
	}
	
	public void calcChange(){
		qRemain = change % quarter;		
		dRemain = qRemain % dime;
		nRemain = dRemain % nickel;
		
		System.out.print("Quarters: " + change/quarter);
		System.out.print("\n" + "Dimes: " + qRemain/dime);
		System.out.print("\n" + "Nickels: " + dRemain/nickel);
		System.out.print("\n" + "Pennies: " + nRemain/penny);
	}
}
