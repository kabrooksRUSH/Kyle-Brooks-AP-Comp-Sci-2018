package chapter4ExercisesPackage;

import java.util.Scanner;

public class PackageCheck_2 {
	
	double weight;
	double length;
	double width;
	double height;
	double volume;
	
	Scanner input = new Scanner(System.in);
	
	public PackageCheck_2(){
	}
	
	public void getSize(){
		System.out.print("Enter package weight in kilograms: ");
		weight = input.nextDouble();
		
		System.out.print("Enter package length in centimeters: ");
		length = input.nextDouble();
		
		System.out.print("Enter package width in centimeters: ");
		width = input.nextDouble();
		
		System.out.print("Enter package height in centimeters: ");
		height = input.nextDouble();
	}
	public void analyzePackage(){
		volume = width*height*length;
		
		if (weight > 32 && volume > 100000){
			System.out.print("Too phat");
		} else if (weight > 32) {
			System.out.print("Too heavy");
		} else if (volume > 100000){
			System.out.print("Too wide");
		} else if (weight <= 32 && volume <= 100000){
			System.out.print("Schmokay");
		}
	}
}
