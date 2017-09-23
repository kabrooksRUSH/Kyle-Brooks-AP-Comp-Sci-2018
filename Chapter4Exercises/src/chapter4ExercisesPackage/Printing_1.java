package chapter4ExercisesPackage;

import java.util.Scanner;

/*Printing prices are based on number of copies to be printed
0-99 30c per copy
100-499 28c per copy
500-749 27c per copy
759-1000 26c per copy
over 1000 25c per copy*/

public class Printing_1 {
	
	 int copies;
	 double pricePer;
	 double total;
	
	Scanner inputC = new Scanner(System.in);
	
	public void printing_1(){
		
	}
	public void getCopies(){
		System.out.print("How many copies would you like to buy: ");
		copies = inputC.nextInt();
	}
	public  void calcCost(){
		if (copies <= 99){
			total = (copies*30);
			pricePer = .30;
		} 
		else if(copies >= 100 && copies <= 499){
			total = copies * 28;
			pricePer = .28;
		} 
		else if(copies >= 500 && copies <= 749){
			total = copies * 27;
			pricePer = .27;
		}
		else if(copies >= 750 && copies <= 1000){
			total = copies * 26;
			pricePer = .26;
		} 
		else if(copies >= 1000){
			total = copies * 25;
			pricePer = .25;
		}
		
		System.out.println("That'll cost you $" + total/100);
		System.out.print("$" + pricePer + " Per copy");
	}
}
