package chapter4ExercisesPackage;

import java.util.Scanner;

public class CarRecall_4 {
	
	Scanner input = new Scanner(System.in);
	int modelNum;
	
	boolean broken = false;
	
	public CarRecall_4(){
		
	}
	
	public void getModel(){
		System.out.print("Enter your model number: ");
		modelNum = input.nextInt();
	}
	
	public void testModel(){
		switch (modelNum){
		case 119:  
		case 179:
		case 221:
		case 780:
		case 189:
		case 190:
		case 191:
		case 192:
		case 193:
		case 194:
		case 195: broken = true;
				  break;
		}
		if (broken == true){
			System.out.print("Your car is BROKEN.");
		}
		else if (broken == false){
			System.out.print("You good");
		}
	}
}
