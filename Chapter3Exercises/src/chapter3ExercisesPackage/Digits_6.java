package chapter3ExercisesPackage;

import java.util.Scanner;

public class Digits_6 {
	
	int hRemain;
	int tRemain;
	int oRemain;
	
	int dividend;
	
	public Digits_6(){
		System.out.print("Enter a three digit number: ");
	}
	
	public void setDividend(){
		Scanner input = new Scanner(System.in);
		dividend = input.nextInt();
	}
	
	public void calcChange(){
		hRemain = dividend % 100;
		tRemain = hRemain % 10;
		
		System.out.print("Hundreds: " + dividend/100);
		System.out.print("\n" + "Tens: " + hRemain/10);
		System.out.print("\n" + "Ones: " + tRemain/1);
	}
}
