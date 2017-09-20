package chapter3ExercisesPackage;

import java.util.Scanner;

public class Spending_12 {
	double rentC;
	double entertainmentC;
	double clothingC;
	double foodC;
	
	double totalC;
	
	public Spending_12(){
		System.out.println("Enter the amount spent last month on...");
	}
	public void getRentC(){
		System.out.print("Rent: ");
		Scanner inputD = new Scanner(System.in);
		rentC = inputD.nextInt();
	}
	public void getEntertainmentC(){
		System.out.print("Entertainment: ");
		Scanner inputC = new Scanner(System.in);
		entertainmentC = inputC.nextInt();
	}
	public void getClothingC(){
		System.out.print("Clothing: ");
		Scanner inputDe = new Scanner(System.in);
		clothingC = inputDe.nextInt();
	}
	public void getFoodC(){
		System.out.print("Food: ");
		Scanner inputT = new Scanner(System.in);
		foodC = inputT.nextInt();
	}
	public void getCosts(){
		getFoodC();
		getClothingC();
		getEntertainmentC();
		getRentC();
	}
	
	public void calcPercent(){
		totalC = foodC + entertainmentC + clothingC + rentC;
		
		System.out.println("\n" + "Task               % Time");
		System.out.println("Food:                " + (foodC/totalC)*100 + " %");
		System.out.println("Clothing:            " + (clothingC/totalC)*100 + " %");
		System.out.println("Entertainment:       " + (entertainmentC/totalC)*100 + " %");
		System.out.println("Rent:                " + (rentC/totalC)*100 + " %");	
	}
}
