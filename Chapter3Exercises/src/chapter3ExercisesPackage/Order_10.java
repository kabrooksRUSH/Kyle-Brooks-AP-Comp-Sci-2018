package chapter3ExercisesPackage;

import java.util.Scanner;

public class Order_10 {
	
	double burger = 1.69;
	double fries = 1.09;
	double pop = .99;
	
	double money;
	
	int numBurgers;
	int numFries;
	int numPop;
	
	double tax = 1.06;
	double totalC;
	
	public Order_10(){
	}
	
	public void getBurgers(){
		System.out.print("Enter the number of burgers: ");
		Scanner inputB = new Scanner(System.in);
		numBurgers = inputB.nextInt();
	}
	public void getFries(){
		System.out.print("Enter the number of fries: ");
		Scanner inputF = new Scanner(System.in);
		numFries = inputF.nextInt();
	}
	public void getPop(){
		System.out.print("Enter the number of sodas: ");
		Scanner inputP = new Scanner(System.in);
		numPop = inputP.nextInt();
	}
	public void calcCost(){
		totalC = (numBurgers*burger + numPop*pop + numFries*fries)*tax;
		System.out.print("\n" + "Cost before tax: " + (numBurgers*burger + numPop*pop + numFries*fries));
		System.out.print("\n" + "tax: " + (numBurgers*burger + numPop*pop + numFries*fries)*.06);
		System.out.print("\n" + "Your total is: " + totalC + "\n");
	}
	
	public void getTended(){
		System.out.print("Enter the amount of money tendered: ");
		Scanner inputM = new Scanner(System.in);
		money = inputM.nextInt();
	}	
	
	public void calcChange(){
		System.out.print("Change: " + (money - totalC));
	}
}
